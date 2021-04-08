package Grazioso;

// Monkey class that is subclass of the base class RescueAnimal
public class Monkey extends RescueAnimal {
    
    // Instance variables specific to Monkey class
    private String species;
    private double tailLength;
    private double height;
    private double bodyLength;

    // Constructor that takes in and sets values for all attributes
    public Monkey(String name, String species, String gender, String age,
    String weight, double tailLength, double height, double bodyLength,
    String acquisitionDate, String acquisitionCountry,
    String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
    }

    // Setter and getter methods for the attributes that are specific to the Monkey class
    // setter method for species
    public void setSpecies(String species) {
        this.species = species;
    }

    // getter method for species
    public String getSpecies() {
        return species;
    }

    // setter method for tailLength
    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    // getter method for tailLength
    public double getTailLengh() {
        return tailLength;
    }

    // setter method for height
    public void setHeight(double height) {
        this.height = height;
    }

    // getter method for height
    public double getHeight() {
        return height;
    }

    // setter method for bodyLength
    public void setBodyLength(double bodyLength) {
        this.bodyLength = bodyLength;
    }

    // getter method for bodyLength
    public double getBodyLength() {
        return bodyLength;
    }

}
