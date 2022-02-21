package com.innso.clientfolder.repository;

import com.innso.clientfolder.entities.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderRepository extends JpaRepository<Folder,Integer> {

  Folder findByClientName(String clientName);
  List<Folder> findAllByClientName(String clientName);
}
