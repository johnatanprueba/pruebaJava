package co.prueba.com.hacker.rank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class HackerRank {

	public static void main(String... args) {
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			// int n = Integer.parseInt(br.readLine());
			// int m = Integer.parseInt(br.readLine());
			// String[] numbers = br.readLine().split(" ");

			// System.out.println("N:"+n);
			// System.out.println("M:"+m);

			int m = 3;
			String[] numbers = { "5", "3", "5", "2", "3", "2" };

			int max = 0;
			Set<String> sub = new HashSet<>();

			Deque<String> deque = new LinkedList<>();
			for (int i = 0; i <numbers.length; i++) {

				if (deque.size() < m) {
					deque.offer(numbers[i]);
					continue;
				}

				if (deque.size() == m) {
					sub.clear();
					sub.addAll(deque);
					if (sub.size() == m) {
						System.out.println(m);
						return;
					}

					if (sub.size() > max) {
						max = sub.size();
					}

				}
				deque.poll();
				deque.offer(numbers[i]);
			}

			System.out.println(max);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
