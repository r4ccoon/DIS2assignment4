package toolkit;

import java.util.LinkedList;
import java.util.List;

public class Button extends Widget implements MouseEventHandler{

    protected List<ButtonEventHandler> buttonEventListeners = new LinkedList<ButtonEventHandler>();
    Label label;

    public Button(){
        this.AddActionListeners(this);
    }

    public Button(int posX, int posY, int width, int height ) {
        this.positionX = posX;
        this.positionY = posY;
        this.width = width;
        this.height = height;

        this.AddActionListeners(this);
    }

    public void AddButtonEventListener(ButtonEventHandler listener){
        buttonEventListeners.add(listener);
    }

    @Override
    protected void HandlePaint(Desktop ges){
        ges.setColor(BackgroundColor) ;
        ges.fillRect(this.positionX, this.positionY, this.positionX + this.width, this.positionY + this.height);

        ges.setColor(ForegroundColor) ;

        //draw top
        ges.drawLine(positionX, positionY - 2, positionX + width + 1, positionY - 2  );
        //draw left
        ges.drawLine(positionX - 1, positionY - 1, positionX - 1, positionY + 1 + height);
        //draw right
        ges.drawLine(positionX + 1 + width, positionY - 1, positionX + width + 1, positionY + height + 1);
        //draw bottom
        ges.drawLine(positionX, positionY + height + 1, positionX + width, positionY + height + 1);

        ges.drawString(this.getText(), this.positionX  , this.positionY + this.height);
    }

    @Override
    public void handleMouseClicked(EventArgs e) {
        super.handleMouseClicked(e);
    }

    @Override
    public void OnClick(Widget Widget, EventArgs e) {
        for (ButtonEventHandler hl : buttonEventListeners)
            hl.OnClick(this, e);
    }

    @Override
    public void OnMousePressed(Widget widget, EventArgs e) {

    }

    @Override
    public void OnMouseReleased(Widget widget, EventArgs e) {

    }

    @Override
    public void OnMouseMoved(Widget widget, EventArgs e) {

    }

    @Override
    public void OnMouseDragged(Widget widget, EventArgs e) {

    }
}
