package helloworld;

import toolkit.Desktop;
import toolkit.Label;
import toolkit.Panel;

/**
 *
 * class to handle creation of widgets.
 * create english, francois, german  buttons.
 * create the label as well
 *
 */
public class MainForm extends Panel {
	
	public MainForm(int x, int y, int w, int h){	
		this.setPositionX(x);
		this.setPositionY(y);
		this.setWidth(w);
		this.setHeight(h);		
				
		Label hello =  new Label("hello");		
		hello.setWidth(300);
		hello.setHeight(30);
		hello.setPositionX(50);
		hello.setPositionY(110);				
		hello.setText("HELLO WORLDS");

		this.AddWidget(hello);
	}

    @Override
    protected void HandlePaint(Desktop ges) {

    }
}
