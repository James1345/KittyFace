package kittyface.dom.core;

public interface DOMImplementaionList{
	
	DOMImplementation item(long index);
	
	private long length;
	public long getLength();

}