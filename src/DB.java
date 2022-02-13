import java.util.Collection;
import java.util.LinkedList;

public class DB <T> {

	
	
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
				
				System.out.println(basiclist.head.basicdata.getAddress());
				
				
				LinkedList< LinkedList<CBID> > list = new LinkedList< LinkedList<CBID> >();		
		
				list.add( new LinkedList <CBID>() );
				
						
				list.get(0).add(basiclist);
				
				list.get(1).addAll((Collection<? extends CBID>) crimelist);
				
				System.out.println(list.get(0).get(0).head.basicdata.getAddress());
				
				System.out.println(list.getLast().get(0).getAddress());
			
				System.out.println(list.getLast());
				
	
				System.out.println(list.get(1).get(0).head);
				
				
	}
	
}
