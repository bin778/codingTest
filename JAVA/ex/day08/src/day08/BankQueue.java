package day08;

import queue.linkedList.LinkedListQueue;
import java.util.Scanner;

public class BankQueue {
    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        int count = 1;
        int size = 0;
        boolean isStop = false;

        while (!isStop) {
            System.out.println("1. 대기표 발급");
            System.out.println("2. 입    장");
            System.out.println("3. 대기인원");
            System.out.println("4. 종    료");
            System.out.print("=>");

            int choose = new Scanner(System.in).nextInt();
            switch (choose) {
                case 1:
                    queue.enqueue(count);
                    System.out.println(String.format("대기 번호: %s번 발급.\n", count));

                    count++;
                    size++;
                    break;
                case 2:
                    if (queue.empty()) {
                        System.out.println("대기 중인 고객이 없습니다.\n");
                        break;
                    }

                    int number = (int) queue.dequeue();
                    System.out.println(String.format("%s번 창구로 이동해 주세요.\n", number));
                    size--;
                    break;
                case 3:
                    System.out.println(String.format("현재 인원은 %s명 입니다.\n", size));
                case 4:
                    System.out.println("종    료.\n");
                    isStop = true;
                    break;
                default:
                        System.out.println("1.    대기표 발급");
                        System.out.println("2.    입   장");
                        System.out.println("3.    대기인원");
                        System.out.print("=>");
            }
        }
    }
}
