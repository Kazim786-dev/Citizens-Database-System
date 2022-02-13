import java.util.*;
public class AD <T> {

	private String CNIC, Name,FatherName,Gender,Address,Nationality;
	SinglyNode HEAD;
	
	Scanner sc=new Scanner(System.in);
	
	AD(){
		
	}
	
	AD( String nic, String n, String fn, String g, String a, String natio ){
		
		 CNIC=nic; Name=n;FatherName=fn;Gender=g;Address=a;Nationality=natio;
	}
	//getters & setters
	public String getCNIC() {
		return CNIC;
	}

	public void setCNIC(String cNIC) {
		CNIC = cNIC;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getFatherName() {
		return FatherName;
	}

	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}
	
	//To declare alien someone
		public void DeclareAlien(DoublyNode dhead, DoublyNode current) {
	
			
			AD obj1=new AD (current.basicdata.getCNIC(),current.basicdata.getName(), current.basicdata.getFatherName(), current.basicdata.getGender(), current.basicdata.getAddress(), current.basicdata.getNationality());
			SinglyNode <AD> newnode = new SinglyNode <AD>(obj1, 1); 
			
			//Now add to alien list
			if(HEAD==null) {
				HEAD=newnode;
				
			}
			else {
				
				newnode.next=HEAD;
				HEAD=newnode;
			}
			
			
			
			
		/*
			String nic;
			System.out.println("To whom you wanna declare as Alien?\n"
					+ "Enter CNIC!!!\n");
			nic=sc.next();
			DoublyNode dcurrent = dhead;
			
			while(dcurrent!=null) {
			 
				if(dcurrent.basicdata.getCNIC().compareTo(nic)==0) {
					dcurrent.basicdata.setNationality("Alien");
					
					AD obj1=new AD (dcurrent.basicdata.getCNIC(),dcurrent.basicdata.getName(), dcurrent.basicdata.getFatherName(), dcurrent.basicdata.getGender(), dcurrent.basicdata.getAddress(), dcurrent.basicdata.getNationality());
					SinglyNode <AD> newnode = new SinglyNode <AD>(obj1, 1); 
					
					//Now add to alien list
					if(HEAD==null) {
						HEAD=newnode;
						
					}
					else {
						
						newnode.next=HEAD;
						HEAD=newnode;
					}
					break;
				}
				dcurrent=dcurrent.next;
			}
			
		*/	
			
			
		}

		//To print linked list
		public void printList() {
			
			SinglyNode tnode = HEAD;    // tnode is traversal node
	        
			while (tnode != null)
	        {
				System.out.println("CNIC ==> "+tnode.aliendata.getCNIC());
	            System.out.print("Name: "+tnode.aliendata.getName()+"\n"
	            		+ "Father name: "+tnode.aliendata.getFatherName()+"\n"
	            				+ "Gender: "+tnode.aliendata.getGender()+"\n"
	            						+ "Address: "+tnode.aliendata.getAddress()+"\n"
	            								+ "Nationality: "+tnode.aliendata.getNationality()+"\n");
	            System.out.println("-----------------------\n");
	            tnode = tnode.next;
	        }
			
			
	    }
	
	
}