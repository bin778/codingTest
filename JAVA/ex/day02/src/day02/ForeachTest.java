package day02;

import java.util.Arrays;

public class ForeachTest {
	public static void main(String[] args) {
		int[] student = {1,2,3,4,5,6,7,8,9,10};
//		for (int i = 0; i < student.length; i++)
		System.out.println("변경 전 : " + Arrays.toString(student));
		
		int[] student1 = new int[student.length];
		for (int i = 0; i < student.length; i++) {
//			student1[(student.length - 1) - i] = student[i]; // 중요한 패턴!
			student1[i] = student[(student.length - 1) - i];
		}
		System.out.println("변경 후 : " + Arrays.toString(student1));
		
		for (int studentNum : student) {
			System.out.println("학생 번호는 : " + studentNum);
		}	
	}
	
}