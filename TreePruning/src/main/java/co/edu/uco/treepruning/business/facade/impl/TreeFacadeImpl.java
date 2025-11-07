package co.edu.uco.treepruning.business.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.treepruning.business.assembler.dto.impl.TreeDTOAssembler;
import co.edu.uco.treepruning.business.business.impl.TreeBusinessImpl;
import co.edu.uco.treepruning.business.domain.TreeDomain;
import co.edu.uco.treepruning.business.facade.TreeFacade;
import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.data.dao.factory.DAOFactory;
import co.edu.uco.treepruning.dto.TreeDTO;

public final class TreeFacadeImpl implements TreeFacade {

    @Override
    public List<TreeDTO> findAllTrees() {
        var daoFactory = DAOFactory.getFactory();
        var business = new TreeBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            List<TreeDomain> domainList = business.findAllTrees();
            return TreeDTOAssembler.getTreeDTOAssembler().toDTO(domainList);

        } catch (final TreePruningException exception) {
            daoFactory.rollbackTransaction();
            throw exception;

        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = MessagesEnum.USER_ERROR_TREE_FIND_BY_FILTER_UNEXPECTED.getTitle();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TREE_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<TreeDTO> findTreesByFilter(final TreeDTO treeFilters) {
        var daoFactory = DAOFactory.getFactory();
        var business = new TreeBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            var filterDomain = TreeDTOAssembler.getTreeDTOAssembler().toDomain(treeFilters);
            List<TreeDomain> domainList = business.findTreesByFilter(filterDomain);
            return TreeDTOAssembler.getTreeDTOAssembler().toDTO(domainList);

        } catch (final TreePruningException exception) {
            daoFactory.rollbackTransaction();
            throw exception;

        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = MessagesEnum.USER_ERROR_TREE_FIND_BY_FILTER_UNEXPECTED.getTitle();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TREE_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public TreeDTO findSpecificTree(final UUID id) {
        var daoFactory = DAOFactory.getFactory();
        var business = new TreeBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();
            TreeDomain domain = business.findSpecificTree(id);
            return TreeDTOAssembler.getTreeDTOAssembler().toDTO(domain);

        } catch (final TreePruningException exception) {
            daoFactory.rollbackTransaction();
            throw exception;

        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = MessagesEnum.USER_ERROR_TREE_FIND_BY_FILTER_UNEXPECTED.getTitle();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TREE_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } finally {
            daoFactory.closeConnection();
        }
    }
}