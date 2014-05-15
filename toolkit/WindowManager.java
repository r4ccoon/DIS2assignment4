package toolkit;
import java.awt.Color;

/**
 * skin the windows (the title bar) etc.. 
 *
 * @author rpl
 *
 */
public class WindowManager extends Widget implements MouseEventHandler{
    Window win;
    CloseButton close ;
    MinimiseButton min ;

    Vector2 mouseMovement;

    public WindowManager(){
        this.AddActionListeners(this);
    }

    public void Initiate(Window window){
        win = window;

        positionX = win.getPositionX();
        positionY = win.getPositionY() - Constants.title_bar_height;

        mouseMovement = new Vector2(positionX, positionY);

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

        this.AddActionListeners(this);
        close.AddActionListeners(this);
        min.AddActionListeners(this);

        close.AddCloseButtonListener(win);
        min.AddMinimiseButtonListener(win);

        this.AddWidget(close);
        this.AddWidget(min);
    }

    @Override
    protected void HandlePaint(Desktop ges){
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
    }

    @Override
    public void OnClick(Widget widget, EventArgs e) {
    }

    @Override
    public void OnMousePressed(Widget widget, EventArgs e) {
        if(widget.getClass() == WindowManager.class)
        {
            isFocused = true;

            mouseMovement.setX(e.position.getX());
            mouseMovement.setY(e.position.getY());

            System.out.println("title bar pressed");
        }
    }

    @Override
    public void OnMouseReleased(Widget widget, EventArgs e) {
        if(widget.getClass() == WindowManager.class)
        {
            System.out.println("OnMouseReleased");

            mouseMovement.setX(e.position.getX());
            mouseMovement.setY(e.position.getY());

            System.out.println("title bar Released");

            isFocused = false;
        }
    }

    @Override
    public void OnMouseMoved(Widget widget, EventArgs e) {

    }

    @Override
    public void OnMouseDragged(Widget widget, EventArgs e) {
        if(widget.getClass() == WindowManager.class && isFocused)
        {
            System.out.println("OnMouseDragged");

            int deltaX = mouseMovement.getX() - e.position.getX();
            int deltaY = mouseMovement.getY() - e.position.getY();

            positionX -= deltaX;
            positionY -= deltaY;

            mouseMovement.setX(e.position.getX());
            mouseMovement.setY(e.position.getY());

            win.OnWindowDragged(deltaX, deltaY);

            for(int i = 0; i < widgets.size(); i++){
                Widget w = widgets.get(i);
                w.OnWindowDragged(deltaX, deltaY);
            }
        }
    }

    /**
     * Set Size of the manager, usually being called by minimize and maximize function
     * pass in the new width and height
     * 
     * @param vWidth 
     */
	public void SetWidth(int vWidth ) {
		width = vWidth; 
	}
}
