
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rohan
 */
public class CloseButton extends Widget {



    public CloseButton(int width, int height) {
        this.width = width;
        this.height = height;

        this.positionX = 0;
        this.positionY = 0;

    }

    public CloseButton(int width, int height, int posX, int posY){
        this.positionX = posX;
        this.positionY = posY;

        this.width = width;
        this.height = height;
    }

    public CloseButton(Vector2 v, int width, int height) {
        this.positionX = v.getX();
        this.positionY = v.getY();

        this.width = width;
        this.height = height;
    }



    public void drawButton(Desktop ges){

        ges.setColor(Color.RED) ;
        ges.fillRect(this.positionX, this.positionY, this.positionX + this.width, this.positionY + this.height);
        ges.setColor(Color.BLACK) ;
       // ges.drawString("x", ( this.positionX + this.width ) / 2 , this.positionY +this.height);


       ges.drawString("X", this.positionX, this.positionY+ this.height);

        
        //ges.drawLine(this.positionX, this.positionX, positionX + this.width - 1 , this.positionY + this.height - 1);
    }

    public void OnWindowManagerOnMouseDrag() {
        // TODO Auto-generated method stub

    }

    public void OnWindowManagerOnMouseRelease() {
        // TODO Auto-generated method stub

    }




}
