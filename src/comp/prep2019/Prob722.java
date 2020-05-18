package comp.prep2019;
import java.util.*;
public class Prob722 {
	public List<String> removeComments(String[] source) {
		List<String> result = new ArrayList<>();
		boolean blockStarted = false;
		int idx;
		String prev = "";
		for (String s : source) {
			String st = "";
			if (blockStarted) {
				if ((idx = s.indexOf("*/")) < 0) continue;
				s = prev + s.substring(idx + 2);
				prev = "";
				blockStarted = false;
			}
			int blockStartIndex;
			while((blockStartIndex = s.indexOf("/*")) > -1 
					&& ((idx = s.indexOf("//")) < 0 || idx > blockStartIndex)) {
				blockStarted = true;
				st += s.substring(0, blockStartIndex);
				s = s.substring(blockStartIndex + 2);
				int blockendIndex;
				if ((blockendIndex = s.indexOf("*/")) > -1) {
					s = s.substring(blockendIndex + 2);
					blockStarted = false;
				} else break;
			}
			if (!blockStarted) {
				if ((idx = s.indexOf("//")) > -1) st += s.substring(0, idx);
				else st += s;
				if (!"".equals(st)) result.add(st);
			} else {
				prev = st;
			}
			
		}
		if (!"".equals(prev)) result.add(prev);
		return result;
    }
	
	public static void main(String[] args) {
		Prob722 prob = new Prob722();
		System.out.println(prob.removeComments(new String[] {"/*Test program */", 
				"int main()", "{ ", "  // variable declaration ", "int a, b, c;", 
				"/* This is a test", "   multiline  ", "   comment for ", 
				"   testing */", "a = b + c;", "}"}));
	}
}
