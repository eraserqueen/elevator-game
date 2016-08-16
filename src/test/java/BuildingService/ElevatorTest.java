package BuildingService;

import BuildingServiceExceptions.ElevatorCapacityOutOfBoundsException;
import BuildingServiceExceptions.ElevatorSpeedOutOfBoundsException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ElevatorTest {
    private Elevator elevator;
    @Before
    public void SetUp(){
        elevator = new Elevator();
    }
    @Test
    public final void ShouldHaveAUniqueId(){
        Elevator a = new Elevator();
        Elevator b = new Elevator();
        Assert.assertNotNull(a.getId());
        Assert.assertNotNull(b.getId());
        Assert.assertNotEquals(a.getId(), b.getId());
    }
    @Test
    public final void ShouldHaveBaseSpecs(){
        Assert.assertFalse(elevator.isActive());
        Assert.assertEquals(2048, elevator.getMaxCapacityInKilos());
        Assert.assertEquals(1000, elevator.getMaxSpeedInMillisPerFloor());
        Assert.assertEquals(1024, elevator.getEnergyConsumptionPerFloor());
    }
    @Test
    public final void CanModifyMaxCapacity(){
        elevator.setMaxCapacityInKilos(1000);
        Assert.assertEquals(1000, elevator.getMaxCapacityInKilos());
    }
    @Test(expected = ElevatorCapacityOutOfBoundsException.class)
    public final void CannotHaveMaxCapacityOverSpecs(){
        elevator.setMaxCapacityInKilos(9999);
    }
    @Test
    public final void CanModifyMaxSpeed(){
        elevator.setMaxSpeedInMillisPerFloor(3000);
        Assert.assertEquals(3000, elevator.getMaxSpeedInMillisPerFloor());
    }
    @Test(expected = ElevatorSpeedOutOfBoundsException.class)
    public final void CannotHaveMaxSpeedOverSpecs(){
        elevator.setMaxSpeedInMillisPerFloor(500);
    }
    @Test
    public final void ShouldHaveABaseEnergyConsumption(){
        Assert.assertNotNull(elevator.getEnergyConsumptionPerFloor());
        Assert.assertTrue(elevator.getEnergyConsumptionPerFloor()>0);
    }
    @Test
    public final void WhenWeightIncreases_ShouldIncreaseElectricityConsumption(){
        int baseConsumption = elevator.getEnergyConsumptionPerFloor();
        elevator.setPassengerWeight(500);
        Assert.assertTrue(elevator.getEnergyConsumptionPerFloor()>baseConsumption);
    }
    @Test
    public final void WhenSpeedIncreases_ShouldIncreaseElectricityConsumption(){
        elevator.setPassengerWeight(500);
        int baseConsumption = elevator.getEnergyConsumptionPerFloor();
        elevator.setMaxSpeedInMillisPerFloor(5000);
        int slower = elevator.getEnergyConsumptionPerFloor();
        Assert.assertTrue(slower < baseConsumption);
    }
    @Test
    public final void ShouldHaveAnEmptyRoute(){
        Assert.assertNull(elevator.getRoute());
    }
    @Test
    public final void CanBeActivatedOrDisabled(){
        elevator.setActive();
        Assert.assertTrue(elevator.isActive());
        elevator.setInactive();
        Assert.assertFalse(elevator.isActive());
    }
}
