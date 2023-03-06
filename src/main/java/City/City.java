package City;

import javax.xml.crypto.Data;

public class City {
    private String name;
    private String region;
    private String distinct;
    private int population;
    private String foundation;

    public City(String name, String region, String distinct, int population, String foundation) {
        this.name = name;
        this.region = region;
        this.distinct = distinct;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistinct() {
        return distinct;
    }

    public void setDistinct(String distinct) {
        this.distinct = distinct;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        return "name=" + name + ", " + "region=" + region + ", " + "distinct=" + distinct + ", " +
                "population=" + population + ", " + "foundation=" + foundation;
    }
}
