/**
 * 
 */
package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 *
 */
class AutorTest {
	Autor a;

	@BeforeEach
	void setUp() throws Exception {
		a = new Autor();
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
	}


	@Test
	void testSetImeSveOk() {
		a.setIme("Pera");
		
		assertEquals("Pera", a.getIme());
	}

	@Test
	void testSetImeNull() {
		Exception e=assertThrows(NullPointerException.class, ()->a.setIme(null));
		
		assertEquals("Ime ne sme biti null!", e.getMessage());
	}
	
	@Test
	void testSetImeEmpty() {
		assertThrows(IllegalArgumentException.class, ()->a.setIme(""));
		
	}
	


	/**
	 * Test method for {@link biblioteka.Autor#setPrezime(java.lang.String)}.
	 */
	@Test
	void testSetPrezimeSveOk() {
		a.setPrezime("Jovana");
		assertEquals("Jovana", a.getPrezime());
	}

	@Test
	void testSetPrezimeNull() {
		Exception e=assertThrows(NullPointerException.class, ()->a.setPrezime(null));
		assertEquals("Prezime ne sme biti null!", e.getMessage());
	}
	@Test
	void testSetPrezimePrazanString() {
		assertThrows(IllegalArgumentException.class, ()->a.setPrezime(""));
	}
	

}
