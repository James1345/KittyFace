package kittyface.swing;

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
		// Self explanatory what this should do
	}

	public void printDomTree(){
		printNode(domTree);
	}
	
	private void printNode(Node n){
		// Testing output
		NodeList nodes = n.getChildNodes();
		for(int i = 0; i < nodes.getLength(); i++) {
			String line = nodes.item(i).getNodeValue();
			if( line != null || line != "\n")
				System.out.println(line);
			printNode(nodes.item(i));
		}	
	}

}