package algorithm;

import java.util.Arrays;

/**
 * 버블소트
 *
 */
public class Solution_BubbleSort {
	public static void main(String[] args) {
		int[] arr = {29,10,14,37,14,1,7,28,32};
		
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}//end of main
}//end of class
