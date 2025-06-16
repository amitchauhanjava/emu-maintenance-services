package in.org.cris.cmm.emumaintenance.service.serviceImpl;

import in.org.cris.cmm.emumaintenance.config.ModelMapperConfig;
import in.org.cris.cmm.emumaintenance.dto.EmuCoachMasterDTO;
import in.org.cris.cmm.emumaintenance.entity.EmuCoachMaster;
import in.org.cris.cmm.emumaintenance.repo.EmuCoachMasterRepository;
import in.org.cris.cmm.emumaintenance.service.EmuCoachMasterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmuCoachMasterServiceImpl implements EmuCoachMasterService {

    @Autowired
    private EmuCoachMasterRepository coachMasterRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Save or Update record
     * @param dto
     * @return
     */
    @Override
    public EmuCoachMasterDTO saveOrUpdate(EmuCoachMasterDTO dto) {
        EmuCoachMaster entity;

        if (dto.getCoachId() != null && coachMasterRepository.existsById(dto.getCoachId())) {
            EmuCoachMaster existing = coachMasterRepository.findById(dto.getCoachId()).orElse(null);
            if (existing != null) {

                if (dto.getCoachNo() != null) existing.setCoachNo(dto.getCoachNo());
                if (dto.getOwningRly() != null) existing.setOwningRly(dto.getOwningRly());
                if (dto.getCoachType() != null) existing.setCoachType(dto.getCoachType());
                if (dto.getCoachKind() != null) existing.setCoachKind(dto.getCoachKind());
                if (dto.getCoachCategory() != null) existing.setCoachCategory(dto.getCoachCategory());
                if (dto.getPowerGenerationType() != null) existing.setPowerGenerationType(dto.getPowerGenerationType());
                if (dto.getPwdTrcType() != null) existing.setPwdTrcType(dto.getPwdTrcType());
                if (dto.getPwdTrcMake() != null) existing.setPwdTrcMake(dto.getPwdTrcMake());
                if (dto.getUnitNo() != null) existing.setUnitNo(dto.getUnitNo());
                if (dto.getLocalCoachNo() != null) existing.setLocalCoachNo(dto.getLocalCoachNo());
                if (dto.getManufacturer() != null) existing.setManufacturer(dto.getManufacturer());

                entity = existing;
            } else {
                entity = modelMapper.map(dto, EmuCoachMaster.class);
            }
        } else {
            entity = modelMapper.map(dto, EmuCoachMaster.class);
            entity.setCoachId(null);
        }

        EmuCoachMaster saved = coachMasterRepository.save(entity);
        return modelMapper.map(saved, EmuCoachMasterDTO.class);
    }

    /**
     * Retrieve list of emu maintenance
     * @return
     */
    @Override
    public List<EmuCoachMasterDTO> getEmuList() {

        List<EmuCoachMaster> entityList = coachMasterRepository.findAll();

        List<EmuCoachMasterDTO> list = entityList.stream()
                .map(entity -> modelMapper.map(entity, EmuCoachMasterDTO.class))
                .collect(Collectors.toList());
        return list;

    }
}
