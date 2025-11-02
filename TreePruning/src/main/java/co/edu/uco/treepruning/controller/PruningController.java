package co.edu.uco.treepruning.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.uco.treepruning.business.facade.impl.PruningFacadeImpl;
import co.edu.uco.treepruning.controller.dto.Response;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.dto.PruningDTO;
import co.edu.uco.treepruning.dto.StatusDTO;

@RestController
@RequestMapping("/api/v1/prunings")
public class PruningController {
	

	@GetMapping("/dummy")
	public PruningDTO getPruningDTODummy() {
		return new PruningDTO();
	}

    @PostMapping
    public ResponseEntity<Response<PruningDTO>> schedulePruning(@RequestBody PruningDTO pruningDTO) {
        Response<PruningDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new PruningFacadeImpl();
            facade.schedulePruning(pruningDTO);
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

        return new ResponseEntity<Response<PruningDTO>>(responseObjectData, responseStatusCode);
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
            exception.printStackTrace();
        } catch (final Exception exception) {
            var userMessage = "";
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(userMessage);
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            exception.printStackTrace();
        }

        return new ResponseEntity<Response<PruningDTO>>(responseObjectData, responseStatusCode);
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

        return new ResponseEntity<Response<PruningDTO>>(responseObjectData, responseStatusCode);
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

        return new ResponseEntity<Response<PruningDTO>>(responseObjectData, responseStatusCode);
    }

    @GetMapping
    public ResponseEntity<Response<PruningDTO>> findPrunings(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) String plannedDate,
            @RequestParam(required = false) String executedDate,
            @RequestParam(required = false) UUID statusId,
            @RequestParam(required = false) UUID treeId,
            @RequestParam(required = false) UUID quadrilleId) {

        Response<PruningDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new PruningFacadeImpl();

            if (id == null && plannedDate == null && executedDate == null &&
                statusId == null && treeId == null && quadrilleId == null) {

                responseObjectData.setData(facade.findAllPrunings());

            } else {
                PruningDTO filter = new PruningDTO();
                filter.setId(id);

                if (plannedDate != null && !plannedDate.isBlank()) {
                    try {
                        filter.setPlannedDate(LocalDate.parse(plannedDate));
                    } catch (final Exception ex) {
                        System.out.println("Formato de fecha inválido: " + plannedDate);
                    }
                }

                if (executedDate != null && !executedDate.isBlank()) {
                    try {
                        filter.setExecutedDate(LocalDate.parse(executedDate));
                    } catch (final Exception ex) {
                        System.out.println("Formato de fecha inválido: " + executedDate);
                    }
                }

                if (statusId != null) {
                    var status = new StatusDTO();
                    status.setId(statusId);
                    filter.setStatus(status);
                }

                if (treeId != null) {
                    var tree = new co.edu.uco.treepruning.dto.TreeDTO();
                    tree.setId(treeId);
                    filter.setTree(tree);
                }

                if (quadrilleId != null) {
                    var quadrille = new co.edu.uco.treepruning.dto.QuadrilleDTO();
                    quadrille.setId(quadrilleId);
                    filter.setQuadrille(quadrille);
                }

                responseObjectData.setData(facade.findPruningsByFilter(filter));
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

        return new ResponseEntity<Response<PruningDTO>>(responseObjectData, responseStatusCode);
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
        return new ResponseEntity<Response<PruningDTO>>(responseObjectData, responseStatusCode);
    }

    @GetMapping("/filter")
    public ResponseEntity<Response<PruningDTO>> findPruningsByFilter(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) String plannedDate, 
            @RequestParam(required = false) String executedDate, 
            @RequestParam(required = false) UUID statusId,
            @RequestParam(required = false) UUID treeId,
            @RequestParam(required = false) UUID quadrilleId) {

        Response<PruningDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new PruningFacadeImpl();

            PruningDTO filter = new PruningDTO();
            filter.setId(id);

            if (plannedDate != null && !plannedDate.isBlank()) {
                try {
                    filter.setPlannedDate(LocalDate.parse(plannedDate));
                } catch (final Exception exeption) {
                        System.out.println("Formato de fecha inválido: " + plannedDate);
                }
            }

            if (executedDate != null && !executedDate.isBlank()) {
                try {
                    filter.setExecutedDate(LocalDate.parse(executedDate));
                } catch (final Exception ex) {
                        System.out.println("Formato de fecha inválido: " + executedDate);
                }
            }

            if (statusId != null) {
                var status = new StatusDTO();
                status.setId(statusId);
                filter.setStatus(status);
            }

            if (treeId != null) {
                var tree = new co.edu.uco.treepruning.dto.TreeDTO();
                tree.setId(treeId);
                filter.setTree(tree);
            }

            if (quadrilleId != null) {
                var quadrille = new co.edu.uco.treepruning.dto.QuadrilleDTO();
                quadrille.setId(quadrilleId);
                filter.setQuadrille(quadrille);
            }

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
        return new ResponseEntity<Response<PruningDTO>>(responseObjectData, responseStatusCode);
    }
}
