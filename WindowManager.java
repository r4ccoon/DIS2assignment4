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
                
//                min.setHeight(Constants.minimise_button_height);
  //              min.setWidth(Constants.minimise_button_width);
    //            min.setPositionX(positionX + 2 ) ;
      //          min.setPositionY(positionY + 2 ) ;
                 
               close = new CloseButton(Constants.close_button_width ,Constants.close_button_height , positionX + Constants.minimise_button_width +  2  , positionY + Constants.minimise_button_width + 2 );

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
                close.drawButton(ges);
                
	}	
	
	// handle mouse drag
	public void onMouseDrag( ){ 
		win.OnWindowManagerOnMouseDrag();
	}
	
	public void onMouseRelease( ){
		win.OnWindowManagerOnMouseRelease();
	}
	
	
	
}
