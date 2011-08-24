package kittyface;

import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

class WebPanel extends JPanel {

	protected URL url = null;
	protected Document domTree = null;
	
	protected Mode mode = Mode.BASIC;
	
	public void setMode(Mode mode){
		this.mode = mode;
	}
	
	public void setUrl(URL url){
		this.url = url;
	}
	
	public void setUrl(String url){
		try{
			this.url = new URL(url);
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
		}
	}
	
	public void render(){
		// Self explanatory
	}


}