package com.innso.clientfolder.webservices;


import com.innso.clientfolder.mapper.MessageMapper;
import com.innso.clientfolder.models.Canal;
import com.innso.clientfolder.parameters.CreateMessageBody;
import com.innso.clientfolder.services.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class MessageControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private MessageService messageService;


    @Test
    void createMessage() throws Exception {

       CreateMessageBody createMessageBody = new CreateMessageBody("Jérémie Durand","Bonjour, j’ai un problème avec mon nouveau téléphone", Canal.MAIL);

       String requestBodyJson = MessageMapper.objectToJson(createMessageBody);

       RequestBuilder request =
               MockMvcRequestBuilders.post("/messages/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBodyJson)
                .accept(MediaType.APPLICATION_JSON);

          mvc.perform(request).andExpect(status().isOk());
    }

}