package nl.hu.v2pafr.service.exporter;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import nl.hu.v2pafr.model.SentenceStorage;

public class XmlExport implements Export{
	private Document document = null;
	private Element rootElement = null;
	private String txt = SentenceStorage.getInstance().getSentence();

	public XmlExport() {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			this.document = documentBuilder.newDocument();
			
			this.rootElement = document.createElement("export");
			this.document.appendChild(rootElement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean saveExport(File file) {
		if(txt != null & file != null) {
			createXMLFile();
			writeXMLFile(file);
			
			return true;
		} else {
			return false;
		}
	}
	
	//Write the xml file with the correct elements
	private void createXMLFile() {
		//The sentences go in this element
		Element translations = this.document.createElement("translations");
		this.rootElement.appendChild(translations);
		
		//Here a the current translated sentence is appended
		Element sentence = this.document.createElement("sentence");
		sentence.appendChild(this.document.createCDATASection(txt));
		this.rootElement.appendChild(sentence);
	}
	
	//Export the xml file
	private void writeXMLFile(File file) {
		File output = new File(file.getAbsolutePath() + ".xml");
		
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(this.document);
			
			StreamResult stream = new StreamResult(output);
			
			transformer.transform(domSource, stream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
