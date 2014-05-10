import java.util.LinkedList;
import java.util.List;

import de.rwth.hci.Graphics.GraphicsEventSystem;


public class Widget {
    protected int width;
    protected int height;
    protected int positionX;
    protected int positionY;
    protected String tittle;
    protected boolean isFocused; 
    
    protected List<MouseHandlerDelegate> listeners;
	
	public void AddActionListeners(MouseHandlerDelegate mouseClickDelegate) { 
		listeners.add(mouseClickDelegate);
	}

	List<Widget> widgets;
	
	public Widget(){
		isFocused = false;
		
		widgets = new LinkedList<Widget>();  
		listeners = new LinkedList<MouseHandlerDelegate>();
	}
	 
	public void AddWidget(Widget w){
		widgets.add(w);
	}

    public String getTittle(){
        return tittle ;
    }
    
    public void setTittle(String tittle){
        this.tittle = tittle ;
    }
    
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    
    public void HandlePaint(GraphicsEventSystem ges){
    	// print this and the child
    	for(int i = 0; i < widgets.size() ; i++){
    		Widget w = widgets.get(i);
    		w.HandlePaint(ges);
    	}
    }

    public boolean checkCollision(int x, int y){
        if( x >= positionX && x <= positionX + width && y >= positionY && y <= positionY + height + Constants.OS_title_bar_height){
            return true;
        }

        return false;
    }
    
    public void handleMouseClicked(EventArgs e){ 
        {
        	for(int i = 0; i < widgets.size(); i++){
        		Widget w = widgets.get(i);
        		w.handleMouseClicked(e);
        	}

            if(checkCollision(e.getPosition().getX(), e.getPosition().getY())) { 
                for (MouseHandlerDelegate hl : listeners){
                    // call callback
                    hl.OnClick(this, e);
                }
            }
        }
    } 

	public void handleMousePressed(EventArgs e) {
		for(int i = 0; i < widgets.size(); i++){
    		Widget w = widgets.get(i);
    		w.handleMousePressed(e);
    	}

        if(checkCollision(e.getPosition().getX(), e.getPosition().getY())) {
        	isFocused = true;
        	
        	for (MouseHandlerDelegate hl : listeners){
                // call callback
                hl.OnMousePressed(this, e);
            } 
        }
	}

	public void handleMouseReleased(EventArgs e) {
		for(int i = 0; i < widgets.size(); i++){
    		Widget w = widgets.get(i);
    		w.handleMouseReleased(e);
    	}
 
		if(isFocused)
        { 
        	for (MouseHandlerDelegate hl : listeners){
                // call callback
                hl.OnMouseReleased(this, e);
            }  
        } 
	}

	public void handleMouseMoved(EventArgs e) {
		for(int i = 0; i < widgets.size(); i++){
    		Widget w = widgets.get(i);
    		w.handleMouseMoved(e);
    	}

    	for (MouseHandlerDelegate hl : listeners){
            // call callback
            hl.OnMouseMoved(this, e);
        }   
	}

	public void handleMouseDragged(EventArgs e) {
		for(int i = 0; i < widgets.size(); i++){
    		Widget w = widgets.get(i);
    		w.handleMouseDragged(e);
    	}
 
		if(isFocused)
		{
	    	for (MouseHandlerDelegate hl : listeners){
	            // call callback
	            hl.OnMouseDragged(this, e);
	        }    
        }
	}

	public void OnWindowDragged(int deltaX, int deltaY) {
		// TODO Auto-generated method stub
		
	}
}
