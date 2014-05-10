import java.awt.Color;
import java.util.List;

import de.rwth.hci.Graphics.GraphicsEventSystem;

/**
 * skin the windows (the title bar) etc.. 
 *
 * @author rpl
 *
 */
public class WindowManager extends Widget implements MouseHandlerDelegate{
    Window win;
    CloseButton close ;
    MinimiseButton min ;

    public WindowManager(){
    	this.setMouseClickDelegate(this);
    }

    public void Initiate(Window win){
        positionX = win.getPositionX();
        positionY = win.getPositionY() - Constants.title_bar_height;

        width = win.width;
        height = Constants.title_bar_height;

        close = new CloseButton(Constants.close_button_width ,
        		Constants.close_button_height , 
        		positionX +   Constants.spacing_between_buttons  , 
        		positionY +   Constants.spacing_between_buttons
        );
        
        min = new MinimiseButton( Constants.minimise_button_height ,
        		Constants.minimise_button_width , 
        		close.getPositionX() +  Constants.spacing_between_buttons + close.getWidth() , 
        		close.getPositionY()  
        ) ;
        this.tittle = win.getTittle() ;
        this.AddWidget(close);
        this.AddWidget(min);
    }

    //draw title bar
    @Override
    public void HandlePaint(GraphicsEventSystem ges){
        // draw title bar
        {
            ges.setColor(new Color(150, 150, 150));

            //draw top
            ges.drawLine(positionX - 1, positionY - 1, positionX + width + 1, positionY - 1);
            //draw left
            ges.drawLine(positionX - 1, positionY - 1, positionX - 1, positionY + 1 + height);
            //draw right
            ges.drawLine(positionX + 1 + width, positionY - 1, positionX + width + 1, positionY + height + 1);
            //draw bottom
            ges.drawLine(positionX, positionY + height + 1, positionX + width, positionY + height + 1);

            // fill bg color
            ges.setColor(new Color(138,226,237));
            ges.fillRect(positionX, positionY, positionX + width, positionY + height);
 
            ges.setColor(Color.BLACK);
            //add decorator ( close + minimise buttons + tittle)
            ges.drawString(this.tittle,  positionX + Constants.xPositionTittleName , positionY + (this.height/Constants.to_get_midpoint) + 5  );

        }

        // the widgets in the "widgets" are drawn using this call
        super.HandlePaint(ges);
    }

    // handle mouse drag
    public void onMouseDrag( ){
        win.OnWindowManagerOnMouseDrag();
    }

    public void onMouseRelease( ){
        win.OnWindowManagerOnMouseRelease();
    }

    @Override
    public void OnClick(Object o, EventArgs e) { 
	System.out.println("on title bar click");
    }



}
