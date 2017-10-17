package lesson2.homeTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class CarListTest implements Testable {

    private Car[] array = {new Car(1, "Opel", 1500.5, 160, 2004),
            new Car(2, "BMW", 2134.5, 190, 2008),
            new Car(3, "Mercedes", 1935.7, 206, 2013),
            new Car(4, "Toyota", 1580.4, 180, 2013),
            new Car(5, "Toyota", 1488.0, 175, 1998),
            new Car(6, "Ferrari", 1386.5, 280, 2003),
            new Car(7, "Lada", 1678.9, 175, 1986)};

    private List<Car> list = new LinkedList<>();

    @Override
    public void test() {
        addValuesToList(array);
        printListEntries(list);

        sortByIssueYear();
        printListEntries(list);
        sortBySpeed();
        printListEntries(list);
        deleteByFilter(1, 2000);
        printListEntries(list);

        //deleteByMaxIssueYearValue();
        //printListEntries(list);
        //deleteByMinIssueYearValue();
        //printListEntries(list);
        //getThirdItem();
        //printListEntries(list);
        //refactorName();
        //printListEntries(list);
        //getTwoItems();
        //printListEntries(list);
    }

    @Override
    public void deleteByFilter(int filterNumber, Object filter) {
        for (int i = 0; i < list.size(); i++) {
            switch (filterNumber) {
                case 1:
                    if (ExpressionHelper.isBigger(list.get(i).getIssueYear(), filter)) {
                        list.remove(i);
                        i--;
                    }
                    break;
                case 2:
                    if (ExpressionHelper.isLower(list.get(i).getIssueYear(), filter)) {
                        list.remove(i);
                        i--;
                    }
                    break;
            }
        }
    }

    @Override
    public void sortByName() {
        list.sort((o1, o2) ->
                Collator.getInstance().compare(o1.getName(), o2.getName()));
    }

    @Override
    public void sortByIssueYear() {
        list.sort((o1, o2) ->
                Collator.getInstance().compare(o1.getIssueYear().toString(), o2.getIssueYear().toString()));
    }

    @Override
    public void sortByWeight() {
        list.sort((o1, o2) ->
                Collator.getInstance().compare(o1.getWeight().toString(), o2.getWeight().toString()));
    }

    @Override
    public void sortBySpeed() {
        list.sort((o1, o2) ->
                Collator.getInstance().compare(o1.getMaxSpeed().toString(), o2.getMaxSpeed().toString()));
    }

    @Override
    public void sortById() {
        list.sort((o1, o2) ->
                Collator.getInstance().compare(o1.getId().toString(), o2.getId().toString()));
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
        for (Car item : list) {
            if (item.getName().contains(symbol) ||
                    Integer.toString(item.getMaxSpeed()).contains(symbol) ||
                    Integer.toString(item.getIssueYear()).contains(symbol) ||
                    Integer.toString(item.getId()).contains(symbol) ||
                    Double.toString(item.getWeight()).contains(symbol)) {
                System.out.println(item);
            }
        }
    }

    @Override
    public void getThirdItem() {
        System.out.println(list.get(2));
        list.remove(2);
    }

    private void addValuesToList(Car[] array) {
        list.addAll(Arrays.asList(array));
    }

    private void printListEntries(List<Car> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Entry #" + i +  " = " + list.get(i));
        }
        System.out.println("Array length = " + array.length);
        System.out.println("List size = " + list.size());
    }

    @Override
    public void refactorName() {
        for (Car item : list) {
            item.setName("_1" + item.getName());
        }
    }

    @Override
    public void getTwoItems() {
        Car[] result = new Car[2];
        result[0] = list.get(1);
        result[1] = list.get(2);
        for (Car item : result) {
            System.out.println(item);
        }
    }

    @Override
    public void deleteByMaxIssueYearValue() {
        Car temp = list.get(0);
        Integer value = temp.getIssueYear();
        for (int i = 1; i < list.size(); i++) {
            Car temp1 = list.get(i);
            if (temp1.getIssueYear() > value) {
                value = temp1.getIssueYear();
            }
        }
        Car[] deleteItems = new Car[array.length];
        int j = 0;
        for (Object aList : list) {
            Car temp1 = (Car) aList;
            if (Objects.equals(temp1.getIssueYear(), value)) {
                deleteItems[j] = temp1;
                j++;
            }
        }
        for (int i = 0; i < j; i++) {
            list.remove(deleteItems[i]);
        }
    }

    @Override
    public void deleteByMinIssueYearValue() {
        Car temp = list.get(0);
        Integer value = temp.getIssueYear();
        for (int i = 1; i < list.size(); i++) {
            Car temp1 = list.get(i);
            if (temp1.getIssueYear() < value) {
                value = temp1.getIssueYear();
            }
        }
        Car[] deleteItems = new Car[array.length];
        int j = 0;
        for (Object aList : list) {
            Car temp1 = (Car) aList;
            if (Objects.equals(temp1.getIssueYear(), value)) {
                deleteItems[j] = temp1;
                j++;
            }
        }
        for (int i = 0; i < j; i++) {
            list.remove(deleteItems[i]);
        }
    }

    @Override
    public void deleteByMaxIdValue() {
        Car temp = list.get(0);
        Integer value = temp.getId();
        for (int i = 1; i < list.size(); i++) {
            Car temp1 = list.get(i);
            if (temp1.getId() > value) {
                value = temp1.getIssueYear();
            }
        }
        Car[] deleteItems = new Car[array.length];
        int j = 0;
        for (Object aList : list) {
            Car temp1 = (Car) aList;
            if (Objects.equals(temp1.getId(), value)) {
                deleteItems[j] = temp1;
                j++;
            }
        }
        for (int i = 0; i < j; i++) {
            list.remove(deleteItems[i]);
        }
    }

    @Override
    public void deleteByMinIdValue() {
        Car temp = list.get(0);
        Integer value = temp.getId();
        for (int i = 1; i < list.size(); i++) {
            Car temp1 = list.get(i);
            if (temp1.getId() < value) {
                value = temp1.getIssueYear();
            }
        }
        Car[] deleteItems = new Car[array.length];
        int j = 0;
        for (Object aList : list) {
            Car temp1 = (Car) aList;
            if (Objects.equals(temp1.getId(), value)) {
                deleteItems[j] = temp1;
                j++;
            }
        }
        for (int i = 0; i < j; i++) {
            list.remove(deleteItems[i]);
        }
    }

    @Override
    public void deleteByMaxMaxSpeedValue() {
        Car temp = list.get(0);
        Integer value = temp.getMaxSpeed();
        for (int i = 1; i < list.size(); i++) {
            Car temp1 = list.get(i);
            if (temp1.getMaxSpeed() > value) {
                value = temp1.getMaxSpeed();
            }
        }
        Car[] deleteItems = new Car[array.length];
        int j = 0;
        for (Object aList : list) {
            Car temp1 = (Car) aList;
            if (Objects.equals(temp1.getMaxSpeed(), value)) {
                deleteItems[j] = temp1;
                j++;
            }
        }
        for (int i = 0; i < j; i++) {
            list.remove(deleteItems[i]);
        }
    }

    @Override
    public void deleteByMinMaxSpeedValue() {
        Car temp = list.get(0);
        Integer value = temp.getMaxSpeed();
        for (int i = 1; i < list.size(); i++) {
            Car temp1 = list.get(i);
            if (temp1.getMaxSpeed() < value) {
                value = temp1.getMaxSpeed();
            }
        }
        Car[] deleteItems = new Car[array.length];
        int j = 0;
        for (Object aList : list) {
            Car temp1 = (Car) aList;
            if (Objects.equals(temp1.getMaxSpeed(), value)) {
                deleteItems[j] = temp1;
                j++;
            }
        }
        for (int i = 0; i < j; i++) {
            list.remove(deleteItems[i]);
        }
    }

    @Override
    public void deleteByMaxNameValue() {
        Car temp = list.get(0);
        String value = temp.getName();
        for (int i = 1; i < list.size(); i++) {
            Car temp1 = list.get(i);
            if (temp1.getName().compareTo(value) > 0) {
                value = temp1.getName();
            }
        }
        Car[] deleteItems = new Car[array.length];
        int j = 0;
        for (Object aList : list) {
            Car temp1 = (Car) aList;
            if (Objects.equals(temp1.getName(), value)) {
                deleteItems[j] = temp1;
                j++;
            }
        }
        for (int i = 0; i < j; i++) {
            list.remove(deleteItems[i]);
        }
    }

    @Override
    public void deleteByMinNameValue() {
        Car temp = list.get(0);
        String value = temp.getName();
        for (int i = 1; i < list.size(); i++) {
            Car temp1 = list.get(i);
            if (temp1.getName().compareTo(value) < 0) {
                value = temp1.getName();
            }
        }
        Car[] deleteItems = new Car[array.length];
        int j = 0;
        for (Object aList : list) {
            Car temp1 = (Car) aList;
            if (Objects.equals(temp1.getName(), value)) {
                deleteItems[j] = temp1;
                j++;
            }
        }
        for (int i = 0; i < j; i++) {
            list.remove(deleteItems[i]);
        }
    }

    @Override
    public void deleteByMaxWeightValue() {
        Car temp = list.get(0);
        Double value = temp.getWeight();
        for (int i = 1; i < list.size(); i++) {
            Car temp1 = list.get(i);
            if (temp1.getWeight() > value) {
                value = temp1.getWeight();
            }
        }
        Car[] deleteItems = new Car[array.length];
        int j = 0;
        for (Object aList : list) {
            Car temp1 = (Car) aList;
            if (Objects.equals(temp1.getWeight(), value)) {
                deleteItems[j] = temp1;
                j++;
            }
        }
        for (int i = 0; i < j; i++) {
            list.remove(deleteItems[i]);
        }
    }

    @Override
    public void deleteByMinWeightValue() {
        Car temp = list.get(0);
        Double value = temp.getWeight();
        for (int i = 1; i < list.size(); i++) {
            Car temp1 = list.get(i);
            if (temp1.getWeight() < value) {
                value = temp1.getWeight();
            }
        }
        Car[] deleteItems = new Car[array.length];
        int j = 0;
        for (Object aList : list) {
            Car temp1 = (Car) aList;
            if (Objects.equals(temp1.getWeight(), value)) {
                deleteItems[j] = temp1;
                j++;
            }
        }
        for (int i = 0; i < j; i++) {
            list.remove(deleteItems[i]);
        }
    }
}
