package co.edu.uco.treepruning.controller;

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

import co.edu.uco.treepruning.business.facade.impl.TreeFacadeImpl;
import co.edu.uco.treepruning.controller.dto.Response;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.TextHelper;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.dto.TreeDTO;
import co.edu.uco.treepruning.dto.FamilyDTO;
import co.edu.uco.treepruning.dto.SectorDTO;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/trees")
public class TreeController {

	@GetMapping("/dummy")
	public TreeDTO dummy() {
		return new TreeDTO();
	}

    @GetMapping
    public ResponseEntity<Response<TreeDTO>> findTrees(
            @RequestParam(required = false) UUID id,
            @RequestParam(required = false) String longitude,
            @RequestParam(required = false) String latitude,
            @RequestParam(required = false) UUID familyId,
            @RequestParam(required = false) UUID sectorId
    ) {
        Response<TreeDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new TreeFacadeImpl();
            TreeDTO filter = new TreeDTO();
            filter.setId(UUIDHelper.getUUIDHelper().getDefault(id));
            filter.setLongitude(TextHelper.getDefaultWithTrim(longitude));
            filter.setLatitude(TextHelper.getDefaultWithTrim(latitude));

            FamilyDTO family = new FamilyDTO();
            family.setId(UUIDHelper.getUUIDHelper().getDefault(familyId));
            filter.setFamily(family);

            SectorDTO sector = new SectorDTO();
            sector.setId(UUIDHelper.getUUIDHelper().getDefault(sectorId));
            filter.setSector(sector);

            responseObjectData.setData(facade.findTreesByFilter(filter));
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

        return new ResponseEntity<Response<TreeDTO>>(responseObjectData, responseStatusCode);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<TreeDTO>> findSpecificTree(@PathVariable UUID id) {

        Response<TreeDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new TreeFacadeImpl();

            responseObjectData.setData(List.of(facade.findSpecificTree(id)));
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

        return new ResponseEntity<Response<TreeDTO>>(responseObjectData, responseStatusCode);
    }
}


