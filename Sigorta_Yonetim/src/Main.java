import java.util.Scanner;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {		
		
		AccountManager accountManager = new AccountManager();
		
		boolean sart = true;
		while(sart) 
		{
			System.out.println("-------------------------------");
			System.out.println("GÜNEŞ SİGORTAYA HOŞGELDİNİZ");
			System.out.println("-------------------------------");
			System.out.println("1-)Giriş Yap");
			System.out.println("2-)Hesap Oluştur");
			System.out.println("3-)Çıkış Yap");
			int secim = scanner.nextInt();
			scanner.nextLine();
			switch(secim) 
			{
				case 1:
					int i=3;
					while(i>=0) 
					{
						System.out.print("Mail adresinizi giriniz: ");
						String email = scanner.nextLine();
						System.out.print("Şifrenizi giriniz: ");
						String sifre = scanner.nextLine();
						Account account = accountManager.Login(email, sifre);
						if(account != null) {
							System.out.println("Giriş Başarılı");
							GirisBasarili(account);
							break;
						}
						else {
							System.out.println("Kullanıcı adı veya şifre yanlış");
							i--;
						}
					}
					break;
				
				case 2:
					accountManager.addAccount();
					break;
				case 3:
					System.out.println("Çıkılıyor.");
					sart = false;
					System.exit(3);
					break;
			}
		}
		
		
	}
	
	public static void GirisBasarili(Account account) 
	{
		while(true) 
		{
			System.out.println("---------------------");
			System.out.println("1-)Sigorta İşlemleri");
			System.out.println("2-)Adres İşlemleri");
			System.out.println("3-)Bilgilerini görüntüle");
			System.out.println("4-)Çıkış");
			int secim = scanner.nextInt();
			
			if(secim == 1) 
			{
				sigortaMenu(account);
			}
			else if(secim == 2) 
			{
				adresMenusu(account);
			}
			else if(secim == 3) 
			{
				account.showUserInfo();
			}
			else if(secim == 4) 
			{
				System.out.println("Çıkılıyor.");
				System.exit(0);
			}
				
			
		}
	}
	
	
	public static void adresMenusu(Account account) {
		while(true) {
			System.out.println("---------------------------------");
			System.out.println("ADRES İŞLEMLERİ");
			System.out.println("--------------------------------");
			System.out.println("1-) Adresleri görüntüle");
			System.out.println("2-) Adres Ekle");
			System.out.println("3-) Çıkış");
			int secim = scanner.nextInt();
			if(secim == 1) {
				System.out.println("---------- Kayıtlı Adresleriniz ----------------");
				for(Address adres : account.user.adresListesi) {
					System.out.println(adres.getAddressDetail());
				}
			}
			else if(secim == 2) {
				System.out.println("1-) Ev adresi");
				System.out.println("2-) İş adresi");
				int Adressecim = scanner.nextInt();
				scanner.nextLine();
				
				if(Adressecim == 1) {
					System.out.println("Eklenecek olan adresinizi giriniz. Doğru olduğundan emin olunuz !! : ");
					
					String address = scanner.nextLine();
					AddressManager.AdresEkle(account.user,new HomeAddress(address));
				}else if(Adressecim == 2) {
					System.out.println("Eklenecek olan adresinizi giriniz. Doğru olduğundan emin olunuz !! : ");
					String address = scanner.nextLine();
					AddressManager.AdresEkle(account.user,new BusinessAddress(address));
				}				
			}
			else if(secim == 3) {
				break;
			}
		}
	}
	
	
	public static void sigortaMenu(Account account) 
	{
		while(true) 
		{
			System.out.println("SİGORTA MENÜSÜ");
			System.out.println("----------------------");
			System.out.println("1-)Sigortalarımı görüntüle\n2-)Sigorta poliçesi oluştur\n3-)Çıkış");
			int secim = scanner.nextInt();
			if(secim == 1) {
				InsuranceManager.printInsurance(account);
			}else if(secim == 2) {
				InsuranceManager.addInsurance(account);
			}else {
				break;
			}
			
		}
	}

}
