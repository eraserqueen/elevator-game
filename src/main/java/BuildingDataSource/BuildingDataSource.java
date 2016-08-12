package BuildingDataSource;

import BuildingService.Building;

import java.util.LinkedList;
import java.util.List;

public class BuildingDataSource {

    public List<Building> buildings = new LinkedList<Building>();

    public BuildingDataSource(List<Building> buildings) {
        this.buildings = buildings;
    }

    public BuildingDataSource() {
    }

    public void Add(Building building) {
        buildings.add(building);
    }


    public void DeleteById(int id) {
        for (Building building:buildings) {
            if(building.getId() == id) {
                buildings.remove(building);
                break;
            }
        }
    }

    public Building GetById(int id) {
        for (Building building:buildings) {
            if(building.getId() == id) return building;
        }
        return null;
    }
}
