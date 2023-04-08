package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KnjigaTest {
	Knjiga k;
	@BeforeEach
	void setUp() throws Exception {
		k=new Knjiga();
	}

	@AfterEach
	void tearDown() throws Exception {
		k=null;
	}

	@Test
	void testSetNaslov() {
		assertThrows(NullPointerException.class,()->k.setNaslov(null));
	}


	@Test
	void testSetIzdavac() {
		k.setIzdavac("Vulkan");
		assertEquals("Vulkan", k.getIzdavac());
	}

	@ParameterizedTest
	@CsvSource({
		"0",
		"-1",
		"-22"
	})
	void testSetIzdanjeManjeOdJedan(int izdanje) {
		Exception e=assertThrows(IllegalArgumentException.class, ()->k.setIzdanje(izdanje));
		assertEquals("Izdanje ne sme biti manje od 1!", e.getMessage());
	}

	@Test
	@DisplayName ("Test za toString metodu")
	void testToString() {
		Knjiga kn=new Knjiga();
		kn.setNaslov("Mali princ");
		kn.setIzdanje(3);
		kn.setIsbn(1213l);
		kn.setIzdavac("Vulkan");
		Autor au=new Autor();
		au.setIme("Robert");
		au.setPrezime("Filds");
		List<Autor> autori=new ArrayList<>();
		autori.add(au);
		kn.setAutori(autori);
		String s=kn.toString();
		
		assertTrue(s.contains("Mali princ"));
		assertTrue(s.contains("3"));
		assertTrue(s.contains("1213"));
		assertTrue(s.contains("Vulkan"));
		assertTrue(s.contains("Robert"));
		assertTrue(s.contains("Filds"));
	}

	@ParameterizedTest
	@CsvSource({
		"123,123,true",
		"123,321,false"
	})
	void testEquals(long isbn1,long isbn2,boolean daLiSuIsti) {
		k.setIsbn(isbn1);
		Knjiga k2=new Knjiga();
		k2.setIsbn(isbn2);
		
		assertEquals(daLiSuIsti,k.equals(k2));
	}
	@Test
	void testEquals() {
		assertFalse(k.equals(new Autor()));
	}
	
}
