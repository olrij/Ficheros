import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class XpathPruebas {

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		// TODO Auto-generated method stub

		// Crea un DocumentBuilderFactory y un árbol DOM
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document documento = factory.newDocumentBuilder().parse(new File("personas.xml"));
		// Crea el objeto XpathFactory

		XPath xpath = XPathFactory.newInstance().newXPath();
		// Crea un XpathExpression con la consulta deseada

		// personasMayoresDeX(30,xpath,documento);
		//personaConIdX(1, xpath, documento);
		personaConIdXYMayorDeX(1, 20,xpath, documento);

	}

	public static void personasMayoresDeX(int edad, XPath xpath, Document documento) throws XPathExpressionException {

		String xpathExpression = "//persona[./edad>" + edad + "]";

		// Consultas

		NodeList nodos = (NodeList) xpath.evaluate(xpathExpression, documento, XPathConstants.NODESET);

		for (int i = 0; i < nodos.getLength(); i++) {
			Element e = (Element) nodos.item(i);
			mostrarInfoPersona(e);
		}

	}

	public static void personaConIdX(int id, XPath xpath, Document documento) throws XPathExpressionException {

		String xpathExpression = "//persona[./@id=" + id + "]";

		// Consultas

		NodeList nodos = (NodeList) xpath.evaluate(xpathExpression, documento, XPathConstants.NODESET);

		for (int i = 0; i < nodos.getLength(); i++) {
			Element e = (Element) nodos.item(i);
			mostrarInfoPersona(e);
		}

	}

	public static void personaConIdXYMayorDeX(int id,int edad, XPath xpath, Document documento) throws XPathExpressionException {

		String xpathExpression = "//persona[./@id=" + id + " and ./edad>"+edad+"]";

		// Consultas

		NodeList nodos = (NodeList) xpath.evaluate(xpathExpression, documento, XPathConstants.NODESET);

		for (int i = 0; i < nodos.getLength(); i++) {
			Element e = (Element) nodos.item(i);
			mostrarInfoPersona(e);
		}

	}

	public static void nombrePersonasMayoresDeX(int edad, XPath xpath, Document documento)
			throws XPathExpressionException {

		String xpathExpression = "//persona[./edad>30]/nombre";

		// Consultas

		NodeList nodos = (NodeList) xpath.evaluate(xpathExpression, documento, XPathConstants.NODESET);

		for (int i = 0; i < nodos.getLength(); i++) {
			Element e = (Element) nodos.item(i);
			mostrarInfoPersona(e);
		}

		System.out.println(nodos.getLength());

	}

	public static void mostrarInfoPersona(Element p) {

		System.out.print(p.getTagName() + " id:" + p.getAttribute("id"));

		NodeList nl = p.getChildNodes();

		for (int i = 0; i < nl.getLength(); i++) {
			Node n = nl.item(i);

			switch (n.getNodeType()) {
			case Node.ELEMENT_NODE:
				Element e = (Element) n;
				System.out.print(e.getTagName() + ":" + e.getTextContent());

				break;
			case Node.TEXT_NODE:
				Text t = (Text) n;
				System.out.print(t.getWholeText());
				break;
			}
		}
	}

}
