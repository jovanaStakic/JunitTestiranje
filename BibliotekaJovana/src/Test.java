import biblioteka.Biblioteka;
import biblioteka.Knjiga;
import biblioteka.iterfejs.BibliotekaInterfejs;

public class Test {

	public static void main(String[] args) {
		BibliotekaInterfejs biblioteka=new Biblioteka();
		Knjiga k=new Knjiga();
		k.setIsbn(2323);
		biblioteka.dodajKnjigu(k);
		

	}

}
