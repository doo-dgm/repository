package co.edu.uco.treepruning.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.treepruning.crosscuting.exception.TreePruningException;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
import co.edu.uco.treepruning.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.treepruning.entity.SectorEntity;

public final class SectorMapper {

    public static SectorEntity map(final ResultSet resultSet) {
        var sector = new SectorEntity();

        try {
           
            var municipality = MunicipalityMapper.map(resultSet);
            sector.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
            sector.setName(resultSet.getString("name"));
            sector.setMunicipality(municipality);

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SECTOR_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SECTOR_MAPPER.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SECTOR_MAPPER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SECTOR_MAPPER_UNEXPECTED.getContent();
            throw TreePruningException.create(exception, userMessage, technicalMessage);
        }

        return sector;
    }
}

