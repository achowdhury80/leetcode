package misc;
import java.io.*;
public class NormalizeReviseProblem {

	public static void main(String[] args) throws IOException{
		String inputFileNameWithPath = "D:\\personal\\study\\prep\\toCode.txt", 
				outputFileNameWithPath = "D:\\\\personal\\\\study\\\\prep\\\\toCodeNormalized.txt";
		FileReader fr = null;
		BufferedWriter bw = null;
		boolean[] arr = new boolean[1600];
		try {
			fr = new FileReader(inputFileNameWithPath);
			int c;
			boolean started = false;
			int num = 0;
			while ((c = fr.read()) != -1) {
				if (c >= '0' && c <= '9') {
					if (!started) started = true;
					num = num * 10 + (c - '0');
				} else {
					if (started) {
						started = false;
						arr[num] = true;
						num = 0;
					}
				}
			}
			bw = new BufferedWriter(new FileWriter(outputFileNameWithPath));
			StringBuilder s = new StringBuilder();
			int count = 0;
			for (int i = 1; i < 1500; i++) {
				if (arr[i]) {
					s.append(i + ", ");
					count++;
					if (count == 5) {
						bw.write(s.toString());
						bw.newLine();
						count = 0;
						s = new StringBuilder();
					}
				}
			}
			if (count > 0) bw.write(s.toString());
			
		} catch(IOException ioe) {
			
		} finally {
			fr.close();
			bw.close();
		}

	}

}
