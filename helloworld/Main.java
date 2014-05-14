package helloworld;

import javax.swing.SwingUtilities;

import toolkit.Desktop;
import toolkit.Vector2;
import toolkit.Window;


public class Main {
	public static final int width = 1024;
	public static final int height = 800;

	public static void main(String[] args) {
		// desktop

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() { 
				Desktop desktop = new Desktop(); 
				
				Window root = desktop.CreateWindow("Hello World App", 640, 480);  
				root.AddWidget(new MainForm());
			}
		});


	}
}
