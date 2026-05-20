package co.prueba;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Pragma {

	public static void main(String... args) throws ParseException {

		// System.out.println(BinaryConverter("100101"));

		// System.out.println(Consecutive(new int[] { -2, 10, 4 }));

		// System.out.println(contarMinutosAuxiliar("3:33pm", "4:00pm"));

		// System.out.println(FibonacciChecker(54));
		
		System.out.println(pasosRobot("RUULLLDDDDR"));

	}

	public static String BinaryConverter(String str) {
		// code goes here
		return String.valueOf(Integer.parseInt(str, 2));
	}

	public static int Consecutive(int[] arr) {

		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));

		int cont = 0;
		for (int i = 0; i < arr.length - 1; i++) {

			int dif = arr[i + 1] - arr[i];
			if (dif > 1) {
				cont += dif - 1;
			}
		}

		return cont;
	}

	public static String FibonacciChecker(int num) {

		int a = 0;
		int b = 1;

		if (num == a || num == b) {
			return "yes";
		}

		while (b < num) {
			int next = a + b;
			a = b;
			b = next;
		}

		return b == num ? "yes" : "no";
	}

	private static int contarMinutosAuxiliar(String timeUno, String timeDos) {

		String timeUnoAux = timeUno.replace("am", "AM").replace("pm", "PM");
		String timeDosAux = timeDos.replace("am", "AM").replace("pm", "PM");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mma", Locale.US);
		LocalTime localTimeUno = LocalTime.parse(timeUnoAux, formatter);
		LocalTime localTimeDos = LocalTime.parse(timeDosAux, formatter);

		long minutos = ChronoUnit.MINUTES.between(localTimeUno, localTimeDos);

		if (minutos < 0) {

			minutos = (24 * 60) + minutos;
		}

		return (int) minutos;

	}

	private static int pasosRobot(String comando) {

		double distMax = -1;
		int cantidadPasos = 0;

		char[] rutas = comando.toCharArray();

		Map<Character, Integer> mapTem = new HashMap<>();
		mapTem.put('L', -1);
		mapTem.put('R', 1);
		mapTem.put('U', 1);
		mapTem.put('D', -1);

		class Coordenada {
			int x;
			int y;
		}

		List<Coordenada> listCoor = new ArrayList<>();

		for (char paso : rutas) {

			if (paso == 'R' || paso == 'L') {

				int val = mapTem.get(paso);

				if (listCoor.isEmpty()) {
					Coordenada coordenada = new Coordenada();
					coordenada.x = val;
					coordenada.y = 0;

					listCoor.add(coordenada);

				} else {
					Coordenada coordenadaUltima = listCoor.get(listCoor.size() - 1);

					Coordenada coordenada = new Coordenada();
					coordenada.x = coordenadaUltima.x + val;
					coordenada.y = coordenadaUltima.y;

					listCoor.add(coordenada);

				}

			}

			if (paso == 'U' || paso == 'D') {
				
				int val = mapTem.get(paso);
				
				if (listCoor.isEmpty()) {
					Coordenada coordenada = new Coordenada();
					coordenada.x = 0;
					coordenada.y = val;

					listCoor.add(coordenada);

				} else {
					Coordenada coordenadaUltima = listCoor.get(listCoor.size() - 1);

					Coordenada coordenada = new Coordenada();
					coordenada.x = coordenadaUltima.x;
					coordenada.y = coordenadaUltima.y+val;

					listCoor.add(coordenada);

				}

			}
			
			Coordenada coordenada = listCoor.get(listCoor.size()-1);
			int corX = coordenada.x;
			int corY = coordenada.y;
			
			System.out.println("x:"+corX+",y:"+corY);
			
			int calX = Math.abs(corX);
			int calY = Math.abs(corY);

			double distMaxTemp = Math.sqrt(Math.pow(calX, 0.5) + Math.pow(calY, 0.5));

			if (distMaxTemp > distMax) {
				System.out.println("==========maximo========");
				distMax = distMaxTemp;

				cantidadPasos = calX+calY;
			}
		}

		return cantidadPasos;
	}

}
