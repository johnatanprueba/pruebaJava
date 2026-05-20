package co.prueba.com.ejecutar.jar;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class CargarApplication {
	
	public static void loadJar(final String pathToJar) throws IOException {

		// Class name to Class object mapping.
		final Map<String, Class<?>> classMap = new HashMap<>();

		final JarFile jarFile = new JarFile(pathToJar);
		final Enumeration<JarEntry> jarEntryEnum = jarFile.entries();

		final URL[] urls = { new URL("jar:file:" + pathToJar + "!/") };
	
		final URLClassLoader urlClassLoader = URLClassLoader.newInstance(urls);
		
		
		
	}
	

}
