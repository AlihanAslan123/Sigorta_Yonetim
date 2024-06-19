import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Scanner;
import java.util.Calendar;

public class InsuranceManager {
	static Scanner scanner = new Scanner(System.in);
	
	
	 public static void addInsurance(Account account){
		 
		    Calendar calender  = Calendar.getInstance();
			Date takvim = (Date) calender.getTime();
			
			DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			
			calender.add(Calendar.YEAR, 1); // bir yıl ekleyelim
		
			Date takvim2 =(Date) calender.getTime();
			
		 	
		 	System.out.println("------------------------------------");
	        System.out.println("1-Araba Sigortası\n2-Seyehat Sigortası\n3-Sağlık Sigortası\n4-Konut Sigortası");
	        int select = scanner.nextInt();
	        scanner.nextLine();
	        
	        if(select == 1) {
	        	System.out.println("Araba Sigortası 1 yıl süreyle oluşturulacaktır. Onaylıyormusunuz(y/n)");
	        	String secim = scanner.nextLine();
	        	if(secim.equals("y") || secim.equals("Y")) {
	        		account.insurances.add(new CarInsurance(account.user.getIsim(),1500,takvim,takvim2));
	        		System.out.println("Araba sigortanız oluşturuldu.");
	        	}
	        	else {
	        		System.out.println("Oluşturma işlemi başlatılamadı.");
	        	}
	        }
	        
	        else if(select == 2) 
	        {
	        	System.out.println("Seyehat sigortası 1 yıl süreyle oluşturulacaktır. Onaylıyormusunuz(y/n)");
	        	String secim = scanner.nextLine();
	        	if(secim.equals("y") || secim.equals("Y")) {
	        		account.insurances.add(new TravelInsurance(account.user.getIsim(),1500,takvim,takvim2));
	        		System.out.println("Seyehat sigortanız oluşturuldu.");
	        	}
	        	else {
	        		System.out.println("Oluşturma işlemi başlatılamadı.");
	        	}
	        }
	        
	        
	        else if(select == 3) 
	        {
	        	System.out.println("Sağlık sigortası 1 yıl süreyle oluşturulacaktır. Onaylıyormusunuz(y/n)");
	        	String secim = scanner.nextLine();
	        	if(secim.equals("y") || secim.equals("Y")) {
	        		account.insurances.add(new HealthInsurance(account.user.getIsim(),1500,takvim,takvim2));
	        		System.out.println("Sağlık sigortanız oluşturuldu.");
	        	}
	        	else {
	        		System.out.println("Oluşturma işlemi başlatılamadı.");
	        	}
	        }
	        
	        
	        else if(select == 4) 
	        {
	        	System.out.println("Konut sigortası 1 yıl süreyle oluşturulacaktır. Onaylıyormusunuz(y/n)");
	        	String secim = scanner.nextLine();
	        	if(secim.equals("y") || secim.equals("Y")) {
	        		account.insurances.add(new ResidenceInsurance(account.user.getIsim(),1500,takvim,takvim2));
	        		System.out.println("Konut sigortanız oluşturuldu.");
	        	}
	        	else {
	        		System.out.println("Oluşturma işlemi başlatılamadı.");
	        	}
	        }	       
	      
	    }
	    public static void printInsurance(Account account){
	    	if(account.insurances.isEmpty() || account.insurances == null) {
	    		System.out.println("Kayıtlı Poliçe bulunamadı.");
	    	}
	    	else {
	    		int i = 1;
	    		System.out.println("-------------- Sigortalar -------------------");
	    		for(Insurance insurance: account.insurances) {
	    			System.out.println(i+"-) "+insurance.isim + "  Başlangıç tarihi: "+insurance.baslangicTarihi+ "\n \t  Bitiş Tarihi: "+insurance.bitisTarihi);
	    			i++;
	    		}
	    	}
	    }
}
