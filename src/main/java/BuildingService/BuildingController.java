package BuildingService;

import BuildingDataSource.*;
import BuildingServiceExceptions.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BuildingController {

    private BuildingDataSource datasource;

    public BuildingController() {
        this.datasource = new BuildingDataSource();
    }

    public BuildingController(BuildingDataSource dataSource) {
        this.datasource = dataSource;
    }

    @RequestMapping("/building")
    public Building GetBuilding(@RequestParam(value="id", defaultValue="") String val) {
        int id = 0;
        try {
            id = Integer.parseInt(val);
        } catch (NumberFormatException ex) {
            throw new BuildingServiceBadDataException("Missing building id");
        }
        Building building = datasource.GetById(id);
        if(building == null) {
            throw new BuildingNotFoundException();
        }
        return building;
    }
}