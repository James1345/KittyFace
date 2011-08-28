package kittyface.dom.html;

import kittyface.dom.core.*;

public interface HTMLOptionsCollection {

	private long length;
	public long getLength();
	public void setLength(long length) throws DOMException;
	
	public Node item(long index);
	public Node NamedItem(String name);

}