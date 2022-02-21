package com.innso.clientfolder.webservices;

import com.innso.clientfolder.dtos.FolderDto;
import com.innso.clientfolder.entities.Folder;
import com.innso.clientfolder.expcetions.ServieClientException;
import com.innso.clientfolder.parameters.CreateFolderBody;
import com.innso.clientfolder.parameters.GetFoldersBody;
import com.innso.clientfolder.services.FolderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.catalina.LifecycleState;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/folders")
@Tag(name = "Folder", description = "Gestion des dossiers clients")
public class ClientFolderController {

  private final FolderService folderService;

  public ClientFolderController(FolderService folderService) {
    this.folderService = folderService;
  }

  @PostMapping("/create")
  @Operation(summary = "service de creation des dossiers clients")
  public ResponseEntity<?> createFolder(@RequestBody CreateFolderBody createFolderBody){
    try {
      return ResponseEntity.ok(folderService.create(createFolderBody));
    } catch (ServieClientException e) {
      // add logger
      e.fillInStackTrace();
      return ResponseEntity.internalServerError().body("service not available");
    }
  }

  @PatchMapping("/update")
  @Operation(summary = "service de mise à jour des dossiers clients")
  public ResponseEntity<String> updateFolder(@RequestBody CreateFolderBody createFolderBody){
    try {
      folderService.update(createFolderBody);
      return ResponseEntity.ok("folder updated");
    } catch (ServieClientException e) {
      e.fillInStackTrace();
      return ResponseEntity.internalServerError().body("service not available");
    }
  }
  @GetMapping(value = "/getFolders")
  public ResponseEntity<?> getFolders(@RequestBody GetFoldersBody getFoldersBody){
    try{
      return ResponseEntity.ok(folderService.getFolders(getFoldersBody));
    } catch (ServieClientException e){
      e.fillInStackTrace();
      return ResponseEntity.internalServerError().body("Service unavailable");
    }
  }
}
