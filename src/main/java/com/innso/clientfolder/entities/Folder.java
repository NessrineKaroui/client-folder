package com.innso.clientfolder.entities;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Folder {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String clientName;
  private LocalDateTime openDate;
  private String reference;
  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "folder_id")
  private List<Message> messages;

  public Folder(){
  }

  public Folder(String clientName, LocalDateTime openDate, String reference, List<Message> messages) {
    this.clientName = clientName;
    this.openDate = openDate;
    this.reference = reference;
    this.messages = messages;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public LocalDateTime getOpenDate() {
    return openDate;
  }

  public void setOpenDate(LocalDateTime openDate) {
    this.openDate = openDate;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }
}
