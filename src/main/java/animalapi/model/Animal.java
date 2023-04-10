package animalapi.model;


public class Animal {
    private Long regNo;
    private String description;
    private double weight;
    private String animalDate;

    public Animal(Long regNo, String description, double weight, String animalDate) {
        this.regNo = regNo;
        this.description = description;
        this.weight = weight;
        this.animalDate = animalDate;
    }

    public Long getRegNo() {
        return regNo;
    }

    public void setRegNo(Long regNo) {
        this.regNo = regNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double amount) {
        this.weight = amount;
    }
}
