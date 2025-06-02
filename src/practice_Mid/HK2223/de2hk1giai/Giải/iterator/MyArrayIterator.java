package practice_Mid.HK2223.de2hk1giai.Giải.iterator;

public class MyArrayIterator implements Iterator {
	private String[] items;
	private int position;
 
	public MyArrayIterator(String[] items) {
		this.items = items;
		this.position = 0;
	}
 
	public String next() {
		/* TODO */
		return items[position++];
	}
 
	public boolean hasNext() {
		/* TODO */
		return position < items.length;
	}
}
