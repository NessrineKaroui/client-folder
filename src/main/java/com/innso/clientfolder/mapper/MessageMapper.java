package com.innso.clientfolder.mapper;

import com.innso.clientfolder.dtos.MessageDTO;
import com.innso.clientfolder.entities.Message;
import com.innso.clientfolder.parameters.CreateMessageBody;

import java.time.LocalDateTime;

public final class MessageMapper {

    // transform a CreateMessageBody request to an Entity
    public static Message RequestBodyToEntity(CreateMessageBody createMessageBody) {
        return new Message(createMessageBody.getAuthorName(), createMessageBody.getContent(),
                LocalDateTime.now(), createMessageBody.getCanal());
    }
    // transform an entity to a message DTO
    public static MessageDTO entityToDto(Message message) {
        return new MessageDTO(message.getAuthorName(),
                message.getContent(), message.getDate(), message.getCanal());
    }
}
