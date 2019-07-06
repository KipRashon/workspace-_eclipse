package triangle;

public class Points {
	int x,y;

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

	@Override
	public String toString() {
		String result=String.format("(%s, %s)", getX(),getY());
		return  result;
	}
}
