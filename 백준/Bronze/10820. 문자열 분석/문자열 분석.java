import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = "";
		while ((input = br.readLine()) != null){
		    int[] answer = new int[4];
            for (int i=0; i<input.length(); i++) {
                int num = input.charAt(i) + 0;
                if (num >= 65 && num <= 90) {
                    answer[0]++;
                }
                
                if (num >= 97 && num <= 122) {
                    answer[1]++;
                }
                
                if (num >= 48 && num <= 57) {
                    answer[2]++;
                }
                
                if (num == 32) {
                    answer[3]++;
                }
		    }
		    
		    bw.write(answer[1] + " " + answer[0] + " " + answer[2] + " " + answer[3] + "\n");
		    bw.flush();
		}
		
	}
}
