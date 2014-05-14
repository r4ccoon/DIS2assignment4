package main;

import javax.swing.SwingUtilities;

import toolkit.Desktop;
import toolkit.Vector2;


public class Main {
	public static final int width = 1024;
	public static final int height = 800;

	public static void main(String[] args) {
		// desktop

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() { 
				Desktop desktop = new Desktop();

				// example create window inside the desktop
				desktop.CreateWindow("Second", 640, 480);

				// example create window inside the desktop
				desktop.CreateWindow("First", new Vector2(400, 200), 100, 200); 
			}
		});


	}
}
