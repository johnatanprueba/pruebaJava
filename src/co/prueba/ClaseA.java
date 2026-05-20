package co.prueba;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import java.util.Deque;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.Spliterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.swing.event.ListSelectionEvent;

class A {
	public List<CharSequence> saludar(Set<Double> set) {
		return null;
	}
}

class AA extends A {
	public ArrayList<CharSequence> saludar(Set<Double> set) {
		return null;
	}
}

class I<Integer> {

}

public class ClaseA implements Comparable<ClaseA> {

	private String nombre;

	public void probar(Integer i) {
		System.out.println("INTEGER..");
	}

	@Override
	public int compareTo(ClaseA a) {

		return this.nombre.trim().toLowerCase().compareTo(a.nombre.trim().toLowerCase());
	}

	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ClaseA)) {
			return false;
		}

		ClaseA claseA = (ClaseA) o;

		return this.nombre.equalsIgnoreCase(claseA.nombre);
	}

	@Override
	public int hashCode() {
		return this.nombre.length();
	}

	public static void main(String... args) throws Exception {

		var lista = List.of(new Craneo(1, "Paola"), new Craneo(2, "Pedro"), new Craneo(3, "Pedro"));

		List<Craneo> myList = new ArrayList<>(lista);

		Comparator<Craneo> c = Comparator.comparing(Craneo::nombre)
				.thenComparing(Comparator.comparing(Craneo::id).reversed());

		Comparator<Craneo> c1 = Comparator.comparing(Craneo::nombre).thenComparing(Comparator.comparing(Craneo::id));

		Collections.sort(myList, c);

		myList.forEach(System.out::println);

		List<ClaseA> listClaseA = new ArrayList<>();

		ClaseA claseA = new ClaseA();
		claseA.nombre = "Paula";

		ClaseA claseA_2 = new ClaseA();
		claseA_2.nombre = "Paula";

		ClaseA claseA_3 = new ClaseA();
		claseA_3.nombre = "Roman";

		System.out.println(claseA.equals(claseA_2));

		listClaseA.add(claseA);
		listClaseA.add(claseA_2);
		listClaseA.add(claseA_3);

		listClaseA.stream().distinct().forEach(x -> System.out.println("->" + x));

		// SplitIterator
		List<String> list = List.of("a", "b", "c123", "d", "e");

		Spliterator<String> splOrigin = list.spliterator();

		System.out.println("Origin");
		splOrigin.tryAdvance(System.out::println);

		Spliterator<String> remain = splOrigin.trySplit();

		System.out.println("Remain");
		remain.forEachRemaining(System.out::println);

		// Fin SplitIterator

		List<String> d = list.stream().collect(Collectors.filtering(x -> x.length() == 1, Collectors.toList()));
		System.out.println(d);

		Reutilizar r = list.stream().collect(Collectors.teeing(Collectors.groupingBy(x -> x.length()),
				Collectors.partitioningBy(x -> x.length() <= 1, Collectors.toSet()), (x, y) -> new Reutilizar(x, y)));

		System.out.println(r);

		Stream is = Stream.empty();
		is.collect(Collectors.toSet());

		ResourceBundle s = ResourceBundle.getBundle("zoo", new Locale("en", "US"));
		System.out.println(s.getString("casa"));

		NumberFormat nf = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), Style.SHORT);
		System.out.println(nf.format(1_000_000));

		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

		String h1 = (String) null;

		System.out.println("H1--->" + h1);

		GregorianCalendar diaFechaNavegacion = new GregorianCalendar();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date = sdf.parse("2022-09-16 01:24:14");

		// Date date = new Timestamp(diaFechaNavegacion.getTimeInMillis());
		/**
		 * Si la hora es menor que las siete de la mañana, debe mostrar el día anterior,
		 * no el día atual
		 */

		System.out.println(sdf.format(date));
		if (diaFechaNavegacion.get(Calendar.HOUR_OF_DAY) < 7) {
			diaFechaNavegacion.add(Calendar.DAY_OF_MONTH, -1);
		}

		Date dateRes = new Timestamp(diaFechaNavegacion.getTimeInMillis());

		System.out.println(dateRes);

		int u = 9;

		var h = switch (u) {
		case 1: {
			int j = 9;
			if (j % 2 == 0) {
				yield "uno";
			} else {
				yield "nose";
			}
		}
		default: {
			yield "dos";
		}

		};

		System.out.println(h);

		File f = new File("r/y");
		System.out.println(f.getAbsolutePath());

		Path p = Paths.get("D:\\OCP17_IO");
		System.out.println(Files.exists(p));

		Path p2 = Paths.get("/zoo/../home").getParent().normalize().toAbsolutePath();

		System.out.println(p2);

		Files.createDirectories(Paths.get("D:\\OCP17_IO\\Prueba"));

		// Files.copy(Paths.get("D:\\OCP17_IO\\A"), Paths.get("D:\\OCP17_IO\\Copy"));

		List<String> liy = List.of("1", "2");

		// liy.add("");

		liy.stream().distinct().collect(Collectors.toCollection(ArrayList::new));

		List<String> liyr = new LinkedList<>();

		String[] liA = liy.toArray(new String[0]);

		Map<String, Integer> map = new HashMap<>();
		map.put("Uno", 1);

		Integer t = map.putIfAbsent("Uno", 2);
		System.out.println("result Mp:" + t);

		Integer valor = map.merge("Dos", 2, (v, w) -> v + w);

		System.out.println(valor);

		System.out.println(map);

		Integer otherResul = map.replace("Uno", 81);
		System.out.println(otherResul);

		System.out.println(map);

		Integer[] ut = { 5, 4, 7 };
		List<Integer> listArr = Arrays.asList(ut);
		listArr.sort(Comparator.naturalOrder());
		System.out.println("=========");
		System.out.println(listArr);
		System.out.println(ut[0]);
		// listArr.removeIf(x->x%2==0);

		System.out.println("=========");

		var listArrOf = List.of(5, 1, 7, 4);
		// listArrOf.sort(Comparator.naturalOrder());
		System.out.println(listArrOf);

		List<Integer> listSimple = new ArrayList<>();
		listSimple.add(5);
		listSimple.add(1);
		listSimple.add(4);

		var listCopy = List.copyOf(listSimple);
		// listCopy.sort(Comparator.naturalOrder());
		System.out.println(listCopy);

		int[] ho = new int[] { 1, 2, 3 };

		int[] hoSame = new int[] { 1, 2, 3 };

		System.out.println("son iguales?:" + ho.equals(hoSame));

		LinkedList<String> lilist = new LinkedList<>();
		lilist.add(null);

		System.out.println(lilist);

		Deque<String> arrDeque = new ArrayDeque<>();
		// arrDeque.offer(null);
		arrDeque.peek();
		arrDeque.poll();
		arrDeque.offer("");
		arrDeque.poll();

		Queue<String> queu = null;
		// queu.peek();

		Date dateTemp = null;

		Short g = 9;

		String valFin = String.format("%.2f", 1245.1488);

		System.out.println(valFin.replace(",", "."));

		for (int y1 = 0, v1 = 0; v1 < 0; v1++) {
		}

		LABEL_CONTINUE_WHILE: while (g-- < 10) {
			
			if (g % 2 == 0) {
				continue LABEL_CONTINUE_WHILE;
			}

		}
		int count = 8;
		L2: do {
			System.out.println("=>" + count);
			if (count % 2 == 0) {
				continue L2;
			}
		} while (count--> 0);

		Object gh = 9;
		if (!(gh instanceof Integer jk)) {
			return;
		}

		jk = 87;

	}

	static boolean _$(String t) {
		return false;
	}

	public void saludar(List<String> li) {

	}

	public void saludar(ArrayList<String> li) {

	}

}

record Craneo(int id, String nombre) {
	public Craneo(String nombreTemp, int idTemp) {
		this(idTemp, nombreTemp);
	}
};

record Reutilizar(Map<Integer, List<String>> map1, Map<Boolean, Set<String>> map2) {
}