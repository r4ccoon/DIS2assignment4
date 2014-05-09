import java.util.LinkedList;
import java.util.List;

import de.rwth.hci.Graphics.GraphicsEventSystem;

/**
 * factory class for managing windows
 * @author rpl
 *
 */
public class Desktop extends GraphicsEventSystem{
	List<Window> windows;
	
	public Desktop(){
		super(1024, 768); 
		
		windows = new LinkedList<Window>();
	}
	 
	public Window CreateWindow(String title, int width, int height){
		Window win = new Window(width, height);
		
		// add to the stacks
		windows.add(win);
		
		return win;
	}
	
	/**
	 * remove window from the stack
	 * @param win
	 */
	public void RemoveWindow(Window win){
		windows.remove(win);
	}

	@Override
	protected void handlePaint() {
		// TODO Auto-generated method stub
		
	}
	
}
