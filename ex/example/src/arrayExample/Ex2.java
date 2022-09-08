package arrayExample;

//중복된 요소를 제거한 후 새로운 배열을 반환하는 메소드를 작성하시오.
//중복 제거된 빈 요소에는 기본 값 0으로 삽입
//int[] arr = {5, 10, 9, 27, 2, 8, 10, 4, 27, 1};

import java.util.Arrays;

public class Ex2 {
	public static void main(String[] args) {
		
		int[] arr = {5, 10, 9, 27, 2, 8, 10, 4, 27, 1};
		int[] arr2 = new int[10];
		int data = 0;
		
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j] && i != j) {
					data = arr[i];
				}
			}
		}
		
		for (int i = 0; i < arr2.length; i++) {
			if (data == arr[i]) {
				arr2[i] = 0;
			} else {
				arr2[i] = arr[i];
			}
		}
		System.out.println(Arrays.toString(arr2));
	}
}
