package co.prueba.extras;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.DoubleToIntFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class ClsG<T extends Collection>{
	
}
interface In2{ int m();}

interface In1{default int m() {return 0;}}

//interface In3 extends In2,In1{}

class Cls1 implements In1,In2{
	
	public int m() {return 0;}
}

interface I2 {
	static void meto() {

	}
}

class Cl2 implements I2 {
	void meto() {

	}
}

interface I {
	boolean equals(Object o);

	int hashCode();

	String toString();
}

class Ou implements I {
	
	static int valEs = 9;
	
	class Inn{
		public void sludar() {System.out.println(valEs);}
	}
}

class B{
	int id;
	
	public B(int id) {
		this.id = id;
	}
	
	public String toString() {
		return String.valueOf(id);
	}
}

public class PatoBlanco {
	public int edad;

	class Inner {
		void saludar() {
			System.out.println(edad);
		}
	}

	static class St {
	}

	class Pato extends PatoBlanco {
		void saludar() {
			System.out.println(this.edad + super.edad);
		}
	}

	void saludar() {
		PatoBlanco.Inner i = new PatoBlanco.Inner();
		Inner j = new Inner();
		St st = new St();
		St st_2 = new PatoBlanco.St();

		class Local {
			public void saludar() {
				System.out.println(edad);
			}
		}
	}

	record Carrera(int longtud) {
		public void met() {
		}
	};

	public static void main(String[] args) throws Exception{

		String identi = "a32342*34";
		System.out.println(identi.matches("^[a-zA-Z0-9]*$"));
		
		I2 i2 = null;
		I2.meto();
		
		int[] j = new int[2];
		
		String k = "";
		
		k = "t";
		Predicate<String> p = k::equalsIgnoreCase;
		
		DoubleToIntFunction dti = (double x)->(int)x;
		
		Comparator b = null;
		
		B b1 = new B(1);
		B b2 = new B(2);
		
		B bx = b1;
		b1 = b2;
		System.out.println(bx);
		System.out.println(b1);
		
		int[] ar = {1,2};
		int[] br = {1,2};
		System.out.println("Holla:"+ar.equals(br));
		
		Connection conn = null;
		

	}

}
