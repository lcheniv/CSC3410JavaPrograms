//////////////////////////////////////////
/// NAME: Lawrence Chen                ///
/// ASSIGNMENT: phonedir.java (#4)     ///
/// DUE: October 8th 2015              ///
/// PROF: Jaman Bhola                  ///
/// CLASS: CSc 3410                    ///
//////////////////////////////////////////

public class Record {
	private String first_Name, last_Name, phone_Num;
	
		public Record(String firstN, String lastN, String phoneN){
			first_Name = firstN;
			last_Name = lastN;
			phone_Num = phoneN;
		}
		
		public void changeFirst(String firstN){
			first_Name = firstN;
		}
		
		public void changeLast(String lastN){
			last_Name = lastN;
		}
		
		public void changePhone(String phoneN){
			phone_Num = phoneN;
		}
		
		public String getFirst(){
			return first_Name;
		}
		
		public String getLast(){
			return last_Name;
		}
		
		public String getNumber(){
			return phone_Num;
		}
		
}
