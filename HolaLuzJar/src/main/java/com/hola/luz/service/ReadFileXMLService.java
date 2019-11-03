package com.hola.luz.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.hola.luz.exception.ExceptionRead;
import com.hola.luz.pojo.Measure;
import com.hola.luz.properties.GeneralPropierties;


public class ReadFileXMLService implements ReadFileServiceInterface {
	
	
	/**
	 * Leemos los fichero del fichero xml para recogerlos en objetos Measure.
	 */
	@Override
	public List<Measure> readFile(File file) throws ExceptionRead {
		
		List<Measure> result = new ArrayList<Measure>();
		
		try {		
		
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
		  
			doc.getDocumentElement().normalize();
		  
			NodeList nList = doc.getElementsByTagName("reading");
		  
			for(int i = 0; i < nList.getLength(); i++) {
			  
			
				Node nNode = nList.item(i);
	
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				
					Element eElement = (Element) nNode;
					
					// Tal como dice en la prueba supenemos que todos los valores son correctos.
					String client = eElement.getAttribute("clientID");
					
					String period = eElement.getAttribute("period");
						
					String sReading  = eElement.getFirstChild().getTextContent();
					Long reading = Long.valueOf(sReading);
					
					Measure measure = new Measure(client, period, reading);
					
					result.add(measure);
				  }
			}			
			
		} catch(Exception e) {
		
			String s = "ReadFileXMLService.readFile: " + GeneralPropierties.ERROR_READING_FILE + " XML";
			throw new ExceptionRead(s, e);	
		}
				
		return (result);
	}

}
