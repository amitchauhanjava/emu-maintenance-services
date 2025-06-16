package in.org.cris.cmm.emumaintenance.service;

import in.org.cris.cmm.emumaintenance.dto.EmuCoachMasterDTO;

import java.util.List;

public interface EmuCoachMasterService {

    public EmuCoachMasterDTO saveOrUpdate(EmuCoachMasterDTO emuCoachMasterDTO);

    List<EmuCoachMasterDTO> getEmuList();
}
