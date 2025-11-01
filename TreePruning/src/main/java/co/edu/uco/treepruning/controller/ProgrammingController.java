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

import co.edu.uco.treepruning.business.facade.impl.ProgrammingFacadeImpl;
import co.edu.uco.treepruning.controller.dto.Response;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.dto.ProgrammingDTO;

@RestController
@RequestMapping("/api/v1/programmings")
public class ProgrammingController {

    @GetMapping
    public ResponseEntity<Response<ProgrammingDTO>> findAllProgrammings() {

        Response<ProgrammingDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {

            var facade = new ProgrammingFacadeImpl();

            responseObjectData.setData(facade.findAllProgrammings());
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

        return new ResponseEntity<Response<ProgrammingDTO>>(responseObjectData, responseStatusCode);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<ProgrammingDTO>> findSpecificProgramming(@PathVariable UUID id) {

        Response<ProgrammingDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {

            var facade = new ProgrammingFacadeImpl();

            responseObjectData.setData(List.of(facade.findSpecificProgramming(id)));
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
        return new ResponseEntity<Response<ProgrammingDTO>>(responseObjectData, responseStatusCode);
    }

    @GetMapping("/filter")
    public ResponseEntity<Response<ProgrammingDTO>> findProgrammingsByFilter(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) String initialDate, // ISO yyyy-MM-dd expected
            @RequestParam(required = false) Integer frequencyMonths,
            @RequestParam(required = false) Integer quantity) {

        Response<ProgrammingDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new ProgrammingFacadeImpl();

            ProgrammingDTO filter = new ProgrammingDTO();
            filter.setId(id);

            if (initialDate != null && !initialDate.isBlank()) {
                try {
                    filter.setInitialDate(LocalDate.parse(initialDate));
                } catch (final Exception exeption) {
                    System.out.println("Formato de fecha inválido: " + initialDate);
                }
            }

            if (frequencyMonths != null) {
                filter.setFrequencyMonths(frequencyMonths);
            }

            if (quantity != null) {
                filter.setQuantity(quantity);
            }

            responseObjectData.setData(facade.findProgrammingsByFilter(filter));
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
        return new ResponseEntity<Response<ProgrammingDTO>>(responseObjectData, responseStatusCode);
    }
}

