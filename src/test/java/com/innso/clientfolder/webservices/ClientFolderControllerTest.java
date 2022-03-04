package com.innso.clientfolder.webservices;

import com.innso.clientfolder.mapper.MessageMapper;
import com.innso.clientfolder.parameters.CreateFolderBody;
import com.innso.clientfolder.parameters.GetFoldersBody;
import com.innso.clientfolder.services.FolderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ClientFolderControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private FolderService folderService;

    @Test
    void createFolderTestOK() throws Exception {
        CreateFolderBody createFolderBody = new CreateFolderBody("Jérémie Durand", "");

        String requestBodyJson = MessageMapper.objectToJson(createFolderBody);

        RequestBuilder request = getRequestBuilder(MockMvcRequestBuilders.post("/folders/create"), requestBodyJson);

        mvc.perform(request).andExpect(status().isOk());
    }



    @Test
    void getFoldersTestOK() throws Exception {
        GetFoldersBody getFolderBody = new GetFoldersBody("Jérémie Durand");

        String requestBodyJson = MessageMapper.objectToJson(getFolderBody);

        RequestBuilder request = getRequestBuilder(MockMvcRequestBuilders.get("/folders/getFolders"), requestBodyJson);

        mvc.perform(request).andExpect(status().isOk());
    }

    @Test
    void updateFolderTestOK() throws Exception {
        CreateFolderBody createFolderBody = new CreateFolderBody("Jérémie Durand","KA-18B6");

        String requestBodyJson = MessageMapper.objectToJson(createFolderBody);

        RequestBuilder request = getRequestBuilder(MockMvcRequestBuilders.patch("/folders/update"), requestBodyJson);

        mvc.perform(request).andExpect(status().isOk());
    }

    private RequestBuilder getRequestBuilder(MockHttpServletRequestBuilder verbs, String requestBodyJson) {
        RequestBuilder request =
                verbs
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBodyJson)
                        .accept(MediaType.APPLICATION_JSON);
        return request;
    }
}