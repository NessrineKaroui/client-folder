package com.innso.clientfolder.parameters;

import com.innso.clientfolder.models.Canal;

public class CreateMessageBody {
    private final String authorName;
    private final String content;
    private final Canal canal;

    public CreateMessageBody(String authorName, String content, Canal canal) {
        this.authorName = authorName;
        this.content = content;
        this.canal = canal;
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
