import java.util.List;
import java.util.ArrayList;

public abstract class Building {
    private String name;
    private List<Villager> occupants;

    public Building(String name) {
        this.name = name;
        this.occupants = new ArrayList<>();
    }

    /**
     * Returns the name of the building.
     * @return the name of the building
     */
    public String getName() {
        return this.name;
    }

    /**
     * Adds a villager as an occupant of the building.
     * @param villager the villager to add
     */
    public void addOccupant(Villager villager) {
        this.occupants.add(villager);
    }

    /**
     * Returns a list of the occupants of the building.
     * @return a list of the occupants of the building
     */
    public List<Villager> getOccupants() {
        return this.occupants;
    }
}
