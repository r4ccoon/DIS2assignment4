package calculator;

import toolkit.Desktop;
import toolkit.Window;

import javax.swing.*;


public class Main {
	public static final int width = 1024;
	public static final int height = 800;

	public static void main(String[] args) {
		// desktop

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() { 
				Desktop desktop = new Desktop(); 
				
				Window root = desktop.CreateWindow("Calculator App", 640, 480);
				root.AddWidget(new MainForm());
			}
		});

	}
}
