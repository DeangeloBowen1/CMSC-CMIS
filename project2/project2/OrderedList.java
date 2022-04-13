package project2;

import java.util.List;
/*
 * Author: DeAngelo Bowen
 * CMSC 350 7387
 * This program was designed to meet the requirements of PROJECT 2
 * for UMGC CMSC 350 7387. 
 */


public class OrderedList {
	public static <T extends Comparable<? super T>> boolean checkSorted(List<T> list){
		boolean isSorted = true;
		
		for(int i = list.size()-1; i > 0 ; i--){
			T current = list.get(i);
			
			if(!checkSorted(list, current)){
				isSorted = false;
			}
		}
		return isSorted;
}
// slight complications with the check order in regards to returning weak and strong orders
private static <T extends Comparable<? super T>> boolean checkSorted(List<T> list, T current) {
	
	T currentValue = list.get(list.indexOf(current));
	
	T nextValue = list.get(list.indexOf(current) - 1);

	if (nextValue != null) {
		//Checks for nulls when comparing values
		
		//if next index is larger return false
		return currentValue.compareTo(nextValue) >= 0; 
	}
	return true;
	}
}