package com.innso.clientfolder.services;

import com.innso.clientfolder.dtos.MessageDTO;
import com.innso.clientfolder.expcetions.ServieClientException;
import com.innso.clientfolder.parameters.CreateFolderBody;
import com.innso.clientfolder.parameters.CreateMessageBody;
import com.innso.clientfolder.parameters.ReplyMessageBody;

public interface MessageService {
   MessageDTO create(CreateMessageBody createMessageBody) throws ServieClientException;

   void reply(ReplyMessageBody replyMessageBody)  throws ServieClientException;
}
