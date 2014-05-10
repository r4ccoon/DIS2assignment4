
public interface MouseHandlerDelegate {
	
	public void OnClick(Widget Widget, EventArgs e );

	public void OnMousePressed(Widget widget, EventArgs e);

	public void OnMouseReleased(Widget widget, EventArgs e);

	public void OnMouseMoved(Widget widget, EventArgs e);

	public void OnMouseDragged(Widget widget, EventArgs e);
	
}
