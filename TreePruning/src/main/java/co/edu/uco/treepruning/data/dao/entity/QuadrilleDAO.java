package co.edu.uco.treepruning.data.dao.entity;

import java.util.UUID;

import co.edu.uco.treepruning.data.dao.CreateDAO;
import co.edu.uco.treepruning.data.dao.DeleteDAO;
import co.edu.uco.treepruning.data.dao.RetrieveDAO;
import co.edu.uco.treepruning.data.dao.UpdateDAO;
import co.edu.uco.treepruning.entity.QuadrilleEntity;

public interface QuadrilleDAO
		extends CreateDAO<QuadrilleEntity>, RetrieveDAO<QuadrilleEntity, UUID>, UpdateDAO<QuadrilleEntity>, DeleteDAO<UUID> {

}
