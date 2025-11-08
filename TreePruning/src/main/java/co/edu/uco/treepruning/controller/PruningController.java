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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.treepruning.business.facade.impl.PruningFacadeImpl;
import co.edu.uco.treepruning.controller.dto.Response;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.DateHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.PQRDTO;
import co.edu.uco.treepruning.dto.PruningDTO;
import co.edu.uco.treepruning.dto.QuadrilleDTO;
import co.edu.uco.treepruning.dto.StatusDTO;
import co.edu.uco.treepruning.dto.TreeDTO;
import co.edu.uco.treepruning.dto.TypeDTO;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/prunings")
public class PruningController {

    @GetMapping("/dummy")
    public PruningDTO getPruningDTODummy() {
        return new PruningDTO();
    }

    @PostMapping("/corrective")
    public ResponseEntity<Response<PruningDTO>> scheduleCorrectivePruning(@RequestBody PruningDTO pruningDTO) {
        Response<PruningDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;
        try {
            var facade = new PruningFacadeImpl();
            facade.scheduleCorrectivePruning(pruningDTO);
            responseObjectData.addMessage("Poda correctiva ejecutada con exito");
        } catch (final TreePruningException exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.BAD_REQUEST;
        } catch (final Exception exception) {
            var userMessage = "";
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(userMessage);
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(responseObjectData, responseStatusCode);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Response<PruningDTO>> cancelPruning(@PathVariable UUID id, @RequestBody StatusDTO status) {
        Response<PruningDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new PruningFacadeImpl();
            facade.cancelPruning(id, status);
            responseObjectData.addMessage("");
        } catch (final TreePruningException exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.BAD_REQUEST;
        } catch (final Exception exception) {
            var userMessage = "";
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(userMessage);
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(responseObjectData, responseStatusCode);
    }

    @PutMapping("/{id}/reschedule")
    public ResponseEntity<Response<PruningDTO>> reschedulePruning(@PathVariable UUID id, @RequestBody PruningDTO pruningDTO) {
        Response<PruningDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new PruningFacadeImpl();
            facade.reschedulePruning(id, pruningDTO);
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

        return new ResponseEntity<>(responseObjectData, responseStatusCode);
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Response<PruningDTO>> completePruning(@PathVariable UUID id, @RequestBody StatusDTO status) {
        Response<PruningDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new PruningFacadeImpl();
            facade.completePruning(id, status);
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

        return new ResponseEntity<>(responseObjectData, responseStatusCode);
    }

    @GetMapping
    public ResponseEntity<Response<PruningDTO>> findPrunings(
            @RequestParam(required = false) Date plannedDate,
            @RequestParam(required = false) Date executedDate,
            @RequestParam(required = false) UUID statusId,
            @RequestParam(required = false) UUID treeId,
            @RequestParam(required = false) UUID quadrilleId,
            @RequestParam(required = false) UUID typeId,
            @RequestParam(required = false) UUID pqrId) {

        Response<PruningDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;
        try {
            var facade = new PruningFacadeImpl();
    
            PruningDTO filter = new PruningDTO();
            filter.setPlannedDate(DateHelper.getDateHelper().dateToLocalDate(plannedDate));
            filter.setExecutedDate(DateHelper.getDateHelper().dateToLocalDate(executedDate));

            var status = new StatusDTO();
            status.setId(UUIDHelper.getUUIDHelper().getDefault(statusId));
            filter.setStatus(status);

            var tree = new TreeDTO();
            tree.setId(UUIDHelper.getUUIDHelper().getDefault(treeId));
            filter.setTree(tree);

            var quadrille = new QuadrilleDTO();
            quadrille.setId(UUIDHelper.getUUIDHelper().getDefault(quadrilleId));
            filter.setQuadrille(quadrille);

            var type = new TypeDTO();
            type.setId(UUIDHelper.getUUIDHelper().getDefault(typeId));
            filter.setType(type);

            var pqr = new PQRDTO();
            pqr.setId(UUIDHelper.getUUIDHelper().getDefault(pqrId));
            filter.setPqr(pqr);

            responseObjectData.setData(facade.findPruningsByFilter(filter));
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

        return new ResponseEntity<>(responseObjectData, responseStatusCode);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<PruningDTO>> findSpecificPruning(@PathVariable UUID id) {
        Response<PruningDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new PruningFacadeImpl();
            responseObjectData.setData(List.of(facade.findSpecificPruning(id)));
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
        return new ResponseEntity<>(responseObjectData, responseStatusCode);
    }
}
