package com.innso.clientfolder.webservices;

import com.innso.clientfolder.dtos.MessageDTO;
import com.innso.clientfolder.expcetions.ServieClientException;
import com.innso.clientfolder.parameters.CreateMessageBody;
import com.innso.clientfolder.parameters.ReplyMessageBody;
import com.innso.clientfolder.services.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/messages")
@RestController
@Tag(name = "Message", description = "Gestion des messages clients")
public class MessageController {

  private final MessageService messageService;

  public MessageController(MessageService messageService) {
    this.messageService = messageService;
  }

  @PostMapping("/create")
  @Operation(summary = "Service de creation des messages")
  public ResponseEntity<?> createMessage(@RequestBody CreateMessageBody message){
    try {
      return  ResponseEntity.ok(messageService.create(message));
    } catch (ServieClientException e) {
      return exceptionHandler(e);
    }
  }

  @PostMapping("/reply")
  @Operation(summary = "Service des réponses clients")
  public ResponseEntity<String> assignMessage(@RequestBody ReplyMessageBody replyMessageBody){
    try {
      messageService.reply(replyMessageBody);
      return  ResponseEntity.ok("message sent");
    } catch (ServieClientException e) {
      return exceptionHandler(e);
    }
  }

  private ResponseEntity<String> exceptionHandler(ServieClientException e) {
    e.fillInStackTrace();
    return ResponseEntity.internalServerError().body("service not available");
  }
}
