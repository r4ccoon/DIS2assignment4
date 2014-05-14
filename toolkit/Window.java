package toolkit;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * the window class
 *
 * @author rpl
 *
 */
public class Window extends Widget implements CloseButtonHandler, MinimiseButtonHandler {
    WindowManager manager;
     
    protected List<WindowEventHandler> windowEventListeners;
    Vector2 temporarySize = new Vector2();

	private boolean isMinimized = false;

    public void AddWindowEventListener(WindowEventHandler listener){ 
    	windowEventListeners.add(listener);
    }

    public Window( String title , int width, int height) {
        this.width = width;
        this.height = height;

        this.positionX = 0;
        this.positionY = 0;

        this.tittle = title ; 
        
        windowEventListeners = new LinkedList<WindowEventHandler>();
    } 

    public Window(String title , Vector2 v, int width, int height) {
        this.positionX = v.getX();
        this.positionY = v.getY();

        this.width = width;
        this.height = height;

        this.tittle = title ;
        
        windowEventListeners = new LinkedList<WindowEventHandler>();
    }

    public void SetManager(WindowManager mgr){
        manager = mgr;
        mgr.Initiate(this);
    }

    protected void handlePaint(Desktop ges) {
    	if(isMinimized){
    	    drawMinimizedWindow(ges);    
    	}
    	else
    	{
	        drawWindow(ges);
    	}
    	
        manager.HandlePaint(ges); 
        ges.requestRepaint();
    }

    private void drawMinimizedWindow(Desktop ges) {
        ges.setColor(new Color(150,150,150));
 
        //draw left
        ges.drawLine(positionX - 1, positionY - 1, positionX - 1, positionY + 1 + Constants.height_minimized);
        //draw right
        ges.drawLine(positionX + 1 + Constants.width_minimized, positionY - 1, positionX + Constants.width_minimized + 1, positionY + Constants.height_minimized + 1);
        //draw bottom
        ges.drawLine(positionX, positionY + Constants.height_minimized + 1, positionX + Constants.width_minimized, positionY + Constants.height_minimized + 1);

        // fill bg color
        ges.setColor(new Color(196, 196, 196));
        ges.fillRect(positionX, positionY, positionX + Constants.width_minimized, positionY + Constants.height_minimized); 
	}

	/**
     * draw square window
     */
    private void drawWindow(Desktop ges){
        ges.setColor(new Color(150,150,150));
 
        //draw left
        ges.drawLine(positionX - 1, positionY - 1, positionX - 1, positionY + 1 + height);
        //draw right
        ges.drawLine(positionX + 1 + width, positionY - 1, positionX + width + 1, positionY + height + 1);
        //draw bottom
        ges.drawLine(positionX, positionY + height + 1, positionX + width, positionY + height + 1);

        // fill bg color
        ges.setColor(new Color(232,232,232));
        ges.fillRect(positionX, positionY, positionX + width, positionY + height); 
    }

    /**
     *
     * @param originX
     * @param originY
     * @param destinationX
     * @param destinationY
     */
    protected void drawLine(Desktop ges, float originX, float originY, float destinationX, float destinationY){
        int origX = Helper.Convert(SizeType.width, originX, width, height);
        int origY = Helper.Convert(SizeType.height, originY, width, height);

        int destX = Helper.Convert(SizeType.width, destinationX, width, height);
        int destY = Helper.Convert(SizeType.height, destinationY, width, height);

        ges.drawLine(origX, origY, destX, destY);
    }

    public void OnWindowManagerOnMouseDrag(int deltaX, int deltaY) {
    	positionX -= deltaX;
		positionY -= deltaY;  
    } 

    @Override
    public void handleMouseClicked(EventArgs e){
        super.handleMouseClicked(e);

        if(manager != null)
            manager.handleMouseClicked(e);
    }

    @Override
    public void handleMousePressed(EventArgs e){
        super.handleMousePressed(e);

        if(manager != null)
            manager.handleMousePressed(e);
    }

    @Override
    public void handleMouseReleased(EventArgs e){
        super.handleMouseReleased(e);

        if(manager != null)
            manager.handleMouseReleased(e);
    }
    
    @Override
    public void handleMouseMoved(EventArgs e){
        super.handleMouseMoved(e);

        if(manager != null)
            manager.handleMouseMoved(e);
    }
    
    @Override
    public void handleMouseDragged(EventArgs e){
        super.handleMouseDragged(e);

        if(manager != null)
            manager.handleMouseDragged(e);
    }


    /**
     * close the window
     */
	public void Close() {
		System.out.println("close the window");
		
		for (WindowEventHandler hl : windowEventListeners)
            hl.OnCloseWindow(this); 
	}

	public void Minimise() {
		// if it s minimized. maximize it!!
		if(isMinimized){ 
			System.out.println("maximize the window"); 
			
			width  = temporarySize.getX();
			height = temporarySize.getY();
			
			isMinimized  = false;
		}
		else // minimize it
		{
			System.out.println("minimize the window");
			
			temporarySize.setX(width);
			temporarySize.setY(height);
			
			width  = Constants.width_minimized;
			height = Constants.height_minimized;
			
			isMinimized  = true;
		}
		
		manager.SetWidth(width);
	}

	@Override
	public void OnClickCloseButton(Widget w, EventArgs e) {
		Close();
	}
	
	@Override 
	public void OnClickMinimiseButton(Widget w, EventArgs e) {
		Minimise();
	}
}
