package com.thuexcursion.crud;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thuexcursion.crud.controller.AdminController;
import com.thuexcursion.crud.model.Admin;
import com.thuexcursion.crud.service.AdminService;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest({AdminController.class})
public class AdminControllerLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AdminService adminService;

    /**
     * This test is currently disabled since POST requests aren't being done at the moment.
     * 
     * This tests whether a new Admin can successfully be saved with an HTTP Status 200 (OK).
     * 
     * Actual results of the test are 405 Method Not Allowed:
     * The HyperText Transfer Protocol (HTTP) 405 Method Not Allowed response status code indicates 
     * that the request method is known by the server but is not supported by the target resource.
     * The server must generate an Allow header field in a 405 response containing a list of the 
     * target resource's currently supported methods.
     * 
     * @throws Exception
     */
    @Disabled
    @Test
    @WithMockUser(username = "user1", password = "pwd", roles = "USER")
    public void testSaveAdmin() throws Exception {

        Admin admin = new Admin(1, 123, "Max", "Mann", "mann@gmx.de", "Olgastr. 2", "username1", "password1");

        //when(adminService.updateAdmin(any())).thenReturn(Boolean.TRUE);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/admin/saveAdmins")
                        .content(asJsonString(admin))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(content().string("Admin update complete"));
    }

    /**
     * This tests if a standard JSON document is fetched with a HTTP Request code status 200
     * @throws Exception
     */
    @Test
    @WithMockUser(username = "user1", password = "pwd", roles = "USER")
    public void testFecthAdminInDB() throws Exception {

        List<Admin> adminList = Arrays.asList(
                new Admin(1,3862349,"John", "Smith", "smith@thu.de", "Neue Str. 23","username2", "password2"),
                new Admin(1,2131099,"Ann", "Doe", "doe@thu.de", "Neue Str. 8723","username3", "password3"),
                new Admin(1,27683421,"Jane", "Winter", "winter@thu.de", "Neue Str. 90","username4", "password4")
        );

        when(adminService.getAdmins()).thenReturn(adminList);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/admins"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}, {}]"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}