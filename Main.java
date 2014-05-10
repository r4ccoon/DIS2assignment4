
public class Main {
	public static final int width = 1024;
	public static final int height = 800;
	
	public static void main(String[] args) {
		// desktop
		Desktop desktop = new Desktop();
		
		// example create window inside the desktop
		desktop.CreateWindow("main window", 640, 480);
		
		// example create window inside the desktop 
		desktop.CreateWindow("second window", new Vector2(400, 200), 100, 200);  
	} 
}
