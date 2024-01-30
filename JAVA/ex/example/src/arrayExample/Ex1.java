package arrayExample;

//두 개의 배열이 존재한다. 
//순서가 없는 두 개의 배열에서 서로 같은 요소가 포함되어 있는지 판별하는 메소드를 작성하시오.
//첫 번째 배열 arr1 = { 1,2,3 };
//두 번째 배열 arr2 = { 2,3,1 };

import java.util.Arrays;

public class Ex1 {
	public static void main(String[] args) {

		int[] arr1 = {1, 2, 3};
		int[] arr2 = {2, 3, 1};
		int length;
		boolean equals = false;
		
		// arr1, arr2를 오름차순으로 정렬한다 sort()
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		// arr1과 arr2의 배열 길이 중 어느 것이 더 큰 지 비교
		length = arr1.length >= arr2.length ? arr1.length : arr2.length;
		
		try {
			for (int i = 0; i < length; i++) {
				// 두 배열의 요소가 모두 같으면 true, 아니면 false
				if (arr1[i] == arr2[i]) {
					if (i == arr2.length - 1)
						equals = true;
				}
				else {
					equals = false;
					break;
				}
			}
		// 두 배열의 요소가 서로 일치하지 않으면 예외 처리한다
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 요소가 잘못 설정됨");
			System.exit(0);
		}
		
		// 결과값 출력(true이면 같음, false면 다름)
		if (equals == true)
			System.out.println("두 배열의 요소가 서로 같습니다.");
		else if (equals == false)
			System.out.println("두 배열의 요소가 다릅니다.");
	}
}
