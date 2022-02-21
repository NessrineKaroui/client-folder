package com.innso.clientfolder.services;

import com.innso.clientfolder.dtos.FolderDto;
import com.innso.clientfolder.entities.Folder;
import com.innso.clientfolder.expcetions.ServieClientException;
import com.innso.clientfolder.mapper.FolderMapper;
import com.innso.clientfolder.parameters.CreateFolderBody;
import com.innso.clientfolder.parameters.GetFoldersBody;
import com.innso.clientfolder.repository.FolderRepository;
import com.innso.clientfolder.repository.MessageRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class FolderServiceImp implements FolderService {

  private final FolderRepository folderRepository;
  private final MessageRepository messageRepository;


  public FolderServiceImp(FolderRepository folderRepository, MessageRepository messageRepository) {
    this.folderRepository = folderRepository;
    this.messageRepository = messageRepository;
  }

  @Override
  public FolderDto create(CreateFolderBody createFolderBody) throws ServieClientException {
    try {
      Folder createdFolder = folderRepository.save(FolderMapper.dtoToEntity(createFolderBody,messageRepository));
      return FolderMapper.entityToDto(createdFolder);
    }catch (Exception e){
      throw  new ServieClientException(e.getMessage());
    }
  }

  @Override
  @Transactional
  public void update(CreateFolderBody createFolderBody) throws ServieClientException {
    try {
      Folder folder = folderRepository.findByClientName(createFolderBody.getClientName());
      folder.setReference(createFolderBody.getReference());
    }catch (Exception e){
      throw  new ServieClientException(e.getMessage());
    }
  }

  @Override
  public List<FolderDto> getFolders(GetFoldersBody getFoldersBody) throws ServieClientException {
    try {
      return FolderMapper.listEntityToDto(folderRepository.findAllByClientName(getFoldersBody.getClientName()));
    }
    catch (Exception e){
      throw new ServieClientException(e.getMessage());
    }
    }

}
