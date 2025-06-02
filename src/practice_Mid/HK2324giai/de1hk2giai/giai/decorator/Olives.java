package practice_Mid.HK2324giai.de1hk2giai.giai.decorator;

public class Olives extends ToppingDecorator {
	public Olives(Bread bread) {
		this.bread = bread;
	}
 
	public String getDescription() {
		return this.bread.getDescription() + ", Olives";
	}
 
	public double cost() {
		return this.bread.cost() + 2.0;
	}
}
