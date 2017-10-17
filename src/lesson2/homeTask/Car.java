package lesson2.homeTask;

public class Car {
    private Integer id;
    private String name;
    private Double weight;
    private Integer maxSpeed;
    private Integer issueYear;
    private String[] fieldsNames = {"id", "name", "weight", "maxSpeed", "issueYear"};

    public Car(Integer id, String name, Double weight, Integer maxSpeed, Integer issueYear) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.issueYear = issueYear;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + id;
        result = prime * result + (Double.toString(weight).hashCode());
        result = prime * result + issueYear;
        result = prime * result + maxSpeed;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o ==  this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Car car = (Car) o;
        if (id != car.id) {
            return false;
        }
        if(weight != car.weight) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "name = " + getName() +
                ", id = " + Integer.toString(getId()) +
                ", weight = " + Double.toString(getWeight()) +
                ", max speed = " + Integer.toString(getMaxSpeed()) +
                ", issue year = " + Integer.toString(getIssueYear());
    }

    public String[] getFieldsNames() {
        return fieldsNames;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public Integer getIssueYear() {
        return issueYear;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setIssueYear(Integer issueYear) {
        this.issueYear = issueYear;
    }
}
