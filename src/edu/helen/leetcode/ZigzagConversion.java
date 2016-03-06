package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {

	public ZigzagConversion() {
		// TODO Auto-generated constructor stub
	}

	public String convert(String s, int numRows) {
		if (numRows <= 1) {
			return s;
		}
		List<StringBuilder> list = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			StringBuilder sb = new StringBuilder();
			list.add(sb);
		}
		int x = 0;
		int step = 1;
		for (int j = 0; j < s.length(); j++) {
			char ch = s.charAt(j);
			StringBuilder sb = list.get(x);
			sb.append(ch);
			x += step;
			if (x == numRows - 1 || x == 0) {
				step *= -1;
			}

		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			StringBuilder sb = list.get(i);
			builder.append(sb.toString());
		}
		return builder.toString();
	}

}
