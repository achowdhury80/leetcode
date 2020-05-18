package comp.prep2019;

public class Prob468 {
	public String validIPAddress(String IP) {
        if (IP.indexOf(':') > 0) return validateIPV6(IP);
        if (IP.indexOf('.') > 0) return validateIPV4(IP);
        return "Neither";
    }
	
	private String validateIPV6(String ip) {
		if(ip.startsWith(":") || ip.endsWith(":")) return "Neither";
	    String[] arr = ip.split(":");
	    if(arr.length != 8) return "Neither";
	    for(int i = 0; i < 8; i++){
	      if(arr[i].trim().equals("") || arr[i].length() > 4) return "Neither";
	      for(int j = 0; j < arr[i].length(); j++){
	        char c = arr[i].charAt(j);
	        if(!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) return "Neither";
	      }
	    }
	    return "IPv6";
	}
	
	private String validateIPV4(String ip) {
		String[] arr = ip.split("\\.");
		if (arr.length != 4 || ip.startsWith(".") || ip.endsWith(".")) 
			return "Neither";
		for (String block : arr) {
			if (block.length() > 1 && block.startsWith("0") || block.startsWith("-"))
				return "Neither";
			try{
		        int i = Integer.parseInt(block);
		        if(i < 0 || i > 255) return "Neither";
		      }catch (Exception ex){
		        return "Neither";
		      }
		}
		return "IPv4";
	}
}
