package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OfflineExercises {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") → "TTThhheee"
	// multChar("AAbb") → "AAAAAAbbbbbb"
	// multChar("Hi-There") → "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			String subStr = input.substring(i,i+1);
			sb.append(subStr + subStr + subStr);
		}

		return sb.toString();
		
		
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") → "evilc"
	// getBert("xxbertfridgebertyy") → "egdirf"
	// getBert("xxBertfridgebERtyy") → "egdirf"
	// getBert("xxbertyy") → ""
	// getBert("xxbeRTyy") → ""

	public String getBert(String input) {
		int bertCount = 0;
		for (int i = 0; i < input.length()-3; i++) {
			if (input.toLowerCase().substring(i,i+4).equals("bert")) bertCount++;
		}
		

		if(bertCount >= 2) {
			int bertStart = 0;
			int bertEnd = 0;
			String middleBert;
			StringBuilder reverseBert = new StringBuilder();
			bertStart = input.toLowerCase().indexOf("bert") + 4;
			bertEnd = input.toLowerCase().lastIndexOf("bert");
			middleBert = input.substring(bertStart,bertEnd);
			
			for (int i = 0; i < middleBert.length(); i++) {
				reverseBert.append(middleBert.charAt(middleBert.length()-(i+1)));
			}

			return reverseBert.toString();
		} else return "";
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false
	// evenlySpaced(4, 60, 9) → false

	public boolean evenlySpaced(int a, int b, int c) {
		int[] intArray = {a,b,c};
		Arrays.sort(intArray);
		int small = intArray[0];
		int medium = intArray[1];
		int large = intArray[2];
		
//		System.out.println(small + " " + medium + " " + large);
		return (large - medium == medium - small);
		
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) → "Ho"
	// nMid("Chocolate", 3) → "Choate"
	// nMid("Chocolate", 1) → "Choclate"

	public String nMid(String input, int a) {
		StringBuilder sb = new StringBuilder(input);
		if (input.length() % 2 == 0) {
			sb.replace((sb.length())/2 - (a/2), (sb.length()+1)/2 + (a/2), "");
		}else {
			sb.replace((sb.length()+1)/2 - (a/2) - 1, (sb.length()+1)/2 + (a/2), "");
		}
		return sb.toString();
	}

	// Given a string, return true if it ends in "dev". Ignore Case

	// endsDev("ihatedev") → true
	// endsDev("wehateDev") → true
	// endsDev("everoyonehatesdevforreal") → false
	// endsDev("devisnotcool") → false

	public boolean endsDev(String input) {
		int lastDev = input.toLowerCase().lastIndexOf("dev");
		if (lastDev == -1) return false;
		else return (lastDev == input.length()-3);
	}



	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") → 2
	// superBlock("abbCCCddDDDeeEEE") → 3
	// superBlock("") → 0

	public int superBlock(String input) {
		List<Character> uniqueChars = new ArrayList<Character>();
		for (int i = 0; i < input.length(); i++) {
			if (!uniqueChars.contains(input.charAt(i))) uniqueChars.add(input.charAt(i));
		}
		
		int maxCount = 0;
		for (Character character : uniqueChars) {
			int currentCount = 0;
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i)== character) currentCount++;
			}
			maxCount = Math.max(currentCount, maxCount);
		}
		
		return maxCount;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") → 1
	//amISearch("I am in Amsterdam am I?") → 2
	//amISearch("I have been in Amsterdam") → 0

	public int amISearch(String arg1) {
		int amCount = 0;
		
		for (int i = 0; i<arg1.length()-4; i++) {
			if (arg1.toLowerCase().substring(i,i+4).equals(" am ")) amCount++;
		}
		if (arg1.toLowerCase().equals("am")) {
			amCount++;
		} else {
			if (arg1.toLowerCase().substring(0, 3).equals("am ")) amCount++;
			if (arg1.toLowerCase().substring(arg1.length()-3).equals(" am")) amCount++;
		}	
		
		return amCount;
		
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) → "fizz"
	//fizzBuzz(10) → "buzz"
	//fizzBuzz(15) → "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		if (arg1 % 5 == 0 && arg1 % 3 == 0) return "fizzbuzz";
		else if (arg1 % 5 == 0) return "buzz";
		else if (arg1 % 3 == 0) return "fizz";
		else return "";
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") → 14
	//largest("15 72 80 164") → 11
	//largest("555 72 86 45 10") → 15
	
	public int largest(String arg1) {
		String[] strNums = arg1.split(" ");
		int max = 0;
		for (String str : strNums) {
			int temp = 0;
			for (Integer Int : strToNums(str)) temp += Int;
			max = Math.max(max, temp);
		}
		
		
		return max;
		
	}
	
	private List<Integer> strToNums(String str) {
		List<Integer> ints = new ArrayList<Integer>();
		for (int i = 0; i < str.length(); i++) {
			ints.add(Integer.parseInt(str.substring(i,i+1)));
		}
		
		return ints;
	}
	
	
}
