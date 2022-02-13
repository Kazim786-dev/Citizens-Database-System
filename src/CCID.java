import java.util.*;

public class CCID <T> {

	private String Detail, Punishment,Charges,Fine,CNIC;

	DoublyCircular <T> head, last;
	
	CBID <CBID> basicobject;
	CCND <CCND> networkobject;
	
	
	
	Scanner sc=new Scanner(System.in);
	
	public CCID() {
		
	}
	
//parameterized constructor
	
	public CCID( String nic, String d, String p, String c, String f) //, CBID obj1, CCND obj2) 
	   {
		
		 CNIC=nic; Detail=d; Punishment=p; Charges=c; Fine=f; // basicobject=obj1; networkobject=obj2;
		}
	
	//getters setters

	public String getDetail() {
		return Detail;
	}

	public void setDetail(String detail) {
		Detail = detail;
	}

	public String getPunishment() {
		return Punishment;
	}

	public void setPunishment(String punishment) {
		Punishment = punishment;
	}

	public String getCharges() {
		return Charges;
	}

	public void setCharges(String charges) {
		Charges = charges;
	}

	public String getFine() {
		return Fine;
	}

	public void setFine(String fine) {
		Fine = fine;
	}

	public String getCNIC() {
		return CNIC;
	}

	public void setCNIC(String cNIC) {
		CNIC = cNIC;
	}

	
	
    public void printList() {
		
    	int x=1;
    	DoublyCircular <T> tnode = head;    // tnode is traversal node
       
		do {
			 System.out.print(x+"- "+tnode.crimedata.getCNIC()+" "+tnode.crimedata.getDetail()+" "+tnode.crimedata.getPunishment()+" "+tnode.crimedata.getCharges()+" "+tnode.crimedata.getFine() );
			 System.out.println();
	            tnode = tnode.next;
		
		x++;
		}
		while (tnode != head);
       
		x=0;
		System.out.println();
    }
	
 // To insert at last
	
 	public void insertAtLast(CCID <T> object)
 	{
 		DoublyCircular <T> newnode = new DoublyCircular <T>(object);
 		
 	    // 1. Check if the head Node is null 
 	    if (head == null)
 	    {
 	    	  
 	    	head=newnode;
 	    	last=newnode;
 	    	last.next=head;
 	    	head.previous=last;
 	        return;
 	    }
 	 
 	    /*  Allocate the Node &
 	     Put in the data*/
 	 
 	    newnode.next =head;
 	    last.next=newnode;
 	    last=newnode;
 	   head.previous=last;
 	    sortList();

 	}

 	
 // To sort the record

 	@SuppressWarnings("unchecked")
	public void sortList() {  
 		DoublyCircular <T> current = null, index = null;  
         CCID <T> temp;  
         //Check whether list is empty  
         if(head == null) {  
             return;  
         }  
         else {  
        	 current = head;
        	 do {
        		 
        		 //Index will point to node next to current  
        		 index = current.next;
              	while( index != head ) {  
                  
              		//If current's data is greater than index's data, 
              		//swap the data of current and index  
                  
              		String cnic1=current.crimedata.CNIC;
            		String cnic2=index.crimedata.getCNIC();
              		
              		if(Integer.parseInt(cnic1) > Integer.parseInt(cnic2)) {
              		
                          temp = current.crimedata;  
                          current.crimedata = index.crimedata;  
                          index.crimedata = temp;  
                       }
              		index = index.next;
                  }
              	 current = current.next; //Current will point to next
        	 
        	 } 
        	 while( current != head);
             
         }  
     }  
 	 
 	
 	
 	//To search record
 		public void search() {
 			
 			System.out.println("Enter CNIC whose record You wanna Search");
 			String nic=sc.next();
 			
 			DoublyCircular <T> current=head;
 			
 			do {
 				
               if(current.crimedata.CNIC.compareTo(nic)==0) {
 					
            	   System.out.println(" Crime data==>\n ");
            	   
 					System.out.println("CNIC: "+current.crimedata.getCNIC()+"\n"
 									+ "Crime: "+current.crimedata.getDetail()+"\n"
 											+ "Punishment: "+current.crimedata.getPunishment()+"\n"
 													+ "Charges: "+current.crimedata.getCharges()+"\n"
 															+ "Fine: "+current.crimedata.getFine()+"\n");
 				 
 					if( current.crimedata.basicobject!=null ) {
 						
 						System.out.println(" Basic data==>\n ");
 						
 						System.out.println("Name :"+current.crimedata.basicobject.getName()+"\n"
 								+ "Father name: "+current.crimedata.basicobject.getFatherName()+"\n"
 										+ "CNIC: "+current.crimedata.basicobject.getCNIC()+"\n"
 										+ "Gender: "+current.crimedata.basicobject.getGender()+"\n"
 												+ "Address: "+current.crimedata.basicobject.getAddress()+"\n"
 														+ "Nationality: "+current.crimedata.basicobject.getNationality()+"\n");
 		 			}
 					
 					if ( current.crimedata.networkobject!=null ) {
 						
 						System.out.println(" Cell Network data==>\n ");
 						
 						 System.out.println( "CNIC: "+current.crimedata.networkobject.getCNIC()+"\n"
 								+ "Numbers: "+current.crimedata.networkobject.getNumber1()+"\n"
 										+ "Activation Date: "+current.crimedata.networkobject.getActivation_Date1()+"\n"
 												+ "Deactivation Date: "+current.crimedata.networkobject.getDeactivation_Date1()+"\n"
 														+ "Status: "+current.crimedata.networkobject.getStatus1()+"\n");
 					}
 					
 					System.out.println("------------\n------------\n");
 					
 					
 					break;  //after print searched record exit from this method
 				}
 				current=current.next;
 				
 			} while(current!=head);
 			
 			
 	//		if(current==head) 
 	//			System.out.println("\nCNIC doesn't exist!\n");
 			
 			
 			
 		}
 	
 	
 	

 	//To update record
	
 		public void update() {
 			
 			System.out.println("Enter CNIC whose record You wanna Update");
 			String nic=sc.next();
 			System.out.println("Enter Crime of this person");
 			String crime=sc.next();
 			
 			DoublyCircular <T> current=head;
 			
 			do {
 				     // check if given inputs (Both) exist and match
            if(current.crimedata.CNIC.compareTo(nic)==0 && current.crimedata.getDetail().compareTo(crime)==0) {
 					
 					System.out.println( "CNIC: "+current.crimedata.getCNIC()+"\n"
 									+ "Crime: "+current.crimedata.getDetail()+"\n"
 											+ "Punishment: "+current.crimedata.getPunishment()+"\n"
 													+ "Charges: "+current.crimedata.getCharges()+"\n"
 															+ "Fine: "+current.crimedata.getFine()+"\n");
 				 
 					System.out.println("1- To update Crime Details\n"
 							+ "2- To update Punishment\n"
 							+ "3- To update Charges / Fine\n");
 					int selection=0;
 					selection=sc.nextInt();
 					while(selection<1 || selection>3) {
 						System.out.println("Enter again! ");
 						selection=sc.nextInt();
 					}
 					if (selection==1) {
 					System.out.println("Enter Crime");
 					Detail=sc.next();
 					current.crimedata.setDetail(Detail);
 					
 					}
 					else if(selection==2) {
 						System.out.println("Enter Punishment");
 	 					Punishment=sc.next();
 	 					current.crimedata.setPunishment(Punishment);
 							
 					}
 					else if(selection==3) {
 					System.out.println("Enter Charges");
 					Charges=sc.next();
 					System.out.println("Enter Fine");
 					Fine=sc.next();
 					current.crimedata.setCharges(Charges);
 					current.crimedata.setFine(Fine);
 					}
 					
 					
 					break;  //after update record exit from this method
 				}
 				current=current.next;
 				
 			} while(current!=head);
 			
 		}

 		
 		//To Add the crime on given CNIC which is not already present in crime list 
 		// but present in CBID
 		
 		void AddNewCrime( DoublyNode <CBID> basiclistHead ) {
 			
 			System.out.println("Enter CNIC");
 			CNIC=sc.next();
 			
 			
 			
 			DoublyNode <CBID> basiccurrent=basiclistHead;
 			boolean check=false;
 			
 	// loop to check wheteher given CNIC exists in CBID		
 			while(basiccurrent!=null) {
 				
 				if(basiccurrent.basicdata.getCNIC().equalsIgnoreCase(CNIC)) {
 					
 					check=true;
 					break;
 				}
 				basiccurrent=basiccurrent.next;
 			}
 			
 			if( check==false ) {
 				
 				System.out.println("\nCNIC does'nt register in CBID.");
 				System.out.println("First register in CBID\n");
 				return;
 			}
             
 		// loop to check wheteher given CNIC already exists in CCID			
 			
 			DoublyCircular <T> current=head;
 			
 			do {
 				
               if(current.crimedata.CNIC.compareTo(CNIC)==0) {
            	   
            	   System.out.println("It's not a new one.This CNIC already exists in CCID database. Choose different option from menu.");
            	   check=false;
            	   
            	   break;
            	   
               }
				current=current.next;
				
			} while(current!=head);
 			
 			
 			 if( check==true ) {
 				
 				
 				DoublyCircular <T> crimecurrent=head;
 				
 				
 				 System.out.println("\nOk! Now enter crime related data you want to add....\n");
 		    	   String waste =sc.nextLine();
 		    	   System.out.println("Enter crime details!");
 		 			Detail=sc.next();
 		 			waste =sc.nextLine();
 		 			System.out.println("Enter Punishment!");
 		 			String punishment=sc.nextLine();
 		 			 waste =sc.nextLine();
 		 			System.out.println("Enter Charges!");
 		 			Charges=sc.next();
 		 			System.out.println("Enter Fine!");
 		 			Fine=sc.next();
 				
 		 			CCID <T> obj = new CCID(CNIC, Detail, punishment, Charges, Fine); // , null, null);
 		 			
 		 			// Assigning the read values from file
 		 			
 		 			insertAtLast(obj);
 		 			
 		 			System.out.println("\nSuccessfully Added!\n");
 		 			
 		 			
 		 			
 		 			System.out.println("---------------------------\n");
 		 			
 				
 			}
 			
 			
 		}  // AddNewCrime function closing bracket
 		
 		
 		
 		
 		
 		//To Add the crime on given CNIC which is already in crime list
 		
 		void AddCrimeOnRegistered() {
 			
 			System.out.println("Enter CNIC");
 			String nic=sc.next();
 			
 			DoublyCircular <T> current=head;
 			
 			do {
			     // check if given inputs (Both) exist and match
 				if(current!=null)
                 if(current.crimedata.CNIC.compareTo(nic)==0) {
 			
    	   System.out.println("\nOk! Now enter crime related data you want to add....\n");
    	   String waste =sc.nextLine();
    	   System.out.println("Enter crime details!");
 			Detail=sc.next();
 			waste =sc.nextLine();
 			System.out.println("Enter Punishment!");
 			String punishment=sc.nextLine();
 			 waste =sc.nextLine();
 			System.out.println("Enter Charges!");
 			Charges=sc.next();
 			System.out.println("Enter Fine!");
 			Fine=sc.next();
 			
 			//append the data on given CNIC
 			
 			if(current.crimedata.getDetail().charAt(current.crimedata.getDetail().length()-1)==' ')
 				Detail=current.crimedata.getDetail()+Detail;
 			else
 			Detail=current.crimedata.getDetail()+" "+Detail;
 			
 			if( current.crimedata.getPunishment().charAt(current.crimedata.getPunishment().length()-1)==',')
 				Punishment=current.crimedata.getPunishment()+punishment+",";	
 			else
 			Punishment=current.crimedata.getPunishment()+","+punishment;
 			Charges=current.crimedata.getCharges()+" "+Charges;
 			Fine=current.crimedata.getFine()+" "+Fine;
 			
 			
 			current.crimedata.setDetail(Detail);
 			current.crimedata.setPunishment(Punishment);
 			current.crimedata.setCharges(Charges);
 			current.crimedata.setFine(Fine);
 			
 			CCID <T> obj = new CCID(CNIC, Detail, punishment, Charges, Fine); // , current.crimedata.basicobject, current.crimedata.networkobject);
 			
 			System.out.println("\nSuccessfully Added!\n");
 			break;
 			}
 			
 			
 		}while(current!=head);
 		
 		
       }
 		
 		//To delete the crime on given CNIC
 		
 		void deleteCrime() {
 		
 			System.out.println("Enter CNIC whose Crime You want to delete");
 			String nic=sc.next();
 			
 			DoublyCircular <T> current=head;
 			
 			do {
			     // check if given inputs (Both) exist and match
       if(current.crimedata.CNIC.compareTo(nic)==0) {
 			
    	   
    	   System.out.println("Crimes==>\n");
    	   
    	 //Split the Crimes,punishments,charges and fines
    	   
    	   String [] Crimearray=current.crimedata.getDetail().split(" ");
    	   String [] Punisharray=current.crimedata.getPunishment().split(",");
    	   String [] Chargesarray=current.crimedata.getCharges().split(" ");
    	   String [] Finearray=current.crimedata.getFine().split(" ");
    	  
    	   //Show the Splitted Crimes 
    	   for(int i=0; i<Crimearray.length;i++) {
    		   System.out.println((i+1)+"- "+Crimearray[i]);
    	   }
    	 
    	   System.out.println("Choose which you want to delete!");
    	   int choice=sc.nextInt();
    	   
    	   while(choice<1||choice>Crimearray.length) {
    		   System.out.println("Enter again");
    		   choice=sc.nextInt();
    	   }
    	   
    	   //delete the choosen crime and related data from array 
    	
    	   for(int j=choice-1;j<Crimearray.length-1;j++) {
    		   Crimearray[j]=Crimearray[j+1];
    		   Punisharray[j]=Punisharray[j+1];
    		   Chargesarray[j]=Chargesarray[j+1];
    		   Finearray[j]=Finearray[j+1];
    		   
    	   }
    	   
    	   
    	   
    	   Detail="";Punishment="";Charges="";Fine="";
    	
    	  // loop to assign data to variables from array with appending
    	   
    	   for(int i=0;i<Crimearray.length-1;i++) {
    			
    		   if(Crimearray[i]!=null) {
    			
    			Detail=Detail+Crimearray[i]+" ";
    			Punishment=Punishment+Punisharray[i]+",";
    			Charges=Charges+Chargesarray[i]+" ";
    			Fine=Fine+Finearray[i]+" ";
    			}
    		 }
 			
 			current.crimedata.setDetail(Detail);
 			current.crimedata.setPunishment(Punishment);
 			current.crimedata.setCharges(Charges);
 			current.crimedata.setFine(Fine);
 			
 			
 			System.out.println("Successfully deleted!\n");
 			break;
 			}
 			
 			
 		}while(current!=head);
 		
 	  }
 		
 		
 		
 	// function to link the same CNIC in different linked lists  
 	// OR  to build the two way relationship between CBID,CCID,CCND 	
 		
 		
 		void LINK( CBID <CBID> basiclist , CCND <CCND> networklist) {
 			
 		 DoublyNode <CBID> basiccurrent = basiclist.head;
 		DoublyCircular <T> crimecurrent=head;
         SinglyCircular <CCND> networkcurrent = networklist.head;	
         
         // link with CBID
         
 			do {
 				basiccurrent = basiclist.head;
               do {
            	   
            	   if(crimecurrent.crimedata.CNIC.compareTo( basiccurrent.basicdata.getCNIC() )==0) {
    					
                	   crimecurrent.crimedata.basicobject = basiccurrent.basicdata;
     					
     					break;  
     				}
            	   
            	   basiccurrent=basiccurrent.next;
            	   
               }while( basiccurrent!=null );
               
               
 				crimecurrent=crimecurrent.next;
 			
 			}while(crimecurrent!=head);
 			
 			
 		// link with CCND
 			
 			crimecurrent=head;   // set crimecurrent to head again to traverse from start
 			
 			do {
 				
 				networkcurrent = networklist.head;
 				
                do{
             	  // System.out.println("asif");
             	   if(crimecurrent.crimedata.CNIC.compareTo( networkcurrent.celldata.getCNIC() )==0) {
     					
                 	   crimecurrent.crimedata.networkobject = networkcurrent.celldata;
      					
      					break;  
      				}
             	   
             	  networkcurrent=networkcurrent.next; 
             	   
                } while( networkcurrent!=networklist.head );
                
                
  				crimecurrent=crimecurrent.next;
  			
  			} while(crimecurrent!=head);
 			
 			
 		} // LINK method closing bracket
 		
 		
 		
 		
 		
 		
}		