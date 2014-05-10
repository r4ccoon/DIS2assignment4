
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
        
        this.setMouseClickDelegate(this);
    }  

    @Override
    public void HandlePaint(GraphicsEventSystem ges){
    	super.HandlePaint(ges);
    	
        ges.setColor(Color.RED) ;
        ges.fillRect(this.positionX, this.positionY, this.positionX + this.width, this.positionY + this.height);
        ges.setColor(Color.BLACK) ;
        ges.drawString("X", this.positionX, this.positionY+ this.height);

    }

    public void OnWindowManagerOnMouseDrag() {
        // TODO Auto-generated method stub

    }

    public void OnWindowManagerOnMouseRelease() {
        // TODO Auto-generated method stub

    }

	@Override
	public void OnClick(Object o, EventArgs e) {
		System.out.println("onclose button");	
	}




}
