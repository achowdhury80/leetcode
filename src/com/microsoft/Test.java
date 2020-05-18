package com.microsoft;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Test {
	public static void main(String[] args) throws IOException {
		//String inputFile = "D:\\\\project\\\\docListBuilder\\\\cosmosStream\\\\resourceSet\\\\ResourceSetFeed.csv";
		//String outputFile = "D:\\\\project\\\\docListBuilder\\\\cosmosStream\\\\resourceSet\\\\resourceSetFeedUpdated.csv";
		String inputFile = "D:\\\\project\\\\docListBuilder\\\\cosmosStream\\\\product\\\\productFeed.csv";
		String outputFile = "D:\\\\project\\\\docListBuilder\\\\cosmosStream\\\\product\\\\productFeedUpdated1.csv";
		TimeZone tz = TimeZone.getTimeZone("PST");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
		df.setTimeZone(tz);
		String nowAsISO = df.format(new Date());
		String type = "Product";
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		String st;
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
		int count = 0;
		while((st = br.readLine()) != null) {
			/*String[] arr = st.split(",");
			String id = arr[0].substring(0, arr[0].length() - 1) + ",";
			id += arr[1] + "\"";
			String s = arr[0] + "," + arr[1] + ",\"" + type + "\"," + id + ",\"" + nowAsISO + "\"";*/
			count++;
			/*bw.write(s);
			bw.newLine();*/
			
		}
		bw.close();
		br.close();
		System.out.println(count + " records are updated.");
	}
}
