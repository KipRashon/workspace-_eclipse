package code1;

public class Helper {

	//create the method to check if the format of the value entered in the log in are ok
	public boolean checkFormat(loginuser us) {
		boolean tof=false;
		//check if they are null
		if(!ifNull(us.getFname(),us.getLname(),us.getPassword())) {
			if(ifLengthOk(us.getFname(),us.getLname(),us.getPassword())) {
				tof=true;
				return tof;
			}
		}
		
		
		return tof;
		
	}

	private boolean ifLengthOk(String fname, String lname, String password) {
		if(fname.length()>=3 && lname.length()>=3 && password.length()>=4) {
			return true;
		}
		return false;
	}

	private boolean ifNull(String fname, String lname, String password) {
		if(fname!=null && lname!=null && password!=null) {
			return true;
		}
		return false;
	}
	
//create the method to check the length and format of the values entered in the register page
	public boolean checkRegister(registeruser us) {
		boolean tof=false;
		//check if the password is greater than four digits  and the names are > than 3 
		if(us.getPassword().length()>4 && us.getCountry().length()>=3 ) {
			if(ifLengthOk(us.getFname(),us.getLname(),us.getPassword())) {
				tof=true;
				return tof;
			}
			else {
				tof=false;
				return tof;
			}
		}
		
		return tof;
		
	}
}