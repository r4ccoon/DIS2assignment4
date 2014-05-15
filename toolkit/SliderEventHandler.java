package toolkit;

public interface SliderEventHandler {

    void OnSliderFinishedMove(Slider slider, EventArgs e);

    void OnSliderStartDragged(Slider slider, EventArgs e);

    void OnSliderDragged(Slider slider, EventArgs e);
}
