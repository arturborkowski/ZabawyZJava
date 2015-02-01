
public class Pies extends Zwierze{

	int waga;
	int wiek;
	
	public Pies() {
		super();
		this.waga = 10;
		this.wiek = 11;
	}
	
	public Pies(String imie, int waga) {
		super(imie);
		this.waga = waga;
		this.wiek = 11;
	}
	
	
	public Pies(String name, int weight, int wiek){
		this(name, weight);
		this.wiek = wiek;
	}

	static void szczekaj() {
		System.out.println("HAU HAU HAU!");
	}
	
	@Override
	public String toString() {
		return "Pies [waga=" + waga + ", wiek=" + wiek + ", imie=" + imie + "]";
	}
	

}
