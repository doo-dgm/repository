package co.edu.uco.treepruning.business.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.assembler.dto.impl.StatusDTOAssembler;
import co.edu.uco.treepruning.business.business.impl.StatusBusinessImpl;
import co.edu.uco.treepruning.business.domain.StatusDomain;
import co.edu.uco.treepruning.business.facade.StatusFacade;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;
import co.edu.uco.treepruning.dto.StatusDTO;

public final class StatusFacadeImpl implements StatusFacade {

    @Override
    public List<StatusDTO> findAllStatuses() {
        var daoFactory = DAOFactory.getFactory();
        var business = new StatusBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            List<StatusDomain> domainList = business.listAllStatuses();
            return StatusDTOAssembler.getStatusDTOAssembler().toDTO(domainList);

        } catch (final TreePruningException exception) {
            daoFactory.rollbackTransaction();
            throw exception;

        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = "";
            var technicalMessage = "";
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<StatusDTO> findStatusesByFilter(final StatusDTO statusFilters) {
        var daoFactory = DAOFactory.getFactory();
        var business = new StatusBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            var filterDomain = StatusDTOAssembler.getStatusDTOAssembler().toDomain(statusFilters);
            List<StatusDomain> domainList = business.listStatusesByCriteria(filterDomain);
            return StatusDTOAssembler.getStatusDTOAssembler().toDTO(domainList);

        } catch (final TreePruningException exception) {
            daoFactory.rollbackTransaction();
            throw exception;

        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = "";
            var technicalMessage = "";
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public StatusDTO findSpecificStatus(final UUID id) {
        var daoFactory = DAOFactory.getFactory();
        var business = new StatusBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            StatusDomain domain = business.getStatusById(id);
            return StatusDTOAssembler.getStatusDTOAssembler().toDTO(domain);

        } catch (final TreePruningException exception) {
            daoFactory.rollbackTransaction();
            throw exception;

        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = "";
            var technicalMessage = "";
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } finally {
            daoFactory.closeConnection();
        }
    }
}
