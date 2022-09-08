package day02;

import java.util.Arrays;

public class ReferenceTest1 {
	public static void main(String[] args) {
		String[] folderA = { "java", "program" };
		String[] folderB = new String[folderA.length];
		
		System.out.println("[사본 배열의 값 변경 전] 원본 배열 : " + Arrays.toString(folderA));
		
		for (int i = 0; i < folderA.length; i++) {
			folderB[i] = folderA[i];
		}
		
		folderB[0] = "newFolderB";
		
		System.out.println("[사본 배열의 값 변경 후] 원본 배열 : " + Arrays.toString(folderA));
		System.out.println("[사본 배열의 값 변경 후] 사본 배열 : " + Arrays.toString(folderB));
		
		/* Result
		[사본 배열의 값 변경 전] 원본 배열 : [java, program]
		[사본 배열의 값 변경 후] 원본 배열 : [java, program]
		[사본 배열의 값 변경 후] 사본 배열 : [newFolderB, program]
		 */
		
		// folderA와 folderB는 메모리 주소 값을 따로 가르키고 있기 때문
		// 따라서, 둘 중 하나의 요소만 변경하면 요소를 바꾼 배열의 요소만 변경된다.
	}
}