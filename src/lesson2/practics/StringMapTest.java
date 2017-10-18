package lesson2.practics;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StringMapTest implements Testable {

    private String[] array = {"Opel", "VW", "Ferrari", "Tesla", "Toyota","Ferrari"};

    private Map<String, Integer> map = new HashMap();

    @Override
    public void test() {
        addValuesToList(array);
        printListEntries(map);
    }

    private void addValuesToList(String[] array) {
        for (String item : array) {
            map.put(item, new Random().nextInt(10) + 1);
        }
    }

    private void printListEntries(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Item #" + entry.getKey() + ", number " + entry.getValue());
        }
        System.out.println("Array length = " + array.length);
        System.out.println("Map size = " + map.size());
    }
}
