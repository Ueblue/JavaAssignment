package Company.AJCS;

public class CompanyMember extends Member{
	
	public boolean validate(String id){
		int sum = 0;
		
		if(id.length() != 8)
			return false;
		
		for(int i = 0;i< id.length();i++){
			sum += Integer.parseInt(id.charAt(i) + "");
		}
		
		if(sum % 8 != 0)
			return false;
		
		return true;
	}
	
}