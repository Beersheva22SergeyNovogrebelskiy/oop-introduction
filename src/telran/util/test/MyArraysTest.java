package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import telran.util.MyArrays;

class MyArraysTest {

	@Test
	
	void sortTest() {
		String[] strings = {"abcd", "lmn", "zz"};
		String[] expected = {"zz", "lmn", "abcd"};
		Integer [] ar = {3, 2, 1};
		
		MyArrays.sort(strings, new StringLengthComparator());
		assertArrayEquals(expected, strings);
		MyArrays.sort(ar, (a, b) -> a - b);
		
	}
	
	@Test
	void binarySearchTest() {		
		Integer[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Comparator<Integer> comp = new IntegersComparator(); 
		assertEquals(4, MyArrays.binarySearch(nums1, 5, comp));
		
		Integer[] nums2 = {1, 2, 3, 4, 6, 7, 8, 9, 10};
		assertEquals(-5, MyArrays.binarySearch(nums2, 5, comp));
		
		assertEquals(-10, MyArrays.binarySearch(nums2, 100, comp));
	}
	
	@Test
	void sortNumberEvenOddTest() {
		Integer numbers[] = {13, 2, -8, 47, 100, 10, 7};
		Integer expected[] = {-8, 2, 10, 100, 47, 13, 7};
		MyArrays.sort(numbers, new EvenOddComparator());
		assertArrayEquals(expected, numbers);
	}

}