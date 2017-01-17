package chapter1;

import java.util.Arrays;

/* Determines if 2 Strings are permutations of each other */
public class OnePoint3 {
	public static void main (String [] args){
		test("hello", "olhel");
		test("james", "bean");
	}
	
	/* Solution 1 - Sort the 2 Strings (by converting to char[]), then compare them: O(n log n) */
	public static boolean isPermutation_1(String s1, String s2){
		if (s1.length() != s2.length())
			return false;
		
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		s1 = sort(s1);	//we wrote our own sort for Strings, see below
		s2 = sort(s2);

		return s1.equals(s2);
	}
	
	/* Sorts the characters in a String, returning a new String */
	private static String sort(String s){
		char [] charArray = s.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
	
	/* Solution 2 - Count the different characters using an array (as shown below) or a HashMap.
	 * For each string, count the number of each character and save it in an array. Compare these 2 arrays, however...
	 * instead of using 2 arrays, we can do it with 1, as shown below. Must ask interviewer if ASCII string.
	 */
	public static boolean isPermutation_2(String s1, String s2){
		if (s1.length() != s2.length())
			return false;
		
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		int [] letters = new int[256]; //256 Assumes ASCII string (Not unicode)
		
		for (int i = 0; i < s1.length(); i++){
			char c = s1.charAt(i);
			letters[c]++;
		}
		for (int i = 0; i < s2.length(); i++){
			char ch = s2.charAt(i);
			if (--letters[ch] < 0)
				return false;
		}
		
		return true;
	}
	
	/* Tests code */
	private static void test(String s1, String s2){
		System.out.println(s1 + " " + s2);
		System.out.println("Solution 1: " + isPermutation_1(s1, s2));
		System.out.println("Solution 2: " + isPermutation_2(s1, s2));
		System.out.println();
	}
}
