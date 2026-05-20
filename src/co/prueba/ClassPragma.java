package co.prueba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

import java.io.File;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

class J {
	private final int k;

	{
		// k = 9;
	}

	J() {
		k = 9;
	}

	J(String h) {
		k = 9;
	}

	private final void saludar() {
	}

	static final void saludaru() {
	}
}

abstract class O {
	static void fr() {
	}
}

public class ClassPragma {

	static class Coordenanda {
		int x;
		int y;

		public String toString() {
			return "x:" + x + ",y:" + y;
		}
	}

	public static void main(String... args) throws Exception {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// Elemento raíz
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("Document");
		doc.appendChild(rootElement);

		// Primer elemento
		Element elemento1 = doc.createElement("NominaIndividual");
		rootElement.appendChild(elemento1);

		Attr attr = doc.createAttribute("xmlns:xsi");
		attr.setValue("http://www.w3.org/2001/XMLSchema-instance");
		elemento1.setAttributeNode(attr);

		// Primer Correo

		Element elementoCorreo = doc.createElement("Correo");

		Attr attrCor = doc.createAttribute("xsi:nil");
		attrCor.setValue("true");

		elementoCorreo.setAttributeNode(attrCor);
		// elementoCorreo.setTextContent(String.format("%.2f",1245.1488).replace(",",
		// "."));
		elemento1.appendChild(elementoCorreo);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new StringWriter());
		transformer.transform(source, result);

		String xmlString = result.getWriter().toString();
		System.out.println(xmlString.replace(" standalone=\"no\"", ""));

		Instant j = Instant.now();

		Instant j1 = Instant.now();

		Duration h = Duration.between(j, j1);

		String hj = "ab";

		System.out.println("longitud hj:" + hj.length());
		System.out.println("longitud hj ident:" + hj.indent(0).length());

	}

}
