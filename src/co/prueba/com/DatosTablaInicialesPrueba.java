package co.prueba.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

enum TableInsertEnum {
	DOMINIO("dominio"), UBICACION_PAIS("ubicacion_pais"), TERCERO_TIPO_CONTRIBUYENTE("tercero_tipo_contribuyente"),
	IMPUESTO("impuesto"), TERCERO_CLASIFICACION_ADMINISTRADOR_INPUESTO("tercero_clasificacion_administrador_impuesto"),
	TERCERO_TIPO_TELEFONO("tercero_tipo_telefono"), TERCERO_TIPO_DIRECCION("tercero_tipo_direccion"),
	TERCERO_TIPO_IDENTIFICACION("tercero_tipo_identificacion"), UBICACION_DEPARTAMENTO("ubicacion_departamento"),
	UBICACION_CIUDAD("ubicacion_ciudad");

	private String nombre;

	TableInsertEnum(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public String getInsertParcial() {

		return "INSERT INTO " + nombre + " (";
	}

}

public class DatosTablaInicialesPrueba {

	public static void main(String... args) throws Exception {

		//iniciarQuitarEncabezadoPublicTablasIniciales();

		iniciarQuitarEncabezadoPublicDatosIniciales();

		ordenarInsertsDatosIniciales();

		agregarBackUpBlancoDatosIniciales();

	}

	public static void iniciarQuitarEncabezadoPublicTablasIniciales() throws Exception {

		String pathOrigin = "C:\\Users\\JOHNATAN\\Desktop\\BackOriginales\\ArchivosParaProbar\\TablasIniciales.sql";

		String pathResult = "C:\\Users\\JOHNATAN\\Desktop\\BackOriginales\\ArchivosParaProbar\\TablasInicialesFinal.sql";

		String indice = "CREATE TABLE";

		quitarEncabezadoPublic(pathOrigin, pathResult, indice);

	}

	public static void iniciarQuitarEncabezadoPublicDatosIniciales() throws Exception {

		String pathOrigin = "C:\\Users\\JOHNATAN\\Desktop\\BackOriginales\\ArchivosParaProbar\\DatosIniciales.sql";

		String pathResult = "C:\\Users\\JOHNATAN\\Desktop\\BackOriginales\\ArchivosParaProbar\\DatosInicialesFinal.sql";

		String indice = "INSERT INTO";

		quitarEncabezadoPublic(pathOrigin, pathResult, indice);

	}

	public static void quitarEncabezadoPublic(String pathOrigin, String pathResult, String indice) throws Exception {

		Path original = Paths.get(pathOrigin);

		Path recipiente = Paths.get(pathResult);

		try (BufferedWriter buffereWriter = new BufferedWriter(new FileWriter(recipiente.toFile()));
				BufferedReader buffereReader = new BufferedReader(new FileReader(original.toFile()))) {

			boolean beginCopy = false;

			String currentLine;
			while ((currentLine = buffereReader.readLine()) != null) {

				if (currentLine.contains(indice)) {
					beginCopy = true;
				}

				if (beginCopy) {

					buffereWriter.write(currentLine.replace("public.", ""));
					buffereWriter.newLine();
				}

			}

		}

		Files.move(recipiente, original, StandardCopyOption.REPLACE_EXISTING);

	}

	public static void ordenarInsertsDatosIniciales() throws Exception {

		Path origen = Paths.get("C:\\Users\\JOHNATAN\\Desktop\\BackOriginales\\ArchivosParaProbar\\DatosIniciales.sql");

		Path destino = Paths.get(
				"C:\\Users\\JOHNATAN\\Desktop\\BackOriginales\\ArchivosParaProbar\\DatosInicialesOrdenarInsert.sql");

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(destino.toFile()))) {

			// agregamos dominio
			ejecutarAdd(bw, TableInsertEnum.DOMINIO.getInsertParcial(), origen);

			// agregamos ubicacion pais
			ejecutarAdd(bw, TableInsertEnum.UBICACION_PAIS.getInsertParcial(), origen);

			// agregamos tercero_tipo_contribuyente
			ejecutarAdd(bw, TableInsertEnum.TERCERO_TIPO_CONTRIBUYENTE.getInsertParcial(), origen);

			// agregamos impuesto
			ejecutarAdd(bw, TableInsertEnum.IMPUESTO.getInsertParcial(), origen);

			// agregamos tercero_clasificacion_administrador_impuesto
			ejecutarAdd(bw, TableInsertEnum.TERCERO_CLASIFICACION_ADMINISTRADOR_INPUESTO.getInsertParcial(), origen);

			// agregamos tercero_tipo_telefono
			ejecutarAdd(bw, TableInsertEnum.TERCERO_TIPO_TELEFONO.getInsertParcial(), origen);

			// agregamos tercero_tipo_direccion
			ejecutarAdd(bw, TableInsertEnum.TERCERO_TIPO_DIRECCION.getInsertParcial(), origen);

			// agregamos tercero_tipo_identificacion
			ejecutarAdd(bw, TableInsertEnum.TERCERO_TIPO_IDENTIFICACION.getInsertParcial(), origen);

			// agregamos ubicacion_departamento
			ejecutarAdd(bw, TableInsertEnum.UBICACION_DEPARTAMENTO.getInsertParcial(), origen);

			// agregamos ubicacion_ciudad
			ejecutarAdd(bw, TableInsertEnum.UBICACION_CIUDAD.getInsertParcial(), origen);

			// agregamos el resto de lineas
			ejecutarAddRestFile(bw, origen);

		}

		Files.move(destino, origen, StandardCopyOption.REPLACE_EXISTING);

	}

	private static void ejecutarAdd(BufferedWriter bw, String match, Path origen) throws Exception {

		try (BufferedReader br = new BufferedReader(new FileReader(origen.toFile()))) {

			String currentLine;
			while ((currentLine = br.readLine()) != null) {

				if (currentLine.contains(match)) {

					bw.write(currentLine);
					bw.newLine();
				}
			}

		}

		bw.newLine();
		bw.newLine();

	}

	private static void ejecutarAddRestFile(BufferedWriter bw, Path origen) throws Exception {

		try (BufferedReader br = new BufferedReader(new FileReader(origen.toFile()))) {

			String currentLine;
			while ((currentLine = br.readLine()) != null) {

				boolean isOtherLine = othersLines(currentLine);

				if (!isOtherLine) {

					bw.write(currentLine);
					bw.newLine();
				}
			}

		}

		bw.newLine();
		bw.newLine();

	}

	private static boolean othersLines(String line) {

		boolean result = Arrays.asList(TableInsertEnum.values()).stream()
				.anyMatch(x -> line.contains(x.getInsertParcial()));

		return result;
	}

	private static void agregarBackUpBlancoDatosIniciales() throws Exception {

		Path pathBackUpBlanco = Paths
				.get("D:\\TrabajoWorlOffice\\GitAux\\wo-backend\\wo-main\\scripts\\BackUpBlanco.sql");

		Path destino = Paths
				.get("C:\\Users\\JOHNATAN\\Desktop\\BackOriginales\\ArchivosParaProbar\\DatosIniciales.sql");

		try (Stream<String> strStream = Files.lines(pathBackUpBlanco)) {

			String result = strStream.collect(Collectors.joining("\n"));

			Files.write(destino, result.getBytes(), StandardOpenOption.APPEND);
		}

	}

}
