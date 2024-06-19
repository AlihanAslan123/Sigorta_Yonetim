import java.util.Scanner;
import java.util.TreeSet;

public class AccountManager {
	static Scanner scanner = new Scanner(System.in);
	
	static TreeSet<Account> hesaplar = new TreeSet<>();
	
	
	public static  void addAccount()
	{
		System.out.println("----------------------------");
		System.out.print("Adınız: ");
		String isim = scanner.nextLine();
		System.out.println("----------------------------");
		System.out.print("Soyadınızı Giriniz: ");
		String soyisim = scanner.nextLine();
		System.out.println("----------------------------");
		System.out.print("Mail adresinizi giriniz: ");
		String mail = scanner.nextLine();
		System.out.println("----------------------------");
		System.out.print("Şifrenizi belirleyin: ");
		String sifre = scanner.nextLine();
		System.out.println("----------------------------");
		System.out.print("Mesleğinizi giriniz: ");
		String meslek = scanner.nextLine();
		System.out.println("----------------------------");
		System.out.print("Yaşınızı giriniz: ");
	    int yas = scanner.nextInt();
	    System.out.println("----------------------------");
	    System.out.println("Lütfen Bir Seçim Yapın"+"\n1-)Bireysel Hesap"+"\n2-)Kurumsal Hesap");
	    int hesapSecimi = scanner.nextInt();
	    
	    User u = new User(isim,soyisim,mail,sifre,meslek,yas);
	    if(hesapSecimi == 1) 
	    {	    	
	    	hesaplar.add(new Bireysel(u));
	    	System.out.println("Hesabınız oluşturuldu.");
	    }
	    else if(hesapSecimi == 2) 
	    {
	    	hesaplar.add(new Kurumsal(u));
	    	System.out.println("Hesabınız oluşturuldu.");
	    }
	    else {
	    	System.out.println("Hatalı Hesap Seçimi");
	    }
	    
	}
	
	public Account Login(String email , String sifre) 
	{	
		for(Account hesap: hesaplar) 
		{
			try {
				hesap.login(email, sifre);
				return hesap;
			} catch (InvalidAuthenticationException e) {
				System.out.println(e);
			}
		}
		return null;
	}
	
}
