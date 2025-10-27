package co.edu.uco.treepruning.controller;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.treepruning.business.facade.impl.PruningFacadeImpl;
import co.edu.uco.treepruning.controller.dto.Response;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.dto.PruningDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/prunings")
public class PruningController {
	
	@GetMapping
	public ResponseEntity<Response<PruningDTO>> findAllPruning() {
		
		Response<PruningDTO> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
		try {
			/*
			var responsePruningList = new ArrayList<PruningDTO>();
			
			responsePruningList.add(new PruningDTO());
			responsePruningList.add(new PruningDTO());
			responsePruningList.add(new PruningDTO());
			responsePruningList.add(new PruningDTO());
			*/
			var facade = new PruningFacadeImpl();
			var responsePruningList = facade.findAllPrunings();
			
			responseObjectData.setData(responsePruningList);
			
			responseObjectData.addMessage("All prunings filtered succesfully");
		} catch (TreePruningException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
		} catch (Exception exception) {
			var userMessage = "Unexpected error";
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(userMessage);
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
		}
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
	@PostMapping
	public String schedulePruning(@RequestBody PruningDTO pruning) {
		return null;
	}
	
	@PutMapping("{id}")
	public String reschedulePruning(@PathVariable UUID id, @RequestBody PruningDTO pruning) {
		return null;
	}
	
	@DeleteMapping("{id}")
	public String cancelPruning(@PathVariable UUID id) {
		return null;
	}
}
