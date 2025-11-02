package co.edu.uco.treepruning.controller;

import java.time.LocalDate;
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

import co.edu.uco.treepruning.business.facade.impl.PQRFacadeImpl;
import co.edu.uco.treepruning.controller.dto.Response;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.dto.PQRDTO;
import co.edu.uco.treepruning.dto.StatusDTO;

@RestController
@RequestMapping("/api/v1/pqrs")
public class PQRController {
	@GetMapping("/dummy")
	public PQRDTO getPQRDTODummy() {
		return new PQRDTO();
	}

	@GetMapping
    public ResponseEntity<Response<PQRDTO>> findPQRs(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) String date, 
            @RequestParam(required = false) UUID statusId) {

        Response<PQRDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new PQRFacadeImpl();
            if (id == null && (date == null || date.isBlank()) && statusId == null) {
                responseObjectData.setData(facade.findAllPQRS());
            } else {
                PQRDTO filter = new PQRDTO();
                filter.setId(id);

                if (date != null && !date.isBlank()) {
                    try {
                        filter.setDate(LocalDate.parse(date));
                    } catch (final Exception ex) {
                    	System.out.println("Formato de fecha inválido: " + date);
                    }
                }

                if (statusId != null) {
                    StatusDTO status = new StatusDTO();
                    status.setId(statusId);
                    filter.setStatus(status);
                }

                responseObjectData.setData(facade.findPQRSByFilter(filter));
            }
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
            return new ResponseEntity<Response<PQRDTO>>(responseObjectData, responseStatusCode);
        }

    @GetMapping("/{id}")
    public ResponseEntity<Response<PQRDTO>> findSpecificPQR(@PathVariable UUID id) {

        Response<PQRDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {

            var facade = new PQRFacadeImpl();

            responseObjectData.setData(List.of(facade.findSpecificPQR(id)));
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
        return new ResponseEntity<Response<PQRDTO>>(responseObjectData, responseStatusCode);
    }

}