import java.util.List;
import java.util.ArrayList;

public abstract class Building {
    private String name;
    private List<Villager> occupants;

    public Building(String name) {
        this.name = name;
        this.occupants = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addOccupant(Villager villager) {
        this.occupants.add(villager);
    }

    public List<Villager> getOccupants() {
        return this.occupants;
    }
}

