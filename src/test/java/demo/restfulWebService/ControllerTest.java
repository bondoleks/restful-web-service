package demo.restfulWebService;

import demo.restfulWebService.controller.ProjectController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProjectController projectController;

    @Test
    public void test() throws Exception {
        assertThat(projectController).isNotNull();
    }

    @Test
    public void shouldReturnTextProject() throws Exception {
        this.mockMvc.perform(get("/project"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Project")))
                .andExpect(content().string(containsString("More")))
                .andExpect(content().string(containsString("Add project")));
    }

    @Test
    public void shouldReturnDetailsProject() throws Exception {
        this.mockMvc.perform(get("/project/102"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Project 1")))
                .andExpect(content().string(containsString("Test project description 1")));
    }

    @Test
    public void shouldReturnEditProject() throws Exception {
        this.mockMvc.perform(get("/project/102/edit"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Project 1")))
                .andExpect(content().string(containsString("Edit")));
    }

    @Test
    public void shouldReturnDetailsTask() throws Exception {
        this.mockMvc.perform(get("/task/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Administration work")));
    }

    @Test
    public void shouldReturnEditTask() throws Exception {
        this.mockMvc.perform(get("/task/2/edit"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Task edit")))
                .andExpect(content().string(containsString("admin")));
    }

    @Test
    public void shouldReturnTextUser() throws Exception {
        this.mockMvc.perform(get("/user"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Alex")))
                .andExpect(content().string(containsString("Ruslan")))
                .andExpect(content().string(containsString("Oleh")))
                .andExpect(content().string(containsString("Olena")));
    }

    @Test
    public void shouldReturnDetailsUser() throws Exception {
        this.mockMvc.perform(get("/user/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("dev")))
                .andExpect(content().string(containsString("Alex")))
                .andExpect(content().string(containsString("Silorev")))
                .andExpect(content().string(containsString("Developer")))
                .andExpect(content().string(containsString("Middle")));

    }
}
