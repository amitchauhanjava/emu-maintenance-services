package in.org.cris.cmm.emumaintenance.repo;

import in.org.cris.cmm.emumaintenance.dto.EmuRakeConsistDTO;
import in.org.cris.cmm.emumaintenance.entity.EmuRakeConsists;
import in.org.cris.cmm.emumaintenance.entity.EmuRakeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmuRakeMasterRepository extends JpaRepository<EmuRakeMaster, Long> {

    List<EmuRakeMaster> findByRakeMaintenanceLoc(String depot);

}