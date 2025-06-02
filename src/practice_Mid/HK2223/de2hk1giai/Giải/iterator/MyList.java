package practice_Mid.HK2223.de2hk1giai.Giải.iterator;

import java.util.ArrayList;

public class MyList implements MyIterable {
	private ArrayList<String> menuItems;
 
	public MyList() {
		menuItems = new ArrayList<String>();
	}

	public void addItem(String name) {
		/* TODO */
		menuItems.add(name);
	}
 
	public ArrayList<String> getMenuItems() {
		/* TODO */
		return menuItems;
	}
  
	public Iterator createIterator() {
		/* TODO */
		return new MyListIterator(menuItems);
	}
  
	public String toString() {
		/* TODO */
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (String item : menuItems) {
			sb.append(item);
		}
		sb.append(']');
		return sb.toString();
	}
}
