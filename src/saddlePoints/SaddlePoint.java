/**Jinmo Chong's Code 
 * 
 */


package saddlePoints;

import java.util.Random;
//import java.util.Arrays;

class SaddlePoint {

	public static void main(String[] args) {
		while (true) {
		int[][] array1 = SaddlePoint.createRandomArray(2, 2, -10, 10);
		SaddlePoint.printArray(array1);
		SaddlePoint.printArrayInfo(array1);
		System.out.println();
		int[][] array2 = SaddlePoint.createRandomArray(3, 3, 2, 10);
		SaddlePoint.printArray(array2);
		SaddlePoint.printArrayInfo(array2);
		System.out.println();
		int[][] array3 = SaddlePoint.createRandomArray(4, 4, -20, 20);
		SaddlePoint.printArray(array3);
		SaddlePoint.printArrayInfo(array3); 
		System.out.println();
		int i = 0;				//flag of how many saddlepoint has
		int j = 0;				//flag of how many nonesaddlepoints
		if (SaddlePoint.hasSaddlePoint(array1)) {
			i += 1;
		} else {
			j += 1;
		}
		if (SaddlePoint.hasSaddlePoint(array2)) {
			i += 1;
		} else {
			j += 1;
		}
		if (SaddlePoint.hasSaddlePoint(array3)) {
			i += 1;
		} else {
			j += 1;
		}
		if (i >= 1 && j >= 1) {
			break;
		} else {
			continue;
		}
	}
		
		

	/*
		int [] array2 = {1, 2, 3, 4, 5};
		int n1 = SaddlePoint.largest(array2);
		System.out.println(String.valueOf(n1));
		int[][] array3 = new int[][]{{1,3,5},{2,4,6},{3,7,2}};
		
		System.out.println(SaddlePoint.largestValues(array3));
		SaddlePoint.printArray(array3);
		int[][] array4 = new int[][]{{-9, 12, -6}, {7, 14, 5}, {10, -9, 3}, {6, 17, -10}};
		SaddlePoint.printArray(array4);
		*/
		}
		

	
	public static void printArray(int[][] array) {
		int i = 0;
		int j = 0;
		for (i = 0;i < array.length;i++) {  // for each row is i
			for (j = 0;j <array[0].length;j++) { // for each column is j
			System.out.print((array[i][j]) + "  ");
			}
			System.out.print("\n");  // put newline after each row
		}
	}
	
	
	public static void printArrayInfo(int[][] array) {
		if (SaddlePoint.hasSaddlePoint(array)) {
			System.out.println("Has saddle point at row " + (SaddlePoint.saddlePointRow(array) + 1) + " and column " + (SaddlePoint.saddlePointColumn(array) + 1));
			System.out.println("The value is " + array[SaddlePoint.saddlePointRow(array)][SaddlePoint.saddlePointColumn(array)]);
		} else {
			System.out.println("Doesn't have a saddle point");
		}
	}
	
	public static int[][] createRandomArray(int numberOfRows,
							  int numberOfColumns,
							  int minValue,
							  int maxValue) {
		int [][] array;
		array = new int [numberOfRows][numberOfColumns];
		
		for (int i = 0;i < numberOfRows; i++) {
			for (int j = 0;j < numberOfColumns; j++){
				Random r = new Random();
					int b = minValue;
					int a = r.nextInt(maxValue - b + 1);
					array[i][j] = a + b;			
			}
		}
		return array;
	}
	
	public static int largest(int[] array) {
		int i;
		int a = array[0];
		for (i = 0;i < array.length; i++) {
			a = Math.max(a, array[i]);
		}
		return a;	
	}
	

	public static int smallest(int[] array) {
		int i;
		int a = array[0];
		for (i = 0;i < array.length;i++) {
			a = Math.min(a, array[i]);
		}
		return a;
	}
	
	
	public static int[] largestValues(int[][] array) {
		// this is largest of each columns
		int[] arrayValue = new int[array.length];
		int[] arrayLargest = new int[array[0].length];
		
		int i = 0;
		int j = 0;
		for (j = 0;j < array[0].length;j++) { // for first, second, elements in each rows
			for (i = 0;i < array.length;i++) {	//for column 0 to array.length - 1
			arrayValue[i] = array[i][j];			//this is the jth element of each rows
			
//			arrayValue[i] = SaddlePoint.largest(arrayValue)
//		int[] a = SaddlePoint.largest(arrayValue);
			
			
			} // after this there will be arrayvalue with jth components of each rows
			arrayLargest[j] = SaddlePoint.largest(arrayValue);
		}
		return arrayLargest;
	}
	
	public static int[] smallestValues(int[][] array) {
		//this is smallest values of each columns
		int[] arrayValue = new int[array.length];
		int[] arraySmallest = new int[array[0].length];
		
		int i = 0;
		int j = 0;
		for (j = 0;j < array[0].length;j++) { // for first, second, third ... elements of the rows
			for (i = 0;i < array.length;i++) { // for how many rows there are
				arrayValue[i] = array[i][j];
			} // after this there will be arrayValue with jth component of each rows
			arraySmallest[j] = SaddlePoint.smallest(arrayValue);	
		}
		return arraySmallest;
	}
		
	public static boolean hasSaddlePoint(int[][] array) {
		//Max wants the largest, he can only pick which rows 
		//so the best of the worst for him is to pick biggest of smallest of each rows
		//Min wants the smallest, she can only pick which columns
		// so the best of the worst for her is to pick the smallest of biggest of each columns
		//so first for max, we pick smallest of each rows
		
		int[] arraySmallestRows = new int[array.length];
		int i = 0;
		int maxFav;
		for (i = 0;i < array.length;i++) {
			arraySmallestRows[i] = SaddlePoint.smallest(array[i]); //array[i] is each rows
		} 						// after this we get smallest of each rows
		maxFav = SaddlePoint.largest(arraySmallestRows);
		
		int [] arrayLargestCols = new int[array[0].length];
//		int j = 0;
		arrayLargestCols = SaddlePoint.largestValues(array);
		int minFav;
		minFav = SaddlePoint.smallest(arrayLargestCols);
		return maxFav == minFav;
	}

	public static int saddlePointRow(int[][] array) {
		// we apply the same logic as hasSaddlePoint
		int[] arraySmallestRows = new int[array.length];
		int i = 0;
		int maxFav;
		for (i = 0;i < array.length;i++) {
			arraySmallestRows[i] = SaddlePoint.smallest(array[i]); //array[i] is each rows
		}								//after this we get smallest of each rows
		maxFav = SaddlePoint.largest(arraySmallestRows);	// 
		int n = -1;
		int j = 0;
		for (j = 0;j < array.length;j++) { //try to find out the row of maxFav
			if (arraySmallestRows[j] == maxFav){
				n = j;
			}
		}
		return n;
	}

	
	public static int saddlePointColumn(int[][] array) {
		//same as hasSaddlePoint and saddlePointRow
		int [] arrayLargestCols = new int[array[0].length];
		arrayLargestCols = SaddlePoint.largestValues(array);
		int minFav;
		minFav = SaddlePoint.smallest(arrayLargestCols);
		int n = -1;
		int j = 0;
		for (j = 0;j < arrayLargestCols.length;j++) {
			if (arrayLargestCols[j] == minFav) {
				n = j;
			}
		}
		return n;
	}
	
	
}
