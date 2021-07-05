package com.lambda;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringReverse rev = s -> {
			String result = "";
			for(int i = s.length()-1; i >=0 ;i--) {
				result += s.charAt(i);
			}
			return result;
		};
		String name = "Alberto";
		System.out.println(rev.reverse(name));
	}

}
