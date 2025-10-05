package co.edu.uco.treepruning.business.domain;

import java.util.UUID;
import co.edu.uco.treepruning.crosscuting.helper.UUIDHelper;
	class Domain {

		private UUID id;
		
		protected Domain (final UUID id) {
			setId(id);
		}

		public UUID getId() {
			return id;
		}

		public void setId(UUID id) {
			this.id = UUIDHelper.getUUIDHelper().getDefault(id);
		}
}
