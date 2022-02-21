package com.innso.clientfolder.services;

import com.innso.clientfolder.dtos.MessageDTO;
import com.innso.clientfolder.entities.Folder;
import com.innso.clientfolder.entities.Message;
import com.innso.clientfolder.expcetions.ServieClientException;
import com.innso.clientfolder.mapper.MessageMapper;
import com.innso.clientfolder.parameters.CreateMessageBody;
import com.innso.clientfolder.parameters.ReplyMessageBody;
import com.innso.clientfolder.repository.FolderRepository;
import com.innso.clientfolder.repository.MessageRepository;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImp implements MessageService {

  private final MessageRepository messageRepository;

  private final FolderRepository folderRepository;

  public MessageServiceImp(MessageRepository messageRepository,
      FolderRepository folderRepository) {
    this.messageRepository = messageRepository;
    this.folderRepository = folderRepository;
  }

  @Override
  public MessageDTO create(CreateMessageBody createMessageBody) throws ServieClientException {
    try {
      Message messageCreated = messageRepository.save(MessageMapper.RequestBodyToEntity(createMessageBody));
      return MessageMapper.entityToDto(messageCreated);
    } catch (Exception e) {
      throw new ServieClientException(e.getMessage());
    }
  }

  @Override
  public void reply(ReplyMessageBody replyMessageBody) throws ServieClientException {
    try {
      Folder folder = folderRepository.findByClientName(replyMessageBody.getClientName());
      Message message = new Message(replyMessageBody.getAuthorName(), replyMessageBody.getContent(),
          LocalDateTime.now(), replyMessageBody.getCanal());
      message.setFolder(folder);
      messageRepository.save(message);
    } catch (Exception e) {
      throw new ServieClientException(e.getMessage());
    }
  }
}
