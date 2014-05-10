import java.util.LinkedList;
import java.util.List;

import de.rwth.hci.Graphics.GraphicsEventSystem;


public class Widget {
    protected int width;
    protected int height;
    protected int positionX;
    protected int positionY;
    protected String tittle ;
    private boolean isFocused;
	private MouseHandlerDelegate mouseClickDelegate;
	
	public void setMouseClickDelegate(MouseHandlerDelegate mouseClickDelegate) {
		this.mouseClickDelegate = mouseClickDelegate;
	}

	List<Widget> widgets;
	
	public Widget(){
		isFocused = true;
		
		widgets = new LinkedList<Widget>(); 
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
        if(isFocused){
        	for(int i = 0; i < widgets.size(); i++){
        		Widget w = widgets.get(i);
        		w.handleMouseClicked(e);
        	}

            if(checkCollision(e.getPosition().getX(), e.getPosition().getY())) {
                if (mouseClickDelegate != null) {
                    // call callback
                    mouseClickDelegate.OnClick(this, e);
                }
            }
        }
    }
}
