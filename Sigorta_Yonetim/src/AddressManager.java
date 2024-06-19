
//Müşteri adresi ekleme çıkarmaya yarayan sınıf

import java.util.Scanner;

public class AddressManager {
	
	public static void AdresEkle(User user, Address address) 
	{
		user.adresListesi.add(address);
	}
	
	
	public static void AdresSil(User user, Address address) 
	{
		user.adresListesi.remove(address);
	}	
}