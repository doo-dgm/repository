package co.edu.uco.treepruning.business.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.assembler.dto.impl.PQRDTOAssembler;
import co.edu.uco.treepruning.business.business.impl.PQRBusinessImpl;
import co.edu.uco.treepruning.business.domain.PQRDomain;
import co.edu.uco.treepruning.business.facade.PQRFacade;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;
import co.edu.uco.treepruning.dto.PQRDTO;

public final class PQRFacadeImpl implements PQRFacade {

    @Override
    public List<PQRDTO> findAllPQRS() {
        var daoFactory = DAOFactory.getFactory();
        var business = new PQRBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            List<PQRDomain> domainList = business.findAllPQRs();
            return PQRDTOAssembler.getPQRDTOAssembler().toDTO(domainList);

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
    public List<PQRDTO> findPQRSByFilter(final PQRDTO pqrFilters) {
        var daoFactory = DAOFactory.getFactory();
        var business = new PQRBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            var filterDomain = PQRDTOAssembler.getPQRDTOAssembler().toDomain(pqrFilters);
            List<PQRDomain> domainList = business.findPQRsByFilter(filterDomain);
            return PQRDTOAssembler.getPQRDTOAssembler().toDTO(domainList);

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
    public PQRDTO findSpecificPQR(final UUID id) {
        var daoFactory = DAOFactory.getFactory();
        var business = new PQRBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            PQRDomain domain = business.findSpecificPQR(id);
            return PQRDTOAssembler.getPQRDTOAssembler().toDTO(domain);

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

