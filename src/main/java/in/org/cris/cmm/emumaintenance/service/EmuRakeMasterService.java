package in.org.cris.cmm.emumaintenance.service;

import in.org.cris.cmm.emumaintenance.dto.EmuRakeMasterDTO;

import java.util.List;

public interface EmuRakeMasterService {

    public EmuRakeMasterDTO saveOrUpdate(EmuRakeMasterDTO emuRakeMasterDTO);

    public List<EmuRakeMasterDTO> getList();

}