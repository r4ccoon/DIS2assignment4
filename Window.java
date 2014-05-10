import java.awt.Color;

/**
 * the window class
 *
 * @author rpl
 *
 */
public class Window extends Widget {
    WindowManager manager;

    public Window( String title , int width, int height) {
        this.width = width;
        this.height = height;

        this.positionX = 0;
        this.positionY = 0;

        this.tittle = title ; 
    }

    public Window( String title , int width, int height, int posX, int posY){
        this.positionX = posX;
        this.positionY = posY;

        this.width = width;
        this.height = height;

        this.tittle = title ;
    }

    public Window(String title , Vector2 v, int width, int height) {
        this.positionX = v.getX();
        this.positionY = v.getY();

        this.width = width;
        this.height = height;

        this.tittle = title ;
    }

    public void SetManager(WindowManager mgr){
        manager = mgr;
        mgr.Initiate(this);
    }

    protected void handlePaint(Desktop ges) {
        drawWindow(ges);

        manager.drawTitleBar(ges);

        ges.requestRepaint();
    }

    /**
     * draw square window
     */
    private void drawWindow(Desktop ges){
        ges.setColor(new Color(150,150,150));

        //draw top
        //ges.drawLine(positionX - 1, positionY - 1, positionX + width + 1, positionY - 1);
        //draw left
        ges.drawLine(positionX - 1, positionY - 1, positionX - 1, positionY + 1 + height);
        //draw right
        ges.drawLine(positionX + 1 + width, positionY - 1, positionX + width + 1, positionY + height + 1);
        //draw bottom
        ges.drawLine(positionX, positionY + height + 1, positionX + width, positionY + height + 1);

        // fill bg color
        ges.setColor(new Color(232,232,232));
        ges.fillRect(positionX, positionY, positionX + width, positionY + height); 
    }

    /**
     *
     * @param originX
     * @param originY
     * @param destinationX
     * @param destinationY
     */
    protected void drawLine(Desktop ges, float originX, float originY, float destinationX, float destinationY){
        int origX = Helper.Convert(SizeType.width, originX, width, height);
        int origY = Helper.Convert(SizeType.height, originY, width, height);

        int destX = Helper.Convert(SizeType.width, destinationX, width, height);
        int destY = Helper.Convert(SizeType.height, destinationY, width, height);

        ges.drawLine(origX, origY, destX, destY);
    }

    public void OnWindowManagerOnMouseDrag() {
        // TODO Auto-generated method stub

    }

    public void OnWindowManagerOnMouseRelease() {
        // TODO Auto-generated method stub

    }

    public void handleMouseClicked(EventArgs eventArgs) {
        // TODO Auto-generated method stub

    }


}
