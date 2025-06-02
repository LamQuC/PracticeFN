package practice_Mid.HK2324giai.de1hk2giai.giai.decorator;

public class Cheese extends ToppingDecorator {
	public Cheese(Bread bread) {
		this.bread = bread;
	}
 
	public String getDescription() {
		return this.bread.getDescription() + ", Cheese";
	}
 
	public double cost() {
		return this.bread.cost() + 1.0;
	}
}
