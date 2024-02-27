import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[1] = 0;
		
		for (int i = 2; i <= n; i++) {
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
			}  
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
			} 
			dp[i] = Math.min(dp[i], dp[i - 1] + 1);
		}
		System.out.println(dp[n]);
	}
}