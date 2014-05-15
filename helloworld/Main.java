package helloworld;

import javax.swing.SwingUtilities; 
import toolkit.Desktop;
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
				
				Window root = desktop.CreateWindow("Hello", 640, 480);

                MainForm form = new MainForm(10, 40, 640, 480);
				root.AddWidget(form);
			}
		});

	}
}
