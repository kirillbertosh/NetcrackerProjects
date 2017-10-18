package lesson2.practics;

import lesson2.homeTask.Car;

import java.util.LinkedList;
import java.util.List;

public class StringListTest implements Testable {

    private Car[] array = {new Car(1, "Opel", 1500.5, 160, 2004),
            new Car(1, "BMW", 2134.5, 190, 2008)};

    private List list = new LinkedList();

    @Override
    public void test() {
        addValuesToList(array);
        printListEntries(list);
    }

    private void addValuesToList(Car[] array) {
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
    }

    private void printListEntries(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Entry #" + i +  " = " + list.get(i));
        }
        System.out.println("Array length = " + array.length);
        System.out.println("List size = " + list.size());
    }
}
