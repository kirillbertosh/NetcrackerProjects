package lesson2.homeTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.*;

public class CarMapTest implements Testable {

    private Car[] array = {new Car(1, "Opel", 1500.5, 160, 2004),
            new Car(2, "BMW", 2134.5, 190, 2008),
            new Car(3, "Mercedes", 1935.7, 206, 2013),
            new Car(4, "Toyota", 1580.4, 180, 2013),
            new Car(5, "Toyota", 1488.0, 175, 1998),
            new Car(6, "Ferrari", 1386.5, 280, 2003),
            new Car(7, "Lada", 1678.9, 175, 1986)};

    private Map<String, Car> map = new HashMap();

    @Override
    public void test() {
        addValuesToList(array);
        printListEntries(map);
        deleteByMaxWeightValue();
        System.out.println("");
        printListEntries(map);
        getThirdItem();
        //sortByKey();
        //findSymbol();
    }

    private List sortByKey() {
        List<Car> list = new LinkedList<>();
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        list.sort((o1, o2) ->
                Collator.getInstance().compare(o1.getName(), o2.getName()));
        return list;
    }

    @Override
    public void getTwoItems() {
        List<Car> list = sortByKey();
        System.out.println(list.get(1).toString());
        System.out.println(list.get(2).toString());
    }

    public void getThirdItem() {
        List<Car> list = sortByKey();
        map.entrySet().removeIf(o -> o.getValue().getName() == list.get(2).getName());
        printListEntries(map);
    }

    @Override
    public void refactorName() {
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            entry.getValue().setName("_1" + entry.getValue().getName());
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
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            if (entry.getValue().getName().contains(symbol) ||
                    Integer.toString(entry.getValue().getMaxSpeed()).contains(symbol) ||
                    Integer.toString(entry.getValue().getIssueYear()).contains(symbol) ||
                    Integer.toString(entry.getValue().getId()).contains(symbol) ||
                    Double.toString(entry.getValue().getWeight()).contains(symbol)) {
                System.out.println(entry.getValue().toString());
            }
        }
    }

    @Override
    public void deleteByMaxIssueYearValue() {
        Car temp = array[0];
        int i = 0;
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            if (entry.getValue().getIssueYear().intValue() >= temp.getIssueYear().intValue()) {
                i = entry.getValue().getIssueYear().intValue();
            }
        }
        int finalI = i;
        map.entrySet().removeIf(o -> o.getValue().getIssueYear().intValue() == finalI);
    }

    @Override
    public void deleteByMinIssueYearValue() {
        Car temp = array[0];
        int i = 0;
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            if (entry.getValue().getIssueYear().intValue() <= temp.getIssueYear().intValue()) {
                i = entry.getValue().getIssueYear().intValue();
            }
        }
        int finalI = i;
        map.entrySet().removeIf(o -> o.getValue().getIssueYear().intValue() == finalI);
    }

    @Override
    public void deleteByMaxWeightValue() {
        Car temp = array[0];
        double i = 0;
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            if (entry.getValue().getWeight().doubleValue() >= temp.getWeight().doubleValue()) {
                i = entry.getValue().getWeight().doubleValue();
            }
        }
        double finalI = i;
        map.entrySet().removeIf(o -> o.getValue().getWeight().doubleValue() == finalI);
    }

    @Override
    public void deleteByMinWeightValue() {
        Car temp = array[0];
        double i = 0;
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            if (entry.getValue().getWeight().doubleValue() <= temp.getWeight().doubleValue()) {
                i = entry.getValue().getWeight().doubleValue();
            }
        }
        double finalI = i;
        map.entrySet().removeIf(o -> o.getValue().getWeight().doubleValue() == finalI);
    }

    @Override
    public void deleteByMaxNameValue() {
        Car temp = array[0];
        String name = "";
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            if (entry.getValue().getName().compareTo(temp.getName()) >= 0 ) {
                name = entry.getValue().getName();
            }
        }
        String finalName = name;
        map.entrySet().removeIf(o -> o.getValue().getName().compareTo(finalName) == 0);
    }

    @Override
    public void deleteByMinNameValue() {
        Car temp = array[0];
        String name = "";
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            if (entry.getValue().getName().compareTo(temp.getName()) <= 0 ) {
                name = entry.getValue().getName();
            }
        }
        String finalName = name;
        map.entrySet().removeIf(o -> o.getValue().getName().compareTo(finalName) == 0);
    }

    @Override
    public void deleteByMaxMaxSpeedValue() {
        Car temp = array[0];
        int i = 0;
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            if (entry.getValue().getMaxSpeed().intValue() >= temp.getMaxSpeed().intValue()) {
                i = entry.getValue().getMaxSpeed().intValue();
            }
        }
        int finalI = i;
        map.entrySet().removeIf(o -> o.getValue().getMaxSpeed().intValue() == finalI);
    }

    @Override
    public void deleteByMinMaxSpeedValue() {
        Car temp = array[0];
        int i = 0;
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            if (entry.getValue().getMaxSpeed().intValue() <= temp.getMaxSpeed().intValue()) {
                i = entry.getValue().getMaxSpeed().intValue();
            }
        }
        int finalI = i;
        map.entrySet().removeIf(o -> o.getValue().getMaxSpeed().intValue() == finalI);
    }

    @Override
    public void deleteByMaxIdValue() {
        Car temp = array[0];
        int i = 0;
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            if (entry.getValue().getId().intValue() >= temp.getId().intValue()) {
                i = entry.getValue().getId().intValue();
            }
        }
        int finalI = i;
        map.entrySet().removeIf(o -> o.getValue().getId().intValue() == finalI);
    }

    @Override
    public void deleteByMinIdValue() {
        Car temp = array[0];
        int i = 0;
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            if (entry.getValue().getId().intValue() <= temp.getId().intValue()) {
                i = entry.getValue().getId().intValue();
            }
        }
        int finalI = i;
        map.entrySet().removeIf(o -> o.getValue().getId().intValue() == finalI);
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
}
