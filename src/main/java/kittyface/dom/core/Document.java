package kittyface.dom.core;

public interface Document extends Node {

 private DocumentType doctype;
 private DOMImplementation implementation;
 private Element documentElement;
 
 public DocumentType getDocType();
 public DOMImplementation getImplementation();
 public Element getDocumentElement();

 public Element createElement(String tagName) throws DOMException;
 
 public DocumentFragment createDocumentFragment();
 public Text createTextode(String data);
 public Comment createComment();
 public CDATASection createCDATASection(String data) throws DOMException;
 
 public ProcessingInstruction createProcessingInstruction(String target, String data) throws DOMException;
 
 public Attr createAttribute(String name) throws DOMException;
 
 public EntityReference createEntityReference( String name) throws DOMException;
 public NodeList getElementsByTagName( String tagname);
 public Node importNode( Node importedNode, boolean deep) throws DOMException;
 public Element createElementNS( String namespaceURI, String qualifiedName) throws DOMException;
 public Attr createAttributeNS( String namespaceURI,String qualifiedName) throws DOMException;
public NodeList getElementsByTagNameNS( String namespaceURI, String localName);
public Element getElementById( String elementId);



private String inputEncoding;
public String getInputEncoding();

private String xmlEncoding;
public String getXmlEncoding();

private boolean xmlStandalone;
public boolean getXmlStandalone();
public void setXmlStandalone(boolean xmlStandalone) throws DOMException();

 private String xmlVersion;
public String getXmlVersion();
public void setXmlVersion(String xmlVersion) throws DOMException;

 private boolean strictErrorChecking;
 public boolean getStrictErrorChecking();
 public void setStrictErrorChecking(boolean strictErrorChecking);
 
 private String documentURI;
 public String getDocumentURI();
 public void setDocumentURI(String documentURI);
 
public Node adoptNode( Node source) throws DOMException;
 private DOMConfiguration domConfig;
 public DOMConfiguration getDomConfig();
 
public void normalizeDocument();
public Node renameNode( Node n, String namespaceURI, String qualifiedName) throws DOMException;


}