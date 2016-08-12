package BuildingDataSource;

import BuildingService.Building;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class CRUDTests {

    private BuildingDataSource emptyDataSource;
    private BuildingDataSource PrefilledDataSource;

    @Before
    public final void setUp() {
        LinkedList<Building> list = new LinkedList<Building>();
        list.add(new Building(1));
        emptyDataSource = new BuildingDataSource();
        PrefilledDataSource = new BuildingDataSource(list);
    }

    @Test
    public final void CreateBuilding_AddsBuildingToDataSource(){
        emptyDataSource.Add(new Building(1));
        Assert.assertNotNull(emptyDataSource.buildings);
    }

    @Test
    public final void DeleteBuilding_RemovesBuildingToDataSource(){
        PrefilledDataSource.DeleteById(1);
        Assert.assertTrue(PrefilledDataSource.buildings.isEmpty());
    }

    @Test
    public final void UpdateBuilding_UpdatesBuildingInDataSource(){

    }

    @Test
    public final void ReadBuilding_ReturnsBuildingFromDataSource(){
        Building building = PrefilledDataSource.GetById(1);
        Assert.assertEquals(1, building.getId());
    }

}
