package co.prueba;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

interface E1 {
	public default int saludo() {
		return 5;
	}

}

interface E2 {
	public default int saludo() {
		return 5;
	}
}

class A0 {
	int tth;

	public void saludar() {
		System.out.println("A0");
	}
}

class A11 extends A0 {

}

class B1 extends A11 {
	int id;
	
	public B1(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof B1 b1) {

			return id == b1.id;
		}

		return false;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
}

class C1 extends B1 {
	
	public C1() {
		super(0);
	}

	public void f() {
		super.saludar();
	}
}

class Ex implements AutoCloseable {

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub

	}
}

class X0 {

	public void m() {
		System.out.println("m X0");
	}
}

class XX extends X0 implements E1, E2 {
	static int f;

	public int saludo() {
		return E1.super.saludo();
	}

}

class YY extends XX {
	static int f;

	public void m() {
		System.out.println("m YY:" + f);
		super.m();
	}
}

interface Pru {
	int h = 9;
}

class VV implements Pru {
	public static int h = 8;

	public void saludar() {
		System.out.println("" + h);
	}

	public static void hh() {
		System.out.println("" + h);
	}
}

class ZZ extends VV implements Pru {

	public void saludar() {
		// System.out.println(""+h);
	}
}

enum IOL {
	A {
		public void salA() {
		}
	},
	B {
		public void salB() {
		}
	}
}

interface PRU_A{
	
	public default String  hola() {return null;};
}

interface PRU_B{
	public default String  hola() {return null;};
}

interface PRU_C extends PRU_A,PRU_B{
	public  String hola();
}





public class Entur {

	record GT() {
	}

	class FT {
	}

	int y;

	public void j() {
		int y = 9;
		this.y = 9;
		
		class AG{}
	}

	public static String funPru(int ui) {
		return null;
	}
	
	static int[] myArray = {1,2,1,3,3,1,2,1,5,1};

	public static void main(String... args) throws Exception {
		
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<myArray.length;i++) {
			list.add(myArray[i]);
		}
		
		list.stream().forEach(System.out::println);
		
		Map<Integer,List<Integer>> map = list.stream()
				.collect(Collectors.groupingBy(x->x));


		
		
	}
	
	enum JI{
		A,B;
		
		private String ht;
		
		private JI() {
			this.ht = "";
			
			class DF{}
		}
	}

	public static void guardarStreams() {
		try (var in = new BufferedInputStream(new FileInputStream("D:\\WorkEclipse3\\PruebaJava\\hola\\textFile"));
				var ou = new BufferedOutputStream(
						new FileOutputStream("D:\\WorkEclipse3\\PruebaJava\\hola\\textFileFinal"))) {

			byte[] rec = new byte[1024];
			int longRead;
			while ((longRead = in.read(rec)) != -1) {
				ou.write(rec, 0, longRead);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void guardarFileStreams() {
		try (var in = new BufferedReader(new FileReader("D:\\WorkEclipse3\\PruebaJava\\hola\\textFile"));
				var ou = new BufferedWriter(new FileWriter("D:\\WorkEclipse3\\PruebaJava\\hola\\textFileFinal"))) {

			char[] rec = new char[1024];
			int longRead;
			while ((longRead = in.read(rec)) != -1) {
				ou.write(rec, 0, longRead);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void guardarFileStreams_2() {
		try (var in = new BufferedReader(new FileReader("D:\\WorkEclipse3\\PruebaJava\\hola\\textFile"));
				var ou = new BufferedWriter(new FileWriter("D:\\WorkEclipse3\\PruebaJava\\hola\\textFileFinal"))) {

			String val;
			while ((val = in.readLine()) != null) {
				ou.write(val);
				ou.newLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void guardarFileStreams_3() {
		try (var in = new BufferedReader(new FileReader("D:\\WorkEclipse3\\PruebaJava\\hola\\textFile"));
				var ou = new BufferedWriter(new FileWriter("D:\\WorkEclipse3\\PruebaJava\\hola\\textFileFinal"))) {

			int val;
			while ((val = in.read()) != -1) {
				ou.write(val);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ff() throws IOException {

		try {
			Files.copy(null, null);
		} catch (IOException e) {
			throw e;
		}
	}

	public static void fg(int y) {
		int yr = 9;
	}

}
