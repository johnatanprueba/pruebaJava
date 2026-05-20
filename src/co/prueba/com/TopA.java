package co.prueba.com;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;



class ATemp{}

class BTemp{}

abstract class Super {
	abstract List get() throws IndexOutOfBoundsException;
}

abstract class Sub extends Super {

	abstract ArrayList get();
}

class OutP {
	public void saludar() {
	}
}

interface HHI{}

class AHHI{}

public class TopA {

	static int HY = 0;

	static class vv {
	}

	public static void main(String... args) {

		final int gh = 9;

		record ft() {
			public void hola() {
				System.out.println(HY);
			}
		}

		XOuter.BOuter baux = new XOuter().new BOuter();

		var stclass = new XOuter.XStatic();

		class Inner extends OutP {
			public void saludarDos() {
			}
		}

		Inner inner = new Inner();
		inner.saludarDos();

		Inner innerTres = new Inner() {
			public void saludarTres() {
			}
		};

		// innerTres.saludarTres();

		var innerVar = new Inner() {
			public void saldarCuatro() {
			}
		};

		innerVar.saldarCuatro();

		BigDecimal bigDecimal = BigDecimal.ZERO;
		System.out.println(bigDecimal);

		LocalDate ld = LocalDate.of(2024, 1, 20);

		LocalDate ldf = LocalDate.of(2024, 3, 7);

		System.out.println(ChronoUnit.DAYS.between(ld, ldf));

		LocalDate lda = LocalDate.of(2024, 1, 20);

		LocalDate ldfa = LocalDate.of(2024, 2, 1);

		System.out.println(ChronoUnit.DAYS.between(lda, ldfa));

		System.out.println(Period.between(lda, ldfa).getMonths());

		System.out.println(Period.between(lda, ldfa).getMonths());

		int vf;

		vf = 0;

		ToIntFunction<Integer> ifu = x -> {

			return x.intValue() + vf;
		};

		int HY = 9;
		;

		System.out.println(HY);

		record F() {
		}

		enum YY {
			A, B
		}

		interface Jo {
		}

		TopA topa = new TopA();
		topa.exceptions();

		int[] a = null;
		int[] b = null;

		// List<String> list = new ArrayList<>();

		// System.out.println(Arrays.compare(new Integer[] {1,2}, new Integer[]
		// {1,2,3,4,5}));

		List list = new ArrayList<>();
		list.add(0, "E");
		list.add("X");
		list.add(1, "P");
		list.add(3, "O");

		if (list.contains("O")) {
			list.remove("O");
		}

		System.out.println(list);

		var listy = new ArrayList<String>();
		listy.add("TAKE");
		listy.add("THE");
		listy.add("RISK");

		DoubleSummaryStatistics dss = listy.stream().collect(Collectors.summarizingDouble(x -> x.length()));

		// System.out.println(String.join(".", listy));

		System.out.println(Arrays.compare(new short[] { 1, 2, 78, 34, 5, 46, 7 }, new short[] { 1, 2, 2 }));

		String text = """
				hola\
				""";

		String textAux = "hola";

		System.out.println(text.length());

		System.out.println(text == textAux);

		LocalDate localDateIni = LocalDate.of(2024, 1, 5);

		LocalDate localDateFin = LocalDate.of(2024, 2, 15);

		System.out.println(Period.between(localDateIni, localDateFin));

		System.out.println(ChronoUnit.MONTHS.between(localDateIni, localDateFin));

		enum J {
			A, r
		}

		var rr = new Super() {
			public List get() {
				return null;
			}

			public void saludar() {
			}

		};

		rr.saludar();

		System.out.println(rr.get());

		var sd = "a\n";
		System.out.println(sd + "*");

		var phrase = "prickly \nporcupine";
		System.out.println(phrase.length());// 18
		System.out.println(phrase.indent(1).length());// 21
		System.out.println(phrase.indent(0).length());// 19
		System.out.println(phrase.indent(-1).length());// 19

		System.out.println("cheetah\ncubs");
		System.out.println("cheetah\\ncubs");
		System.out.println("cheetah\ncubs".translateEscapes());
		System.out.println("cheetah\\ncubs".translateEscapes());
		
		var strFull = "a\n"				
			        + "B";
		System.out.println(strFull);

		class Ano {
			private int val;

			Ano(int val) {
				this.val = val;
			}

			public String toString() {
				return "[" + val + "]";
			}

			public boolean equals(Object obj) {

				if (obj instanceof Ano ano) {
					return ano.val == this.val;
				}

				return false;
			}
		}

		List<Ano> lisAnio = new ArrayList<>();

		// Set<Ano> listAno = new HashSet<>();
		lisAnio.add(new Ano(1));

		//lisAnio.forEach(System.out::println);
		
		

		System.out.println(lisAnio.remove(new Ano(1)));
		
		System.out.println(lisAnio);
		
		AHHI ahhi= new AHHI();
		
		boolean resi = ahhi instanceof HHI;  
		
		var srLong = """
				u\n
				f
				""";
	
		System.out.println(srLong+"*");
		
		String strLons = "u\n"
				         +"f";
		
		System.out.println(strLons+"*");
		
		short[] arr1 = new short[] {6,7,8};
		short[] arr2 = new short[] {6,7,89};
		
		System.out.println(Arrays.compare(arr1, arr2));
		
		var strTex = """
				                         hola""";
		
		var strTextSi = "hola";
		
		System.out.println(strTex == strTextSi);
		
		ATemp aTemp =  new ATemp();
		
		HHI iat = (HHI)aTemp;

	}

	public void exceptions() {

		try {

			trigger();
		} catch (FileNotFoundException e) {

			// throw e;
		} catch (IOException e) {
			// TODO: handle exception
		}

		System.out.println("----->");
	}

	public void trigger() throws FileNotFoundException {

	}

	public void prueba() {
		Object u = 2;
		if (!(u instanceof Integer x)) {
			return;
		}

		x = x + 9;

	}

}

class XOuter {
	static class XStatic {
	}

	static {
		System.out.println("TOPA X");
	}

	class BOuter {
		static {
			System.out.println("B");
		}
	}

	public void metodo() {

		BOuter b = new XOuter.BOuter();
	}
}
