package toolkit;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rohan
 */
public class MinimiseButton extends Widget implements MouseEventHandler {

    protected List<MinimiseButtonHandler> minimiseListener;
     
    public MinimiseButton(int width, int height, int posX, int posY){
        this.positionX = posX;
        this.positionY = posY;

        this.width = width;
        this.height = height;

		minimiseListener = new LinkedList<MinimiseButtonHandler>();
        AddActionListeners(this);
    } 
     
    public void AddMinimiseButtonListener(MinimiseButtonHandler listener){  
    	minimiseListener.add(listener);
    }

    @Override
    protected void HandlePaint(Desktop ges){
        ges.setColor(Color.YELLOW) ;
        ges.fillRect(this.positionX, this.positionY, this.positionX + this.width, this.positionY + this.height);
        ges.setColor(Color.BLACK) ;
        ges.drawString("-", this.positionX, this.positionY+ this.height);
    }

	@Override
	public void OnClick(Widget o, EventArgs e) {
		System.out.println("on minimize btn");
		        
        for (MinimiseButtonHandler hl : minimiseListener)
            hl.OnClickMinimiseButton(this, e);
	}

	@Override
	public void OnMousePressed(Widget widget, EventArgs e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnMouseReleased(Widget widget, EventArgs e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnMouseMoved(Widget widget, EventArgs e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnMouseDragged(Widget widget, EventArgs e) {
		// TODO Auto-generated method stub
		
	} 
	
	@Override
	public void OnWindowDragged(int movementX, int movementY){
		positionX -= movementX;
		positionY -= movementY;
	} 

}
