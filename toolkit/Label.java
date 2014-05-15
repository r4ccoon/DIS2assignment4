package toolkit;

import java.awt.Color;

public class Label extends Widget { 
	
	/**
	 * 
	 * @param vname identifier
	 */
	public Label(String vname) {
		this.Name = vname;
		
		Text = "";
	}
	
	/**
	 * 
	 * @param vname identifier
	 * @param text text to print
	 */
	public Label(String vname, String text) {
		this.Name = vname;
		
		Text = text;
	}

	@Override
	protected void HandlePaint(Desktop ges){
        ges.setColor(Color.BLACK);
        ges.drawString(this.Text, positionX, positionY);
	}
	
	
}
