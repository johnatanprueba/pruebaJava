package co.prueba.com;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntBiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Privada {

	int g;
}

interface I0 {
}

interface I1 {
	default void saludar() {
		System.out.println("I1");
	}

	String toString();

	int hashCode();
}

interface I2 {
	default void saludar() {
		System.out.println("I2");
	}
}

public class Prueba2 implements I1, I2 {

	@Override
	public void saludar() {
		I1.super.saludar();
	}

	class Interna {

		public void saludar() {
			System.out.println("Hola..");
		}
	}

	public void imprimir() {

		new Prueba2.Interna().saludar();
	}

	public static void main(String... args) throws Exception {

		new Prueba2().imprimir();

		Privada privada = new Privada();
		System.out.println(privada.g);

		System.out.println(privada instanceof I0);

		Map<Boolean, List<Integer>> map = Arrays.asList(2, 3, 4, 5, 6).stream()
				.collect(Collectors.groupingBy(x -> x % 2 == 0));

		System.out.println(map);

		double avg = Arrays.asList("*", "**", "***").stream().collect(Collectors.averagingInt(x -> x.length()));

		System.out.println(avg);

		IntSummaryStatistics insSumma = Arrays.asList("*", "**", "***").stream()
				.collect(Collectors.summarizingInt(x -> x.length()));
		System.out.println(insSumma);

		String str = "*";
		// for(var var=0;var<4;var++) { str+="*"; }

		for (var var = 0; var < 4; var++) {
			str += "*";
		}

		System.out.println(str);
		
		OptionalInt opi = OptionalInt.of(4);
		opi.getAsInt();
		
		String incidental = """
				                                 Hola""";
		String strNormal = "Hola";
		
		System.out.println(incidental == strNormal);
		System.out.println(incidental.equals(strNormal));
		
		String txt = "No se encontro plan para la empresa WORLD OFFICE COLOMBIA SAS\r\n                    con licencia KGGFH-DQBYY-DRACR-SCKFD\r\n                    y Nit 900534356";
		System.out.println(txt);
		
		
		var bottles = List.of("glass", "plastic", "can");
		for (int type = 1; type < bottles.size();) {
		   System.out.print(bottles.get(type) + "-");
		   if(type < bottles.size()) break;
		}
		System.out.print("end");

	}
}
