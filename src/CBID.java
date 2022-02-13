import java.util.*;
public class CBID <T> {
	
	private String CNIC, Name,FatherName,Gender,Address,Nationality;

	DoublyNode <T> head, last;
	
	CCID <CCID> crimeobject;
	CCND <CCND> networkobject;
	
	Scanner sc=new Scanner(System.in);
	
	public CBID() {
		
	}
	
//parameterized constructor
	
	public CBID( String nic, String n, String fn, String g, String a, String natio)//, CCID obj1, CCND obj2) 
	   {
		
		 CNIC=nic; Name=n;FatherName=fn;Gender=g;Address=a;Nationality=natio; // crimeobject=obj1; networkobject=obj2;
		}

	// getters setters
	
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
	
	
	
	
	int x=1;
	//To print linked list
	
	public void printList() {
		
		DoublyNode <T> tnode = head;    // tnode is traversal node
        
		while (tnode != null)
        {
            System.out.println(x+"-  "+tnode.basicdata.getCNIC()+"  "+ tnode.basicdata.getName()+"    "+tnode.basicdata.getFatherName());
            tnode = tnode.next;
            x++;
        }
		System.out.println();
		x=0;
	
		
    }
	
	
	// To insert at last
	
	public void insertAtLast(CBID <T> object)
	{
	    // 1. Check if the head Node is null 
	    if (head == null)
	    {
	    	DoublyNode <T> newnode = new DoublyNode <T>(object);  
	    	head=newnode;
	    	last=newnode;
	        return;
	    }
	 
	    /*  Allocate the Node &
	     Put in the data*/
	    
	    DoublyNode <T> newnode = new DoublyNode <T>(object);
	 
	    newnode.next =null;
	    last.next=newnode;
	    newnode.previous=last;
	    last=newnode;
	    
	    sortList();
	}
	
	// To sort 
	public void sortList() {  
        DoublyNode <T> current = null, index = null;  
        CBID <T> temp;  
        //Check whether list is empty  
        if(head == null) {  
            return;  
        }  
        else {  
            //Current will point to head  
            for(current = head; current.next != null; current = current.next) {  
            	
                //Index will point to node next to current  
                
            	for(index = current.next; index != null; index = index.next) {  
                    //If current's data is greater than index's data, swap the data of current and index  
                
            		String cnic1=current.basicdata.CNIC;
            		String cnic2=index.basicdata.getCNIC();
            		
            		if(Integer.parseInt(cnic1) > Integer.parseInt(cnic2)) {  
                        temp = current.basicdata;  
                        current.basicdata = index.basicdata;  
                        index.basicdata = temp;  
                    }  
                }  
            }  
        }  
    }  
	
	
	// to add new record
	
	void addRecord() {
		
	String waste=sc.nextLine();
		
	   System.out.println("Enter Name");
		Name=sc.next();
		System.out.println("Enter Father name");
		FatherName=sc.next();
		waste=sc.nextLine();
		System.out.println("Enter Gender");
		Gender=sc.next();
		System.out.println("Enter address");
		Address=sc.next();
		waste=sc.nextLine();
		System.out.println("Enter nationality");
		Nationality=sc.next();
		System.out.println("Enter CNIC");
		CNIC=sc.next();
		
		DoublyNode <T> current=head;
		boolean check=false;
		
		while(current!=null) {
			
			if(current.basicdata.getCNIC().equalsIgnoreCase(CNIC)) {
				
				System.out.println("\n ==> CNIC already registered\n");
				check=true;
				break;
			}
			current=current.next;
		}
		
		if(check==false) {
			
			CBID <T> obj = new CBID <T>(CNIC, Name, FatherName, Gender, Address, Nationality);  // , null, null);
			
			// Assigning the read values from file
			
			insertAtLast(obj);
			
			System.out.println("\nDONE!\n");
			System.out.println("\n---------------------\n"
					         + "---------------------\n");
			
			
		}
		
		
	}  // add function closing bracket
	
	
	
	
	
	//To search record
	public void search() {
		String waste = sc.nextLine();
		System.out.println("Enter CNIC whose record You wanna Search");
		String nic=sc.next();
		
		DoublyNode <T> current=head;
		
		while(current!=null) {
			if(current.basicdata.CNIC.compareTo(nic)==0) {
				
				System.out.println(" Basic data==>\n ");
				
				System.out.println("Name :"+current.basicdata.getName()+"\n"
						+ "Father name: "+current.basicdata.getFatherName()+"\n"
								+ "CNIC: "+current.basicdata.getCNIC()+"\n"
								+ "Gender: "+current.basicdata.getGender()+"\n"
										+ "Address: "+current.basicdata.getAddress()+"\n"
												+ "Nationality: "+current.basicdata.getNationality()+"\n");
			 
				
				if( current.basicdata.crimeobject!=null ) {
						
						System.out.println(" Crime data==>\n ");
						
						System.out.println("CNIC: "+current.basicdata.crimeobject.getCNIC()+"\n"
									+ "Crime: "+current.basicdata.crimeobject.getDetail()+"\n"
											+ "Punishment: "+current.basicdata.crimeobject.getPunishment()+"\n"
													+ "Charges: "+current.basicdata.crimeobject.getCharges()+"\n"
															+ "Fine: "+current.basicdata.crimeobject.getFine()+"\n");
		 			}
					
					if ( current.basicdata.networkobject!=null ) {
						
						System.out.println(" Cell Network data==>\n ");
						
						 System.out.println( "CNIC: "+current.basicdata.networkobject.getCNIC()+"\n"
								+ "Numbers: "+current.basicdata.networkobject.getNumber1()+"\n"
										+ "Activation Date: "+current.basicdata.networkobject.getActivation_Date1()+"\n"
												+ "Deactivation Date: "+current.basicdata.networkobject.getDeactivation_Date1()+"\n"
														+ "Status: "+current.basicdata.networkobject.getStatus1()+"\n");
					}
					
				
				
				break;  //after print searched record exit from this method
			}
			current=current.next;
		}
		
		if(current==null) {
			System.out.println("\nCNIC doesn't exist!\n");
		}
		
	}
	
	//To update record
	
	public void update( AD <AD> alien ) {
		
		String waste=sc.nextLine();
		
		System.out.println("Enter CNIC whose record You wanna Update");
		String nic=sc.next();
		
		DoublyNode <T> current=head;
		
		while(current!=null) {
			if(current.basicdata.CNIC.compareTo(nic)==0) {
				
				System.out.println("Name :"+current.basicdata.getName()+"\n"
						+ "Father name: "+current.basicdata.getFatherName()+"\n"
								+ "CNIC: "+current.basicdata.getCNIC()+"\n"
								+ "Gender: "+current.basicdata.getGender()+"\n"
										+ "Address: "+current.basicdata.getAddress()+"\n\n");
			 
				System.out.println("1- To update Name / Father name\n"
						+ "2- To update Nationality\n"
						+ "3- To update Address\n");
				int selection=0;
				selection=sc.nextInt();
				while(selection<1 || selection>3) {
					System.out.println("Enter again! ");
					selection=sc.nextInt();
				}
				if (selection==1) {
					
				System.out.println("Enter name");
				Name=sc.next();
				System.out.println("Enter father name");
				FatherName=sc.next();
				current.basicdata.setName(Name);
				current.basicdata.setFatherName(FatherName);
				System.out.println("\nDONE!\n");
				System.out.println("\n---------------------"
						         + "---------------------\n");
				
				}
				else if(selection==2) {
					
					System.out.println("Enter Nationality!");
					Nationality=sc.next();
					current.basicdata.setNationality(Nationality);
					
					if(Nationality.equalsIgnoreCase("Alien")) {
					
						DeclareAlien( alien, current );
					}
					
					System.out.println("\nDONE!\n");
					System.out.println("\n---------------------"
							         + "---------------------\n");
					
				}
				else if(selection==3) {
				System.out.println("Enter address");
				Address=sc.next();
				current.basicdata.setAddress(Address);
				
				System.out.println("\nDONE!\n");
				System.out.println("\n---------------------"
						         + "---------------------\n");
				
				}
				
				
				break;  //after update record exit from this method
			}
			current=current.next;
		}
		
	}
	
	//To declare alien someone
	public void DeclareAlien(AD <AD> alien, DoublyNode <T> node) {
		
		//AD <AD> alien = new AD <AD>();
		alien.DeclareAlien(head, node);
	}
	
	
	
		
	// function to link the same CNIC in different linked lists  
	// OR  to build the two way relationship between CBID,CCID,CCND 	
		
		
		void LINK( CCID <CCID> crimelist , CCND <CCND> networklist) {
			
	 DoublyNode <T> basiccurrent = head;
     DoublyCircular <CCID> crimecurrent=crimelist.head;
     SinglyCircular <CCND> networkcurrent = networklist.head;	
     
     // link with CCID
     
			do {
				crimecurrent=crimelist.head;   // again set to head to traverse from start
           do {
        	   
        	   if(crimecurrent.crimedata.getCNIC().compareTo( basiccurrent.basicdata.getCNIC() )==0) {
					
        		   basiccurrent.basicdata.crimeobject = crimecurrent.crimedata;
 					
 					break;  
 				}
        	   
        	   crimecurrent=crimecurrent.next;
        	   
           }while( crimecurrent!=crimelist.head );
           
           
           basiccurrent=basiccurrent.next;
			
			}while ( basiccurrent!=null );
			
			
		// link with CCND
			
			basiccurrent = head;  // set basiccurrent to head again to traverse from start
			
			do {
				networkcurrent = networklist.head; // again set to head to traverse from start
				
            do {
         	   
         	   if(basiccurrent.basicdata.CNIC.compareTo( networkcurrent.celldata.getCNIC() )==0) {
 					
         		  basiccurrent.basicdata.networkobject = networkcurrent.celldata;
  					
  					break;  
  				}
         	   
         	  networkcurrent=networkcurrent.next;
         	   
            }while( networkcurrent!=networklist.head );
            
            
            basiccurrent=basiccurrent.next;
			
			} while(basiccurrent!=null);
			
			
		} // LINK method closing bracket
	
	
	
	
	
	
	
	
	
}
