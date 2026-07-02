package co.prueba.extras;

interface Ipn{
	static void saludar() {}
}

interface Ipne extends Ipn{
	default void saludar() {}
}

enum LETRAS {
	A, B {
		public void saludar() {
		}
	}
}

class Sup{
	class G{
		
	}
	
	static class Est{}
	
	public void saludar() {
		
		Sup.G g = new Sup.G();
		G g2=new G();
		
		Est est = new Sup.Est();
		Est est2 = new Est();
	}
}

public class PatoNegro {
	public static void main(String...args) {
		LETRAS l = LETRAS.B;
		
		var f = """
				              j
				              """;
		
		System.out.println(f);
	}
}
