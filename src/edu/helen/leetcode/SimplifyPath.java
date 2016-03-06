package edu.helen.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {

	public SimplifyPath() {
		// TODO Auto-generated constructor stub
	}

	public String simplifyPath(String path) {
		if (path == null || path.isEmpty()) {
			return path;
		}
		Deque<String> stack = new ArrayDeque<>();
		String[] strs = path.split("/");
		int len = strs.length;
		for (int i = 0; i < len; i++) {
			if (strs[i].equals("") || strs[i].equals(".")) {
				continue;
			} else if (strs[i].equals("..")) {
				if (stack.isEmpty()) {
					continue;
				} else {
					stack.pop();
				}
			} else {
				stack.push(strs[i]);
			}
		}
		if (stack.size() == 0) {
			return "/";
		}
		String sb = "";
		while (!stack.isEmpty()) {
			sb = "/" + stack.pop() + sb;

		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		SimplifyPath sp = new SimplifyPath();
		String path = sp.simplifyPath("/..");
		System.out.println(path);
	}

}
