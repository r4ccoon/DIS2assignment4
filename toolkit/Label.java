package toolkit;
 
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
        ges.setColor(BackgroundColor) ;
        ges.fillRect(this.positionX, this.positionY - this.height/2, this.positionX + this.width, this.positionY + this.height);
        
        ges.setColor(ForegroundColor);
        ges.drawString(this.Text, positionX, positionY + this.height/2);
	}
	
	
}
