
public class Vector {
	private int x;
	private int y;

	public Vector(int x, int y) {
		// TODO Auto-generated constructor stub
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Vector Add(Vector vAdd){
		
		this.x = this.x + vAdd.getX();
		this.y = this.y + vAdd.getY();
		return this;
		
	}

}
