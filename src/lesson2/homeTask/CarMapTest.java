package lesson2.homeTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*public class CarMapTest implements Testable {

    private Car[] array = {
            new Car(1, "Opel", 1500.5, 160, 2004),
            new Car(2, "BMW", 2134.5, 190, 2008),
            new Car(3, "Mercedes", 1935.7, 206, 2013),
            new Car(4, "Toyota", 1580.4, 180, 2013),
            new Car(5, "Toyota", 1488.0, 175, 1998)};

    private Map<String, Car> map = new HashMap();

    @Override
    public void test() {
        addValuesToList(array);
        printListEntries(map);
        deleteByMaxIssueYearValue();
        System.out.println("");
        printListEntries(map);
        //System.out.println(getThirdItem().toString());
    }

    @Override
    public Object getThirdItem() {
        for (int i = map.size(); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (map.get()) {

                }
            }
        }
        return null;
    }

    @Override
    public void sortBySpeed() {

    }

    @Override
    public void deleteByMaxIssueYearValue() {
        Car temp = array[0];
        String[] keyArray = new String[array.length];
        int i = 0;
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            if (entry.getValue().getIssueYear() >= temp.getIssueYear()) {
                temp = entry.getValue();
            }
        }
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            if (Objects.equals(entry.getValue().getIssueYear(), temp.getIssueYear())) {
                keyArray[i] = entry.getValue().getName();
                i++;
            }
        }
        for (int j = 0; j < i; j++) {
            map.remove(keyArray[i]);
        }
    }

    @Override
    public void deleteByMinIssueYearValue() {

    }

    @Override
    public void getTwoItems() {

    }

    private void addValuesToList(Car[] array) {
        for (Car item : array) {
            map.put(item.getName(), item);
        }
    }

    private void printListEntries(Map<String, Car> map) {
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            System.out.println("Item #" + entry.getKey() + "; value : " + entry.getValue());
        }
        System.out.println("Array length = " + array.length);
        System.out.println("Map size = " + map.size());
    }
}*/
