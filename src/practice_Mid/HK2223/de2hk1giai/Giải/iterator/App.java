package practice_Mid.HK2223.de2hk1giai.Giải.iterator;

import java.util.*;

public class App {

	public static void main(String args[]) {
		MyArray myArray = new MyArray();
		myArray.addItem("ArrayItem1");
		myArray.addItem("ArrayItem2");
		myArray.addItem("ArrayItem3");
		myArray.addItem("ArrayItem4");
		myArray.addItem("ArrayItem5");
		myArray.addItem("ArrayItem6");

		MyList myList = new MyList();
		myList.addItem("ListItem1");
		myList.addItem("ListItem2");
		myList.addItem("ListItem3");
		myList.addItem("ListItem4");
		myList.addItem("ListItem5");
		myList.addItem("ListItem6");
		
		// with no iterators
		System.out.println("\nITEMS with loops\n----\nARRAY");
		ArrayList<String> myArrayItems = myList.getMenuItems();
        for (String myArrayItem : myArrayItems) {
            System.out.println(myArrayItem);
        }
		System.out.println(myList);

		System.out.println("\nLIST");
		String[] myListItems = myArray.getMenuItems();

        for (String menuItem : myListItems) {
            System.out.println(menuItem);
        }
		System.out.println(myList);
		
		// with iterators
		Iterator myListIterator = myList.createIterator();
		Iterator myArrayIterator = myArray.createIterator();

		System.out.println("\nITEMS (with iterators)\n----\nARRAY");
		printItems(myArrayIterator);
		System.out.println("\nLIST");
		printItems(myListIterator);
	}
 
	private static void printItems(Iterator iterator) {
		while (iterator.hasNext()) {
			String item = (String)iterator.next();
			System.out.println(item);
		}
	}
}
