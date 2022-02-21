package com.innso.clientfolder.entities;

import com.innso.clientfolder.models.Canal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String authorName;
  private String content;
  private LocalDateTime date;
  private Canal canal;
  @ManyToOne
  private Folder folder;

  public Message() {}

  public Message(String authorName, String content, LocalDateTime date, Canal canal) {
    this.authorName = authorName;
    this.content = content;
    this.date = date;
    this.canal = canal;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public Canal getCanal() {
    return canal;
  }

  public void setCanal(Canal canal) {
    this.canal = canal;
  }

  public Folder getFolder() {
    return folder;
  }

  public void setFolder(Folder folder) {
    this.folder = folder;
  }
}
