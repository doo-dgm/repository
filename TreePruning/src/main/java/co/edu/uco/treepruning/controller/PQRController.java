package co.edu.uco.treepruning.controller;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.treepruning.business.facade.impl.PQRFacadeImpl;
import co.edu.uco.treepruning.controller.dto.Response;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.PQRDTO;
import co.edu.uco.treepruning.dto.PersonDTO;
import co.edu.uco.treepruning.dto.RiskDTO;
import co.edu.uco.treepruning.dto.SectorDTO;
import co.edu.uco.treepruning.dto.StatusDTO;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/pqrs")
public class PQRController {

    @GetMapping("/dummy")
    public PQRDTO getPQRDTODummy() {
        return new PQRDTO();
    }

    @GetMapping
    public ResponseEntity<Response<PQRDTO>> findPQRs(
            @RequestParam(required = false) Date date,
            @RequestParam(required = false) UUID statusId,
            @RequestParam(required = false) UUID riskId,
            @RequestParam(required = false) UUID sectorId,
            @RequestParam(required = false) UUID personId) {

        Response<PQRDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;
        
        try {
            var facade = new PQRFacadeImpl();

            PQRDTO filter = new PQRDTO();
            filter.setDate(DateHelper.getDateHelper().dateToLocalDate(date));

            var status = new StatusDTO();
            status.setId(UUIDHelper.getUUIDHelper().getDefault(statusId));
            filter.setStatus(status);
            
            var risk = new RiskDTO();
            risk.setId(UUIDHelper.getUUIDHelper().getDefault(riskId));
            filter.setRisk(risk);
            
            var sector = new SectorDTO();
            sector.setId(UUIDHelper.getUUIDHelper().getDefault(sectorId));
            filter.setSector(sector);
            
            var person = new PersonDTO();
            person.setId(UUIDHelper.getUUIDHelper().getDefault(personId));
            filter.setPerson(person);

            responseObjectData.setData(facade.findPQRSByFilter(filter));
            responseObjectData.addMessage("");

        } catch (final TreePruningException exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.BAD_REQUEST;
            exception.printStackTrace();

        } catch (final Exception exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage("");
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
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage("");
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            exception.printStackTrace();
        }

        return new ResponseEntity<Response<PQRDTO>>(responseObjectData, responseStatusCode);
    }
}

