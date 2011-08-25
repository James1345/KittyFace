package kittyface.swing;

import java.net.*;

public class WebPanelSettings{

	public boolean css = false;
	public boolean javascript = false;
	public boolean images = false;
	public boolean acceptCookies = false;
	public URL url = null;

	/** Protected to prevent initialization from outside package */
	protected WebPanelSettings(){}
}