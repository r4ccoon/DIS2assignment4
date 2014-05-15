package helloworld;

import toolkit.*;
import toolkit.Button;
import toolkit.Desktop;
import toolkit.Label;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * class to handle creation of widgets.
 * create english, francois, german  buttons.
 * create the label as well
 *
 */
public class MainForm extends Widget implements ButtonEventHandler {

    LinkedHashMap<String, String> HelloLanguage = new LinkedHashMap<String, String>();
    Label hello ;

    public MainForm(int x, int y, int w, int h){
        InitLanguage();

        // init window size and position
		this.setPositionX(x);
		this.setPositionY(y);
		this.setWidth(w);
		this.setHeight(h);

        // create label
        hello =  new Label("hello");
		hello.setWidth(300);
		hello.setHeight(30);
		hello.setPositionX(50);
		hello.setPositionY(110);				
		hello.setText("Good day");

		this.AddWidget(hello);

        // create buttons
        int i = 1;
        for ( Map.Entry<String, String> entry : HelloLanguage.entrySet() ) {
            String key = entry.getKey();
            String value = entry.getValue();

            Button b = new Button(200, 50 + (50 * i), 200, 20);
            b.setName(key);
            b.setText(key);
            b.setBackgroundColor(Color.gray);
            b.setForegroundColor(Color.black);
            b.AddButtonEventListener(this);

            this.AddWidget(b);

            i++;
        }
	}

    public void InitLanguage(){
        HelloLanguage.put( "English", "Good day");
        HelloLanguage.put( "Deutsch", "Guten Tag");
        HelloLanguage.put( "Francois", "Bonne journee");
    }

    @Override
    protected void HandlePaint(Desktop ges) {

    }

    @Override
    public void OnClick(Button button, EventArgs e) {
        hello.setText( HelloLanguage.get(button.getName()) );
    }
}
