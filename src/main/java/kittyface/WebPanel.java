package kittyface;

import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class WebPanel extends JPanel {

	protected URL url = null;
	protected Document domTree = null;
	
	protected Mode mode = Mode.BASIC;
	
        public WebPanel() {
            
        }
        
        
	public void setMode(Mode mode){
		this.mode = mode;
	}
	
	public void setUrl(URL url){
		this.url = url;
                this.load();
	}
	
	public void setUrl(String url){
		try{
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
                this.load();
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
	
	public void render(){
		// Self explanatory
	}


}