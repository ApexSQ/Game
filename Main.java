import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        

        Territory myTerritory = null;
        
        
        while (myTerritory == null) {
            try {
                System.out.print("Choose your territory type:\n1. Kingdom\n2. Dynasty\nEnter your choice: ");
                int choiceT = input.nextInt();
                input.nextLine(); // consume the newline character
                switch (choiceT) {
                    case 1:
                        System.out.print("Enter the name of your kingdom: ");
                        String kingdomName = input.nextLine();
                        myTerritory = Territory.createKingdom(kingdomName);
                        break;
                    case 2:
                        System.out.print("Enter the name of your dynasty: ");
                        String dynastyName = input.nextLine();
                        myTerritory = Territory.createDynasty(dynastyName);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric choice.");
                input.nextLine(); // clear the invalid input
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric choice.");
                input.nextLine(); // clear the invalid input
            }
        }
        

        System.out.println("Territory created: " + myTerritory.getName());


        while (true) {

            try {
                System.out.print("What do you want to do? (1 = add building, 2 = add villager, 3 = assign villager to building, 4 = print structure, 5 = quit): ");
                int choice = input.nextInt();
                input.nextLine();

                if (choice == 1) {
                System.out.print("Enter the name of the building: ");
                String buildingName = input.nextLine();
                System.out.print("Enter the type of the building (1 = Castle, 2 = Farm, 3 = Blacksmith): ");
                int buildingType = input.nextInt();
                input.nextLine();
    
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
                        continue;
                }
    
                myTerritory.addBuilding(newBuilding);
                System.out.println("Building added successfully.");

            } else if (choice == 2) {

                System.out.print("Enter the name of the villager: ");
                String villagerName = input.nextLine();
                System.out.print("Enter the profession of the villager (1 = Knight, 2 = Blacksmith, 3 = Farmer): ");
                int villagerType = input.nextInt();
                input.nextLine();
    
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
                        continue;
                }
    
                myTerritory.addVillager(newVillager);
                System.out.println("Villager added successfully.");
            } else if (choice == 3) {
                
                System.out.print("Enter the name of the villager to assign: ");
                String villagerName = input.nextLine();
                Villager villagerToAssign = null;
                for (Villager villager : myTerritory.getVillagers()) {
                    if (villager.getName().equals(villagerName)) {
                        villagerToAssign = villager;
                        break;
                    }
                }
                if (villagerToAssign == null) {
                    System.out.println("Villager not found.");
                    continue;
                }
    
                System.out.print("Enter the name of the building to assign to: ");
                String buildingName = input.nextLine();
                Building buildingToAssign = null;
                for (Building building : myTerritory.getBuildings()) {
                    if (building.getName().equals(buildingName)) {
                        buildingToAssign = building;
                        break;
                    }
                }
                if (buildingToAssign == null) {
                    System.out.println("Building not found.");
                    continue;
                }
    
                myTerritory.assignVillagerToBuilding(villagerToAssign, buildingToAssign);
                System.out.println("Villager assigned to building successfully.");
            } else if (choice == 4) {
                myTerritory.printStructure();
            } else if (choice == 5) {
                System.out.println("Exiting program.");
                input.close();
                break;
            } else {
                System.out.println("Invalid choice.");
            }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.nextLine();
                continue;
            }
            
        
        }
    }
}