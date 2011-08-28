package kittyface.dom.html;

import kittyface.dom.core.*;

public interface HTMLDocument extends Document{

	private String title;
	public String getTitle();
	public void setTitle(String title);
	
	private String referrer;
	public String getReferrer();
	
	private String domain;
	public String getDomain();
	
	private String URL;
	public String getURL();
	
	private HTMLElement body;
	public HTMLElement getBody();
	public void setBody(HTMLElement body);
	
	private HTMLCollection images;
	public HTMLCollection getImages();
	
	private HTMLCollection applets;
	public HTMLCollection getApplets();
	
	private HTMLCollection links;
	public HTMLCollection getLinks();
	
	private HTMLCollection forms;
	public HTMLCollection getForms();
	
	private HTMLCollection anchors;
	public HTMLCollection getAnchors();
	
	private String cookie;
	public String getCookie();
	public void setCookie(String cookie) throws DOMException;
	
	public void open();
	public void close();
	public void write(String text);
	public void writeln(String text);
	public NodeList getElementByName(String elementName);
}