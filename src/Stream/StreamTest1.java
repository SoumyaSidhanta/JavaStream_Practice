package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamTest1 {

//	@Test
	public void regular() {
		//Count the number of names starting with alphabet A
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijit");
		names.add("Rohit");
		names.add("Abhi");
		names.add("Abhishek");
		names.add("Priti");
		names.add("Ananya");
		int count= 0;
		for (int i = 0; i < names.size(); i++) 
		{
			String acName= names.get(i);
			if (acName.startsWith("A")) {
				count ++;
			} 			
		}
		System.out.println(count);
		Assert.assertEquals(count, 4); // ✅ Test
	}
	
//	@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijit");
		names.add("Rohit");
		names.add("Abhi");
		names.add("Abhishek");
		names.add("Priti");

		//there is no life for intermediate option if there is no terminal option
		//terminal operation only execute whenever intermediate option is true
		// terminal op. - count()
		//intermediate op. - filter()
		
//		Long l= names.stream().filter(a -> a.startsWith("A")).count();
//		System.out.println(l);
		
		// another way
		long c = Stream.of("Abhijit","Abhishek","Don").filter(a -> a.startsWith("A")).count();
		System.out.println(c);
		
		// printing all the names present in the array list with a condition 
		names.stream().filter(s -> s.length()>4).forEach(s->System.out.println(s));
		
		//limiting the result
		// terminal op. - limit()
		names.stream().filter(s -> s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	
	
	@Test
	public void streamMap() {
		
		//printing the names having last letter as "a" with upper case 
		
//		Stream.of("Abhijit","Abhishek","Dona","BigDaddy","Ananya").filter(s->s.endsWith("a")).map(s-> s.toUpperCase())
//		.forEach(s->System.out.println(s));
		
		//Printing the names having first letter as a with upper case and sorted 
		//terminal op.- sorted()
		
//		List<String> nam = Arrays.asList("Azbhijit","Abhishek","Dona","BigDaddy","Ananya");
//		nam.stream().filter(s-> s.startsWith("A")).sorted().map(s-> s.toUpperCase()).forEach(s->System.out.println(s));
		
		//merging two list and sorted it 
		ArrayList<String> names = new ArrayList<String>();
		names.add("Man");
		names.add("Rohit");
		names.add("Abhi");
		names.add("Priti");
		
		List<String> nam = Arrays.asList("Azbhijit","Abhishek","Dona","BigDaddy","Ananya");
		
		Stream<String> newStream= Stream.concat(names.stream(), nam.stream());
//	    newStream.sorted().forEach(s->System.out.println(s));
		
		//finding matches 
		// anyMatch() convert it into boolean
		boolean bool= newStream.anyMatch(s->s.equalsIgnoreCase("Priti"));
	    Assert.assertTrue(bool);
	    
	    
	
		
	}


}
