package kittyface;

import javax.swing.*;
import java.net.*;
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
		// set domTree to have a value based on url
		// javax.xml has parser for creating Documents
	}
	
	public void render(){
		// Self explanatory
	}


}