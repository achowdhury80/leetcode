package misc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Utility {
	public static void main(String[] args) throws Exception{
		String inputFilePath = "E:/temp/commands.txt",
				outputFilePath = "E:/temp/results.txt";
		String currentCluster = "wasd-stage-lkgtst3-a";
		BufferedReader br = null;
		BufferedWriter bw = null;
		Set<String> blackListedSubscription = new HashSet<>();
		blackListedSubscription.add("f4cd2a3e-063f-4e28-8ad6-938814ce250e");
		blackListedSubscription.add("fd04b528-1e20-496d-959b-a77995efe75f");
		blackListedSubscription.add("4952bcc8-a112-4959-95c5-6b0cfc697afd");
		blackListedSubscription.add("dd0ff2bd-cc10-47e9-af25-92a07c6deca0");
		blackListedSubscription.add("5c5ce188-97a1-404d-afa1-2fc397b69883");
		Set<String> result = new HashSet<>();
		try {
			br = new BufferedReader(new FileReader(inputFilePath));
			bw = new BufferedWriter(new FileWriter(outputFilePath));
			String st;
			while((st = br.readLine()) != null) {
				String[] arr = st.split(" ");
				if (blackListedSubscription.contains(arr[2])) continue;
				String s = currentCluster;
				s += ";" + arr[2];
				s += ";" + arr[4];
				s += ";" + arr[6];
				result.add(s);
			}
			for (String ss : result) {
				bw.write(ss);
				bw.newLine();
			}
		}finally {
			br.close();
			bw.close();
		}
	}

}
