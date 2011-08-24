package kittyface;

import javax.swing.*;

// A basic address bar, without all the features planned
class AddressBar extends JTextField {

	protected WebPanel webPanel = null;
	
	public AddressBar(WebPanel webPanel){
		this.webPanel = webPanel;
	}
	
	public void go(){
		webPanel.setUrl(this.getText());
		webPanel.load();
		webPanel.render();
	}
	
	// Do an action listener thing here to activate go() when activated.
	// Seperate actionListener would mean could link go button and this field to same listener
	
	// Consider parent wrapper that acts as listener and contains this, WebPanel and go buttons.


}