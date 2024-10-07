package dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class ArchivosXML {

	public static void main(String[] args)
			throws TransformerException, SAXException, IOException, ParserConfigurationException {
		// TODO Auto-generated method stub

		Document doc = deXMLaDOM("personas.xml");

		Element persona2 = encontrarPersonaPorId("2", doc);
		
		cambiarNombre(persona2,"Hola Mundo");

		mostrarInfoPersona(persona2);
		
		deDOMaXML("personas.xml",doc);
		
		

	}

	public static void deDOMaXML(String ruta, Document doc) throws TransformerException {
		// 1º Creamos una instancia de la clase File para acceder al archivo donde
		// guardaremos el
		// XML.
		File f = new File(ruta);
		// 2º Creamos una nueva instancia del transformador a través de la fábrica de
		// transformadores.
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		// 3º Establecemos algunas opciones de salida, como por ejemplo, la codificación
		// de salida.
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		// 4º Creamos el StreamResult, intermediaria entre el transformador y el archivo
		// de destino.
		StreamResult result = new StreamResult(f);
		// 5º Creamos el DOMSource, intermediaria entre el transformador y el árbol DOM.
		DOMSource source = new DOMSource(doc);
		// 6º Realizamos la transformación.
		transformer.transform(source, result);
	}

	public static Document deXMLaDOM(String ruta)
			throws TransformerException, SAXException, IOException, ParserConfigurationException {
		// 1º Creamos una nueva instancia de una fabrica de constructores de documentos.
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 2º A partir de la instancia anterior, fabricamos un constructor de
		// documentos, que procesará el XML.
		DocumentBuilder db = dbf.newDocumentBuilder();
		// 3º Procesamos el documento (almacenado en un archivo) y lo convertimos en un
		// árbol DOM.
		Document doc = db.parse(ruta);
		return doc;
	}

	public static Element encontrarPersonaPorId(String id, Document doc) {
		// Obtengo raiz
		Element raiz = doc.getDocumentElement();

		// Busco personas
		NodeList personas = raiz.getElementsByTagName("persona");

		for (int i = 0; i < personas.getLength(); i++) {
			Element persona = (Element) personas.item(i);

			if (persona.getAttribute("id").equals(id)) {
				return persona;
			}

		}

		return null;

	}

	public static void mostrarInfoPersona(Element p) {

		System.out.print(p.getTagName() + " id:" + p.getAttribute("id"));

		NodeList nl = p.getChildNodes();

		System.out.println("Tengo "+nl.getLength()+" hijos");
		
		for (int i = 0; i < nl.getLength(); i++) {
			Node n = nl.item(i);

			switch (n.getNodeType()) {
			case Node.ELEMENT_NODE:
				Element e = (Element) n;
				System.out.print(e.getTagName()+":"+e.getTextContent());

				
				break;
			case Node.TEXT_NODE:
				Text t = (Text) n;
				System.out.print(t.getWholeText());
				break;
			}
		}
	}
	
	public static void cambiarNombre(Element p, String nuevoNombre){
		
		
		NodeList nl = p.getElementsByTagName("nombre");
		
		Element nombre=(Element) nl.item(0);
		
		nombre.setTextContent(nuevoNombre);
		
		
		
		
	}

}
