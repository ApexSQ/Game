import java.util.ArrayList;

public class Territory {
    private String name;
    private ArrayList<Building> buildings;
    private ArrayList<Villager> villagers;

    public Territory(String name) {
        this.name = name;
        this.buildings = new ArrayList<>();
        this.villagers = new ArrayList<>();
    }


    public String getName() {
        return this.name;
    }

    public void addBuilding(Building building) {
        this.buildings.add(building);
    }

    public ArrayList<Building> getBuildings() {
        return this.buildings;
    }

    public void addVillager(Villager villager) {
        this.villagers.add(villager);
    }

    public ArrayList<Villager> getVillagers() {
        return this.villagers;
    }

    public void assignVillagerToBuilding(Villager villager, Building building) {
        building.addOccupant(villager);
    }

    

    public void printStructure() {
        if (this instanceof Kingdom) {
            System.out.println("Kingdom: " + this.getName());
        } else if (this instanceof Dynasty) {
            System.out.println("Dynasty: " + this.getName());
        } else {
            System.out.println("Territory: " + this.getName());
        }
        System.out.println("Buildings:");
        for (Building building : this.buildings) {
            System.out.println("- " + building.getName());
            System.out.println("  Occupants:");
            for (Villager occupant : building.getOccupants()) {
                System.out.println("  - " + occupant.getName());
            }
        }
    }
    
    public static Kingdom createKingdom(String name) {
        return new Kingdom(name);
    }

    public static Dynasty createDynasty(String name) {
        return new Dynasty(name);
    }
}
