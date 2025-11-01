package co.edu.uco.treepruning.business.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.assembler.dto.impl.QuadrilleDTOAssembler;
import co.edu.uco.treepruning.business.business.impl.QuadrilleBusinessImpl;
import co.edu.uco.treepruning.business.domain.QuadrilleDomain;
import co.edu.uco.treepruning.business.facade.QuadrilleFacade;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;
import co.edu.uco.treepruning.dto.QuadrilleDTO;

public final class QuadrilleFacadeImpl implements QuadrilleFacade {

    @Override
    public List<QuadrilleDTO> findAllQuadrilles() {
        var daoFactory = DAOFactory.getFactory();
        var business = new QuadrilleBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            List<QuadrilleDomain> domainList = business.findAllQuadrilles();
            return QuadrilleDTOAssembler.getQuadrilleDTOAssembler().toDTO(domainList);

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
    public List<QuadrilleDTO> findQuadrillesByFilter(final QuadrilleDTO quadrilleFilters) {
        var daoFactory = DAOFactory.getFactory();
        var business = new QuadrilleBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            var filterDomain = QuadrilleDTOAssembler.getQuadrilleDTOAssembler().toDomain(quadrilleFilters);
            List<QuadrilleDomain> domainList = business.findQuadrillesByCriteria(filterDomain);
            return QuadrilleDTOAssembler.getQuadrilleDTOAssembler().toDTO(domainList);

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
    public QuadrilleDTO findSpecificQuadrille(final UUID id) {
        var daoFactory = DAOFactory.getFactory();
        var business = new QuadrilleBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            QuadrilleDomain domain = business.getQuadrilleById(id);
            return QuadrilleDTOAssembler.getQuadrilleDTOAssembler().toDTO(domain);

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

