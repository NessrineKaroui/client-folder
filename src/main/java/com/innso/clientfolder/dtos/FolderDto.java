package com.innso.clientfolder.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class FolderDto {
private final String clientName;
private final LocalDateTime openDate;
private final String reference;
private final List<MessageDTO> messages;

  public FolderDto(String clientName, LocalDateTime openDate, String reference,
      List<MessageDTO> messages) {
    this.clientName = clientName;
    this.openDate = openDate;
    this.reference = reference;
    this.messages = messages;
  }

  public String getClientName() {
    return clientName;
  }

  public LocalDateTime getOpenDate() {
    return openDate;
  }

  public String getReference() {
    return reference;
  }

  public List<MessageDTO> getMessages() {
    return messages;
  }
}
