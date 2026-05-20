package co.prueba.com;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Map;

class A {
	int a = -8;

	static int y = 9;

	public static void saludarsatico() {

	}
	
	public void metodoInstacia() {
		class Local{
			private void sal() {
				System.out.println("a->"+a+",y->"+y);
			}
		}
		
		Local local =  new Local();
		local.sal();
		
		new Iner();
		new InnerStatic();
	}
	
	public static void metodoEstatico() {
		class Local{
			private void sal() {
				System.out.println(",y->"+y);
				saludarsatico();
			}
		}
		
	
		new InnerStatic();
	}

	public void saludar() {
		System.out.println("A");
	}

	public void saludarPropiodeA() {
		System.out.println("Propio A");
	}

	class Iner {
		int a = 67;
		public void saludarInner() {
			System.out.println("Hola a:" + a);
			saludar();
		}
	}

	static class InnerStatic {

		public void saludarStatic() {
			System.out.println();
		}

		public static void saludarStaticVer() {
			System.out.println(y);
			saludarsatico();
		}
	}
}

class B extends TopA {
	int b;

	public void saludar() {
		System.out.println("->B");
	}
}

class C extends B {
	int c;

	public void saludar() {
		super.saludar();		
	}
}

class D<T extends B>{
	
	T t = null;
	
	public T devuelve() {
		return t;
	}

}

interface I {
	boolean saludar();
}

interface IG<T> {

	void saludar(T t);
}

class CG<T> implements IG {

	public void saludar(Object s) {
	}

	void saludarGenericoClase() {
	}
}

class CG_2<T> {

	public T saludar(T t) {
		return t;
	}

	public static <X> X metodo(X x) {
		return x;
	}
}

record Craneo() {
	Craneo {

	}
}

public class Prueba {
	private int y = 8;

	public Prueba() {
	}

	public Prueba(int y) {
		this.y = y;
	}

	record Hola() {
	}

	class HolaT {
	}
	
	

	public static void main(String... args) throws Exception {
		// System.out.print("Hola");
		
		

		try (var i = new BufferedInputStream(new FileInputStream("D:\\WorkEclipse3\\PruebaJava\\src\\Text2"));
				var o = new BufferedOutputStream(new FileOutputStream("D:\\WorkEclipse3\\PruebaJava\\src\\Texto"))) {
			
			int lenght;
			byte[] arr = new byte[1024];
			while((lenght = i.read())>0) {
				o.write(lenght);
			}
			
		}
		try {
		} catch (Exception e) {
			// TODO: handle exception
		}

		List.of(1, 2, 3).stream();

		I i = new I() {
			private int y = 9;

			public boolean saludar() {
				return true;
			}
		};

		Prueba nh = new Prueba(3) {
		};

		System.out.println(nh.y);

		List<String> listStr = new ArrayList<>(List.of("a", "b", "c", "d"));

		listStr.add(1, "x");

		System.out.println(listStr);

//		A.Iner ainner = new A().new Iner();
//		ainner.saludarInner();
//
//		B b = new B();
//		b.saludar();
//		b.saludarPropiodeA();
		
		C c = new C();
		c.saludar();

		
	}

	public synchronized void saludar() {

		try {
			System.out.println("HOLA inicio");
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("HOLA Fin");

	}

	public void saludar_2() {

		try {
			System.out.println("HOLA inicio 2 ");
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("HOLA Fin 2");

	}
}
