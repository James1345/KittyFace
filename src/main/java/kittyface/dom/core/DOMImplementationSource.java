package kittyface.dom.core;

public interface DOMImplementationSource{

	public DOMImplementation getDOMImplementaion(String features);
	
	public DOMImplementationList getDOMImplementationList(String features);

}