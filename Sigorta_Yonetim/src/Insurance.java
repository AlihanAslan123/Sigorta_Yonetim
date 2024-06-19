import java.util.Date;

public abstract class Insurance { // Sigortaların üst sınıfı
	
	protected String isim;
    protected double ucret;
    protected Date baslangicTarihi;
    protected Date bitisTarihi;
    
    protected abstract double calculate();
    
	public Insurance(String isim, double ucret, Date baslangicTarihi, Date bitisTarihi) {
		this.isim = isim;
		this.ucret = ucret;
		this.baslangicTarihi = baslangicTarihi;
		this.bitisTarihi = bitisTarihi;
	}
    
}


//Özel Sağlık Sigortası
class HealthInsurance extends Insurance
{
	public HealthInsurance(String isim, double ucret, Date baslangicTarihi, Date bitisTarihi) {
		super(isim, ucret, baslangicTarihi, bitisTarihi);
	}

	@Override
	protected double calculate() {
		return ucret*1.2;
	}	
}


//Konut Sigortası
class ResidenceInsurance extends Insurance
{	
	public ResidenceInsurance(String isim, double ucret, Date baslangicTarihi, Date bitisTarihi) {
		super(isim, ucret, baslangicTarihi, bitisTarihi);
	}	

	@Override
	protected double calculate() {		
		return ucret*1.8;
	}
	
}

//Seyehat Sigortası
class TravelInsurance extends Insurance
{
	public TravelInsurance(String isim, double ucret, Date baslangicTarihi, Date bitisTarihi) {
		super(isim, ucret, baslangicTarihi, bitisTarihi);
	}

	@Override
	protected double calculate() {
		return ucret*1.1;
	}	
}

// Araba Sigortası
class CarInsurance extends Insurance
{
	public CarInsurance(String isim, double ucret, Date baslangicTarihi, Date bitisTarihi) {
		super(isim, ucret, baslangicTarihi, bitisTarihi);
	}

	@Override
	protected double calculate() {
		return ucret*1.3;
	}
	
}



