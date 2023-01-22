package com.prep2020.easy;

public class Problem2299 {
	public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        boolean lowercaseExists = false, upperCaseExists = false, specialExists = false, digitExists = false;
        for (int i = 0; i < password.length(); i++) {
        	char c = password.charAt(i);
        	if (!lowercaseExists && c >= 'a' && c <= 'z') lowercaseExists = true;
        	if (!upperCaseExists && c >= 'A' && c <= 'Z') upperCaseExists = true;
        	if (!digitExists && c >= '0' && c <= '9') digitExists = true;
        	if (!specialExists && "!@#$%^&*()-+".indexOf(c) > -1) specialExists = true;
        	if (i > 0 && c == password.charAt(i - 1)) return false;
        }
        return lowercaseExists && upperCaseExists && specialExists && digitExists;
    }
}
