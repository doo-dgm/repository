package co.edu.uco.treepruning.business.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.assembler.dto.impl.AdministratorDTOAssembler;
import co.edu.uco.treepruning.business.business.impl.AdministratorBusinessImpl;
import co.edu.uco.treepruning.business.domain.AdministratorDomain;
import co.edu.uco.treepruning.business.facade.AdministratorFacade;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;
import co.edu.uco.treepruning.dto.AdministratorDTO;

public final class AdministratorFacadeImpl implements AdministratorFacade {

    @Override
    public List<AdministratorDTO> findAllAdministrators() {
        var daoFactory = DAOFactory.getFactory();
        var business = new AdministratorBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            List<AdministratorDomain> domainList = business.findAllAdministrators();

            return AdministratorDTOAssembler.getAdministratorDTOAssembler().toDTO(domainList);

        } catch (final TreePruningException exception) {
            daoFactory.rollbackTransaction();
            throw exception;

        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = MessagesEnum.USER_ERROR_ADMINISTRATOR_FIND_BY_FILTER_UNEXPECTED.getTitle();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ADMINISTRATOR_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<AdministratorDTO> findAdministratorsByFilter(final AdministratorDTO administratorFilters) {
        var daoFactory = DAOFactory.getFactory();
        var business = new AdministratorBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            var filterDomain = AdministratorDTOAssembler.getAdministratorDTOAssembler().toDomain(administratorFilters);
            List<AdministratorDomain> domainList = business.findAdministratorsByFilter(filterDomain);
            return AdministratorDTOAssembler.getAdministratorDTOAssembler().toDTO(domainList);

        } catch (final TreePruningException exception) {
            daoFactory.rollbackTransaction();
            throw exception;

        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = MessagesEnum.USER_ERROR_ADMINISTRATOR_FIND_BY_FILTER_UNEXPECTED.getTitle();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ADMINISTRATOR_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public AdministratorDTO findSpecificAdministrator(final UUID id) {
        var daoFactory = DAOFactory.getFactory();
        var business = new AdministratorBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            AdministratorDomain domain = business.findSpecificAdministrator(id);
            return AdministratorDTOAssembler.getAdministratorDTOAssembler().toDTO(domain);

        } catch (final TreePruningException exception) {
            daoFactory.rollbackTransaction();
            throw exception;

        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = MessagesEnum.USER_ERROR_ADMINISTRATOR_FIND_BY_FILTER_UNEXPECTED.getTitle();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ADMINISTRATOR_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } finally {
            daoFactory.closeConnection();
        }
    }
}