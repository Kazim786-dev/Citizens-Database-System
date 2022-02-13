import java.util.Scanner;

public class CCND <T> {

	private String CNIC,Network,Number1, Activation_Date1,Deactivation_Date1, Status1;

	SinglyCircular <T> head, last;
	
	CBID <CBID> basicobject;CCID <CCID> crimeobject;
	
    Scanner sc=new Scanner(System.in);
	
	public CCND() {
		
	}
	
//parameterized constructor
	
	public CCND( String nic, String net, String n1, String adate1, String ddate1, String s1) // , CBID obj1, CCID obj2 ) 
	   {
		
		       CNIC=nic; Network=net; Number1=n1;  Activation_Date1=adate1; // basicobject=obj1; crimeobject=obj2;
		       Deactivation_Date1=ddate1; Status1=s1; 
		}

	//getters and setters
	
	public String getCNIC() {
		return CNIC;
	}

	public void setCNIC(String cNIC) {
		CNIC = cNIC;
	}

	public String getNumber1() {
		return Number1;
	}

	public void setNumber1(String number1) {
		Number1 = number1;
	}

	public String getActivation_Date1() {
		return Activation_Date1;
	}

	public void setActivation_Date1(String activation_Date1) {
		Activation_Date1 = activation_Date1;
	}
	
	public String getDeactivation_Date1() {
		return Deactivation_Date1;
	}

	public void setDeactivation_Date1(String deactivation_Date1) {
		Deactivation_Date1 = deactivation_Date1;
	}

	public String getStatus1() {
		return Status1;
	}

	public void setStatus1(String status1) {
		Status1 = status1;
	}
	
	public String getNetwork() {
		return Network;
	}

	public void setNetwork(String network) {
		Network = network;
	}

	
	
	
	// to print the data
	
	void print() {
		
		SinglyCircular <T> tnode = head;    // tnode is traversal node
	       
		int x=1;
		
		do {
			 System.out.print(x+"- "+tnode.celldata.getCNIC()+" "+tnode.celldata.getNumber1()+" "+tnode.celldata.getStatus1()+" "
			 		+tnode.celldata.getActivation_Date1()+" "+tnode.celldata.getDeactivation_Date1() );
			 System.out.print( " NETWORK : "+tnode.celldata.getNetwork() );
			 System.out.println();
	            tnode = tnode.next;
	            
	           x++; 
		}
		while (tnode != head);
       
		x=0;
		System.out.println();
		
	}
	
	
	
	
	
	// to insert a new node
	
	public void insertAtLast(CCND <T> object)
		{
		SinglyCircular <T> newnode = new SinglyCircular <T>(object , true);
			
		    // 1. Check if the head Node is null 
		    if (head == null)
		    {
		    	  
		    	head=newnode;
		    	last=newnode;
		    	last.next=head;
		        return;
		    }
		 
		    /*  Allocate the Node &
		     Put in the data*/
		 
		    newnode.next =head;
		    last.next=newnode;
		    last=newnode;
		    
		    sortList();

		}

		
	// To sort the record

		public void sortList() {  
			SinglyCircular <T> current = null, index = null; 
			
	     CCND <T> temp;  
	     
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
	              
	    			 String cnic1=current.celldata.CNIC;
	            		String cnic2=index.celldata.getCNIC();
	    			 
	          		if(Integer.parseInt(cnic1) > Integer.parseInt(cnic2)) {
	          		
	                      temp = current.celldata;  
	                      current.celldata = index.celldata;  
	                      index.celldata = temp;  
	                   }
	          		index = index.next;
	              }
	          	 current = current.next; //Current will point to next
	    	 
	    	 } 
	    	 while( current != head);
	         
	     }  
	 }
	
	
		//To add new record on given CNIC alaready in CBID list and does not present in CCND list
		
		void AddNewCell( DoublyNode <CBID> basiclistHead ) {
			
			System.out.println("Enter CNIC");
 			CNIC=sc.next();
 			
 			CBID <T> obj=new CBID <T>();
 			
 			DoublyNode <CBID> basiccurrent= basiclistHead ;
 			boolean check=false;
 			
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
 			
 			
 			//check if CNIC already exist in CCND then function does not perform
 			// bcz this is only for newly registered CNIC's
 			
 			SinglyCircular <T> current1=head;
 			
 			do {
 				
 				if( current1.celldata.getCNIC().compareTo(CNIC)==0 ) {
 					System.out.println("\nThis CNIC is already registered in CCND database. Try a differentoption from menu.\n");
 					check=false;
 				}
 				
 			}while( current1!=head );
 			
 			
 			if( check==true ) {
 				
 				        System.out.println("Enter new Number");
					    String number=sc.next();
					    System.out.println("Enter activation date");
	 					String ad=sc.next();
	 					System.out.println("Enter De-activation date");
	 					String dd=sc.next();
	 					System.out.println("Enter netwok");
	 					String network=sc.next();
 				
 				CCND <T> cellobj = new CCND <T>(CNIC,network, number, ad, dd, "active" ); // , null, null);
 				
 				// Assigning the read values from file
 				
 				insertAtLast(cellobj);
 				
 				
 				System.out.println("\nSuccessfully Added!\n");
 				
 			}
			
			
			
		} // AddNewCell method closing bracket
		
		
		
		
		
	
		//To update record on given CNIC alaready in CCND list
		
 		public void updateRecord() {
 			
 			System.out.println("\n==>Enter CNIC whose record You wanna Update\n");
 			String nic=sc.next();
 			
 			SinglyCircular <T> current=head;
 			
 			do {
 				
            if(current.celldata.CNIC.compareTo(nic)==0) {
 					
            		
					// Ask user what he/she want to do	
					
 					System.out.println("1- To register number on this CNIC \n"
 							+ "2- To Delete number registered on this CNIC \n"
 							+ "3- To update number registered on this CNIC \n");
 					int selection=0;
 					selection=sc.nextInt();
 					
 					while(selection<1 || selection>3) {
 						System.out.println("Enter again! ");
 						selection=sc.nextInt();
 					}
 					
 					
 		// Check wheteher 4 numbers have already registered on given CNIC or not 
 			
 				if(selection==1) {
 					
 					SinglyCircular <T> traversalNode=head;
 					
 					
 					
 					String [] NUM;
 					 {
 						NUM=current.celldata.getNumber1().split(" ");
 						
 						if(!current.celldata.getNumber1().equals("")) { 
 						
 		// Show All numbers registered on given CNIC
 			            	
 						
 							System.out.println("\n==> Numbers registered on given CNIC\n");
 							
 						for( int i=0; i<NUM.length; i++ ) {
 							System.out.println((i+1)+"- "+NUM[i]);
 						
 						}// for loop closed
 					  }
 						else {
 							System.out.println("\n==> No number registered on this CNIC!\n");
 						}
 						
 						
 						if(NUM.length==4) {
 							System.out.println("==> Already 4 numbers are registered!\n"
 									+ "You cannot add register more numbers on this CNIC!!!\n\n");
 						}
 						else {
 							System.out.println("Enter new Number");
 		 					String number=sc.next();
 		 					
 		 					SinglyCircular <T> checkNumExistNode =head;
 		 					int flag=0;
 		 					
 		 				// loop to check whether number already registered or not	
 		 					while(flag==0) {
 		 						if( checkNumExistNode.celldata.getNumber1().contains(number) )
 		 						{
 		 							System.out.println("\n==> Number already registered. Please Enter a new one!\n");
 		 							number=sc.next();
 		 							checkNumExistNode =head;
 		 						}
 		 						else if (checkNumExistNode.next==head) {
 		 							flag=1;
 		 						}
 		 						else {
 		 							checkNumExistNode =checkNumExistNode.next;
 		 						}
 		 						
 		 					}
 		 			// take input
 		 					
 		 					System.out.println("Enter activation date");
 		 					String ad=sc.next();
 		 					System.out.println("Enter De-activation date");
 		 					String dd=sc.next();
 		 					System.out.println("Enter netwok");
 		 					Network=sc.next();
 		 					
 		 					if(!current.celldata.getNumber1().equals("")) {
 		 					
 		 					if(current.celldata.getNumber1().charAt(current.celldata.getNumber1().length()-1)==' ' )
 		 						number = current.celldata.getNumber1()+number+" ";
 		 					else
 		 						number = current.celldata.getNumber1()+" "+number+" ";
 		 					}
 		 					
 		 					current.celldata.setNumber1(number);
 		 					
 		 					if(!current.celldata.getActivation_Date1().equals("")) {
 		 					
 		 					if(current.celldata.getActivation_Date1().charAt(current.celldata.getActivation_Date1().length()-1)==' ')
 		 					    ad=current.celldata.getActivation_Date1()+ad+" ";
 		 					else
 		 						ad=current.celldata.getActivation_Date1()+" "+ad+" ";
 		 					}
 		 					current.celldata.setActivation_Date1(ad);
 		 					
 		 					
 		 					if( ! current.celldata.getDeactivation_Date1().equals("") ){	
 		 					
 		 						if( current.celldata.getDeactivation_Date1().charAt(current.celldata.getDeactivation_Date1().length()-1)==' ' )
 		 					     dd=current.celldata.getDeactivation_Date1()+dd+" ";
 		 					else
 		 						dd=current.celldata.getDeactivation_Date1()+" "+dd+" ";
 						}
 		 					current.celldata.setDeactivation_Date1(dd);
 		 					
 		 					if(!current.celldata.getNetwork().equals("")){
 		 					
 		 						if(current.celldata.getNetwork().charAt(current.celldata.getNetwork().length()-1)==' ')
 		 					    Network=current.celldata.getNetwork()+Network+" ";
 		 					else
 		 						Network=current.celldata.getNetwork()+" "+Network+" ";
 						}
 		 					
 		 					current.celldata.setNetwork(Network);
 		 					
 		 					if( ! current.celldata.getStatus1().equals("") ) {
 		 					
 		 						if( current.celldata.getStatus1().charAt(current.celldata.getStatus1().length()-1)==' ' )
 		 					    Status1=current.celldata.getStatus1()+"active"+" ";
 		 					else
 		 						Status1=current.celldata.getStatus1()+" "+"active"+" ";
 		 					}
 		 					current.celldata.setStatus1(Status1);
 		 					
 		 					
 		 					System.out.println("Done!!!");
 		 					
 						}
 						
 					}
 					
            } // selection==1 close
 					
 					
 					
 					
 // "else" for deletion of number					
 					
 					else if(selection==2) {

 						String [] NUM;String [] deac;String [] act;String [] sta;String [] netw;
 			
 			//splitting data into array from a single variable
 						
 						act=current.celldata.getActivation_Date1().split(" ");
	 						deac=current.celldata.getDeactivation_Date1().split(" ");
	 						sta=current.celldata.getStatus1().split(" "); 
 	 						NUM=current.celldata.getNumber1().split(" ");
 	 						netw=current.celldata.getNetwork().split(" ");
 	 						
 	 						if(!current.celldata.getNumber1().equals("")) { 
 	 						
 	 		// Show All numbers registered on given CNIC
 	 			            	
 	 						
 	 							System.out.println("Numbers registered on given CNIC");
 	 							
 	 	 						for( int i=0; i<NUM.length; i++ ) {
 	 	 							System.out.println((i+1)+"- "+NUM[i]);
 	 	 						
 	 	 						}     // for loop closed
 	 	 					  
 	 	 						System.out.println("\n==> Choose the number which you want to delete!");
 	 	 						System.out.println("      Choose by enter corresponding number!!!\n\n");
 	 	 						int select=sc.nextInt();
 
 	 	 						while(select<1||select>NUM.length) {
 	 	 							System.out.println("Enter again!");
 	 	 							select=sc.nextInt();
 	 	 							
 	 	 						} // while closed
 	 						
 	 	 						
 	 	 			//delete the choosen number and related data from array		
 	 	 						
 	 	 						for(int j=select-1;j<NUM.length-1;j++) {
 	 	 			    		   NUM[j]=NUM[j+1];
 	 	 			    		   netw[j]=netw[j+1];
 	 	 			    		   sta[j]=sta[j+1];
 	 	 			    		   deac[j]=deac[j+1];
 	 	 			    		   act[j]=act[j+1];
 	 	 			    		   
 	 	 			    	   }
 	 						
 	 	 		 
 	 	 				Number1="";Network="";Activation_Date1="";Status1="";Deactivation_Date1="";
 	 	 				    	
 	 	 			    	  // loop to assign data to variables from array with appending
 	 	 			    	   
 	 	 			    	   for(int i=0;i<NUM.length-1;i++) {
 	 	 			    			
 	 	 			    		   if(NUM[i]!=null) {
 	 	 			    			
 	 	 			    			Number1=Number1+NUM[i]+" ";
 	 	 			    			Activation_Date1=Activation_Date1+act[i]+",";
 	 	 			    			Network=Network+netw[i]+" ";
 	 	 			    			Status1=Status1+sta[i]+" ";
 	 	 			    			Deactivation_Date1=Deactivation_Date1+deac[i]+" ";
 	 	 			    			}
 	 	 			    		 }
 	 	 			 			
 	 	 			 			current.celldata.setNumber1(Number1);
 	 	 			 			current.celldata.setNetwork(Network);
 	 	 			 			current.celldata.setActivation_Date1(Activation_Date1);
 	 	 			 			current.celldata.setDeactivation_Date1(Deactivation_Date1);
 	 	 			 		    current.celldata.setStatus1(Status1);
 	 	 			 			
 	 	 			 			
 	 	 			 			System.out.println("Successfully deleted!\n");
 	 	 			 			break;			
 	 	 						
 	 						
 	 					  }
 	 						else {
 	 							System.out.println("No number registered on this CNIC!!!\n");
 	 						}
 						
 						
 						
 						
 					}       // selection==2 closed
 					
 				
 				
// "else" to update number	 					
 					
 					else if(selection==3) {

 						
 						String [] NUM;String [] deac;String [] act;String [] sta;
 	 					 
 	 						NUM=current.celldata.getNumber1().split(" ");
 	 						act=current.celldata.getActivation_Date1().split(" ");
 	 						deac=current.celldata.getDeactivation_Date1().split(" ");
 	 						sta=current.celldata.getStatus1().split(" ");
 	 						
 	 						if(!current.celldata.getNumber1().equals("")) { 
 	 						
 	 							System.out.println("\n==>Numbers registered on given CNIC\n");
 	 							
 	 						for( int i=0; i<NUM.length; i++ ) {
 	 							System.out.println((i+1)+"- "+NUM[i]);
 	 						
 	 						}// for loop closed
 	 					  
 	 						System.out.println("\n==>Choose by enter corresponding number!!!\n");
 	 						int select=sc.nextInt();
 	 						
 	 						
 	 						
 	 						while(select<1||select>NUM.length) {
 	 							System.out.println("Enter again!");
 	 							select=sc.nextInt();
 	 							
 	 						} // while closed
 	 						
 	 						System.out.println("1- To Update Activation Date\n"
 		 							+ "2- To Update Deactivation Date\n"
 		 							+ "3- To update status\n"
 		 							+ "4- To update all");
 	 						
 	 						System.out.println("\nChoose what you want to Update!!!");
 	 						int choice=sc.nextInt();
 	 						
 	 						while(choice<1||choice>4) {
 	 							System.out.println("Enter again!");
 	 							choice=sc.nextInt();
 	 							
 	 						} // while closed
 	 						
 	 						
 	 						if(choice==1) {
 	 							System.out.println("Enter Activation date");
 	 							Activation_Date1=sc.next();
 	 							Deactivation_Date1=current.celldata.getDeactivation_Date1();
 	 							Status1=current.celldata.getStatus1();
 	 							
 	 							
 	 							
 	 						}else if(choice==2) {
 	 							System.out.println("Enter Deactivation date");
 	 							Deactivation_Date1=sc.next();
 	 							Activation_Date1=current.celldata.getActivation_Date1();
 	 							Status1=current.celldata.getStatus1();
 	 							
 	 						}
 	 						else if(choice==3) {
 	 							System.out.println("Enter Status");
 	 							Status1=sc.next();
 	 							Activation_Date1=current.celldata.getActivation_Date1();
 	 							Deactivation_Date1=current.celldata.getDeactivation_Date1();
 	 							
 	 						}
 	 						else if(choice==4) {
 	 							System.out.println("Enter Activation date");
 	 							Activation_Date1=sc.next();
 	 							System.out.println("Enter Deactivation date");
 	 							Deactivation_Date1=sc.next();
 	 							System.out.println("Enter Status");
 	 							Status1=sc.next();
 	 							
 	 						}
 	 						
 	 						
 	 						act[select-1]=Activation_Date1;
 	 						deac[select-1]=Deactivation_Date1;
 	 						sta[select-1]=Status1;		
 	 						
 	 						Activation_Date1="";Deactivation_Date1="";Status1="";
 	 						
 	 						// for loop to assign value
 	 						for( int i=0; i<NUM.length; i++ ) {
 	 							
 	 							Activation_Date1=act[i];
 	 							Deactivation_Date1=deac[i];
 	 							Status1=sta[i];
 	 							
 	 						
 	 						}// for loop closed
 	 						
 	 						current.celldata.setActivation_Date1(Activation_Date1);
 	 						current.celldata.setDeactivation_Date1(Deactivation_Date1);
 	 						current.celldata.setStatus1(Status1);
 	 						
 	 						System.out.println("DONE!!\n");
 	 						
 	 					 }
 	 						else {
 	 							System.out.println("No number registered on this CNIC!");
 	 						}
 						
 						
 						
 	 	
 					}   // selection==3 closed
 				
 				
 				
 				
 					
 					break;  //after update record exit from this method
 				}
 				current=current.next;
 				
 			} while(current!=head);
 			
 		}

 		
 		
 		
 		
 		//To search record
 		public void search() {
 			
 			System.out.println("Enter CNIC whose record You wanna Search");
 			String nic=sc.next();
 			
 			SinglyCircular <T> current=head;
 			
 			do {
 				
               if(current.celldata.CNIC.compareTo(nic)==0) {
 					
            	   System.out.println(" Cell network data==>\n ");
 					
            	   System.out.println( "CNIC: "+current.celldata.getCNIC()+"\n"
							+ "Numbers: "+current.celldata.getNumber1()+"\n"
									+ "Activation Date: "+current.celldata.getActivation_Date1()+"\n"
											+ "Deactivation Date: "+current.celldata.getDeactivation_Date1()+"\n"
													+ "Status: "+current.celldata.getStatus1()+"\n");
		 
            	   if( current.celldata.basicobject!=null ) {
						
						System.out.println(" Basic data==>\n ");
						
						System.out.println("Name :"+current.celldata.basicobject.getName()+"\n"
								+ "Father name: "+current.celldata.basicobject.getFatherName()+"\n"
										+ "CNIC: "+current.celldata.basicobject.getCNIC()+"\n"
										+ "Gender: "+current.celldata.basicobject.getGender()+"\n"
												+ "Address: "+current.celldata.basicobject.getAddress()+"\n"
														+ "Nationality: "+current.celldata.basicobject.getNationality()+"\n");
		 			}
            	   
            	   
            	   
            	   if( current.celldata.crimeobject!=null ) {
						
						System.out.println(" Crime data==>\n ");
						
						System.out.println("CNIC: "+current.celldata.crimeobject.getCNIC()+"\n"
									+ "Crime: "+current.celldata.crimeobject.getDetail()+"\n"
											+ "Punishment: "+current.celldata.crimeobject.getPunishment()+"\n"
													+ "Charges: "+current.celldata.crimeobject.getCharges()+"\n"
															+ "Fine: "+current.celldata.crimeobject.getFine()+"\n");
		 			}
            	   
            	   
            	   
            	   

					
 				 
 					break;  //after print searched record exit from this method
 				}
 				current=current.next;
 				
 			}while(current!=head);
 			
 			
 			if(current==head) {
 				System.out.println("\nCNIC doesn't exist!\n");
 			}
 			
 			
 		}
 		
 		
 		// To swap the owners of two numbers based on given CNIC
 		
 		void SwapOwnership() {
 			
 			
 			System.out.println("Enter CNIC whose record You wanna Swap");
 			String nic1=sc.next();
 			
 			SinglyCircular <T> current1=head;
 			
          String [] NUM1;String [] deac1;String [] act1;String [] sta1;String [] netw1;
 			
 			
 			
 			do {
 				
            if(current1.celldata.CNIC.compareTo(nic1)==0) {
            	
            	//splitting data into array from a single variable
					
					act1=current1.celldata.getActivation_Date1().split(" ");
						deac1=current1.celldata.getDeactivation_Date1().split(" ");
						sta1=current1.celldata.getStatus1().split(" "); 
						NUM1=current1.celldata.getNumber1().split(" ");
						netw1=current1.celldata.getNetwork().split(" ");
            	
						
	 						if(!current1.celldata.getNumber1().equals("")) { 
	 						
	 		// Show All numbers registered on given CNIC
	 			            	
	 						
	 							System.out.println("Numbers registered on given CNIC");
	 							
	 	 						for( int i=0; i<NUM1.length; i++ ) {
	 	 							System.out.println((i+1)+"- "+NUM1[i]);
	 	 						
	 	 						}     // for loop closed
	 	 					  
	 	 						System.out.println("\n==>Choose the number which you want to SWAP! ");
	 	 						System.out.print("Choose by enter corresponding number!!!\n\n");
	 	 						
	 	 						System.out.println("==>If you want to swap all numbers, Just enter 100\n");
	 	 						
	 	 						int select1=sc.nextInt();

	 	 						while(select1<1||select1>NUM1.length && select1!=100) {
	 	 							System.out.println("Enter again!");
	 	 							select1=sc.nextInt();
	 	 							
	 	 						} // while closed
	 	 						
	 	 						System.out.println("==>\nEnter CNIC with which you want to SWAP\n");
	 	 						String nic2=sc.next();
	 	 				
	 	 				
	 	 						SinglyCircular <T> current2=head;		
	 	 						
	 	 					// check wether user has entered the same CNIC
	 	 						
	 	 						int flag=1;		
	 	 						
	 	 					if(!nic2.equals(nic1)) {			
	 	 				
	 	 			// for second CNIC		
	 	 						
	  						do {
	 	 							String [] NUM2;String [] deac2;String [] act2;String [] sta2;String [] netw2;
	 	 							
	 	 							
	 	 							 if(current2.celldata.CNIC.compareTo(nic2)==0) {
	 	 								 
	 	 						//splitting data into array from a single variable
	 	 								
	 	 								act2=current2.celldata.getActivation_Date1().split(" ");
	 	 									deac2=current2.celldata.getDeactivation_Date1().split(" ");
	 	 									sta2=current2.celldata.getStatus1().split(" "); 
	 	 									NUM2=current2.celldata.getNumber1().split(" ");
	 	 									netw2=current2.celldata.getNetwork().split(" ");
	 	 								
	 	 							   if( ! current2.celldata.getNumber1().equals("") ) {
	 	 								
	 	 								 String num,deac,act,sta,netw;
	 	 								
	 	 								
	                     // if to swap all numbers
	 	 			
	 	 								if(select1==100) {
	 	 									   
	 	 									num= current1.celldata.getNumber1();
		 	 								deac=current1.celldata.getDeactivation_Date1();
		 	 								act=current1.celldata.getActivation_Date1();
		 	 								sta=current1.celldata.getStatus1();
		 	 								netw=current1.celldata.getNetwork();	
	 	 									
	 	 									
	 	 								current1.celldata.setNumber1( current2.celldata.getNumber1() ); 
	 	 								current1.celldata.setStatus1( current2.celldata.getStatus1() );	   
	 	 								current1.celldata.setNetwork( current2.celldata.getNetwork() );
	 	 								current1.celldata.setActivation_Date1( current2.celldata.getActivation_Date1() );
	 	 								current1.celldata.setDeactivation_Date1( current2.celldata.getDeactivation_Date1() );
	 	 								
	 	 								current2.celldata.setNumber1( num ); 
	 	 								current2.celldata.setStatus1( sta );	   
	 	 								current2.celldata.setNetwork( netw );
	 	 								current2.celldata.setActivation_Date1( act );
	 	 								current2.celldata.setDeactivation_Date1( deac );
	 	 								
	 	 								
	 	 								 }
	 	 								 
	 	 					      else {
	 	 									 
	 	 								// Show All numbers registered on given CNIC
	 	 		 			            	
	 	 			 						
	 	 		 							System.out.println("\n==>Numbers registered on given CNIC\n");
	 	 		 							
	 	 		 	 						for( int i=0; i<NUM2.length; i++ ) {
	 	 		 	 							System.out.println((i+1)+"- "+NUM2[i]);
	 	 		 	 						
	 	 		 	 						}     // for loop closed
	 	 		 	 					  
	 	 		 	 						System.out.println("\n==>Choose the number which you want to SWAP!");
	 	 		 	 						System.out.print("Choose by enter corresponding number!!!\n");
	 	 		 	 						
	 	 		 	 						int select2=sc.nextInt();

	 	 		 	 						while( select2<1||select2>NUM2.length ) {
	 	 		 	 							System.out.println("Enter again!");
	 	 		 	 							select2=sc.nextInt();
	 	 		 	 							
	 	 		 	 						} // while closed
	 	 									 
	 	 		 	 						
	 	 		 	 	String [] NUMtemp;String [] deactemp;String [] acttemp;String [] statemp;String [] netwtemp;
	 	 		 	 						
	 	 		 	     acttemp=current1.celldata.getActivation_Date1().split(" ");
						deactemp=current1.celldata.getDeactivation_Date1().split(" ");
						statemp=current1.celldata.getStatus1().split(" "); 
						NUMtemp=current1.celldata.getNumber1().split(" ");
						netwtemp=current1.celldata.getNetwork().split(" ");
	 	 		 	 	
	 	 		 	 	
	 	 						// Now swapping finally 
	 	 						
	 	 		 	 						NUM1[select1-1]=NUM2[select2-1];
	 	 		 	 						NUM2[select2-1]=NUMtemp[select1-1];
	 	 		 	 						
	 	 		 	 						deac1[select1-1]=deac2[select2-1];
	 	 		 	 						deac2[select2-1]=deactemp[select1-1];
	 	 		 	 						
	 	 		 	 				     	act1[select1-1]=act2[select2-1];
 	 		 	 						    act2[select2-1]=acttemp[select1-1];
	 	 		 	 						
 	 		 	 					     	sta1[select1-1]=sta2[select2-1];
 	 		 	 						    sta2[select2-1]=statemp[select1-1];
 	 		 	 						    
 	 		 	 						    netw1[select1-1]=netw2[select2-1];
	 		 	 						    netw2[select2-1]=netwtemp[select1-1];
	 	 									 
	 		 	 						    
	 		 	 				// First store updated values in variables		    
	 		 	 						    
	 		 	 					num="";act="";deac="";sta="";netw="";	    
	 		 	 						    
	 		 	 						    for(int i=0;i<NUM1.length;i++) {
	 		 	 						    	
	 		 	 						    	num=num+NUM1[i]+" ";
	 		 	 						    	act=act+act1[i]+" ";
	 		 	 						    	sta=sta+sta1[i]+" ";
	 		 	 						    	netw=netw+netw1[i]+" ";
	 		 	 						    	deac=deac+deac1[i]+" ";
	 		 	 						    	
	 		 	 						    }
	 		 	 						
                                // Now updating the new values for 1st given CNIC
	 		 	 						    
	 		 	 						    current1.celldata.setNumber1( num ); 
		 	 								current1.celldata.setStatus1(sta);	   
		 	 								current1.celldata.setNetwork(netw );
		 	 								current1.celldata.setActivation_Date1( act );
		 	 								current1.celldata.setDeactivation_Date1( deac );		    
	 		 	 						    
	 		 	 						    
	 		 	 						 num="";act="";deac="";sta="";netw="";	  	    
	 		 	 						    
	 		 	 						 for(int i=0;i<NUM2.length;i++) {
	 		 	 						    	
	 		 	 						    	num=num+NUM2[i]+" ";
	 		 	 						    	act=act+act2[i]+" ";
	 		 	 						    	sta=sta+sta2[i]+" ";
	 		 	 						    	netw=netw+netw2[i]+" ";
	 		 	 						    	deac=deac+deac2[i]+" ";
	 		 	 						    	
	 		 	 						    }
	 		 	 						    
	 		 	 						 // Now updating the new values for 1st given CNIC
	 		 	 						    				
		 	 								current2.celldata.setNumber1( num ); 
		 	 								current2.celldata.setStatus1( sta );	   
		 	 								current2.celldata.setNetwork( netw );
		 	 								current2.celldata.setActivation_Date1( act );
		 	 								current2.celldata.setDeactivation_Date1( deac );		    
	 		 	 						    
	 		 	 						    
	 	 								 } // else close
	 	 								 
	 	 								   
	 	 							   }
	 	 							   
	 	 							   else {
	 	 								   System.out.println("No number is registered on given CNIC!!");
	 	 							   }
	 	 								 
	 	 								 break;
	 	 							 }
	 	 							 
	 	 							current2=current2.next;
	 	 							
	 	 						}while(current2!=head);
	 	 					
	 	 					}	
	 	 					else {
	 	 						flag=0;
	 	 						System.out.println("\n==>Sorry you cannot swap with yourself");
	 	 					}
	  						
	 	 						if(current2==head && flag==1) {
	 	 							System.out.println("\nSorry, No such CNIC exists!!!\n");
	 	 						}
	 	 						
	 						
	 						}   // second if closed
	 						
	 						else {
	 							System.out.println("\n==>No number registered on this CNIC!!\n");
	 						}
	 	 						
	 						
               
			   break;
            }
            
            // shift current to next node
            current1=current1.next;
            
 			} while(current1!=head);   // do bracket closed
 			
 			
 			
 			
 		}
 		
 		
 		// To count total phone numbers registered on each network
 		
 		void CountNumOnNetwok() {
 			
 			
 			int count=0;
 			
 			String networks= "Vodafone EE O2 Skymobile BTmobile Ufone Jazz Warid Telenor Zong" ;
 			String [] array=networks.split(" ");
 			
 			
 			System.out.println("\n----------------------------------\n"
		           	 + "----------------------------------\n");
 			
 			for( int i=0 ; i<array.length; i++) {
 			
 				SinglyCircular <T> current=head;
 				
 				
 				
 				
 				do {
 					
 					String array2[]=current.celldata.getNetwork().split(" ");
 					
 					for( int j=0 ; j<array2.length; j++ ) {
 						
 						if( array[i].equalsIgnoreCase(array2[j]) ) {
 							count+=1;
 						}
 						
 					}
 					
 					current=current.next;
 					
 				}while(current!=head);
 				
 				
 				if(count!=0) {
 					System.out.println(array[i]+" = "+count);
 					count=0;
 				}
 				
 				
 			}  // outer for loop closing bracket
 				
 			System.out.println("\n----------------------------------\n"
 				           	 + "----------------------------------\n");
 				
 		
 		}  // CountNumOnNetwok method closing bracket
 		
 		void LINK( CBID <CBID> basiclist, CCID <CCID> crimelist) {
			
 			 DoublyNode <CBID> basiccurrent = basiclist.head;
 			DoublyCircular <CCID> crimecurrent=crimelist.head;
 		    SinglyCircular <T> networkcurrent = head;	
 		     
 		     
 		 // link with CBID
				
				
				do {
					basiccurrent = basiclist.head;  // set basiccurrent to head again to traverse from start
					
	            do {
	         	   
	         	   if(basiccurrent.basicdata.getCNIC().compareTo( networkcurrent.celldata.getCNIC() )==0) {
	 					
	         		 networkcurrent.celldata.basicobject = basiccurrent.basicdata;
	  					
	  					break;  
	  				}
	         	   
	         	  basiccurrent=basiccurrent.next;
	         	   
	            }while( basiccurrent!=null );
	            
	            
	           networkcurrent=networkcurrent.next;
				
				} while(networkcurrent!=head);
 		     
 		     
 		     
 		     // link with CCID
 		     
				networkcurrent = head;	
				
 					do {
 						crimecurrent=crimelist.head;
 		           do {
 		        	   
 		        	   if(crimecurrent.crimedata.getCNIC().compareTo( networkcurrent.celldata.getCNIC() )==0) {
 							
 		        		  networkcurrent.celldata.crimeobject = crimecurrent.crimedata;
 		 					
 		 					break;  
 		 				}
 		        	   
 		        	   crimecurrent=crimecurrent.next;
 		        	   
 		           }while( crimecurrent!=crimelist.head );
 		           
 		           
 		                networkcurrent=networkcurrent.next;
 					
 					} while ( networkcurrent!=head );
 					
 					
 				
 					
 					
 				} // LINK method closing bracket
 		
 		
 		
 		
 		
}
  




 
	 

