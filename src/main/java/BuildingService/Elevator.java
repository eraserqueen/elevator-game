package BuildingService;

import BuildingServiceExceptions.ElevatorCapacityOutOfBoundsException;
import BuildingServiceExceptions.ElevatorSpeedOutOfBoundsException;

import java.util.UUID;

public class Elevator {
    private final int baseEnergyConsumption;
    private final int baseMaxSpeedInMillisPerFloor = 1000;
    private boolean active;
    private int maxCapacityInKilos;
    private int maxSpeedInMillisPerFloor;
    private int passengerWeight;
    private ElevatorRoute route;
    private UUID id;
    private int energyCostPerKilo = 1;
    private int elevatorWeight = 1024;
    private int baseMaxCapacityInKilos = 2048;

    public Elevator() {
        this.id = UUID.randomUUID();
        this.active = false;
        this.maxSpeedInMillisPerFloor = baseMaxSpeedInMillisPerFloor;
        this.maxCapacityInKilos = baseMaxCapacityInKilos;
        this.baseEnergyConsumption = 100;
    }

    public UUID getId() {
        return id;
    }
    public void setInactive() {
        active = false;
    }
    public void setActive() {
        active = true;
    }

    public boolean isActive() {
        return active;
    }


    public int getMaxCapacityInKilos() {
        return maxCapacityInKilos;
    }

    public void setMaxCapacityInKilos(int maxCapacityInKilos) {
        if(maxCapacityInKilos > this.baseMaxCapacityInKilos) throw new ElevatorCapacityOutOfBoundsException();
        this.maxCapacityInKilos = maxCapacityInKilos;
    }

    public int getMaxSpeedInMillisPerFloor() {
        return maxSpeedInMillisPerFloor;
    }

    public void setMaxSpeedInMillisPerFloor(int maxSpeedInMillisPerFloor) {
        if(maxSpeedInMillisPerFloor < this.baseMaxSpeedInMillisPerFloor) throw new ElevatorSpeedOutOfBoundsException();
        this.maxSpeedInMillisPerFloor = maxSpeedInMillisPerFloor;
    }

    public int getEnergyConsumptionPerFloor() {
        return (elevatorWeight+passengerWeight)*energyCostPerKilo*(1000/maxSpeedInMillisPerFloor);
    }

    public void setPassengerWeight(int passengerWeight) {
        this.passengerWeight = passengerWeight;
    }

    public ElevatorRoute getRoute() {
        return null;
    }

}
