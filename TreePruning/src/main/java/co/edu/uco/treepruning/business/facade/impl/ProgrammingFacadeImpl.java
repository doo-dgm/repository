package co.edu.uco.treepruning.business.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.assembler.dto.impl.ProgrammingDTOAssembler;
import co.edu.uco.treepruning.business.business.impl.ProgrammingBusinessImpl;
import co.edu.uco.treepruning.business.domain.ProgrammingDomain;
import co.edu.uco.treepruning.business.facade.ProgrammingFacade;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;
import co.edu.uco.treepruning.dto.ProgrammingDTO;

public final class ProgrammingFacadeImpl implements ProgrammingFacade {

    @Override
    public List<ProgrammingDTO> findAllProgrammings() {
        var daoFactory = DAOFactory.getFactory();
        var business = new ProgrammingBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            List<ProgrammingDomain> domainList = business.findAllProgrammings();
            return ProgrammingDTOAssembler.getProgrammingDTOAssembler().toDTO(domainList);

        } catch (final TreePruningException exception) {
            daoFactory.rollbackTransaction();
            throw exception;

        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = "";
            var technicalMessage = "";
            exception.printStackTrace();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<ProgrammingDTO> findProgrammingsByFilter(final ProgrammingDTO programmingFilters) {
        var daoFactory = DAOFactory.getFactory();
        var business = new ProgrammingBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            var filterDomain = ProgrammingDTOAssembler.getProgrammingDTOAssembler().toDomain(programmingFilters);
            List<ProgrammingDomain> domainList = business.findProgrammingsByFilter(filterDomain);
            return ProgrammingDTOAssembler.getProgrammingDTOAssembler().toDTO(domainList);

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
    public ProgrammingDTO findSpecificProgramming(final UUID id) {
        var daoFactory = DAOFactory.getFactory();
        var business = new ProgrammingBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            ProgrammingDomain domain = business.findSpecificProgramming(id);
            return ProgrammingDTOAssembler.getProgrammingDTOAssembler().toDTO(domain);

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

