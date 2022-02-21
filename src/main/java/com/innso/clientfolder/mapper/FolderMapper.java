package com.innso.clientfolder.mapper;

import com.innso.clientfolder.dtos.FolderDto;
import com.innso.clientfolder.dtos.MessageDTO;
import com.innso.clientfolder.entities.Folder;
import com.innso.clientfolder.entities.Message;
import com.innso.clientfolder.parameters.CreateFolderBody;
import com.innso.clientfolder.repository.MessageRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public final class FolderMapper {

    public static Folder dtoToEntity(CreateFolderBody createFolderBody,MessageRepository messageRepository) {
        List<Message> messages = messageRepository.findByAuthorName(createFolderBody.getClientName());
        return new Folder(createFolderBody.getClientName(), LocalDateTime.now(), createFolderBody.getReference(),
                messages);
    }


    // transform a List of entity folder to a list of dto folder
    public static List<FolderDto> listEntityToDto(List<Folder> folders) {
        return folders.stream().map(FolderMapper::entityToDto).collect(Collectors.toList());
    }
    // transform an entity folder to a dto folder
    public static FolderDto entityToDto(Folder createdFolder) {
        return new FolderDto(createdFolder.getClientName(), createdFolder.getOpenDate(),
                createdFolder.getReference(),
                createdFolder.getMessages().stream().map(MessageMapper::entityToDto).collect(
                        Collectors.toList()));
    }

}
