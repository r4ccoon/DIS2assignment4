import java.awt.Color;
import java.util.List;

/**
 * skin the windows (the title bar) etc.. 
 *
 * @author rpl
 *
 */
public class WindowManager extends Widget{
    Window win;
    CloseButton close ;
    MinimiseButton min ;

    public WindowManager( ){
    }

    public void Initiate(Window win){
        positionX = win.getPositionX();
        positionY = win.getPositionY() - Constants.title_bar_height;

        width = win.width;
        height = Constants.title_bar_height;

        close = new CloseButton(Constants.close_button_width ,Constants.close_button_height , positionX + Constants.close_button_width +  Constants.constant_spacing_between_buttons  , positionY + Constants.close_button_width + Constants.constant_spacing_between_buttons );
        min = new MinimiseButton( Constants.minimise_button_height ,Constants.minimise_button_width , close.getPositionX() + Constants.minimise_button_width + Constants.constant_spacing_between_buttons , close.getPositionY() + Constants.minimise_button_height + Constants.constant_spacing_between_buttons  ) ;
    }

    //draw title bar
    public void drawTitleBar(Desktop ges){
        ges.setColor(new Color(150,150,150));

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


        //add decorator ( close + minimise buttons + tittle)
        ges.drawString(win.tittle, ( positionX + width ) / Constants.constant_to_get_midpoint,( positionY + height ) / Constants.constant_to_get_midpoint );
        close.drawButton(ges);
        min.drawButton(ges);
    }

    // handle mouse drag
    public void onMouseDrag( ){
        win.OnWindowManagerOnMouseDrag();
    }

    public void onMouseRelease( ){
        win.OnWindowManagerOnMouseRelease();
    }



}
