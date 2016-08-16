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
    public final void ShouldHaveAtLeastOneFloor() {
        Assert.assertTrue(building.getFloors() > 0);
    }

    @Test
    public final void CanHaveMultipleFloors() {
        building.setFloors(3);
        Assert.assertEquals(3, building.getFloors());
    }

    @Test(expected = RuntimeException.class)
    public final void CannotHaveNegativeFloors() {
        building.setFloors(-1);
    }
    @Test
    public final void ShouldHaveAtLeastOneEmployee() {
        Assert.assertTrue(building.getEmployees() > 0);
    }

    @Test
    public final void CanHaveMultipleEmployees() {
        building.setEmployees(1000);
        Assert.assertEquals(1000, building.getEmployees());
    }
    @Test(expected = RuntimeException.class)
    public final void CannotHaveNegativeEmployees() {
        building.setEmployees(-1);
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
    public final void ShouldHaveAnInternalClock() {
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

    }

    @Test
    public final void WhenBuildingIsOpen_ShouldHaveAllActiveEmployees() {
    }

}