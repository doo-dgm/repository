package co.edu.uco.treepruning.data.dao.entity;

import java.util.UUID;

import co.edu.uco.treepruning.data.dao.CreateDAO;
import co.edu.uco.treepruning.data.dao.DeleteDAO;
import co.edu.uco.treepruning.data.dao.RetrieveDAO;
import co.edu.uco.treepruning.data.dao.UpdateDAO;
import co.edu.uco.treepruning.entity.SectorEntity;

public interface SectorDAO extends CreateDAO<SectorEntity>, RetrieveDAO<SectorEntity, UUID>, UpdateDAO<SectorEntity>,
		DeleteDAO<SectorEntity> {

}
