public class Villager {
    private String name;         // Name of the villager
    private String profession;   // Profession of the villager

    public Villager(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    public String getName() {
        return this.name;
    }

    public String getProfession() {
        return this.profession;
    }
}