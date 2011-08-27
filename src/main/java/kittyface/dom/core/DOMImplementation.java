package kittyface.dom.core;

public interface DOMImplementation {

	public boolean hasFeature(String feature, String version);
	
	public DocumentType createDocumentType(String qualifiedName, String publicId, String systemId) throws DOMException;
	
	public Document createDocument(String namespaceURI, String qualifiedName, DocumentType doctype) throws DOMException;
	
	public DOMObject getFeature(String feature, String version);


}