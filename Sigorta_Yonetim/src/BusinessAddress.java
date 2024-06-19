
public class BusinessAddress implements Address{

	String address;
	
	public BusinessAddress(String address) {	
		this.address = address;
	}

	@Override
	public String getAddressDetail() {
		return address;
	}
	
}
