package com.innso.clientfolder.services;

import com.innso.clientfolder.dtos.FolderDto;
import com.innso.clientfolder.expcetions.ServieClientException;
import com.innso.clientfolder.parameters.CreateFolderBody;
import com.innso.clientfolder.parameters.GetFoldersBody;

import java.util.List;

public interface FolderService {

  FolderDto create(CreateFolderBody createFolderBody) throws ServieClientException;

  void update(CreateFolderBody createFolderBody) throws ServieClientException;

  List<FolderDto> getFolders(GetFoldersBody getFoldersBody) throws ServieClientException;
}
