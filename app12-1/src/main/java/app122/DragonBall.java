package app122;

public class DragonBall {
	private String charactor;

	public DragonBall(String charactor) {
		super();
		this.charactor = charactor;
	}

	@Override
	public String toString() {
		return "DragonBall [charactor=" + charactor + "]";
	}

	public String getCharactor() {
		return charactor;
	}

	public void setCharactor(String charactor) {
		this.charactor = charactor;
	}
	
}
