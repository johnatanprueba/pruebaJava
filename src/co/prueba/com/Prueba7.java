package co.prueba.com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Book {

	String author;
	String title;

	Book(String authorName, String title) {
		this.author = authorName;
		this.title = title;
	}

	Book() {
		System.out.println("HOLA!");
	}
}

class BookSon extends Book implements Serializable {

	public String inbs;
}

public class Prueba7 {

	public static void main(String args[]) throws Exception {

		try (var out = new ObjectOutputStream(new FileOutputStream("D:/WorkEclipse3/PruebaJava/John.txt"))) {

			Book b = new BookSon();
			b.author = "Amebar";
			b.title = "Abre los ojos";

			out.writeObject(b);

		}
		
		try(var in = new ObjectInputStream(new FileInputStream("D:/WorkEclipse3/PruebaJava/John.txt"))){
			
			Book b = (Book)in.readObject();
			
			Path k = null;
		}

	}

}