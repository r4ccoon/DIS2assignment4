import java.util.LinkedList;
import java.util.List;

import de.rwth.hci.Graphics.GraphicsEventSystem;


/**
 * factory class for managing windows, some custom method that extends GES
 *
 * @author rpl
 *
 */
public class Desktop extends GraphicsEventSystem{
    // take care of all windows
    List<Window> windows;

    public Desktop(){
        super(1024, 768);

        windows = new LinkedList<Window>();
    }

    /**
     * create window with 0,0 position
     * @param title
     * @param width
     * @param height
     * @return
     */
    public Window CreateWindow(String title, int width, int height){
        // create window, push it down a bit because the title bar height
        Window win = new Window(
                title,
                new Vector2( 0, Constants.title_bar_height),
                width,
                height);

        WindowManager mgr = new WindowManager();
        win.SetManager(mgr);

        // add to the stacks
        windows.add(win);

        return win;
    }

    public Window CreateWindow(String title, Vector2 startPosition, int width, int height){
        // create window, push it down a bit because the title bar height
        Window win = new Window(
                title,
                new Vector2(startPosition.x, startPosition.y + Constants.title_bar_height),
                width,
                height);

        WindowManager mgr = new WindowManager();
        win.SetManager(mgr);

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
        for (int i = 0; i < windows.size(); i++) {
            Window win = windows.get(i);
            win.handlePaint(this);
        }
    }

    @Override
    public void handleMouseClicked(int x, int y) {
        super.handleMouseClicked(x, y);

        for (int i = 0; i < windows.size(); i++) {
            Window win = windows.get(i);
            win.handleMouseClicked(new EventArgs(x, y));
        }
    }

}
