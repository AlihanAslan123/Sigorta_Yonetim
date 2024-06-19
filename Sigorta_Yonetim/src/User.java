import java.sql.Date;
import java.util.ArrayList;

public class User {
	
	private String isim;
	private String soyisim;
	private String mail;
	private String sifre;
	private String meslek;
	private int yas;
	ArrayList<Address> adresListesi = new ArrayList<>();
	private Date lastLogin;
	
	
	public User(String isim, String soyisim, String mail, String sifre, String meslek, int yas) {
		this.isim = isim;
		this.soyisim = soyisim;
		this.mail = mail;
		this.sifre = sifre;
		this.meslek = meslek;
		this.yas = yas;
		this.lastLogin = new Date(System.currentTimeMillis()); // Şimdiki zamanı atadı.
	}


	public String getIsim() {
		return isim;
	}


	public void setIsim(String isim) {
		this.isim = isim;
	}


	public String getSoyisim() {
		return soyisim;
	}


	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getSifre() {
		return sifre;
	}


	public void setSifre(String sifre) {
		this.sifre = sifre;
	}


	public String getMeslek() {
		return meslek;
	}


	public void setMeslek(String meslek) {
		this.meslek = meslek;
	}


	public int getYas() {
		return yas;
	}


	public void setYas(int yas) {
		this.yas = yas;
	}


	public Date getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	
	
}
