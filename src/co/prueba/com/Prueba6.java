package co.prueba.com;

import java.io.FileWriter;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prueba6 {

	record Hj() {

		public Hj {

		}
	}

	public static void main(String... args) {

		var df1 = new DecimalFormat("###,##,#");
		var df2 = new DecimalFormat("##,###,#");

		System.out.println(df1.format(1264));

		System.out.println(df2.format(1264));

		var df3 = new DecimalFormat("###,###,###.#");
		System.out.println(df3.format(1264));

		String s1 = new String("ALL IS WELL");
		String s2 = new String("ALL IS WELL");

		System.out.println(s1.toString() == s2.toString());
		
		List<Integer> list = List.of(1);

		System.out.println(list);

		int h = 9;

		int x = switch (h) {
		case 10 -> {

			yield 4;
		}
		default ->6;
		};
	}
}
