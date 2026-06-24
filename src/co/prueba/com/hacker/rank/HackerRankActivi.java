package co.prueba.com.hacker.rank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HackerRankActivi {

	public static long activityNotifications(List<Integer> expenditure, int d) {

		int indiceM = d % 2 == 0 ? d / 2 : (d / 2) + 1;
		int indiceMAux = d % 2 == 0 ? indiceM + 1 : -1;

		List<Integer> listSemilla = expenditure.subList(0, d).stream().sorted().collect(Collectors.toList());

		Double mediana = null;
		long contEnvios = 0;
		for (int i = d; i < expenditure.size(); i++) {
			mediana = getMediana(listSemilla, indiceM, indiceMAux);
			if (expenditure.get(i) >= 2 * mediana) {
				contEnvios++;
			}
			reordenar(Integer.valueOf(i - d), i - 1, listSemilla);
		}
		return contEnvios;

	}

	public static double getMediana(List<Integer> listOrd, int m, int ma) {
		Integer medElm = listOrd.get(m);
		Integer medElmAux = ma != -1 ? listOrd.get(ma) : null;
		Double mediana = null;
		if (medElmAux == null) {
			mediana = medElm.doubleValue();
		} else {
			mediana = (medElm.doubleValue() + medElmAux.doubleValue()) / 2;
		}
		return mediana;
	}

	public static List<Integer> reordenar(Integer sale, Integer entra, List<Integer> list) {
		list.remove(sale);
		int indice = Collections.binarySearch(list, entra);
		if (indice < 0) {
			indice = -indice - 1;
		}
		list.add(indice, entra);
		return list;
	}

	public static void main(String... args) {
		 List<Integer> ex = Arrays.asList(2, 3, 4, 2, 3, 6, 8, 4, 5);
		 int d = 5;

		//List<Integer> ex = Arrays.asList(1, 2, 3, 4, 4);
		//int d = 4;

		long result = activityNotifications(ex, d);
		System.out.println(result);
	}

}
