package toolkit;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Slider extends Widget {
    private int handlerXMin;
    private int handlerXMax;
    private int minValue = 0;
    private int maxValue = 100;
    private Vector2 mouseMovement = new Vector2(positionX, positionY);
    private int handlerX;
    private int handlerY;
    private int handlerWidth = 10;
    private int handlerHeight = 18;

    protected List<SliderEventHandler> sliderListeners = new LinkedList<SliderEventHandler>();

    public Slider(int x, int y, int w){
        positionX = x;
        positionY = y;

        width = w;
        height = 10;

        handlerXMin = handlerX = positionX;
        handlerXMax = positionX + width;

        handlerY = positionY - 4;

        mouseMovement.setX(handlerX);

        this.setValue(0.0f);
    }

	public void AddSliderListener(SliderEventHandler listener) {
        sliderListeners.add(listener);
	}

	@Override
	protected void HandlePaint(Desktop ges) {
		// draw the bar
        ges.setColor(Color.LIGHT_GRAY);
        ges.fillRect(positionX, positionY - 2, positionX + width + 2, positionY + height);

        // draw the handler;
        ges.setColor(Color.gray);
        ges.fillRect(handlerX, handlerY, handlerX + handlerWidth, handlerY + handlerHeight);

	}

    /**
     * override so it collide only for the handler
     *
     * @param x current mouse position x
     * @param y current mouse position y
     * @return
     */
    @Override
    public boolean checkCollision(int x, int y){
        if( x >= handlerX - 3 && x <= handlerX + handlerWidth + 2 && y >= handlerY + Constants.OS_title_bar_height && y <= handlerY + handlerHeight + Constants.OS_title_bar_height)
            return true;

        return false;
    }

    @Override
    public void handleMouseDragged(EventArgs e) {
        if(isFocused)
        {
            int deltaX = mouseMovement.getX() - e.position.getX();
            handlerX -= deltaX ;

            mouseMovement.setX(e.position.getX());

            // avoid handler to exceed boundaries
            if(handlerX < handlerXMin)
                handlerX = handlerXMin;
            else if(handlerX > handlerXMax)
                handlerX = handlerXMax;

            // set the value percentage
            Float delta = (handlerX - positionX) / (float)width * maxValue;
            this.setValue(delta);

            // call callback
            for (SliderEventHandler hl : sliderListeners)
                hl.OnSliderDragged(this, e);
        }
    }

    @Override
    public void handleMousePressed(EventArgs e) {
        if(!isFocused && checkCollision(e.getPosition().getX(), e.getPosition().getY())) {
            mouseMovement.setX(handlerX);

            isFocused = true;

            for (SliderEventHandler hl : sliderListeners){
                // call callback
                hl.OnSliderStartDragged(this, e);
            }
        }
    }

    @Override
    public void handleMouseReleased(EventArgs e) {
        if(isFocused)
        {
            for (SliderEventHandler hl : sliderListeners){
                // call callback
                hl.OnSliderFinishedMove(this, e);
            }
        }

        mouseMovement.setX(handlerX);
        isFocused = false;
    }

    @Override
    public void OnWindowDragged(int deltaX, int deltaY) {
        super.OnWindowDragged(deltaX, deltaY);

        handlerX -= deltaX;
        handlerY -= deltaY;

        handlerXMax -= deltaX;
        handlerXMin -= deltaX;
    }
}
