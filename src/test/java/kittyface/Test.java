package kittyface;

import kittyface.swing.*;
import java.awt.*;
import javax.swing.*;

public class Test {

	public static void main(String[] args){
		
		WebPanel p = new WebPanel();
		p.setUrl("http://mithos.github.com/Sedenion/index.html");
		p.load();
		p.printDomTree();
		
		JFrame f = new JFrame();
		f.setContentPane(p);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setPreferredSize(new Dimension(500, 500));
		f.pack();
		f.setVisible(true);
		
	}

}