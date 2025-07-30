import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[n];
        int[] dp = new int[n];
        int[] dp_back = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i=0; i<n; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if (a[j] < a[i] && dp[j] + 1 > dp[i]) {
                    dp[i]++;
                }
            }
        }
        
        for (int i=n-1; i>=0; i--) {
            dp_back[i] = 1;
            for (int j=n-1; j>=i; j--) {
                if (a[j] < a[i] && dp_back[j] + 1 > dp_back[i]) {
                    dp_back[i]++;
                }
            }
        }
        
        int result = 0;
        for (int i=0; i<n; i++) {
            if (result < dp[i] + dp_back[i]) result = dp[i] + dp_back[i];
        }
        
        bw.write(result-1 + "");
        bw.flush();
    }
}