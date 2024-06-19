
public class Bireysel extends Account
{
	public Bireysel(User user) {
		super(user);
	}


	@Override
	public void addInsurance(Insurance insurance) {
		insurances.add(insurance);
	}

}

class Kurumsal extends Account
{

	public Kurumsal(User user) {
		super(user);
	}

	@Override
	public void addInsurance(Insurance insurance) {
		insurances.add(insurance);
	}
	
}
