package practice_Mid.gk.decorator;

public class Olives extends ToppingDecorator {
	public Olives(Bread bread) {
		this.bread = bread;
	}
 
	public String getDescription() {
		return bread.getDescription() + ", Olives";
	}
 
	public double cost() {
		return bread.cost() + 2.0;
	}
}
