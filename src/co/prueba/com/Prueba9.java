package co.prueba.com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

interface Ia1 {

	public void saludar();
}

interface Ib2 {
	default void saludar() {
	}
}

class ORt {
	public void saludar() {
	}
}

class Rt extends ORt implements Ia1, Ib2 {

}

class Ee {

	class Einer {
	}

	static class Oi {
	}

	public void saludar() {

		new Einer();
		new Ee.Einer();

		new Oi();
		new Ee.Oi();
	}

	public static void h() {
		new Ee().new Einer();

		new Ee.Oi();

		new Oi();
		
	}

	public <T extends Number> void ff(T t) {

	}
}

class Ae {
	int id;

	Object obj = new Object();

	public void saludar() {
		System.out.println("Empieza metodo...");

		try {
			synchronized (obj) {
				System.out.println("Entra..");
				Thread.sleep(5000);
				System.out.println("Fin..");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}

class KK {

	int vl;

	KK(int hh) {
		this.vl = hh;
	}
}

interface Ik {
	Character v(Integer i);
}

interface Ayy {
}

class CAyy implements Ayy {
}

class MyProcess {
	int val = 9;

	public MyProcess() {
		val = 89;
	}

	String saludar() {
		return "MyProcesssss";
	}
}

interface IMyprocess {
	MyProcess miMet(MyProcess myProcess);
}

interface Is2 {

	String resultado(String s, Integer i);
}

class Visabuelo {
	public int i = 7;
	public int h = 98;
}

class Abuelo extends Visabuelo {
	private int i = 8;
}

class Padre extends Abuelo {
}

interface Su {
	public default void saludar() {
	}
}

class SubHija implements Su {
	public void misaludar() {

	}
}

interface Iuu {
	String toString();
}

abstract class Abst {

	abstract int getNum();
}

class ConcRete extends Abst {

	public int getNum() {
		return 7;
	}
}

class clsUu implements Iuu {
}

interface MyInterface {
	char obtener(int i);
}

interface MyDef {
	default public void saludar() {
	}
}

class MyClas implements MyDef {

	public void s() {
		MyDef.super.saludar();
	}
}

public class Prueba9 {

	String hh = "123";
	MyInterface myint = hh::charAt;

	static final List<String> mList = new ArrayList<>();

	public static void main(String... args) throws Exception {

		//MyDef myDef = (MyDef)new Prueba9();

		int myvariable = 9;
		Consumer<Integer> myconsumer = x -> {
			// myvariable = 78;
			System.out.println(myvariable);
		};

		Padre padre = new Padre();
		// System.out.println(padre.i);
		System.out.println(padre.h);

		for (int i = 0, j = 0; i < 5; i++, j++) {
		}

		mList.add("c");

		Supplier<MyProcess> iMyprocess = MyProcess::new;

		Is2 is2 = String::substring;

		System.out.println(is2.resultado("0123456", 4));

		Prueba9 prueba9 = new Prueba9();

		System.out.println(prueba9 instanceof Ik);

		List<Integer> listAux = null;

		CAyy ayy = new CAyy();

		Ayy k = ayy;

		if (listAux == ayy) {// Es porque List es una interfaz

		}

		System.out.println(null instanceof Prueba9);

		String hh = "hola";

		Ik ik = hh::charAt;

		System.out.println(ik.v(3));

		List<String> listY = new ArrayList<>();

		List<List<String>> gg = List.of(listY);

		int[] uu = new int[3];
		Short g = 8;

		Integer ij = -255;

		Integer hj = -255;

		int hjAx = -255;

		System.out.println("Igual Integer:" + (ij == hj));

//		Ae ae = new Ae();
//		ExecutorService es = Executors.newFixedThreadPool(2);
//		es.submit(() -> ae.saludar());
//		es.submit(() -> ae.saludar());
//		es.shutdown();

		Ae ae_1 = new Ae();
		ae_1.id = 7;

		Ae ae_2 = new Ae();
		ae_2.id = 8;

		List<Ae> list = List.of(ae_1, ae_2);

		// list.set(0, new Ae());

		list.forEach(x -> System.out.println("id:" + x.id));

		// FileWriter fw = new FileWriter("");

		List<Integer> listTemp = List.of(7, 5, 6);

		LocalDateTime lct = LocalDateTime.now();

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("hh:mm");

		System.out.println(lct.format(dt));

		KK kg = new KK(2987) {

		};

		System.out.println(kg.vl);

		Object oj = (Integer) null;

		System.out.println("o...:" + oj);

		int mival = 8;
		int reult = switch (mival) {
		case 5 -> 8;
		case 6 -> {
			yield 89;
		}
		default -> 9;
		};

		System.out.println("");

		System.out.println(Duration.ofSeconds(80));

		int hhd = 0;

		try (FileWriter fw = new FileWriter("D:/WorkEclipse3/PruebaJava/src/Yuoo")) {

		}
		try(FileOutputStream fis = new FileOutputStream("D:/WorkEclipse3/PruebaJava/src/YuooInoutStream")){
			fis.write(new byte[] {23,24});
			
		}

		List<String> input = List.of("FOO", "FOO", "FOO", "FOO", "FOO", "BAR", "BAR", "BAZ", "BAZ", "BAZ", "DOO",
				"DOO");
		Map<String, Long> map = null;
		map = input.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));

		Integer usu = (Integer) null;
		System.out.println(map);

		List<String> jkk = null;

		Path path1 = Path.of("../P");

		Path path2 = Path.of("../P");

		System.out.println(Files.mismatch(path1, path2));
	}

}
