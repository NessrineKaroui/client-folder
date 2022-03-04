package com.innso.clientfolder.parameters;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetFoldersBody {
    private final String clientName;

    @JsonCreator
    public GetFoldersBody(@JsonProperty("clientName") String clientName) {
        this.clientName = clientName;

    }

    public String getClientName() {
        return clientName;
    }

}
