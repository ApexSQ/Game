// Import required packages
import java.util.InputMismatchException;
import java.util.Scanner;

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Initialize the territory object
        Territory myTerritory = null;
        
        // Loop until the user creates a valid territory
        while (myTerritory == null) {
            try {
                // Prompt the user to choose territory type
                System.out.print("Choose your territory type:\n1. Kingdom\n2. Dynasty\nEnter your choice: ");
                int choiceT = input.nextInt();
                input.nextLine(); // consume the newline character
                
                // Create territory based on user's choice
                switch (choiceT) {
                    case 1:
                        System.out.print("Enter the name of your Kingdom: ");
                        String kingdomName = input.nextLine();
                        myTerritory = Territory.createKingdom(kingdomName);
                        System.out.println("Kingdom created: " + myTerritory.getName());
                        break;
                    case 2:
                        System.out.print("Enter the name of your Dynasty: ");
                        String dynastyName = input.nextLine();
                        myTerritory = Territory.createDynasty(dynastyName);
                        System.out.println("Dynasty created: " + myTerritory.getName());
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } catch (InputMismatchException e) {
                // Catch input mismatch exception
                System.out.println("Invalid input. Please enter a numeric choice.");
                input.nextLine(); // clear the invalid input
            } catch (NumberFormatException e) {
                // Catch number format exception
                System.out.println("Invalid input. Please enter a numeric choice.");
                input.nextLine(); // clear the invalid input
            }
        }

        // Loop until the user quits the program
        while (true) {
            // Display menu and prompt user for input
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add a building");
            System.out.println("2. Add a villager");
            System.out.println("3. Assign a villager to a building");
            System.out.println("4. Print territory structure");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = input.nextInt();
                input.nextLine(); // Consume the newline character

                if (choice == 1) {
                    // Prompt user to choose building type and name
                    System.out.print("Enter the name of the building: ");
                    String buildingName = input.nextLine();
                    System.out.print("Enter the type of building (1 = Castle, 2 = Farm, 3 = Blacksmith): ");
                    int buildingType = input.nextInt();
                    input.nextLine(); // Consume the newline character

                    // Create new building object based on user input
                    Building newBuilding = null;
                    switch (buildingType) {
                        case 1:
                            newBuilding = new Castle(buildingName);
                            break;
                        case 2:
                            newBuilding = new Farm(buildingName);
                            break;
                        case 3:
                            newBuilding = new Blacksmith(buildingName);
                            break;
                        default:
                            System.out.println("Invalid building type.");
                            continue; // Return to menu
                    }

                    // Add new building to the territory and notify user
                    myTerritory.addBuilding(newBuilding);
                    System.out.println("Building added successfully.");

                } else if (choice == 2) {
                    // Prompt user to enter villager name and profession
                    System.out.print("Enter the name of the villager: ");
                    String villagerName = input.nextLine();
                    System.out.print("Enter the profession of the villager (1 = Knight, 2 = Blacksmith, 3 = Farmer): ");
                    int villagerType = input.nextInt();
                    input.nextLine(); // Consume the newline character

                    // Create new villager object based on user input
                    Villager newVillager = null;
                    switch (villagerType) {
                        case 1:
                            newVillager = new Knight(villagerName);
                            break;
                        case 2:
                            newVillager = new BlacksmithVillager(villagerName);
                            break;
                        case 3:
                            newVillager = new Farmer(villagerName);
                            break;
                        default:
                            System.out.println("Invalid villager type.");
                            continue; // Return to menu
                    }

                    // Add new villager to the territory and notify user
                    myTerritory.addVillager(newVillager);
                    System.out.println("Villager added successfully.");

                } else if (choice == 3) {
                    // Prompt user to enter villager and building names to assign
                    System.out.print("Enter the name of the villager to assign: ");
                    String villagerName = input.nextLine();
                    Villager villagerToAssign = null;
                    for (Villager villager : myTerritory.getVillagers()) {
                        if (villager.getName().equals(villagerName)) {
                            villagerToAssign = villager;
                            break;
                        }
                    }

            // If the villager to assign is not found, print an error message and continue to the next iteration of the loop
            if (villagerToAssign == null) {
                System.out.println("Villager not found.");
                continue;
            }

            // Prompt the user to enter the name of the building to assign to
            System.out.print("Enter the name of the building to assign to: ");

            // Read the building name from the user
            String buildingName = input.nextLine();

            // Initialize the building to assign to as null
            Building buildingToAssign = null;

            // Search for the building in the territory's list of buildings
            for (Building building : myTerritory.getBuildings()) {
                // If the building with the specified name is found, assign it to buildingToAssign and break out of the loop
                if (building.getName().equals(buildingName)) {
                    buildingToAssign = building;
                    break;
                }
            }

            // If the building to assign to is not found, print an error message and continue to the next iteration of the loop
            if (buildingToAssign == null) {
                System.out.println("Building not found.");
                continue;
            }

            // Assign the villager to the building
            myTerritory.assignVillagerToBuilding(villagerToAssign, buildingToAssign);

            // Print a success message
            System.out.println("Villager assigned to building successfully.");

            // Handle user choice 4: print the structure of the territory
            } else if (choice == 4) {
                myTerritory.printStructure();

            // Handle user choice 5: exit the program
            } else if (choice == 5) {
                System.out.println("Exiting program.");
                input.close();
                break;

            // Handle invalid user choices
            } else {
                System.out.println("Invalid choice.");
            }

            // Handle invalid input by catching InputMismatchException and printing an error message, then continuing to the next iteration of the loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.nextLine();
                continue;
            }

        }

    }

}