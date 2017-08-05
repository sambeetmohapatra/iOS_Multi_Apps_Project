/**
 * 
 */
package iOS.GenericFunctions;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * @author sambeetmohapatra
 * To Read xpath from XML File.
 * FORMAT - "PAGENAME/ELEMENTNAME"
 */


public class XML_ReadWrite {
	
	private String filename;
	private String ele;

	public XML_ReadWrite(String filename) {
		this.filename = filename;
	}
	
	public  String read_XML(String PageName_ElementName) throws Exception{
	  File inputFile = new File(filename);
		 
	  DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      
      Document doc = dBuilder.parse(inputFile);
      doc.getDocumentElement().normalize();
      
      // ROOT ELEMENT IS ALWAYS CLASS
    /* System.out.println("Root element "+ doc.getDocumentElement().getNodeName());*/ 
		
		 String[] parts = PageName_ElementName.split("/");
		 String pageName = parts[0];
		 String elementName = parts[1];

		 NodeList nList = doc.getElementsByTagName(pageName);	 //Node Tag 

		 Node nNode = nList.item(0);
		 Element eElement = (Element) nNode; // Current Element within the Node Tag
		 
		 if(nNode.getNodeName().equalsIgnoreCase(pageName)) {
			 
			 NamedNodeMap attributes = eElement.getElementsByTagName(elementName).item(0).getAttributes();
			 
		 if(attributes.item(0).getTextContent().equalsIgnoreCase("iOS") && attributes.item(1).getTextContent().equalsIgnoreCase("xpath"))
			 ele = eElement.getElementsByTagName(elementName).item(0).getTextContent();
}
		return ele;
	}
	
}