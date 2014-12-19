package com.unidesign.codercalendar;

import java.util.Calendar;

public class Predict {
	public static long random(long seed1, long seed2) {
		long n = seed1 % 11117;
		for (int i = 0; i < 100 + seed2; i++) {
			n = n * n;
			n = n % 11117; // 11117 �Ǹ�����
		}
		return n;
	}

	static String[] results = {"����", "��", "��", "С��", "δ֪", "С��", "��", "����", "������"};
	static int[] luck_rate = {10, 100, 500, 800, 300, 800, 500, 100, 10}; // ���׸��ʷֲ�������Ϊ 3120

	public static String pickRandomWithRate(int seed) {
		Calendar today = Calendar.getInstance();
		long timeseed = today.getTimeInMillis();
		long result = random(timeseed, seed) % 3120;
		int addup = 0;
		
		for (int i = 0; i < luck_rate.length; i++) {
			addup += luck_rate[i];
			if (result <= addup) {
				return results[i];
			}
		}
		return results[4];
	}
}
