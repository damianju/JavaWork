package 반복제어문3.자가진단01;

//자연수 n을 입력받고 1부터 홀수를 차례대로 더해나가면서 합이 n 이상이면 그 때까지 더해진 홀수의 개수와 그 합을 출력하는 프로그램을 작성하시오.
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		int cnt = 0;
		
		for (int i = 0; sum < n; i++) {
			if(i%2 !=0) {
				sum = sum + i;
				cnt++;
			}
			else {
				sum = sum;
			}
			
		}
		System.out.print(cnt+"\t");
		System.out.print(sum);
		
		sc.close();
	}

}
