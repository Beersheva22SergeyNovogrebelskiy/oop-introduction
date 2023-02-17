package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Recursion {

	@Test
	void reverseTest() {
		int ar[] = {1, 2, 3, 4, 5, 6};
		int expected[] = {6, 5, 4, 3, 2, 1};
		int ar1[] = {1, 2, 3, 4, 5, 6, 7};
		int expected1[] = {7, 6, 5, 4, 3, 2, 1};
		reverse(ar);
		reverse(ar1);
		assertArrayEquals(expected, ar);
		assertArrayEquals(expected1, ar1);
	}
	
	
	
	public static void reverse(int ar[]) {
		int indexMin = 0;
		int indexMax = ar.length - 1;
		int temp;
		
		if(indexMin < indexMax) {
			temp = ar[indexMin];
			ar[indexMin++] = ar[indexMax];
			ar[indexMax--] = temp;
		
		}
		
		
		
	}
	
	

}
