package in.org.cris.cmm.emumaintenance.service;

import in.org.cris.cmm.emumaintenance.dto.EmuRakeConsistDTO;

import java.util.List;

public interface EmuRakeConsistsService {

    public EmuRakeConsistDTO saveOrUpdate(EmuRakeConsistDTO emuRakeConsistDTO);

    public List<EmuRakeConsistDTO> getList();
}
