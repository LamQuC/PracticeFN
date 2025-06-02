package practice_Mid.gk.decorator;

import java.util.*;

public class BreadStore {
	private List<Bread> breads;

	public BreadStore() {
		breads = new LinkedList<>();
	}

	/**
	 * Giả sử bánh mỳ được làm không cho một loại gia vị nhiều hơn một lần.
	 * Bắt đầu, tạo ra và cho vào cửa hàng:
	 *  5 bánh mỳ ThickcrustBread chỉ có cheese,
	 *  5 bánh mỳ ThickcrustBread chỉ có olives,
	 *  5 bánh mỳ ThickcrustBread có cả cheese và olives,
	 *  5 bánh mỳ ThincrustBread chỉ có cheese,
	 *  5 bánh mỳ ThincrustBread chỉ có olives,
	 *  5 bánh mỳ ThincrustBread có cả cheese và olives.
	 */
	public void init() {
		 /* TODO */
		for (int i = 1; i <= 5;i++){
			add(new Cheese(new ThickcrustBread()));
			add(new Olives(new ThickcrustBread()));
			add(new Cheese(new Olives(new ThickcrustBread())));
			add(new Cheese(new ThincrustBread()));
			add(new Olives(new ThincrustBread()));
			add(new Cheese(new Olives(new ThincrustBread())));
		}
	}

	/**
	 * Thêm bánh mỳ vào cửa hàng.
	 */
	public void add(Bread bread) {
		/* TODO */
		breads.add(bread);
	}

	/**
	 * Giả sử cửa hàng bán một cái bánh mỳ nào đó,
	 * Bánh mỳ được lấy ra để bán là bánh mỳ đầu tiên có giá bằng giá
	 *  bánh mỳ yêu cầu.
	 * Nếu còn bánh mỳ để bán thì trả về giá trị true,
	 *  nếu không còn trả về giá trị false.
	 */
	public boolean sell(Bread bread) {
		/* TODO */

		for (int i = 0 ; i < breads.size();i++){
			if(Double.compare(breads.get(i).cost(),bread.cost())==0){
				breads.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * In ra những bánh mỳ còn trong cửa hàng.
	 */
	public void print() {
		/* TODO */
		for (Bread b : breads){
			System.out.println(b.description + b.cost());
		}
	}

	/**
	 * Sắp xếp các bánh mỳ còn lại theo thứ tự được cho bởi order,
	 * nếu order là true, sắp xếp theo thứ tự tăng dần,
	 * nếu order là false, sắp xếp theo thứ tự giảm dần.
	 * Việc sắp xếp không làm thay đổi thứ tự của bánh mỳ trong cửa hàng.
	 */
	public List<Bread> sort(boolean order) {
		List<Bread> sorting = new ArrayList<>(breads);

		sorting.sort(order
				? Comparator.comparingDouble(Bread::cost)
				: Comparator.comparingDouble(Bread::cost).reversed()
		);

		return sorting;
	}
	/**
	 * Lọc ra howMany cái bánh mỳ có giá cao nhất hoặc thấp nhất,
	 * nếu order là true thì lọc ra bánh mỳ có giá cao nhất,
	 * nếu order là false thì lọc ra bánh mỳ có giá thấp nhất.
	 */
	public List<Bread> filter(int howMany, boolean order) {
		/* TODO */
		List<Bread> sorting = sort(order);
		int limit = Math.min(howMany, sorting.size());
		if (order) {
			return new ArrayList<>(sorting.subList(sorting.size() - limit, sorting.size()));
		} else {
			return new ArrayList<>(sorting.subList(0, limit));
		}
	}

	public static void main(String args[]) {
		// Khởi tạo cửa hàng bánh mỳ
		BreadStore breadStore = new BreadStore();
		breadStore.init();

		// Thêm một số bánh mỳ vào cửa hàng
		breadStore.add(new Cheese(new ThickcrustBread()));      // Thêm 1 bánh mỳ ThickcrustBread có Cheese
		breadStore.add(new Olives(new ThincrustBread()));       // Thêm 1 bánh mỳ ThincrustBread có Olives

		// Bán một số bánh mỳ từ cửa hàng
		Bread breadToSell = new Cheese(new ThickcrustBread());  // Bán một bánh mỳ có Cheese và Thickcrust
		if (breadStore.sell(breadToSell)) {
			System.out.println("Bán thành công bánh mỳ: " + breadToSell.getDescription());
		} else {
			System.out.println("Không bán được bánh mỳ: " + breadToSell.getDescription());
		}

		// In ra bánh mỳ còn lại trong cửa hàng theo thứ tự giá tăng dần
		System.out.println("\nDanh sách bánh mỳ còn lại theo giá tăng dần:");
		List<Bread> sortedBreads = breadStore.sort(true);
		for (Bread b : sortedBreads) {
			System.out.println(b.getDescription() + " - Giá: " + b.cost());
		}

		// In ra nhiều nhất 10 bánh mỳ có giá thấp nhất trong cửa hàng
		System.out.println("\nDanh sách bánh mỳ có giá thấp nhất (tối đa 10):");
		List<Bread> filteredBreads = breadStore.filter(10, false);
		for (Bread b : filteredBreads) {
			System.out.println(b.getDescription() + " - Giá: " + b.cost());
		}
	}
}
