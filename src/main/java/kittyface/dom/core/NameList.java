package kittyface.dom.core;

public interface NameList{

	public String getName(long index);
	public String getNamespaceURI(long index);
	private long length;
	public long getLength();
	public boolean contains(String str);
	public boolean containsNS(String namespaceURI, String name);

}