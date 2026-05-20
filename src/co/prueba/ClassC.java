package co.prueba;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


class S{
	S(int g){}
}

class SS extends S{
	SS(){
		super(3);
	}
}
class G1 {
	List<CharSequence> prueba(List<CharSequence> list) {
		System.out.println("HOLA G1");
		return null;
	}

	void saludar() {
		System.out.println("-- G1");
	}
}

class G2 extends G1 {
	ArrayList<CharSequence> prueba(List<CharSequence> list) {
		System.out.println("HOLA G2");
		return null;
	}

	void saludar() {
		System.out.println("-- G2");
	}
}


interface IIO {
	void saludar(int y, int h);
}

class AR {
	int at_1;
	int at_2;

	@Override
	public String toString() {
		return "at:" + at_1 + ",at2:" + at_2;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof AR r) {
			if (at_1 == r.at_1 && at_2 == r.at_2) {
				return true;
			}
		}

		return false;
	}

//	@Override
//	public int hashCode() {
//		return at_1;
//	}
}

class G<T> {
	public T saludar(T t) {
		return t;
	}
}

public sealed class ClassC {

	final class HH extends ClassC {
	}

	public static void main(String... args) throws IOException, ParseException, DatatypeConfigurationException {
		// Files.createDirectory(Path.of("D:/OCP17_IO/A/Ad/AAA"));

		System.out.println("Hola mundo");

		ScheduledExecutorService sd = null;

		Object r = 8;

		boolean result = r == "r";

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M");

		System.out.println("1");

		String h = dtf.format(LocalDate.now());

		

		NumberFormat nf = new DecimalFormat("##.0");
		System.out.println(nf.format(23454.245658));

		Stream<Integer> f = Stream.of(1, 2);

		Double result2 = f.collect(Collectors.averagingInt(x -> x));
		System.out.println("result 2:" + result2);

		Stream<Integer> fr = Stream.of(1, 2);
		DoubleSummaryStatistics u = fr.collect(Collectors.summarizingDouble(x -> x));
		System.out.println("cantidad:" + u.getCount());

		AR a = new AR();
		AR a2 = new AR();
		Set<AR> setA = new HashSet<>();
		setA.add(a);
		setA.add(a2);

		setA.forEach(System.out::println);

		AR a3 = new AR();
		System.out.println(setA.contains(a3));

		List<AR> listAR = new ArrayList<>(setA);
		System.out.println(listAR.contains(a3));

		List<AR> listAr = new ArrayList<>();

		List<Integer> list = Arrays.asList(3, 4, 5);
		System.out.println("mi lista:" + list);

		List<?> x1 = new ArrayList<>();
		var x2 = new ArrayList<>();

		List<Object> x3 = x2;

		// List<Object> x4 = x1;

		G1 g1 = new G1();
		G1 g2 = new G2();

		g2.prueba(null);

		System.out.println(Boolean.valueOf("TRUE"));

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

		Date date = format.parse("2023-03-07T14:41:52.930");

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);

		XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);

		System.out.println(xmlGregCal);
		
		TreeSet<Integer> ts = new TreeSet<>(list);
		System.out.println(ts);
		
}

}

