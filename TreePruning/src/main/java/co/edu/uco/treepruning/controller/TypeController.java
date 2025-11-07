package co.edu.uco.treepruning.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.treepruning.business.facade.impl.TypeFacadeImpl;
import co.edu.uco.treepruning.controller.dto.Response;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.TypeDTO;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/types")
public class TypeController {
	@GetMapping("/dummy")
	public TypeDTO dummy() {
		return new TypeDTO();
	}
	
	@GetMapping
	public ResponseEntity<Response<TypeDTO>> listTypes(
			@RequestParam(required = false) UUID id,
			@RequestParam(required = false) String name) {
		
		Response<TypeDTO> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
		try {
			var facade = new TypeFacadeImpl();
			
			TypeDTO filter = new TypeDTO();
	        filter.setId(UUIDHelper.getUUIDHelper().getDefault(id));
	        filter.setName(TextHelper.getDefaultWithTrim(name));
				
				responseObjectData.setData(facade.listTypesByCriteria(filter));
	
		} catch (final TreePruningException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
			exception.printStackTrace();
		} catch (final Exception exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage("An unexpected error occurred while processing the request.");
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			exception.printStackTrace();
		}
		
		return new ResponseEntity<Response<TypeDTO>>(responseObjectData, responseStatusCode);
		
	}
}
