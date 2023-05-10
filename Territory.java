import java.util.ArrayList;

// Create a public class called Territory
public class Territory {
// Declare private instance variables for the name, buildings, and villagers in the territory
private String name;
private ArrayList<Building> buildings;
private ArrayList<Villager> villagers;

// Create a constructor for the Territory class that initializes the name and creates new ArrayLists for buildings and villagers
public Territory(String name) {
    this.name = name;
    this.buildings = new ArrayList<>();
    this.villagers = new ArrayList<>();
}

// Create a public getter method for the name instance variable
public String getName() {
    return this.name;
}

// Create a public method to add a building to the buildings ArrayList
public void addBuilding(Building building) {
    this.buildings.add(building);
}

// Create a public getter method for the buildings ArrayList
public ArrayList<Building> getBuildings() {
    return this.buildings;
}

// Create a public method to add a villager to the villagers ArrayList
public void addVillager(Villager villager) {
    this.villagers.add(villager);
}

// Create a public getter method for the villagers ArrayList
public ArrayList<Villager> getVillagers() {
    return this.villagers;
}

// Create a public method to assign a villager to a building
public void assignVillagerToBuilding(Villager villager, Building building) {
    building.addOccupant(villager);
}

// Create a public method to print the structure of the territory
public void printStructure() {
    // If the current object is an instance of Kingdom, print the name of the Kingdom
    if (this instanceof Kingdom) {
        System.out.println(" ");
        System.out.println("Kingdom: " + this.getName());
    // If the current object is an instance of Dynasty, print the name of the Dynasty
    } else if (this instanceof Dynasty) {
        System.out.println(" ");
        System.out.println("Dynasty: " + this.getName());
    // Otherwise, print the name of the Territory
    } else {
        System.out.println(" ");
        System.out.println("Territory: " + this.getName());
    }
    // Print the list of buildings and their occupants
    System.out.println("Buildings:");
    for (Building building : this.buildings) {
        System.out.println("- " + building.getName());
        System.out.println("  Occupants:");
        for (Villager occupant : building.getOccupants()) {
            System.out.println("  - " + occupant.getName());
        }
    }
}

// Create a public static method to create a new Kingdom object with the specified name
public static Kingdom createKingdom(String name) {
    return new Kingdom(name);
}

// Create a public static method to create a new Dynasty object with the specified name
public static Dynasty createDynasty(String name) {
    return new Dynasty(name);
}
}

// This class represents a Territory, which can contain buildings and villagers. The Territory class has methods to add buildings and villagers,
// assign villagers to buildings, and print the structure of the territory. The Territory class also has static methods to create Kingdom and Dynasty objects.