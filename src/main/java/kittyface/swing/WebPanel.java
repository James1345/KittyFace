package kittyface.swing;

import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class WebPanel extends JPanel {

	protected URL url = null;
	protected Document domTree = null;
	
	public final WebPanelSettings settings = new WebPanelSettings();
	
	public void setUrl(URL url){
		this.url = url;
	}
	
	public void setUrl(String urlString){
		
		try{
			URL newUrl = new URL(urlString);
			this.setUrl(newUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void load(){
		try{
			domTree = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url.openStream());
		} catch (IOException e) {
			e.printStackTrace(); 
		} catch (SAXException e) {
			// Parse exception, try html parser if not well formed xml.
		} catch (Exception e) {
			// Other exceptions
			e.printStackTrace(); 
		}
	}
	
	public void loadFromURL(URL url){
		setUrl(url);
		load();
	}
	
	public void loadFromURL(String url){
		setUrl(url);
		load();
	}
	
	public void render(){
		repaint();
	}

	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.drawString(printNode(domTree), 0, 32);
		
		// Need to organise rendering better
		// need more classes (e.g. hyperlinks)
		// going to need more handlers
	}
	
	// TEST METHODS ONLY BELOW HERE //
	
	public void printDomTree() {
		System.out.println(printNode(domTree));
	}
	
	private String printNode(Node n){
		
		// Testing output
		String printNode = "";
		NodeList nodes = n.getChildNodes();
		for(int i = 0; i < nodes.getLength(); i++) {
			String line = nodes.item(i).getNodeValue();
			if( line != null){
				printNode += line.trim();
				if(line != ""){
					printNode += "\n";
				}
			}
			printNode += printNode(nodes.item(i));
		}
		return printNode;
	}

}