package co.prueba.com.hacker.rank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
			List<String> list = Arrays.asList(numbers);
			ArrayDeque<String> dequeue = new ArrayDeque<>(list.subList(0, m));
			Set<String> set = new HashSet<>(dequeue);
			long max = 0;
			if(set.size() == m) {
				System.out.println(m);
				return;
			}else if(set.size()>max) {
				max = set.size();
			}
	
			for(int i = m;i<numbers.length;i++) {
				dequeue.poll();
				dequeue.addLast(numbers[i]);
				set.clear();
				set = new HashSet<>(dequeue);
				if(set.size()==m) {
					System.out.println(m);
					return;
				}else if(set.size()>max) {
					max = set.size();
				}
			}
			
			System.out.println(max);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
