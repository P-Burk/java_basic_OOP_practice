package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
    // Creates a list for dogs and monkeys
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    // creates and fills array list with monkey species
    // used for input validation in intakeNewMonkey() method
    private static ArrayList<String> monkeySpeciesList = 
        new ArrayList<String>(Arrays.asList("Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin"));
    

    // Instance variables (if needed)
    static Scanner scanner = new Scanner(System.in);
    static private String userInput;
    static private boolean speciesValid = false;
    static private int animalCount = 0;


    public static void main(String[] args) {
        // Populates the dogList and monkeyList with existing dogs and monkeys (for testing purposes)
        initializeDogList();
        initializeMonkeyList();

        // While loop for calling the displayMenu method as long as the user input isn't "q"
        while (!"q".equals(userInput)) {
            displayMenu();
            userInput = scanner.next();
            switch (userInput) {                // switch statement to call relevant methods based on user selected menu option
                case "1":                       // intake a new dog
                    scanner.nextLine();
                    intakeNewDog();
                    break;
                case "2":                       // intake a new moneky
                    scanner.nextLine();
                    intakeNewMonkey();
                    break;
                case "3":                       // reserve and animal
                    scanner.nextLine();
                    reserveAnimal();
                    break;
                case "4":                       // print a list of all dogs
                    printAnimals("dog");
                    break;
                case "5":                       // print a list of all monkeys
                    printAnimals("monkey");
                    break;
                case "6":                       // print a list of all animals not in a reserved status
                    printAnimals("available");
                    break;
                case "q":                       // quit the program
                    System.out.println("Quitting program. Goodbye.");
                    break;
                default:                        //any option selected not from the list will trigger the default switch branch
                    System.out.println("Please select a valid option from the menu."); // error message if non-menu item is input
                    break;
            }
        }
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");
        Dog dog4 = new Dog("Tom", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", false, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        dogList.add(dog4);
    }


    // Adds monkeys to a list for testing
    // Optional for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Bob", "Capuchin", "male", "3", "10", 12.0, 4.0, 5.0, "1-10-2020", "United States", "intake", false, "United States");
        Monkey monkey2 = new Monkey("Jill", "Tamarin", "Female", "5", "3", 3.0, 5.0, 6.0, "4-20-2020", "Brazil", "Phase II", false, "United States");
        Monkey monkey3 = new Monkey("Tony", "Marmoset", "male", "6", "15", 1.0, 2.0, 3.0, "6-10-2018", "Colombia", "in service", true, "Costa Rica");
        Monkey monkey4 = new Monkey("Tombob", "Marmoset", "male", "6", "15", 1.0, 2.0, 3.0, "6-10-2018", "USA", "in service", false, "Costa Rica");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
        monkeyList.add(monkey4);
    }

    // Set data for all attributes based on user input
    // Add the newly instantiated dog to an ArrayList
    public static void intakeNewDog() {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();

        // checks to see if the dog is already in the dogList based on name attribute
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // collects user input on all of the attributes for the new dog
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine();
        System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine();
        System.out.println("What is the dog's age?");
        String age = scanner.nextLine();
        System.out.println("What is the dog's weight?");
        String weight = scanner.nextLine();
        System.out.println("What is the dog's acquisition date?");
        String acquisitionDate = scanner.nextLine();
        System.out.println("What country did the dog come from?");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("What is the dog's training status?");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the dog currently reserved (true/false)?");
        boolean reserved = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("What country is the dog in service at?");
        String inServiceCountry = scanner.nextLine();

        // adds the new dog to dogList
        dogList.add(new Dog(name, breed, gender, age, weight, acquisitionDate, 
            acquisitionCountry, trainingStatus, reserved, inServiceCountry));
    }


    // Set data for all attributes based on user input
    // Add the newly instantiated monkey to an ArrayList
    public static void intakeNewMonkey() {
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine();

        // checks to see if the monkey is already in the monkeyList based on name attribute
        for (Monkey monkey : monkeyList) {          
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return;     //returns to menu
            }
        }

        // collects user input on all of the attributes for the new monkey
        System.out.println("What is the monkey's species?");
        String species = scanner.nextLine();
        speciesValid = monkeySpeciesList.stream().anyMatch(species::equalsIgnoreCase);  // checks if the species in the approved species list
        if (speciesValid == true) {
            // the code continues if speciesValid == true
        } 
        else {
            System.out.println("This is not an approved species.");
            return;
        }
        System.out.println("What is the monkey's gender?");
        String gender = scanner.nextLine();
        System.out.println("What is the monkey's age?");
        String age = scanner.nextLine();
        System.out.println("What is the monkey's weight?");
        String weight = scanner.nextLine();
        System.out.println("What is the monkey's tail length?");
        double tailLength = scanner.nextDouble();
        System.out.println("What is the monkey's height?");
        double height = scanner.nextDouble();
        System.out.println("What is the monkey's body length?");
        double bodyLength = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("What is the monkey's acquisition date?");
        String acquisitionDate = scanner.nextLine();
        System.out.println("What country did the monkey come from?");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("What is the monkey's training status?");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the monkey currently reserved (true/false)?");
        boolean reserved = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("What country is the monkey in service at?");
        String inServiceCountry = scanner.nextLine();

        // creates the new monkey object and adds it to the monkeyList
        monkeyList.add(new Monkey(name, species, gender, age, weight, tailLength, height, 
            bodyLength, acquisitionDate, acquisitionCountry, trainingStatus, 
            reserved, inServiceCountry));
    }

    // lets user reserve animal based on animal type and country
    public static void reserveAnimal() {
        String animalType;
        String animalCountry;

        // gather user input for animal type and country desired
        System.out.println("What type of animal would you like to reserve?");
        animalType = scanner.nextLine();
        System.out.println("What country would you like to reserve from?");
        animalCountry = scanner.nextLine();

        // dog reservation block
        // if animalCountry matches acquisition country and the dog is not reserved, then reserve the dog and output confirmation message
        if (animalType.toLowerCase().equals("dog")) {
            for (Dog dog : dogList) {
                if ((dog.getAcquisitionLocation().equals(animalCountry)) && (dog.getReserved() == false)) {
                    dog.setReserved(true);
                    ++animalCount;
                    System.out.println("You have reserved the following dog: ");
                    System.out.println("Name: "+ dog.getName() + ", Training Status: " + dog.getTrainingStatus() +
                    ", Acquisition Country: " + dog.getAcquisitionLocation() + ", Reserved: " + dog.getReserved());
                }
            }

            // outputs "no animal found" feedback message to user
            if (animalCount == 0){
                System.out.println("Sorry. There is no " + animalType + " from " + animalCountry + " in the inventory.");
            }
            animalCount = 0;   // resets animal counter for proper "no animal found" handling for future queries
        }

        // monkey reservation block
        // if animalCountry matches acquisition country and the monkey is not reserved, then reserve the monkey and output confirmation message
        else if (animalType.toLowerCase().equals("monkey")) {
            for (Monkey monkey : monkeyList) {
                if ((monkey.getAcquisitionLocation().equals(animalCountry)) && (monkey.getReserved() == false)) {
                    monkey.setReserved(true);
                    ++animalCount;
                    System.out.println("You have reserved the following monkey: ");
                    System.out.println("Name: "+ monkey.getName() + ", Training Status: " + monkey.getTrainingStatus() +
                    ", Acquisition Country: " + monkey.getAcquisitionLocation() + ", Reserved: " + monkey.getReserved());
                }
            }

            // outputs "no animal found" feedback message to user
            if (animalCount == 0) {
                System.out.println("Sorry. There is no " + animalType + " from " + animalCountry + " in the inventory.");
            }
            animalCount = 0;   // resets animal counter for proper "no animal found" handling for future queries
        }
    }

    // method for printing animals. Takes string argument to select which of the three types of lists to print.
    // list 1: all dogs ; list 2: all monkeys ; list 3: all animals available to be reserved
    public static void printAnimals(String animalType) {

        // prints a list of all of the monkeys
        if (animalType.equals("monkey")) {
            System.out.println("CURRENT MONKEYS: ");
            for (Monkey monkey : monkeyList) {
                System.out.println("Name: "+ monkey.getName() + ", Training Status: " + monkey.getTrainingStatus() +
                    ", Acquisition Country: " + monkey.getAcquisitionLocation() + ", Reserved: " + monkey.getReserved());
            }
        }

        // prints a list of all of the dogs
        else if (animalType.equals("dog")) {
            System.out.println("CURRENT DOGS: ");
            for (Dog dog : dogList) {
                System.out.println("Name: "+ dog.getName() + ", Training Status: " + dog.getTrainingStatus() +
                ", Acquisition Country: " + dog.getAcquisitionLocation() + ", Reserved: " + dog.getReserved());
            }

        }

        // prints a list of all of the animals that are "in service" and not reserved
        else if (animalType.equals("available")) {

            // creates new array list for storing the index of the available dogs
            ArrayList<Integer> indexList = new ArrayList<Integer>();

            // iterates through dogList and adds the index of the avaialble dogs to indexList
            for (Dog dog : dogList) {
                if ((dog.getTrainingStatus().equals("in service")) && (dog.getReserved() == false)) {
                    indexList.add(dogList.indexOf(dog));
                }
            }

            // if the indexList contains values, prints dog info for each value in indexList
            if (indexList.size() > 0) {
                System.out.println("CURRENTLY AVAIALBLE DOGS: ");
                for (Integer num : indexList) {
                    System.out.println("Name: "+ dogList.get(num).getName() + ", Training Status: " + dogList.get(num).getTrainingStatus() +
                    ", Acquisition Country: " + dogList.get(num).getAcquisitionLocation() + ", Reserved: " + dogList.get(num).getReserved());
                }
            }

            // else if index list is 0, prints feedback message letting user know there are no dogs available for reservation
            else {
                System.out.println("There are no available dogs for reservation.");
            }
            indexList.clear();     // clears the indexList so that it can be used for finding availalbe monkeys in following code
            System.out.println();

            // iterates through monkeyList and adds the index of the avaialble monkeys to indexList
            for (Monkey monkey : monkeyList) {
                if ((monkey.getTrainingStatus().equals("in service")) && (monkey.getReserved() == false)) {
                    indexList.add(monkeyList.indexOf(monkey));
                }
            }

            // if the indexList contains values, prints monkey info for each value in indexList
            if (indexList.size() > 0) {
                System.out.println("CURRENTLY AVAIALBLE MONKEYS: ");
                for (Integer num : indexList) {
                    System.out.println("Name: "+ monkeyList.get(num).getName() + ", Training Status: " + monkeyList.get(num).getTrainingStatus() +
                    ", Acquisition Country: " + monkeyList.get(num).getAcquisitionLocation() + ", Reserved: " + monkeyList.get(num).getReserved());
                }
            }

            // else if index list is 0, prints feedback message letting user know there are no monkeys available for reservation
            else {
                System.out.println("There are no available monkeys for reservation.");
            }
        }
    }
}