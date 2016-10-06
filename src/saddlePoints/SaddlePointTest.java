/**Jinmo Chong's Code 
 * 
 */

package saddlePoints;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SaddlePointTest {

	
	private int[][] a1;
	private int[][] a2;

	@Before
	public void setUp() {
		a1 = new int[][] {{-9, 12, -6}, // with saddlePoint
                          { 7, 14,  5}, 
                          {10, -8,  3}, 
                          { 6, 17,-10}};
		a2 = new int[][] {{ 1, -2,  3}, // without saddlePoint
			    		  {-6,  5, -4}, 
                          { 7, -8,  9}};
		
	}
	
	@Test
	public void testCreateRandomArray() {
		int[][] array = SaddlePoint.createRandomArray(2, 2, 0, 10);
		assertEquals(array.length, 2);
		assertEquals(array[0].length, 2);
		int i = 0;
		int j = 0;
		for (i = 0;i < 2;i++) {
			for (j = 0;j < 2;j++) {
				assertTrue(array[i][j] < 11 && array[i][j] >= 0);
			}
		}
		int[][] array2 = SaddlePoint.createRandomArray(3,  3,  -10, 10);
		assertEquals(array2.length, 3);
		assertEquals(array2[0].length, 3);
		for (i = 0;i < 3;i++) {
			for (j = 0;j < 3;j++){
				assertTrue(array2[i][j] <= 10 && array2[i][j] >= -10);
			}
		}
		int[][] array3 = SaddlePoint.createRandomArray(5, 5, -10, 10); // checks 1st and 2nd row is not same and also not all row components are same
		assertNotSame(array3[0], array3[1]);
		int n = 0;
		for (n = 0;n < 5;n++) {
	//	assertFalse(array3[n][0] == array3[n][1] && array3[n][0] == array3[n][2] && array3[n][0] == array3[n][3] && array3[n][0] == array3[n][4]);
		}
			
		
		
	}
	
	@Test
	public void testLargest() {
		int [] array = {2, 3, 4, 5, 7, 29, 32, 43, 1};
		int i = SaddlePoint.largest(array);
		assertEquals(i, 43);
		assertEquals(SaddlePoint.largest(a1[0]), 12);
		assertEquals(SaddlePoint.largest(a2[1]), 5);
		assertEquals(SaddlePoint.largest(a1[2]), 10);
		
	}
	
	@Test
	public void testSmallest() {
		int [] array = {1, 2, 5, 8, 13, 24};
		int i = SaddlePoint.smallest(array);
		assertEquals(i, 1);
		assertEquals(SaddlePoint.smallest(a1[1]), 5);
		assertEquals(SaddlePoint.smallest(a2[0]), -2);
	}
	
	@Test
	public void testLargestValues() {
		int[][] array = {{3, 5, 7}, {6, 4, 12}, {21, 14, 3}};
		int[] i = SaddlePoint.largestValues(array);
		assertEquals(i[0], 21);
		assertEquals(i[1], 14);
		assertEquals(i[2], 12);
		int[] a3 = {10, 17, 5};
		assertArrayEquals(SaddlePoint.largestValues(a1), a3);
		int[][] array2  = {{1,8,31,0}, {24, 9, 3, 0},{5, 72, 2, 0},{-3, 73, 2, 0}};
		int[] j = SaddlePoint.largestValues(array2);
		assertEquals(j[0], 24);
		assertEquals(j[1], 73);
		assertEquals(j[2], 31);
		assertEquals(j[3], 0);
		int[] a4 = {7, 5, 9};
		assertArrayEquals(SaddlePoint.largestValues(a2), a4);
	}
	
	@Test
	public void testSmallestValues() {
		int[][] array = {{3, 5, 7}, {6, 4, 12}, {21, 14, 3}};
		int[] i = SaddlePoint.smallestValues(array);
		assertEquals(i[0], 3);
		assertEquals(i[1], 4);
		assertEquals(i[2], 3);
//		int[] i2 = {3, 4, 3};			 // java.util.Arrays 
//		static boolean equals(i, i2);		//How do I uses this?
		int[] a3 = {-9, -8, -10};
		assertArrayEquals(SaddlePoint.smallestValues(a1), a3);
		int[][] array2  = {{1,8,31,0}, {24, 9, 3, 0},{5, 72, 2, 0},{-3, 73, 2, 0}};
		int[] j = SaddlePoint.smallestValues(array2);
		assertEquals(j[0], -3);
		assertEquals(j[1], 8);
		assertEquals(j[2], 2);
		assertEquals(j[3], 0);
		int[] a4 = {-6, -8, -4};
		assertArrayEquals(SaddlePoint.smallestValues(a2), a4);
	}
 
	@Test
	public void testHasSaddlePoint() {
		int[][] array = {{3, 5, 7}, {6, 4, 12}, {21, 14, 3}};
		assertFalse(SaddlePoint.hasSaddlePoint(array));
		int[][] array2  = {{1,8,31,0}, {24, 9, 3, 0},{5, 72, 2, 0},{-3, 73, 2, 0}};
		assertTrue(SaddlePoint.hasSaddlePoint(array2));
		assertTrue(SaddlePoint.hasSaddlePoint(a1));
		assertFalse(SaddlePoint.hasSaddlePoint(a2));
	}
	
	@Test
	public void testSaddlePointRow() {
		int[][] array2  = {{1,8,31,0}, {24, 9, 3, 0},{5, 72, 2, 0},{-3, 73, 2, 0}};
		assertEquals(SaddlePoint.saddlePointRow(array2), 2);
		assertEquals(SaddlePoint.saddlePointRow(a1), 1);
	}

	@Test
	public void testSaddlePointColumn() {
		int[][] array2  = {{1,8,31,0}, {24, 9, 3, 0},{5, 72, 2, 0},{-3, 73, 2, 0}};
		assertEquals(SaddlePoint.saddlePointColumn(array2), 3);
		assertEquals(SaddlePoint.saddlePointColumn(a1), 2);
	}

}
