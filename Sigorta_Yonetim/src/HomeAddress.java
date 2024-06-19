
public class HomeAddress implements Address{
	
	String address;		
	
	public HomeAddress(String address) {
		this.address = address;
	}


	@Override
	public String getAddressDetail() {
		return address;
	}
	
}
