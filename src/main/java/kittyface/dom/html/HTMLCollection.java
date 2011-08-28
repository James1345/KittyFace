package kittyface.dom.html;

import ktiiyface.dom.core.*;

public interface HTMLCollection {

	private long length;
	public long getLength();
	
	public Node item(long index);
	public Node namedItem(String name);

}