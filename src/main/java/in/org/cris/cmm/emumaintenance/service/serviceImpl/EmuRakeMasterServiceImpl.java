package in.org.cris.cmm.emumaintenance.service.serviceImpl;

import in.org.cris.cmm.emumaintenance.config.AuthenticationFacade;
import in.org.cris.cmm.emumaintenance.dto.EmuRakeMasterDTO;
import in.org.cris.cmm.emumaintenance.entity.EmuRakeMaster;
import in.org.cris.cmm.emumaintenance.repo.EmuRakeMasterRepository;
import in.org.cris.cmm.emumaintenance.service.EmuRakeMasterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmuRakeMasterServiceImpl implements EmuRakeMasterService {

    @Autowired
    private EmuRakeMasterRepository emuRakeMasterRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthenticationFacade authentication;

    /**
     * Save Or Update EMU Rake Master
     * @param emuRakeMasterDTO
     * @return
     */
    @Override
    public EmuRakeMasterDTO saveOrUpdate(EmuRakeMasterDTO emuRakeMasterDTO) {

        String depot =  authentication.getLoggedInUser().getDepot();
        String username = authentication.getLoggedInUser().getUser_name();
        EmuRakeMaster entity;

        if (emuRakeMasterDTO.getRakeId() != null && emuRakeMasterRepository.existsById(emuRakeMasterDTO.getRakeId())) {
            entity = emuRakeMasterRepository.findById(emuRakeMasterDTO.getRakeId()).orElse(null);
            if (entity != null) {

                if (emuRakeMasterDTO.getRakeNo() != null)
                    entity.setRakeNo(emuRakeMasterDTO.getRakeNo());

                if (emuRakeMasterDTO.getRakeName() != null)
                    entity.setRakeName(emuRakeMasterDTO.getRakeName());

                if (emuRakeMasterDTO.getRakeType() != null)
                    entity.setRakeType(emuRakeMasterDTO.getRakeType());

                if (emuRakeMasterDTO.getNumberCoach() != null)
                    entity.setNumberCoach(emuRakeMasterDTO.getNumberCoach());

                if (emuRakeMasterDTO.getRakeKind() != null)
                    entity.setRakeKind(emuRakeMasterDTO.getRakeKind());

                if (emuRakeMasterDTO.getRakeMaintenanceLoc() != null)
                    entity.setRakeMaintenanceLoc(depot);

                if (emuRakeMasterDTO.getManufacture() != null)
                    entity.setManufacture(emuRakeMasterDTO.getManufacture());

                if (emuRakeMasterDTO.getWorkingStatus() != null)
                    entity.setWorkingStatus(emuRakeMasterDTO.getWorkingStatus());

                if (emuRakeMasterDTO.getRemarks() != null)
                    entity.setRemarks(emuRakeMasterDTO.getRemarks());

                entity.setUpdatedBy(username);

                entity.setUpdatedOn(new Date());
            }
        } else {
            // Create new record
            entity = modelMapper.map(emuRakeMasterDTO, EmuRakeMaster.class);
            entity.setRakeMaintenanceLoc(depot);
            entity.setCreatedBy(username);
            entity.setCreatedOn(new Date());
        }

        EmuRakeMaster saved = emuRakeMasterRepository.save(entity);
        return modelMapper.map(saved, EmuRakeMasterDTO.class);
    }

    /**
     * Return list of Emu Rake Master By Logged User Depot
     * @param depot
     * @return
     */
    @Override
    public List<EmuRakeMasterDTO> getList() {

        String depot =  authentication.getLoggedInUser().getDepot();
        List<EmuRakeMaster> getListByDepot = emuRakeMasterRepository.findByRakeMaintenanceLoc(depot);

        List<EmuRakeMasterDTO> list = getListByDepot.stream()
                .map(entity -> modelMapper.map(entity, EmuRakeMasterDTO.class))
                .collect(Collectors.toList());
        return list;
    }
}
