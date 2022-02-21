package com.innso.clientfolder.parameters;

import com.innso.clientfolder.dtos.MessageDTO;
import com.innso.clientfolder.models.Canal;

import java.time.LocalDateTime;

public class ReplyMessageBody {
    private final String clientName;
    private final String authorName;
    private final String content;
    private final Canal canal;

    public ReplyMessageBody(String clientName, String authorName, String content, Canal canal) {
        this.clientName = clientName;
        this.authorName = authorName;
        this.content = content;
        this.canal = canal;
    }

    public String getClientName() {
        return clientName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getContent() {
        return content;
    }

    public Canal getCanal() {
        return canal;
    }
}
