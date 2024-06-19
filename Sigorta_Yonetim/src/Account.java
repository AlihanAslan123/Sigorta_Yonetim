import java.util.ArrayList;
import java.util.Objects;

public abstract class Account implements Comparable<Account> { 
	// Müşteri profili icin oluşturulmuş üst sınıf 
	// Burda müşteri bilgileri tutulacak
	protected User user;
	protected ArrayList<Insurance> insurances = new ArrayList<>();
	protected AuthenticationStatus status;
	
	public Account(User user) 
	{
		this.user = user;
		this.status = AuthenticationStatus.FAIL;
	}
	
	// Kullanıcıın login işlemini gerçekleştiren method
	public void login(String email, String sifre) throws InvalidAuthenticationException
	{
		if(user.getMail().equals(email) && user.getSifre().equals(sifre)) 
		{
			status = AuthenticationStatus.SUCCESS;
		}
		else {
			throw new InvalidAuthenticationException("Mail adresiniz veya şifreniz yanlış");
		}
	}
	
	//Kullanıcının adres eklemesini sağlayan method
	public void adresekle(Address address) 
	{
		AddressManager.AdresEkle(user, address);
	}
	
	//Kullanıcının adres silmesini sağlayan method
	public void adresSil(Address address) 
	{
		AddressManager.AdresSil(user, address);
	}
	
	//kullanıcının login olma durumunu veren değer döndüren fonksiyon
	public AuthenticationStatus getStatus() 
	{
		return status;
	}
	
	public abstract void addInsurance(Insurance insurance);	
	
	public final void showUserInfo() 
	{
		System.out.println("--------------------------");
		System.out.println("\tBİLGİLERİNİZ");
		System.out.println("--------------------------");
		System.out.println("İsim: "+user.getIsim()+"\nSoyisim: "+user.getSoyisim()
		+"\nYaş: "+user.getYas()+"\nMail: "+user.getMail()+"\nMeslek: "+user.getMeslek()
		+"\nEn son oturum açtığınız tarih: "+user.getLastLogin());		
	}

	@Override
	public int compareTo(Account o) {
		return this.user.getMail().compareTo(o.user.getMail());
	}

	@Override
	public int hashCode() {
		return Objects.hash(user.getMail());
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Account account = (Account) obj;
		return Objects.equals(user.getMail(), account.user.getMail());
	}
	
	
	
	
}

class InvalidAuthenticationException extends Exception
{
	public InvalidAuthenticationException(String message) {
		super(message);
	}
}
