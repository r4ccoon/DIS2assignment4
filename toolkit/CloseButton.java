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
public class CloseButton extends Button  {

    protected List<CloseButtonHandler> closeListener;
    
    public CloseButton(int width, int height, int posX, int posY){
        this.positionX = posX;
        this.positionY = posY;

        this.width = width;
        this.height = height;  

		closeListener = new LinkedList<CloseButtonHandler>();
        this.AddActionListeners(this);

        this.setText("X");
        this.setBackgroundColor(Color.RED);
        this.setForegroundColor(Color.BLACK);
    }  
    
    public void AddCloseButtonListener(CloseButtonHandler listener){ 
    	closeListener.add(listener);
    }

	@Override
	public void OnClick(Widget o, EventArgs e) {
		System.out.println("on close button");
		
		for (CloseButtonHandler hl : closeListener)
            hl.OnClickCloseButton(this, e);
	}
}
