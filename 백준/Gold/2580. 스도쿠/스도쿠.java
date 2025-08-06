import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    static int[][] arr = new int[9][9];
    static StringBuilder sb = new StringBuilder("");
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for (int i=0; i<arr.length; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j=0; j<arr[i].length; j++) {
		        arr[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		sdoku(0, 0);
	}
	
	public static void sdoku(int row, int col) {
	    if (col == 9) {
	        sdoku(row + 1, 0);
	        return;
	    }
	    
	    if (row == 9) {
	        for (int i=0; i<9; i++) {
	            for (int j=0; j<9; j++) {
	                sb.append(arr[i][j] + " ");
	            }
	            sb.append("\n");
	        }
	        System.out.println(sb);
	        System.exit(0);
	    }
	    
	    if (arr[row][col] == 0) {
	        for (int i=1; i<=9; i++) {
	            if (isSdoku(row, col, i)) {
	                arr[row][col] = i;
	                sdoku(row, col + 1);
	            }
	        }
	        arr[row][col] = 0;
	        return;
	    }
	    
	    sdoku(row, col + 1);
	}
	
	public static boolean isSdoku(int row, int col, int value) {
	    int tmp_row = (row / 3) * 3;
	    int tmp_col = (col / 3) * 3;
	    
	    for (int i=tmp_row; i<tmp_row + 3; i++) {
	        for (int j=tmp_col; j<tmp_col + 3; j++) {
	            if (arr[i][j] == value) {
	                return false;
	            }
	        }
	    }
	    
	    for (int i=0; i<9; i++) {
	        if (arr[row][i] == value) {
	            return false; // 같은 행 중에 같은 값이 있으면 false 리턴
	        }
	    }
	    
	    for (int i=0; i<9; i++) {
	        if (arr[i][col] == value) {
	            return false; // 같은 열 중에 같은 값이 있으면 false 리턴
	        }
	    }
	    
	    return true;
	}
}