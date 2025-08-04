import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] list = new String[n];
		for (int i=0; i<n; i++) {
		    list[i] = br.readLine();
		}
		
		First: for (int i=0; i<list[0].length(); i++) {
		    for (int j=0; j<n; j++) {
		        if (list[0].charAt(i) != list[j].charAt(i)) {
		            bw.write("?");
		            continue First;
		        }
		    }
		    bw.write(list[0].charAt(i));
		}
		bw.write("\n");
		bw.flush();
	}
}
