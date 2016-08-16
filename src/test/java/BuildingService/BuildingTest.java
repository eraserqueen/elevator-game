package BuildingService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

public class BuildingTest {
    private Building building;

    @Before
    public void SetUp() {
        building = new Building();
    }

    @Test
    public final void ShouldHaveAtLeastOneElevator() {
        Assert.assertTrue(building.getElevators().size() > 0);
    }

    @Test
    public final void ShouldHaveThirtyFloors() {
        Assert.assertEquals(30, building.getFloors());
    }

    @Test
    public final void ShouldHave1500Employee() {
        Assert.assertEquals(1500, building.getEmployees());
    }

    @Test
    public final void WhenNoElevatorIsActive_ShouldHaveAnElectricityConsumptionOfZero() {
        Assert.assertEquals(0, building.getCurrentEnergyConsumption());
    }

    @Test
    public final void WhenOneElevatorIsActive_ShouldHaveAnElectricityConsumptionOverZero() {
        building.getElevators().get(0).setActive();
        Assert.assertNotEquals(0, building.getCurrentEnergyConsumption());
    }
    @Test
    public final void ShouldHaveAnInternalClock(){
        Assert.assertNotNull(building.getLocalTime());
    }
    @Test
    public final void CanModifyInternalClock() {
        try {
            building.setLocalTime("2016-11-09 19:08:00");
        } catch (ParseException e) {
            Assert.fail();
        }
        Assert.assertNotNull(building.getLocalTime());
    }
    @Test
    public final void WhenBuildingTimeIsBefore7am_ShouldBeClosed() {
        try {
            building.setLocalTime("2016-08-15 04:00:00");
            Assert.assertFalse(building.isOpen());
        } catch (ParseException e) {
            Assert.fail();
        }

    }
    @Test
    public final void WhenBuildingTimeIsAfter7pm_ShouldBeClosed() {
        try {
            building.setLocalTime("2016-08-15 21:00:00");
            Assert.assertFalse(building.isOpen());
        } catch (ParseException e) {
            Assert.fail();
        }

    }
    @Test
    public final void WhenBuildingTimeIsBetween7amAnd7pm_ShouldBeOpen() {
        try {
            building.setLocalTime("2016-08-15 12:00:00");
            Assert.assertTrue(building.isOpen());
        } catch (ParseException e) {
            Assert.fail();
        }
    }

    @Test
    public final void WhenBuildingIsClosed_ShouldHaveZeroActiveEmployees() {
        try {
            building.setLocalTime("2016-08-15 21:00:00");
            Assert.assertFalse(building.isOpen());
        } catch (ParseException e) {
            Assert.fail();
        }
        Assert.assertEquals(0, building.getActiveEmployees());
    }

    @Test
    public final void WhenBuildingIsOpen_ShouldHaveAllActiveEmployees() {
        try {
            building.setLocalTime("2016-08-15 12:00:00");
            Assert.assertTrue(building.isOpen());
        } catch (ParseException e) {
            Assert.fail();
        }
        Assert.assertEquals(building.getEmployees(), building.getActiveEmployees());

    }

}