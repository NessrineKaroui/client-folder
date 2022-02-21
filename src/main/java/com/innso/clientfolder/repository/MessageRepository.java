package com.innso.clientfolder.repository;

import com.innso.clientfolder.entities.Message;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

  List<Message> findByAuthorName(String clientName);
}
