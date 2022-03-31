package com.helen.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters {

	public RemoveDuplicateLetters() {
		// TODO Auto-generated constructor stub
	}

	public String removeDuplicateLetters(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		// used or not
		boolean[] added = new boolean[26];
		// appearance count
		int[] count = new int[26];
		char[] array = s.toCharArray();
		// count appearances
		for (char ch : array) {
			count[ch - 'a']++;
		}
		// go through each char
		for (char ch : array) {
			count[ch - 'a']--;
			if (added[ch - 'a']) {
				continue;
			}
			// poping out the char which is bigger and still has some left in
			// behind
			while (!stack.isEmpty() && stack.peek() > ch && count[stack.peek() - 'a'] > 0) {
				added[stack.pop() - 'a'] = false;
			}
			// add current one
			stack.push(ch);
			added[ch - 'a'] = true;

		}
		// move from stack to string
		StringBuffer sb = new StringBuffer();
		while (stack.size() > 0) {
			sb.append(stack.pop());
		}

		return sb.reverse().toString();
	}
	
	public static void main(String[] args){
		RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
		String s = rdl.removeDuplicateLetters("bcabc");
		System.out.println(s);
	}
}
