package nodeExample;

import java.util.Arrays;
import java.util.Random;


public class LinkedList5 {
	public static void main(String[] args) {
		Random ran = new Random();
		int[] arr = new int[7];
			
		for(int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(45) + 1;
			if(i>=1) {
				for(int j = 0; j < i; j++) {
					if(arr[i] == arr[j]) {
						arr[i]=ran.nextInt();
						j--;
					}
				}
			}
		}
		
		System.out.println("난수 오름차순 정렬");
		Arrays.sort(arr);
		for(int k : arr)
			System.out.println(k + " ");
	}
}


