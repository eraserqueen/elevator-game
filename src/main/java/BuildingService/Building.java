package BuildingService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Building {

    private List<Elevator> elevators = new LinkedList<Elevator>();
    private int floors;
    private int employees;
    private Date localTime;

    public Building() {
        this.floors = 1;
        this.employees = 1;
        this.elevators.add(new Elevator());
    }

    public int getFloors() {
        return floors;
    }

    public int getEmployees() {
        return employees;
    }

    public List<Elevator> getElevators() {
        return elevators;
    }

    public int getCurrentEnergyConsumption() {
        for (Elevator e:elevators) {
            if(e.isActive()) return 1;
        }
        return 0;
    }

    public boolean isOpen() {
        SimpleDateFormat hours = new SimpleDateFormat("H");
        if(Integer.parseInt(hours.format(localTime)) < 7) return false;
        if(Integer.parseInt(hours.format(localTime)) >= 19) return false;
        return true;
    }

    public void setFloors(int floors) {
        if(floors<=0) throw new RuntimeException("There must be at least one floor");
        this.floors = floors;
    }

    public void setEmployees(int employees) {
        if(employees<=0) throw new RuntimeException("There must be at least one employee");
        this.employees = employees;
    }

    public Date getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String input) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        localTime = ft.parse(input);
    }
}
