package co.prueba.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.DayOfWeek;
import java.time.DayOfWeek.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Prueba4 implements Serializable {

	private static float averigablePrice = 2.99f;
	private String descripcion;
	private transient float price;

	public Prueba4(String descripcion, float price) {
		this.descripcion = descripcion;
		this.price = price;
	}

	public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		price = averigablePrice;
		System.out.println("===========================================");

	}

	public String toString() {
		return descripcion + " " + price + " " + averigablePrice;
	}

	public static void main(String[] args) throws Exception {
		
		Prueba4 p = new Prueba4("Cookie", 3.99f);
		try {
			try (ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("D:/WorkEclipse3/PruebaJava/src/data"))) {
				out.writeObject(p);
			}

			try (ObjectInputStream in = new ObjectInputStream(
					new FileInputStream("D:/WorkEclipse3/PruebaJava/src/data"))) {
				p = (Prueba4) in.readObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(p);
	}

}