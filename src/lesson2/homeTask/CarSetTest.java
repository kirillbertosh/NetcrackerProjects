package lesson2.homeTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarSetTest implements Testable {

    private Car[] array = {new Car(1, "Opel", 1500.5, 160, 2004),
            new Car(2, "BMW", 2134.5, 190, 2008),
            new Car(3, "Mercedes", 1935.7, 206, 2013),
            new Car(4, "Toyota", 1580.4, 180, 2013),
            new Car(5, "Toyota", 1488.0, 175, 1998),
            new Car(6, "Ferrari", 1386.5, 280, 2003),
            new Car(7, "Lada", 1678.9, 175, 1986)};

    private Set<Car> set = new HashSet();

    @Override
    public void test() {
        addValuesToList(array);
        printListEntries(set);
        deleteByMinIdValue();
        printListEntries(set);
    }

    public void deleteByFilter(int filterNumber, Object filter) {
        for (Car item : set) {
            switch (filterNumber) {
                case 1:
                    if (ExpressionHelper.isBigger(item.getIssueYear(), filter)) {
                    set.remove(item);
                }
                break;
                case 2:
                    if (ExpressionHelper.isLower(item.getIssueYear(), filter)) {
                    set.remove(item);
                }
                break;
            }
        }
    }

    @Override
    public void findSymbol() {
        String symbol = "";
        System.out.println("Enter symbol to find");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            symbol = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Car entry : set) {
            if (entry.getName().contains(symbol) ||
                    entry.getMaxSpeed().toString().contains(symbol) ||
                    entry.getWeight().toString().contains(symbol) ||
                    entry.getIssueYear().toString().contains(symbol) ||
                    entry.getId().toString().contains(symbol)) {
                System.out.println(entry);
            }
        }
    }

    @Override
    public void refactorName() {
        for (Car entry : set) {
            entry.setName("_1" + entry.getName());
        }
    }

    @Override
    public void getTwoItems() {

    }

    @Override
    public void deleteByMinIdValue() {
        Car item = array[0];
        for (Car entry : set) {
            if (entry.getId().intValue() <= item.getId().intValue()) {
                item = entry;
            }
        }
        Car finalItem = item;
        set.removeIf(o -> o.getId().intValue() == finalItem.getId().intValue());
    }

    @Override
    public void deleteByMaxIdValue() {
        Car item = array[0];
        for (Car entry : set) {
            if (entry.getId().intValue() >= item.getId().intValue()) {
                item = entry;
            }
        }
        Car finalItem = item;
        set.removeIf(o -> o.getId().intValue() == finalItem.getId().intValue());
    }

    @Override
    public void deleteByMinNameValue() {
        Car item = array[0];
        for (Car entry : set) {
            if (entry.getName().compareTo(item.getName()) < 0) {
                item = entry;
            }
        }
        Car finalItem = item;
        set.removeIf(o -> o.getName().equals(finalItem.getName()));
    }

    @Override
    public void deleteByMaxNameValue() {
        Car item = array[0];
        for (Car entry : set) {
            if (entry.getName().compareTo(item.getName()) > 0) {
                item = entry;
            }
        }
        Car finalItem = item;
        set.removeIf(o -> o.getName().equals(finalItem.getName()));
    }

    @Override
    public void deleteByMinWeightValue() {
        Car item = array[0];
        for (Car entry : set) {
            if (entry.getWeight().doubleValue() <= item.getWeight().doubleValue()) {
                item = entry;
            }
        }
        Car finalItem = item;
        set.removeIf(o -> o.getWeight().doubleValue() == finalItem.getWeight().doubleValue());
    }

    @Override
    public void deleteByMaxWeightValue() {
        Car item = array[0];
        for (Car entry : set) {
            if (entry.getWeight().doubleValue() >= item.getWeight().doubleValue()) {
                item = entry;
            }
        }
        Car finalItem = item;
        set.removeIf(o -> o.getWeight().doubleValue() == finalItem.getWeight().doubleValue());
    }

    @Override
    public void deleteByMinIssueYearValue() {
        Car item = array[0];
        for (Car entry : set) {
            if (entry.getIssueYear().intValue() >= item.getIssueYear().intValue()) {
                item = entry;
            }
        }
        Car finalItem = item;
        set.removeIf(o -> o.getIssueYear().intValue() == finalItem.getIssueYear().intValue());
    }

    @Override
    public void deleteByMaxIssueYearValue() {
        Car item = array[0];
        for (Car entry : set) {
            if (entry.getIssueYear().intValue() >= item.getIssueYear().intValue()) {
                item = entry;
            }
        }
        Car finalItem = item;
        set.removeIf(o -> o.getIssueYear().intValue() == finalItem.getIssueYear().intValue());
    }

    @Override
    public void deleteByMinMaxSpeedValue() {
        Car item = array[0];
        for (Car entry : set) {
            if (entry.getMaxSpeed().intValue() <= item.getMaxSpeed().intValue()) {
                item = entry;
            }
        }
        Car finalItem = item;
        set.removeIf(o -> o.getMaxSpeed().intValue() == finalItem.getMaxSpeed().intValue());
    }

    @Override
    public void deleteByMaxMaxSpeedValue() {
        Car item = array[0];
        for (Car entry : set) {
            if (entry.getMaxSpeed().intValue() >= item.getMaxSpeed().intValue()) {
                item = entry;
            }
        }
        Car finalItem = item;
        set.removeIf(o -> o.getMaxSpeed().intValue() == finalItem.getMaxSpeed().intValue());
    }

    private void addValuesToList(Car[] array) {
        set.addAll(Arrays.asList(array));
    }

    private void printListEntries(Set<Car> set) {
        for (Car entry : set) {
            System.out.println("Entry :" + entry);
        }
        System.out.println("Array length = " + array.length);
        System.out.println("Set size = " + set.size());
    }
}
