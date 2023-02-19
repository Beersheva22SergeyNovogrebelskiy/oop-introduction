package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.util.MyArrays;

class MyArraysTest {
	Integer numbers[] = {13, 2, -8, 47, 100, 10, -7, 7};
	String strings[] = {"ab", "abm", "abmb", "abmbc"};
	@Test
	@Disabled
	void sortTest() {
		String[] strings = {"abcd", "lmn", "zz"};
		String[] expected = {"zz", "lmn", "abcd"};
		
		
		MyArrays.sort(strings, new StringLengthComparator());
		assertArrayEquals(expected, strings);
		
		
	}
	@Test
	@Disabled
	void evenOddTest() {
		
		Integer expected[] = {-8, 2, 10, 100, 47, 13, 7, -7};
		MyArrays.sort(numbers, new EvenOddComparator());
		assertArrayEquals(expected, numbers);
	}
	@Test
	@Disabled
	void binarySearchTest() {
		String strings[] = {
			"ab", "abm", "abmb", "abmbc"	
		};
		Comparator<String> comp = new StringsComparator();
		assertEquals(0, MyArrays.binarySearch(strings, "ab", comp));
		assertEquals(2, MyArrays.binarySearch(strings, "abmb", comp));
		assertEquals(3, MyArrays.binarySearch(strings, "abmbc", comp));
		assertEquals(-1, MyArrays.binarySearch(strings, "a", comp));
		assertEquals(-3, MyArrays.binarySearch(strings, "abma", comp));
		assertEquals(-5, MyArrays.binarySearch(strings, "lmn", comp));
	}
	@Test
	void filterTest() {
		int dividor = 2;
		String subStr = "m";
		Predicate<Integer> predEven = t -> t % dividor == 0;
		Predicate<String> predSubstr = s -> s.contains(subStr);
		String expectedStr[] = {
				 "abm", "abmb", "abmbc"	
			};
		Integer expectedNumbers[] ={2, -8, 100, 10};
		assertArrayEquals(expectedStr, MyArrays.filter(strings, predSubstr));
		assertArrayEquals(expectedNumbers, MyArrays.filter(numbers, predEven));		
	}
	
	@Test
	void removeIfTest() {
		Integer expected[] = {2, -8, 100, 10};
		assertArrayEquals(expected, MyArrays.removeIf(numbers, n -> n % 2 != 0));
	}
	
	@Test
	void removeRepeated() {
		String strings [] = {"aaa", "aaa", "cccc", "aaa", "aaa"};
		printArray(MyArrays.removeRepeated(strings));
		assertArrayEquals(new String[] {"aaa", "cccc"},MyArrays.removeRepeated(strings) );
		Integer[] numbersRepeatedValues = { 13, 13, 2, -8, -8, 47, 100, 100, 100, 10, 7, 7 , 13};
		Integer expected2[] = { 13,  2, -8,  47, 100, 10, 7};
		printArray(MyArrays.removeRepeated(numbersRepeatedValues));
		assertArrayEquals(expected2, MyArrays.removeRepeated(numbersRepeatedValues));
	}
	
	@Test
	void containsTest() {
		Integer numbers[] = {13, 2, -8, 47, 2, 100, 10, -7, 10, 7};
		String strings[] = {"ab", "abm", "ab", "abmb", "abmbc", "abm"};
		assertTrue(MyArrays.contains(strings,"ab"));
		assertTrue(MyArrays.contains(strings, "abmbc"));
		assertTrue(MyArrays.contains(strings, "abm"));
		assertFalse(MyArrays.contains(strings,"bm"));
		assertTrue(MyArrays.contains(numbers,47));
		assertTrue(MyArrays.contains(numbers,-7));
		assertFalse(MyArrays.contains(numbers,-10));
	}
	
	<T> void printArray(T[] array) {
		for(T element: array) {
			System.out.print(element + "\t");
		}
		System.out.println();
	}
}