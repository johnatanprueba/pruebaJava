package co.prueba.com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjecutarDatosTablasDefinitivos {

	public static void main(String... args) {
		
		ejecutarFuncioneDB("C:\\Users\\JOHNATAN\\Desktop\\temp\\Diego\\tablasDefinitivo.sql");
		ejecutarFuncioneDB("C:\\Users\\JOHNATAN\\Desktop\\temp\\Diego\\datosDefinitivo.sql");

	}

	public static void ejecutarFuncioneDB(String rutaFile) {

		try (Stream<String> lines = Files.lines(Paths.get(rutaFile))) {

			String outFuncion = lines.collect(Collectors.joining("\n"));

			if (outFuncion != null && !outFuncion.isEmpty()) {

				String urlConectDataBaseConEsquema = "jdbc:postgresql://localhost:5432/ebdblocal"
						+ "?currentSchema=public";

				try (Connection d = DriverManager.getConnection(urlConectDataBaseConEsquema, "root", "123");
						PreparedStatement pre = d.prepareStatement(outFuncion)) {

					pre.executeUpdate();

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
