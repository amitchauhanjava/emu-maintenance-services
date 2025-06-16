package in.org.cris.cmm.emumaintenance.service.serviceImpl;

import in.org.cris.cmm.emumaintenance.config.AuthenticationFacade;
import in.org.cris.cmm.emumaintenance.dto.EmuRakeConsistDTO;
import in.org.cris.cmm.emumaintenance.dto.EmuRakeMasterDTO;
import in.org.cris.cmm.emumaintenance.entity.EmuRakeConsists;
import in.org.cris.cmm.emumaintenance.entity.EmuRakeMaster;
import in.org.cris.cmm.emumaintenance.repo.EmuRakeConsistsRepository;
import in.org.cris.cmm.emumaintenance.service.EmuRakeConsistsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmuRakeConsistsServiceImpl implements EmuRakeConsistsService {

    @Autowired
    private EmuRakeConsistsRepository emuRakeConsistsRepository;

    @Autowired
    private AuthenticationFacade authentication;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Save Or Update Rake Consists Record
     * @param emuRakeConsistDTO
     * @return
     */
    @Override
    public EmuRakeConsistDTO saveOrUpdate(EmuRakeConsistDTO emuRakeConsistDTO) {

        String depot =  authentication.getLoggedInUser().getDepot();
        String username = authentication.getLoggedInUser().getUser_name();

        EmuRakeConsists emuRakeConsists;

        if (emuRakeConsistDTO.getId() != null && emuRakeConsistsRepository.existsById(emuRakeConsistDTO.getId())) {
            emuRakeConsists = emuRakeConsistsRepository.findById(emuRakeConsistDTO.getId()).orElse(null);
            if (emuRakeConsists != null) {
                // Update existing record

                if (emuRakeConsistDTO.getRakeId() != null)
                    emuRakeConsists.setRakeId(emuRakeConsistDTO.getRakeId());

                if (emuRakeConsistDTO.getCoachDynId() != null)
                    emuRakeConsists.setCoachDynId(emuRakeConsistDTO.getCoachDynId());

                if (emuRakeConsistDTO.getPosition() != null)
                    emuRakeConsists.setPosition(emuRakeConsistDTO.getPosition());

                if (emuRakeConsistDTO.getIsValid() != null)
                    emuRakeConsists.setIsValid(emuRakeConsistDTO.getIsValid());

                if (emuRakeConsistDTO.getIsDeleted() != null)
                    emuRakeConsists.setIsDeleted(emuRakeConsistDTO.getIsDeleted());

                if (emuRakeConsistDTO.getCoachId() != null)
                    emuRakeConsists.setCoachId(emuRakeConsistDTO.getCoachId());

                if (emuRakeConsistDTO.getConsistId() != null)
                    emuRakeConsists.setConsistId(emuRakeConsistDTO.getConsistId());

                if (emuRakeConsistDTO.getLastSchedule() != null)
                    emuRakeConsists.setLastSchedule(emuRakeConsistDTO.getLastSchedule());

                if (emuRakeConsistDTO.getCurrentSchedule() != null)
                    emuRakeConsists.setCurrentSchedule(emuRakeConsistDTO.getCurrentSchedule());

                if (emuRakeConsistDTO.getScheduleType() != null)
                    emuRakeConsists.setScheduleType(emuRakeConsistDTO.getScheduleType());

                if (emuRakeConsistDTO.getCurrentScheduleStatus() != null)
                    emuRakeConsists.setCurrentScheduleStatus(emuRakeConsistDTO.getCurrentScheduleStatus());

                emuRakeConsists.setUpdatedBy(username);
                emuRakeConsists.setUpdatedOn(new Date());
            }
        } else {
            // Create new record
            emuRakeConsists = modelMapper.map(emuRakeConsistDTO, EmuRakeConsists.class);
            emuRakeConsists.setDepot(depot);
            emuRakeConsists.setCreatedBy(username);
            emuRakeConsists.setCreatedOn(new Date());
        }

        EmuRakeConsists saved = emuRakeConsistsRepository.save(emuRakeConsists);
        return modelMapper.map(saved, EmuRakeConsistDTO.class);
    }

    /**
     * Get List of Emu Rake Consists
     * @return
     */
    @Override
    public List<EmuRakeConsistDTO> getList() {
        String depot =  authentication.getLoggedInUser().getDepot();
        List<EmuRakeConsists> getListByDepot = emuRakeConsistsRepository.findByDepot(depot);

        List<EmuRakeConsistDTO> list = getListByDepot.stream()
                .map(entity -> modelMapper.map(entity, EmuRakeConsistDTO.class))
                .collect(Collectors.toList());
        return list;
    }
}
