package serializacja;

public class KartaQuizowa {

	String pytanie, odpowiedz;
	
	public KartaQuizowa(String pytanie, String odpowiedz) {

		this.pytanie = pytanie;
		this.odpowiedz = odpowiedz;
	}

	public String getPytanie() {
		return pytanie;
	}

	public void setPytanie(String pytanie) {
		this.pytanie = pytanie;
	}

	public String getOdpowiedz() {
		return odpowiedz;
	}

	public void setOdpowiedz(String odpowiedz) {
		this.odpowiedz = odpowiedz;
	}
	
	

}
