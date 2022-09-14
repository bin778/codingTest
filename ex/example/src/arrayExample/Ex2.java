package arrayExample;

//중복된 요소를 제거한 후 새로운 배열을 반환하는 메소드를 작성하시오.
//중복 제거된 빈 요소에는 기본 값 0으로 삽입
//int[] arr = {5, 10, 9, 27, 2, 8, 10, 4, 27, 1};

import java.util.Arrays;

public class Ex2 {
	public static void main(String[] args) {
		
		int[] arr = {5, 10, 9, 27, 2, 8, 10, 4, 27, 1};
		// 중복을 제거한 값을 저장할 배열, 중복이 제거된 횟수
		int[] temp = new int[10];
		int count = 0;
		
		// 중복 제거 전
		System.out.println(Arrays.toString(arr));
		
		// for문을 이용해 중복 제거
		// arr[i]와 temp[j]의 값이 같다면 중복이므로 0으로 변환
		for (int i = 0; i < arr.length; i++) {
			boolean flag = false;
			for (int j = 0; j < arr.length; j++) {		
				if (arr[i] == temp[j]) {
					flag = true;
					temp[count++] = 0;
				}
			}
			// 중복이 아니면 temp 배열에 값을 저장
			if(!flag) {
				temp[count++] = arr[i];
			}
		}

		// 중복을 제거한 배열을 result 배열에 저장
		int[] result = new int[count];
		for (int i = 0; i < result.length; i++) {
			result[i] = temp[i];
		}
		
		// 결과 값 출력
		System.out.println(Arrays.toString(result));
		
	}
}
