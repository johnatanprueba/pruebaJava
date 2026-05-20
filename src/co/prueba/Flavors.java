package co.prueba;

import java.io.FileWriter;

interface Ii {
	char met(Integer i);
}

interface Ij {
	char met(Ai ai);
}

class Ai {
	static char m(Integer i) {
		return 'a';
	}

	char n() {
		return 'a';
	}
}

interface Po {
	static void saludar() {
		System.out.println("Hola metodo estatico Po");
	}
}

class Ao implements Po {
}

public class Flavors {

	private class FlavInner {
	}

	static class FlavStatic {
	}

	public void saludar() {

		new Flavors.FlavInner();

		new FlavInner();

		new FlavStatic();

		new Flavors.FlavStatic();
	}

	public static void saludarDos() {

		new FlavStatic();

		new Flavors.FlavStatic();

	}

	public static void main(String[] args) throws Exception {

//		FileWriter fw = new FileWriter("D:\\WorkEclipse3\\PruebaJava\\src\\Text3");
//		System.out.println("Holaalaa");

		Ai ai = new Ai();

		Ii inter = Ai::m;

		Ij ij = Ai::n;

		System.out.println(ij.met(ai));

		Po ao = new Ao();
		Po.saludar();

	}

}
