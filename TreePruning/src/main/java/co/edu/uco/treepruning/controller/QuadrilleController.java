package co.edu.uco.treepruning.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.uco.treepruning.business.facade.impl.QuadrilleFacadeImpl;
import co.edu.uco.treepruning.controller.dto.Response;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.dto.ManagerDTO;
import co.edu.uco.treepruning.dto.QuadrilleDTO;

@RestController
@RequestMapping("/api/v1/quadrilles")
public class QuadrilleController {
	
	@GetMapping("/dummy")
	public QuadrilleDTO dummy() {
		return new QuadrilleDTO();
	}

    @GetMapping
    public ResponseEntity<Response<QuadrilleDTO>> findAllQuadrilles() {
        Response<QuadrilleDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new QuadrilleFacadeImpl();
            responseObjectData.setData(facade.findAllQuadrilles());
            responseObjectData.addMessage(" ");
        } catch (final TreePruningException exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.BAD_REQUEST;
            exception.printStackTrace();
        } catch (final Exception exception) {
            var userMessage = "";
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(userMessage);
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            exception.printStackTrace();
        }

        return new ResponseEntity<Response<QuadrilleDTO>>(responseObjectData, responseStatusCode);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<QuadrilleDTO>> findSpecificQuadrille(@PathVariable final UUID id) {
        Response<QuadrilleDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new QuadrilleFacadeImpl();
            responseObjectData.setData(List.of(facade.findSpecificQuadrille(id)));
            responseObjectData.addMessage("");
        } catch (final TreePruningException exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.NOT_FOUND;
            exception.printStackTrace();
        } catch (final Exception exception) {
            var userMessage = "";
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(userMessage);
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            exception.printStackTrace();
        }

        return new ResponseEntity<Response<QuadrilleDTO>>(responseObjectData, responseStatusCode);
    }

    @GetMapping("/filter")
    public ResponseEntity<Response<QuadrilleDTO>> findQuadrillesByFilter(
            @RequestParam(required = false) final UUID id,
            @RequestParam(required = false) final String name,
            @RequestParam(required = false) final UUID managerId) {

        Response<QuadrilleDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new QuadrilleFacadeImpl();

            QuadrilleDTO filter = new QuadrilleDTO();
            filter.setId(id);
            filter.setName(name);

            if (managerId != null) {
                var manager = new ManagerDTO();
                manager.setId(managerId);
                filter.setManager(manager);
            }

            responseObjectData.setData(facade.findQuadrillesByFilter(filter));
            responseObjectData.addMessage("");
        } catch (final TreePruningException exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.BAD_REQUEST;
            exception.printStackTrace();
        } catch (final Exception exception) {
            var userMessage = "";
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(userMessage);
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            exception.printStackTrace();
        }

        return new ResponseEntity<Response<QuadrilleDTO>>(responseObjectData, responseStatusCode);
    }
}

