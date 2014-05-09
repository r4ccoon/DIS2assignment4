import java.awt.Color;

import de.rwth.hci.Graphics.GraphicsEventSystem;

/**
 * the window class
 * 
 * @author rpl
 *
 */
public class Window extends GraphicsEventSystem{

	int width;
	int height;
	
	public Window(int width, int height) {
		super(width, height); 
		
		this.width = width;
		this.height = height;		
	}
	
	@Override
	protected void handlePaint() { 
		Color color = new Color(255, 0, 0); 
		setColor(color); 
		drawLine(0.2f, 0.3f, 0.8f, 0.7f); 
	}
		
	/**
	 * 
	 * @param originX
	 * @param originY
	 * @param destinationX
	 * @param destinationY
	 */
	protected void drawLine(float originX, float originY, float destinationX, float destinationY){
		int origX = Helper.Convert(SizeType.width, originX, width, height);
		int origY = Helper.Convert(SizeType.height, originY, width, height);
		
		int destX = Helper.Convert(SizeType.width, destinationX, width, height);
		int destY = Helper.Convert(SizeType.height, destinationY, width, height);
		
		this.drawLine(origX, origY, destX, destY);
	}
	
	
}
