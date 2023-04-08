package biblioteka.iterfejs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;



import biblioteka.Knjiga;

public abstract class  BibliotekaInterfejsTest {
	protected BibliotekaInterfejs biblioteka;
	


	@Test
	void testDodajKnjiguDuplikat() {
		Knjiga k=new Knjiga();
		k.setIsbn(123);
		
		biblioteka.dodajKnjigu(k);
		assertThrows(IllegalArgumentException.class, ()->biblioteka.dodajKnjigu(k));
	}
	
	@Test
	void dodajKnjiguSveOk() {
		Knjiga knjiga=new Knjiga();
		biblioteka.dodajKnjigu(knjiga);
		List<Knjiga> knjige=biblioteka.vratiSveKnjige();
		assertEquals(1,knjige.size());
		assertTrue(knjige.contains(knjiga));
	}
	
	@Test
	void obrisiKnjigu() {
		Knjiga k=new Knjiga();
		biblioteka.dodajKnjigu(k);
		biblioteka.obrisiKnjigu(k);
		List<Knjiga> knjige=biblioteka.vratiSveKnjige();
		assertTrue(!knjige.contains(k));
	}
	
	@Test
	void obrisiKnjiguNePostoji() {
		Knjiga k=new Knjiga();
		k.setIsbn(4343);
		Exception e=assertThrows(IllegalArgumentException.class, ()->biblioteka.obrisiKnjigu(k));
		assertEquals("Knjiga ne postoji u bazi!", e.getMessage());
	}
	
	@Test
	@Timeout(1)
	void pronadjiKnjiguSveNull() {
		assertThrows(IllegalArgumentException.class,()->biblioteka.pronadjiKnjigu(null, -1, null, null));
	}
	
}
