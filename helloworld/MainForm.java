package helloworld;

import java.awt.Color;
import java.util.LinkedHashMap;
import java.util.Map;

import toolkit.Button;
import toolkit.ButtonEventHandler;
import toolkit.Desktop;
import toolkit.EventArgs;
import toolkit.Label;
import toolkit.Slider;
import toolkit.SliderEventHandler;
import toolkit.Widget;


/**
 *
 * class to handle creation of widgets.
 * create english, francois, german  buttons.
 * create the label as well
 *
 */
public class MainForm extends Widget implements ButtonEventHandler, SliderEventHandler {

    LinkedHashMap<String, String> HelloLanguage = new LinkedHashMap<String, String>();
    Label hello ;
    private Label sliderValue;


    public MainForm(int x, int y, int w, int h){
        InitLanguage();

        // init window size and position
		this.setPositionX(x);
		this.setPositionY(y);
		this.setWidth(w);
		this.setHeight(h);

        // create label
        hello =  new Label("hello");
		hello.setWidth(100);
		hello.setHeight(30);
		hello.setPositionX(50);
		hello.setPositionY(110);				
		hello.setText("Good day");
		hello.setBackgroundColor(Color.green);
		hello.setForegroundColor(Color.black);

		this.AddWidget(hello);

        // create buttons
        int i = 1;
        for ( Map.Entry<String, String> entry : HelloLanguage.entrySet() ) {
            String key = entry.getKey();

            // arrange position automatically
            Button b = new Button(200, 50 + (50 * i), 200, 20);
            b.setName(key);
            b.setText(key);
            b.setBackgroundColor(Color.LIGHT_GRAY);
            b.setForegroundColor(Color.black);
            b.AddButtonEventListener(this);

            this.AddWidget(b);

            i++;
        }

        CreateSlider();
	}

    public void CreateSlider(){
        Slider slider = new Slider(100, 300, 300);
        slider.AddSliderListener(this);
        slider.setMinValue(0f);
        slider.setMaxValue(1f);

        this.AddWidget(slider);

        // labels for update values
        Label sliderAcc1 =  new Label("sliderAcc1", "slider current value: " );
        sliderAcc1.setPositionX(100);
        sliderAcc1.setPositionY(330);
        sliderAcc1.setForegroundColor(Color.black);
         
        sliderValue =  new Label("sliderValue" );
        sliderValue.setPositionX(100);
        sliderValue.setPositionY(350); 
        sliderValue.setForegroundColor(Color.black);
        Float f = 0.0f;
        sliderValue.setText(f.toString()); 

        this.AddWidget(sliderAcc1);
        this.AddWidget(sliderValue);
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

    @Override
    public void OnSliderFinishedMove(Slider slider, EventArgs e) { 
    	Float val = (Float)slider.getValue();
    	
        Float r = val;
        Float g = val;
        Float b = val;

        Color c = new Color(r, g, b);
        hello.setBackgroundColor(c); 
        
        sliderValue.setText(b.toString()); 
    }

    @Override
    public void OnSliderStartDragged(Slider slider, EventArgs e) {

    }

    @Override
    public void OnSliderDragged(Slider slider, EventArgs e) {

    }
}
