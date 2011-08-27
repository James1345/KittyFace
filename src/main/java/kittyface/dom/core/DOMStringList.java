package kittyface.dom.core;

public interface DOMStringList{

	public String item(long index);
	
	private long length;
	
	public long getLength();
	
	public boolean contains(String str);

}