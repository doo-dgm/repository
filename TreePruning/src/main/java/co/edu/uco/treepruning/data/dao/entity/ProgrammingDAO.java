package co.edu.uco.treepruning.data.dao.entity;

import java.util.UUID;

import co.edu.uco.treepruning.data.dao.CreateDAO;
import co.edu.uco.treepruning.data.dao.DeleteDAO;
import co.edu.uco.treepruning.data.dao.RetrieveDAO;
import co.edu.uco.treepruning.data.dao.UpdateDAO;
import co.edu.uco.treepruning.entity.ProgrammingEntity;

public interface ProgrammingDAO 
		extends CreateDAO<ProgrammingEntity>, RetrieveDAO<ProgrammingEntity, UUID>, UpdateDAO<ProgrammingEntity>, DeleteDAO<UUID> {

}
