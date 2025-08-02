
package com.example.comparablecomparator;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



	
	/*Parameters:
		d1 the first double to compare
		d2 the second double to compare
		Returns:
		the value 0 if d1 is numerically equal to d2; 
		a value less than 0 if d1 is numerically less than d2; 
		and a value greater than 0 if d1 is numerically greater than d2.
	*/
	
//    // Rating Comparator class for custom ordering 
//	class RatingComparator implements Comparator<Products>
//	{
//	
//
//	@Override
//	public int compare(Products p1, Products p2) {
//		// TODO Auto-generated method stub
//		return Double.compare(p2.rating , p1.rating );
//	}
//	
//	
//	
//	}
//	
	

// Name Comparator class for custom ordering 
//class NameComparator implements Comparator<Products>
//{
//
//
//@Override
//public int compare(Products p1, Products p2) {
//	// TODO Auto-generated method stub
//	return p1.name.compareTo(p2.name);
//}
//
//
//
//}


//Rating Comparator class for custom ordering for rating in descending order and then name ascending  
class RatingAndNameComparator implements Comparator<Products>
{


@Override
public int compare(Products p1, Products p2) {
	// TODO Auto-generated method stub\
	int rnc = Double.compare(p2.rating , p1.rating );
	if(rnc !=0)     // If rating is not equal 
		return rnc;
	else
	return p1.name.compareTo(p2.name); // If rating is equal than it will compare on the basis of their name
}



}




public class ComparatorSortingDemo {

	public static void main(String[] args) {
		List<Products> pr = new ArrayList<>();
		pr.add(new Products("Laptop" , 50000, 5));
		pr.add(new Products("Phone" , 20000, 5));
		pr.add(new Products("Tablet" , 10000, 1));
		pr.add(new Products("Mouse" , 500, 5));
		
		// For Custom Ordering you want to order by their rating
        //		Collections.sort(pr, new RankingComparator());
	
       //		for(Products p : pr)
       		
       //		{
       //			System.out.println(p);
       //		}
	
         // For Custom Ordering you want to order by their name
		
//		Collections.sort(pr, new NameComparator());
//		
//		for(Products p : pr)
//		
//		{
//			System.out.println(p);
//		}
		
		 // For Custom Ordering you want to order by their rating first and then by name
Collections.sort(pr, new RatingAndNameComparator());
		
		for(Products p : pr)
		
		{
			System.out.println(p);
		}
		
	}

}






