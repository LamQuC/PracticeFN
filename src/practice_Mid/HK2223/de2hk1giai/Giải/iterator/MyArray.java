package practice_Mid.HK2223.de2hk1giai.Giải.iterator;

import java.util.Arrays;

public class MyArray implements MyIterable {
	private static final int MAX_ITEMS = 6;
	private int numberOfItems;
	private String[] menuItems;
  
	public MyArray() {
		numberOfItems = 0;
		menuItems = new String[MAX_ITEMS];
	}
  
	public void addItem(String name) {
		/* TODO */
		if (numberOfItems == menuItems.length) {
			String[] temp = new String[numberOfItems * 2];
			System.arraycopy(menuItems, 0, temp, 0, numberOfItems);
			menuItems = temp;
		}
		menuItems[numberOfItems] = name;
		numberOfItems++;
	}
 
	public String[] getMenuItems() {
		/* TODO */
		return menuItems;
	}
  
	public Iterator createIterator() {
		/* TODO */
		return new MyArrayIterator(menuItems);
	}
 
	public String toString() {
		return Arrays.toString(menuItems);
	}
}
