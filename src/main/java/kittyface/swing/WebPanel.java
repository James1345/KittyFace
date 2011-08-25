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
	
	/** Pretty much an alias for repaint atm */
	public void render(){
		repaint();
	}

	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		paintNode(document, g2);
	}
	
	/** Utility method to recursively paint Nodes on a given graphics object */
	private void paintNode(Node n, Graphics2D g){
		// Set coordintates
		int x = 0;
		int y = TEXT_LINE_HEIGHT;
		// Create string list.
		Vector<String> lines = new Vector<String>();
		
		// Recursively add strings to vector
		addString(document, lines);
		
		// Paint strings
		for(String line : lines){
				g.drawString(line, x, y); //paint line
				y += TEXT_LINE_HEIGHT; //next line
		}
	}
	
	/** Recusively add node text to Vector */
	private void addString(Node n, Vector<String> v){
		NodeList nodes = n.getChildNodes(); //Get child nodes
		for(int i = 0; i < nodes.getLength(); i++) {
			String line = nodes.item(i).getNodeValue();
			if( line != null){
				v.add(line); //add line if not null
			}
			addString(nodes.item(i), v); //Call on node added to add its children
		}
	}
	
}