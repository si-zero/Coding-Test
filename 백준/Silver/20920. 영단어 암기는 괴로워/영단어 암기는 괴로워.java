import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> list = new HashMap<>(); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i=0; i<n; i++){
            String value = br.readLine();
            if (value.length() < m) {
                continue;
            }
            
            else {
                if (!list.containsKey(value)){
                    list.put(value, 1);
                    continue;
                }
                
                else {
                    int temp = list.get(value);
                    list.remove(value);
                    list.put(value, ++temp);
                    continue;
                }
            }
        }
        
        List <Map.Entry<String, Integer>> entryList = new LinkedList<>(list.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()){
                    if (o1.getKey().length() == o2.getKey().length()){
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    
                    return o2.getKey().length() - o1.getKey().length();
                }
                
                else {
                    return o2.getValue() - o1.getValue();
                }
                
            }
        });
        
        for (Map.Entry<String, Integer> entry : entryList){
            bw.write(entry.getKey() + "\n");
        }
        bw.flush();
    }
}