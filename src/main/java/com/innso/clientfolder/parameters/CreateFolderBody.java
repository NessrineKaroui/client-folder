package com.innso.clientfolder.parameters;


public class CreateFolderBody {
    private final String clientName;
    private final String reference;

    public CreateFolderBody(String clientName, String reference) {
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
