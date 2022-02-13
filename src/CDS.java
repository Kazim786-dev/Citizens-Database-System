import java.util.*;
public class CDS <T> {
	
	
	public static void main(String[] args) {
		
		
	//Linked List objects
		
		CBID <CBID> basiclist =new CBID <CBID>();
		CCID <CCID> crimelist =new CCID <CCID>();
		CCND <CCND> celllist  =new CCND <CCND>();
		AD   <AD>   alienlist =new AD   <AD>  ();
		
	// Read data from files
		
		ReadData objForRead = new ReadData();
		objForRead.readCBIDfile(basiclist);
		objForRead.readCCIDfile(crimelist);
		objForRead.readCCNDfile(celllist);
	
	// link same CNIC's
		
		crimelist.LINK(basiclist, celllist);
		basiclist.LINK(crimelist, celllist );
		celllist.LINK(basiclist , crimelist);
		
		
		Scanner sc=new Scanner(System.in);
		
		boolean iteration=true;
		
		System.out.println("\nWelcome to Citizens Database System\n"
				+ "\n------------------------------"
				+ "\n------------------------------\n");
		
		while(iteration=true) {
			
			System.out.println(
					  "1-  Add new record in CBID\n"
					+ "2-  Update record in CBID \n--------\n"
					+ "3-  Add Crime record\n"
					+ "4-  Delete a crime from CCID \n"
					+ "5-  Update crimes in CCID \n--------\n"
					+ "6-  Add/Delete/Update cell-number\n"
					+ "7-  Print count of cell phone numbers registered on each network \n"
					+ "8-  Swap ownership of two numbers in CCND \n--------\n"
					+ "9-  Print the 'Aliens' records from AD \n--------\n"
					+ "10- Search record\n"
					+ "11- Print data from a database\n"

					+ "0- EXIT \n");
			
			
			int choice=sc.nextInt();
			
			while(choice<0||choice>11) {
				System.out.println("\nWrong input! Enter again\n");
						choice=sc.nextInt();
			}
			
			switch(choice) {
			
			case 0:{
				iteration=false;
				System.out.println("OK BYE!");
				
			}
			case 1:{
				basiclist.addRecord();
				
				break;
			}
			case 2:{
				
				basiclist.update(alienlist);
				break;
			}
			case 3:{
				
				System.out.println( "1- Add new crime on CNIC ( already exists in CCID ) \n"
						+ "2- Add Crime on new CNIC registered in CBID \n" );
				
				int x=sc.nextInt();
				while(x<1||x>2) {
					System.out.println("\nWrong input! Enter again\n");
							x=sc.nextInt();
				}
				if(x==1) {
					crimelist.AddCrimeOnRegistered();
				}
				else {
					crimelist.AddNewCrime( basiclist.head );
				}
				
				
				crimelist.LINK(basiclist, celllist);
				basiclist.LINK(crimelist, celllist );
				celllist.LINK(basiclist , crimelist);
				break;
			}
			case 4:{
				
				crimelist.deleteCrime();
				break;
			}
			case 5:{
				
				crimelist.update();
				break;
			}
			case 6:{
				
				System.out.println("1-  Add/Delete/Update cell-number on CNIC already exists in CCND \n"
					+ "2-  Add cell-number on new CNIC registered in CBID \n" );
				
				int x=sc.nextInt();
				while(x<1||x>2) {
					System.out.println("\nWrong input! Enter again\n");
							x=sc.nextInt();
				}
				if(x==1) {
					celllist.updateRecord();
				}
				else {
					celllist.AddNewCell( basiclist.head );
				}
				
				crimelist.LINK(basiclist, celllist);
				basiclist.LINK(crimelist, celllist );
				celllist.LINK(basiclist , crimelist);
				
				break;
			}
			case 7:{
				
				celllist.CountNumOnNetwok();
				break;
			}
			case 8:{
				
				celllist.SwapOwnership();
				break;
			}
			case 9:{
				
				alienlist.printList();
				break;
			}
			case 10:{
				
				System.out.println("1- Search from CBID \n"
					+ "2- Search from CCID \n"
					+ "3- Search from CCND \n");
				
				int x=sc.nextInt();
				while(x<1||x>3) {
					System.out.println("\nWrong input! Enter again\n");
							x=sc.nextInt();
				}
				if(x==1) {
					basiclist.search();
				}
				else if (x==2){
					crimelist.search();
				}
				else {
					celllist.search();
				}
				
				break;
			}
			case 11:{
				
				System.out.println("1- Print basic record \n"
					+ "2- Print all crime data \n"
					+ "3- Print all cell data \n");
				
				int x=sc.nextInt();
				
				while(x<1||x>3) {
					System.out.println("\nWrong input! Enter again\n");
							x=sc.nextInt();
				}
				if(x==1) {
					basiclist.printList();
				}
				else if (x==2){
					crimelist.printList();
				}
				else {
					celllist.print();
				}
				
				break;
			}
				
			default :{
				
			System.out.println("\nWrong Input!\n");	
				break;
			}
			
			}
			
			
			
		}
		
		
		
		
	}
	
	
}
