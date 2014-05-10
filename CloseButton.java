
import java.awt.Color;

import de.rwth.hci.Graphics.GraphicsEventSystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rohan
 */
public class CloseButton extends Widget implements MouseHandlerDelegate { 

    public CloseButton(int width, int height, int posX, int posY){
        this.positionX = posX;
        this.positionY = posY;

        this.width = width;
        this.height = height;  
    }  

    @Override
    public void HandlePaint(GraphicsEventSystem ges){
        ges.setColor(Color.RED) ;
        ges.fillRect(this.positionX, this.positionY, this.positionX + this.width, this.positionY + this.height);
        ges.setColor(Color.BLACK) ;
        ges.drawString("X", this.positionX, this.positionY+ this.height);

        super.HandlePaint(ges);
    }

    @Override
    public boolean checkCollision(int x, int y){
       return super.checkCollision(x, y);
    }
    
    public void OnWindowManagerOnMouseDrag() {
        // TODO Auto-generated method stub

    }

    public void OnWindowManagerOnMouseRelease() {
        // TODO Auto-generated method stub

    }

	@Override
	public void OnClick(Widget o, EventArgs e) {
		System.out.println("onclose button");	
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
