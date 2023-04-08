package biblioteka;

import java.util.Objects;
/**
 * Ovo je klasa autor
 * 
 * @author Jovana Stakic
 * @since 0.1.0
 */
public class Autor {
	/**
	 * Ime autora kao string
	 */
	private String ime;
	/**
	 * Prezime autora kao string
	 */
	private String prezime;
	public Autor() {
		
	}
	
	public Autor(String ime, String prezime) {
		this.ime = ime;
		this.prezime = prezime;
	}
/**
 * Metoda koja vraca trenutnu vrednost atributa ime
 * 
 * @return ime autora kao String
 */
	public String getIme() {
		return ime;
	}
	/**
	 * Setuje ime
	 * 
	 * @param ime Vrednost na koje se postavlja atribut ime
	 * @throws NullPointerException ako se unese null
	 * @throws IllegalArgumentException ako se unese prazan string
	 */
	public void setIme(String ime) {
		if(ime==null)
			throw new NullPointerException("Ime ne sme biti null!");
		if(ime.isEmpty())
			throw new IllegalArgumentException("Ime ne sme biti prazno!");
		this.ime = ime;
	}
	/**
	 * Get prezimena
	 * 
	 * @return Vraca trenutnu vredost parametra kao string
	 */
	public String getPrezime() {
		return prezime;
	}
	/**
	 * Za setovanje prezimena
	 * 
	 * @param prezime Nova vrednost za prezime
	 * @throws NullPointerException ako se unese NULL
	 * @throws IllegalArgumentException ako se unese prazan string
	 */
	public void setPrezime(String prezime) {
		if(prezime==null)
			throw new NullPointerException("Prezime ne sme biti null!");
		if(prezime.isEmpty())
			throw new IllegalArgumentException("Prezime ne sme biti prazno!");

		this.prezime = prezime;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ime, prezime);
	}
	/**
	 * Poredi dva autora  po imenu i prezimenu char {@code char}
	 * 
	 * @return
	 * <ul>
	 * <li>true - ako su jednaki </li>
	 * <li> false - ako nisu jednaki </li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(ime, other.ime) && Objects.equals(prezime, other.prezime);
	}

	@Override
	public String toString() {
		return "Autor [ime=" + ime + ", prezime=" + prezime + "]";
	}
	
}
