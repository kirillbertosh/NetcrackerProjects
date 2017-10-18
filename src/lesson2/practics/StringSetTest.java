package lesson2.practics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringSetTest implements Testable {

    private String[] array = {"Opel", "VW", "BMW"};

    private Set set = new HashSet();

    @Override
    public void test() {
        addValuesToList(array);
        printListEntries(set);
    }

    private void addValuesToList(String[] array) {
        set.addAll(Arrays.asList(array));
    }

    private void printListEntries(Set<String> set) {
        for (String entry : set) {
            System.out.println("Entry :" + entry);
        }
        System.out.println("Array length = " + array.length);
        System.out.println("Map size = " + set.size());
    }
}
