package co.prueba;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class X {
 public int valXX;
}

class Y extends X{
	
	public void saludar() {
		
		System.out.println("i:"+super.valXX);
	}
}

interface Inter {
	private void saludar() {
	}

	default void caminar() {
	};

}

public class Exa implements Inter {
	{i=8;}
	int i;

	private int h;

	@Override
	public boolean equals(Object o) {

		if (o instanceof Exa exat) {
			return this.h == exat.h;
		}

		return false;
	}

	/*
	 * @Override public int hashCode() {
	 * 
	 * return this.h; }
	 */

	static class On {

	}

	public void ff() {
		Inter.super.caminar();

		On on = new On();
	}

	static Y pruebaInf(X x) {
		return null;
	}

	public static void main(String... args) throws Exception {

		On o = new Exa.On();

		On o1 = new On();

		Exa exa = new Exa();
		exa.h = 9;

		String h = "Hola muldo %s %s";

		System.out.println(String.format(h, "NIE004 -- FechaLiquidacionInicio", "eeeeeeeeee"));

		List<String> list = null;

		var trainDay = LocalDate.of(2022, 5, 13);
		var time = LocalTime.of(10, 0);
		var zone = ZoneId.of("America/Los_Angeles");
		var zdt = ZonedDateTime.of(trainDay, time, zone);
		System.out.println(zdt);
		var instant = zdt.toInstant();
		System.out.println(instant);
		instant = instant.plus(1, ChronoUnit.DAYS);
		System.out.println(instant);

		System.out.println(new Date());

		var smart = """
				barn owl\n\n
				wise
				""";
		var clever = """
				  barn owl\n\n
				wise
				""";
		var sly = """
				barn owl\n\n
				wise""";

		System.out.println("*" + smart.indent(0) + "*");
		System.out.println(smart.equals(smart.strip()));
		System.out.println(smart.equals(smart.stripIndent()));

		System.out.println(clever.equals(clever.indent(0)));
		System.out.println(clever.equals(clever.strip()));
		System.out.println(clever.equals(clever.stripIndent()));

		System.out.println(sly.equals(sly.indent(0)));
		System.out.println(sly.equals(sly.strip()));
		System.out.println(sly.equals(sly.stripIndent()));

		int y, i = 9;

		Files.createDirectories(Path.of("D:\\OCP17_IO\\A\\AA\\AAA"));

		Function<X, Y> f = Exa::pruebaInf;

		Path path = Paths.get("./j");

		System.out.println(path.toAbsolutePath());

		try (var ps = Files.walk(Path.of("D:\\OCP17_STRING"), 0)) {
			ps.forEach(System.out::println);
		}

		try {
		} catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
			// e = new NullPointerException();
		}

		int hyu = 9;

		DoubleFunction<String> df = x -> {

			return "" + hyu;
		};

		Exa exa1 = new Exa();
		exa1.h = 1;
		Exa exa2 = new Exa();
		exa2.h = 1;

		List<Exa> listExa = new ArrayList<>();
		listExa.add(exa1);
		listExa.add(exa2);

		listExa.remove(exa1);

		listExa.forEach(x -> System.out.println("remo:" + x.h));

		// listExa.stream().distinct().forEach(x->System.out.println(x.h));

		Integer hgt = 9;

		hgt += 8;

		System.out.println(hgt);

		long hgtl = hgt;

		LocalTime lctb = LocalTime.of(5, 16);

		LocalTime lcta = LocalTime.of(6, 14);

		System.out.println(Duration.between(lctb, lcta));

		System.out.println(ChronoUnit.MINUTES.between(lctb, lcta));

		//FileReader fr = new FileReader(Path.of("hola").toFile());
		//FileReader frt = new FileReader("Hola");

		int upds = 8;
		Predicate<String> pstr = x -> {
			x = "ere";
			return x.indexOf("f") > upds;
		};

		// upds = 9;
		
		U ubj = new U();

		String hu = "DrLiveSey";
		
		MP mpp = hu::concat;
		
	   System.out.println(mpp.saludo("  uuuu"));
	   
	   
	   NumberFormat.getCurrencyInstance();
	   
	   for(EP ep:EP.values()) {
		   System.out.println("EP:"+ep+",ordinal:"+ep.ordinal()+",name:"+ep.name());
	   }
	   
	   LocalDate date = LocalDate.of(2068, 4, 15);
	   
	   System.out.println(date.getMonth());
	   
	   System.out.println(Period.of(0,0, 0));
	   
	   System.out.println(Period.parse("p-3000y"));
	   
	   String hh = """
	   		hola
	   		""";
	   System.out.println(hh.length());

	   System.out.println(hh.indent(1).length());
	   
	    A a = new Exa().new AA();
	    
	    AA aa = new Exa().new AA();
	    
	    saludar(a);
	    
	    saludar(aa);
	    
	    AIU mi = new AIU();
	    
	   // I_NADA_QUE_VER inaqv= (I_NADA_QUE_VER)mi;
	  
	   // mi.hola();
	    
	    
	    //aiu.hola();
	    
	    List<String> listx =  new ArrayList<>();
	    
	    System.out.println(listx.stream().collect(Collectors.groupingBy(x->x.length()<2)));
	    
	    System.out.println(listx.stream().collect(Collectors.partitioningBy(x->x.length()<2)));
	    
	    IntUnaryOperator iup = (final int  x)->x;
	    
	    IntFunction<Double> ifd = (final int x)->(double)x;
	    
	    List<String> listx_2 =  List.of("1","2","3","4","5");
	    
	    listx_2.stream().skip(2).limit(3).forEach(System.out::println);
	    
	    LocalDate localDate = LocalDate.of(2023, 7, 8);
	    
	    Date dateP = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

	    
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
	    
	    System.out.println(sdf.format(dateP));
	    
	    
	    Exa exaPrueba =  new Exa();
	    
	    var ex = Executors.newFixedThreadPool(2);
	    
	   Future<?> future= ex.submit(()->exaPrueba.metodo1());
	    ex.submit(()->exaPrueba.metodo2());
	    
	    ex.shutdown();
	    
	    for(int yy=9,hgtr=9;yy<4;) {}
	    
	    var vlj = "";
	    int hhh=9;
	    
	    Object opru = "";
	    
	    if(opru instanceof String strpru) {
	    	strpru = "";
	    }
	    
	    class LocalExample{
	    	public int valorLocal;
	    }
	    
	    LocalExample lce = new LocalExample() {
	    	public void saludar() {
	    		System.out.println(this.valorLocal);
	    	}
	    };
	    
	    I_NADA_QUE_VER inqv = new I_NADA_QUE_VER() {};
	    
	    Short yhy=8;
	    
	  
	    
	    
	}
	
	enum ER{
		
 		ER(){}
	}
	public synchronized void metodo1() {
		
		try {
			System.out.println("Comienza....");
			Thread.sleep(5000);
		}catch (Exception e) {
			// TODO: handle exception
		}		
		System.out.println("Finaliza....");
	}
	
	public synchronized void metodo2() {
		
		try {
			System.out.println("Comienza m2....");
			Thread.sleep(2000);
		}catch (Exception e) {
			// TODO: handle exception
		}		
		System.out.println("Finaliza m2....");
	}
	

	
	class A{
		
		public void saludar() throws Exception{}
	}
	
	record MyRecord() implements Serializable{}
	
	class AA extends A{
		public void saludar() {}
	}
	
	public static void saludar(A a) {
		System.out.println("Es A");
	}
	
	public static void saludar(AA a) {
		System.out.println("Es AA");
	}

	
	Runnable rna = ()->{
		synchronized (this) {
			
		}
	};
	
	static class U {
	 void miSaludo() {}
	}

	class U$ extends U {
	}

	interface IU {
		default void saludar() {
		}
		
		 static void prueba() {}
	}

	interface IK {
		default void saludar() {
		}
		
		default void prueba() {}
	}

	interface IL extends IU, IK {
		default void saludar() {
		}
	}

	class U$$ implements IU, IK {
		public void saludar() {
		}
	}

	abstract class U$_$_$ implements IU, IK {
		public void saludar() {
		}
	}

	record UR() implements IU {
	}

	interface MP {
		String saludo(String u);
	}
	
	enum EP{A,B,C}
}

interface MyInterfaz{
	static void hola() {System.out.println("EStatico Hola");}
}

interface MyInterfazZZ extends MyInterfaz{
	default void hola() {System.out.println("Hoolaa");}
}

interface I_NADA_QUE_VER{}

class AIU implements MyInterfaz,MyInterfazZZ{
	
}

