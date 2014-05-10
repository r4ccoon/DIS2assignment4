
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
public class MinimiseButton extends Widget implements MouseHandlerDelegate{

    public MinimiseButton(int width, int height) {
        this.width = width;
        this.height = height;

        this.positionX = 0;
        this.positionY = 0; 
    }

    public MinimiseButton(int width, int height, int posX, int posY){
        this.positionX = posX;
        this.positionY = posY;

        this.width = width;
        this.height = height;
        
        setMouseClickDelegate(this);
    }

    public MinimiseButton(Vector2 v, int width, int height) {
        this.positionX = v.getX();
        this.positionY = v.getY();

        this.width = width;
        this.height = height;
    }

    @Override
    public void HandlePaint(GraphicsEventSystem ges){
        ges.setColor(Color.YELLOW) ;
        ges.fillRect(this.positionX, this.positionY, this.positionX + this.width, this.positionY + this.height);
        ges.setColor(Color.BLACK) ;
        ges.drawString("-", this.positionX, this.positionY+ this.height);

        super.HandlePaint(ges);
    }

	@Override
	public void OnClick(Object o, EventArgs e) {
		System.out.println("on minimiize btn");
	}


}
