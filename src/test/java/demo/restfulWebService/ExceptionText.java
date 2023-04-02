package demo.restfulWebService;

import demo.restfulWebService.controller.ProjectController;
import demo.restfulWebService.controller.TaskController;
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
public class ExceptionText {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskController taskController;

    @Test
    public void test() throws Exception {
        assertThat(taskController).isNotNull();
    }

    @Test
    public void entityNotFoundException() throws Exception {
        this.mockMvc.perform(get("/task/77777777"))
                .andDo(print())
                .andExpect(status().is5xxServerError())
                .andExpect(content().string(containsString("EntityNotFoundException")))
                .andExpect(content().string(containsString("Unable to find demo.restfulWebService.model.projectModel.Task with id 77777777")));
    }
}
