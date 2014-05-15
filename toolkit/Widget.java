package toolkit;
import java.util.LinkedList;
import java.util.List;


public abstract class Widget {
    protected int width;
    protected int height;
    protected int positionX;
    protected int positionY;
    protected String tittle;
    protected boolean isFocused; 
     
    // identifier
    protected String Text; 
    protected Object Value;
    protected String Name;
    
    protected List<MouseEventHandler> listeners;
	
	public void AddActionListeners(MouseEventHandler mouseClickDelegate) { 
		listeners.add(mouseClickDelegate);
	}

	List<Widget> widgets;
	
	public Widget(){
		isFocused = false;
		
		widgets = new LinkedList<Widget>();  
		listeners = new LinkedList<MouseEventHandler>();
	}
	 
	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public Object getValue() {
		return Value;
	}

	public void setValue(Object value) {
		Value = value;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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
    
    /**
     *  
     * @param ges Desktop
     */
    protected abstract void HandlePaint(Desktop ges);

    public void handlePaint(Desktop ges){
        // print this one
        this.HandlePaint(ges);

        // print the children
        for(int i = 0; i < widgets.size() ; i++){
            Widget w = widgets.get(i);
            w.handlePaint(ges);
        }
    }

    public boolean checkCollision(int x, int y){
        if( x >= positionX && x <= positionX + width && y >= positionY && y <= positionY + height + Constants.OS_title_bar_height){
            return true;
        }

        return false;
    }
    
    public void handleMouseClicked(EventArgs e){
        for(int i = 0; i < widgets.size(); i++){
            Widget w = widgets.get(i);
            w.handleMouseClicked(e);
        }

        if(checkCollision(e.getPosition().getX(), e.getPosition().getY())) {
            for (MouseEventHandler hl : listeners){
                // call callback
                hl.OnClick(this, e);
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
        	
        	for (MouseEventHandler hl : listeners){
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
        	for (MouseEventHandler hl : listeners){
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

    	for (MouseEventHandler hl : listeners){
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
	    	for (MouseEventHandler hl : listeners){
	            // call callback
	            hl.OnMouseDragged(this, e);
	        }    
        }
	}

	public void OnWindowDragged(int deltaX, int deltaY) {
        for(int i = 0; i < widgets.size(); i++){
            Widget w = widgets.get(i);
            w.OnWindowDragged(deltaX, deltaY);
        }

        positionX -= deltaX;
        positionY -= deltaY;
	}
}
