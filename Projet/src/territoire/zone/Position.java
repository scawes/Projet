package territoire.zone;

public class Position {
	int x;
	int y;
	
	public Position(int x, int y) {
		setPosition(x, y);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	public void setPosition(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public String toString(){
		return "x : "+x+" y : "+y;
	}
	
	public boolean equals(Position position){
		if(x==position.getX() && y==position.getY())return true;
		return false;
	}
}
