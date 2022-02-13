
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

String crime= "robbery murder snatch";
		
		System.out.println(crime);
		String[] a=crime.split(" ");
	// System.out.println(a[0]);
	 crime="";
		
		int i=0;
	 for( i=0;i<a.length;i++) {
		if(a[i].equalsIgnoreCase("murder")) {
			a[i]=null;
			
		}
		if(a[i]!=null) {
		crime=crime+" "+a[i];	
		}
	 }
	 
	 System.out.println(crime);
	}

}
