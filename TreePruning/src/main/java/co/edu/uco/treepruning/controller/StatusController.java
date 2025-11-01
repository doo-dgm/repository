package co.edu.uco.treepruning.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.treepruning.business.facade.impl.StatusFacadeImpl;
import co.edu.uco.treepruning.controller.dto.Response;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.dto.StatusDTO;

@RestController
@RequestMapping("/api/v1/statuses")
public class StatusController {

    @GetMapping
    public ResponseEntity<Response<StatusDTO>> findAllStatuses() {

        Response<StatusDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {

            var facade = new StatusFacadeImpl();

            responseObjectData.setData(facade.findAllStatuses());
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

        return new ResponseEntity<Response<StatusDTO>>(responseObjectData, responseStatusCode);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<StatusDTO>> findSpecificStatus(@PathVariable UUID id) {

        Response<StatusDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {

            var facade = new StatusFacadeImpl();

            responseObjectData.setData(List.of(facade.findSpecificStatus(id)));
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
        return new ResponseEntity<Response<StatusDTO>>(responseObjectData, responseStatusCode);
    }

    @GetMapping("/filter")
    public ResponseEntity<Response<StatusDTO>> findStatusesByFilter(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) String name) {

        Response<StatusDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new StatusFacadeImpl();

            StatusDTO filter = new StatusDTO();
            filter.setId(id);
            filter.setName(name);

            responseObjectData.setData(facade.findStatusesByFilter(filter));
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
        return new ResponseEntity<Response<StatusDTO>>(responseObjectData, responseStatusCode);
    }
}
