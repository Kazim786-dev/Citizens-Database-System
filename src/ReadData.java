import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadData {

	Scanner read=new Scanner(System.in);
	
	// read data from CBID file
	
  public void readCBIDfile( CBID <CBID> basiclist ) {
		
		try {
			read=new Scanner(new File("C:\\Users\\Taha Asif\\Documents\\_Assignments-3rd semester\\DS\\Citizens Database System (CDS)\\src\\CBID file.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in reading file, no such file : CBID file");
			e.printStackTrace();
		}
		
		while(read.hasNextLine()) {
		
		String cnic=read.next(); String name=read.next();String fname=read.next(); 
		String gender=read.next(); 
		String address=read.next()+" "+read.next()+" "+read.next();
		
		String nationality=read.next();
	
		CBID obj = new CBID(cnic, name, fname, gender, address, nationality); // , null, null);
		
		// Assigning the read values from file
		
		basiclist.insertAtLast(obj);
			
		}
		read.close();
		
	}
  
  

  
  //read data from CCID filr
  
  public void readCCIDfile(  CCID <CCID> crimelist ) {
		
		try {
			read=new Scanner(new File("C:\\Users\\Taha Asif\\Documents\\_Assignments-3rd semester\\DS\\Citizens Database System (CDS)\\src\\CCID.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in reading file, no such file : CCID file");
			e.printStackTrace();
		}
		
		
		// loop will run until next line is present in CCID.txt file
		
		while(read.hasNextLine()) {
			
			String cnic="",Case="",punishment="",charge="";
			
		String line=read.nextLine();
		
		String [] linearray=line.split(" ");
		
		for( int i=0; i<linearray.length; i++ ) {
			
			if(i==0) {
				
				cnic=linearray[i];
			}
			else if(i==1) {
				
				Case=linearray[i];
			}
			else if( (i+1) == linearray.length) {
				
				charge=linearray[i];
			}
			else {
			
				punishment=punishment+linearray[i]+" ";
				
			}
			
		}	
					
		CCID obj = new CCID(cnic, Case, punishment, charge, charge); // , null, null);
		
		// Assigning the read values from file
		
		crimelist.insertAtLast(obj);
		
			
		}
		read.close();
		
	}   // readCCIDfile closing bracket
  
  
  
  
  
  // read data from CCND
  
  public void readCCNDfile( CCND <CCND> celllist ) {
		
		try {
			read=new Scanner(new File("C:\\Users\\Taha Asif\\Documents\\_Assignments-3rd semester\\DS\\Citizens Database System (CDS)\\src\\CCND.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in reading file, no such file : CCND file");
			e.printStackTrace();
		}
		
		while(read.hasNextLine()) {
		
		String cnic=read.next(); 
		String phone=read.next(); 
		String network=read.next();
		String adate=read.next();
		String ddate=read.next();
		String status=read.next();
		
		CCND obj = new CCND(cnic,network, phone, adate, ddate, status); // , null,null );
		
		// Assigning the read values from file
		
		celllist.insertAtLast(obj);
			
		}
		read.close();
		
	}
  
 
	
}
