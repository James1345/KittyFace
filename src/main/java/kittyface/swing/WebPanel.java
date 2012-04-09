package kittyface.swing;

import java.io.*;
import javax.swing.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class WebPanel extends JPanel {

	/** The document to be displayed. */
	private Document document = null;
	
	/** The settings object. */
	public final WebPanelSettings settings = new WebPanelSettings();
	
	public void load(){
		try{
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(settings.url.openStream());
		} catch (IOException e) {
			e.printStackTrace(); 
		} catch (SAXException e) {
			// Parse exception, try html parser if not well formed xml.
		} catch (Exception e) {
			// Other exceptions
			e.printStackTrace(); 
		}
	}
	
	/** Render the document */
	public void render(){
		removeAll();
		add(document);
	}
	
	/** 
	 * Add a node, recurse to add child nodes.
	 *
	 * Messy. modifying parameters D:
	 *
	 * @param n The node to add.
	 */
	private void add(Node n){
	
		switch (n.getNodeName()){
		case "#text":
			String line = n.getNodeValue();
			if( line != null){
				for ( String word : line.split("\\s+") ){
					add(new JLabel(word));
				}
			}
			break;
		case "#comment": break; // Do Nothing on comment
		default:
			// Detect if it's an element
			Element e = null;
			if ( n.getAttributes() != null ) e = (Element)n; //perform cast
			
			// If it is an element
			if ( e != null ){
				if (e.getTagName() == "a"){ // If it's a link element
					add(new JButton(n.getFirstChild().getNodeValue()));
					break;
				}
			}
			// For all nodes not causing a break
			NodeList nodes = n.getChildNodes(); //Get child nodes
			for(int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				add(node);
			}
		}	 
	}
	
}