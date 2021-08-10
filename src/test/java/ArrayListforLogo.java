import java.util.ArrayList;
import java.util.Collections;

public class ArrayListforLogo {

	public static void main(String[] args) {
//		ArrayList<String> price=new ArrayList<String>();
//		price.add("$26.00");
//		price.add("$50.99");
//		price.add("$28.98");
//		price.add("$30.50");
//		price.add("$16.40");
//		Collections.sort(price);
//		
//		System.out.println(price);
		//Desending/reverse // Collections.sort(list/object)// Collections.reverse(list/object)
		ArrayList<String> price=new ArrayList<String>();
		price.add("$26.00");
		price.add("$50.99");
		price.add("$28.98");
		price.add("$30.50");
		price.add("$16.40");
	Collections.sort(price,Collections.reverseOrder());

		System.out.println(price);
	
//		
//		ArrayList<String> price=new ArrayList<String>();
//		ArrayList<String> Newprice=new ArrayList<String>();
//		
//		price.add("$26.00");
//		price.add("$50.99");
//		price.add("$28.98");
//		price.add("$30.50");
//		price.add("$16.40");
//		Newprice.add(price.get(3).replace("$", ""));
//		
//		System.out.println(Newprice);
//			
	}

}
