package kittyface.swing;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class WebPanel extends JPanel {

	/** The document to be displayed. */
	private Document document = null;
	
	/** The settings object. */
	public final WebPanelSettings settings = new WebPanelSettings();
	
	/** The number of pixels in a line of text. */
	public final static int TEXT_LINE_HEIGHT = 16; 
	
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
			NodeList nodes = n.getChildNodes(); //Get child nodes
			for(int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				add(node);
			}
		} 
	}
	
}