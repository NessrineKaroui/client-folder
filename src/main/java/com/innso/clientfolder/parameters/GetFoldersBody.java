package com.innso.clientfolder.parameters;

public class GetFoldersBody {
    private final String clientName;
    private final String reference;

    public GetFoldersBody(String clientName, String reference) {
        this.clientName = clientName;
        this.reference = reference;
    }

    public String getClientName() {
        return clientName;
    }

    public String getReference() {
        return reference;
    }
}
