package practice_Mid.HK2324giai.de1hk2giai.giai.decorator;

public abstract class ToppingDecorator extends Bread {
	Bread bread;
	
	public abstract String getDescription();

	public Bread getBread() {
		return this.bread;
	}
}
