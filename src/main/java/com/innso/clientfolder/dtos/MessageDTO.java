package com.innso.clientfolder.dtos;

import com.innso.clientfolder.models.Canal;
import java.time.LocalDateTime;

public class MessageDTO {
     private final String authorName;
     private final String content;
     private final LocalDateTime date;
     private final Canal canal;

     public MessageDTO(String authorName, String content, LocalDateTime date, Canal canal) {
          this.authorName = authorName;
          this.content = content;
          this.date = date;
          this.canal = canal;
     }

     public String getAuthorName() {
          return authorName;
     }

     public String getContent() {
          return content;
     }

     public LocalDateTime getDate() {
          return date;
     }

     public Canal getCanal() {
          return canal;
     }
}
