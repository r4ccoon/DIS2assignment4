
public class EventArgs {
	
	Vector2 position;
	
	public EventArgs(int x, int y){
		position = new Vector2(x, y);
	}

	public Vector2 getPosition() {
		return position;
	} 
	
}
