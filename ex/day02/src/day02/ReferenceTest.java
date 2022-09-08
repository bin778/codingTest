package day02;

import java.util.Arrays;

public class ReferenceTest {
	public static void main(String[] args) {
		String[] folderA = { "java", "program" };
		String[] folderB = folderA;
		
		System.out.println("[사본 배열의 값 변경 전] 원본 배열 : " + Arrays.toString(folderA));
		
		folderB[0] = "newFolder";
		
		System.out.println("[사본 배열의 값 변경 후] 원본 배열 : " + Arrays.toString(folderA));
		System.out.println("[사본 배열의 값 변경 후] 사본 배열 : " + Arrays.toString(folderB));
		
		/* Result
		[사본 배열의 값 변경 전] 원본 배열 : [java, program]
		[사본 배열의 값 변경 후] 원본 배열 : [newFolder, program]
		[사본 배열의 값 변경 후] 사본 배열 : [newFolder, program]
		 */
		
		// folderA와 folderB는 서로 같은 주소값을 가르키고 있기 때문
		// 따라서, 둘 중 하나의 요소만 변경해도 두 개의 배열 모두 요소가 변경된다.
	}
}