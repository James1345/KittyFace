package kittyface;

import kittyface.swing.*;
import java.awt.*;
import javax.swing.*;
import java.net.*;

public class Test {

	public static void main(String[] args){
		try{
		WebPanel p = new WebPanel();
		p.settings.url = new URL("http://mithos.github.com/Sedenion/index.html");
		p.load();
		p.render();
		p.setPreferredSize(new Dimension(500, 500));
		
		JFrame f = new JFrame();
		f.setContentPane(p);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
		} catch (Throwable t){
		}
	}

}