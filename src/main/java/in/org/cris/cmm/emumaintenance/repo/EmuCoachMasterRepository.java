package in.org.cris.cmm.emumaintenance.repo;

import in.org.cris.cmm.emumaintenance.entity.EmuCoachMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmuCoachMasterRepository extends JpaRepository<EmuCoachMaster, Long> {
}
