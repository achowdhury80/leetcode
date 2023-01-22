package com.prep2020.medium;

public class Problem468 {
	public String validIPAddress(String IP) {
		if(IP.startsWith(".") || IP.startsWith(":") || IP.endsWith(".") 
				|| IP.endsWith(":")) return "Neither";
        if (IP.indexOf('.') > -1) return isValidIpV4(IP);
        if (IP.indexOf(':') > -1) return isValidIpV6(IP);
        return "Neither";
    }

	private String isValidIpV6(String ip) {
		String[] arr = ip.split(":");
		if (arr.length != 8) return "Neither";
		for (String s : arr) {
			if ("".equals(s) || s.length() > 4) return "Neither";
			int val = 0;
			for (char c : s.toCharArray()) {
				if (Character.isDigit(c) || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F') 
					continue;
				return "Neither";
			}
		}
		return "IPv6";
	}

	private String isValidIpV4(String ip) {
		String[] arr = ip.split("\\.");
		if (arr.length != 4) return "Neither";
		for (String s : arr) {
			if ("".equals(s) || s.length() > 1 && s.charAt(0) == '0' || s.length() > 3) 
				return "Neither";
			int val = 0;
			for (char c : s.toCharArray()) {
				if (!Character.isDigit(c)) return "Neither";
				val = val * 10 + (c - '0');
			}
			if (val < 0 || val > 255) return "Neither";
		}
		return "IPv4";
	}
	
	public static void main(String[] args) {
		Problem468 problem = new Problem468();
		//System.out.println(problem.validIPAddress("172.16.254.1"));
		//System.out.println(problem.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
		System.out.println(problem.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
	}
}
