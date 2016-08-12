package BuildingService;

import BuildingDataSource.BuildingDataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BuildingControllerTest {

    private MockMvc mvc;
    private String baseUrl = "/building";

    @Before
    public void setUp() throws Exception {
        BuildingDataSource dataSource = new BuildingDataSource();
        dataSource.Add(new Building(1));
        mvc = MockMvcBuilders.standaloneSetup(new BuildingController(dataSource)).build();
    }

    @Test
    public void getBuilding_GivenNoId_Returns400Error() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(baseUrl)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));
    }
    @Test
    public void getBuilding_GivenInvalidId_Returns404Error() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(baseUrl+"?id=999")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404));
    }
    @Test
    public void getBuilding_GivenValidId_ReturnsBuildingSpecs() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(baseUrl+"?id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1}"));
    }
}
