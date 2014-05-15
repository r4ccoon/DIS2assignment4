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
public class MinimiseButton extends Button {

    protected List<MinimiseButtonHandler> minimiseListener;
     
    public MinimiseButton(int width, int height, int posX, int posY){
        this.positionX = posX;
        this.positionY = posY;

        this.width = width;
        this.height = height;

		minimiseListener = new LinkedList<MinimiseButtonHandler>();

        this.setText("-");

        this.setBackgroundColor(Color.YELLOW);
        this.setForegroundColor(Color.BLACK);
    } 
     
    public void AddMinimiseButtonListener(MinimiseButtonHandler listener){  
    	minimiseListener.add(listener);
    }

	@Override
	public void OnClick(Widget o, EventArgs e) {
		System.out.println("on minimize btn");
		        
        for (MinimiseButtonHandler hl : minimiseListener)
            hl.OnClickMinimiseButton(this, e);
	}

}
