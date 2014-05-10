
public class Widget { 
	protected int width;
	protected int height;
	protected int positionX;
	protected int positionY;
        protected String tittle ;

        public String getTittle(){
            return tittle ;
        }
        
        public void setTittle(String tittle){
            this.tittle = tittle ;
        }
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
}
