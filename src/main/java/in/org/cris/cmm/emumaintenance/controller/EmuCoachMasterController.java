package in.org.cris.cmm.emumaintenance.controller;

import in.org.cris.cmm.emumaintenance.dto.EmuCoachMasterDTO;
import in.org.cris.cmm.emumaintenance.entity.EmuCoachMaster;
import in.org.cris.cmm.emumaintenance.service.EmuCoachMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emumaintenance")
public class EmuCoachMasterController {

    @Autowired
    private EmuCoachMasterService coachMasterService;

    @PostMapping("/save")
    public ResponseEntity<EmuCoachMasterDTO> saveOrUpdate(@RequestBody EmuCoachMasterDTO dto) {
        EmuCoachMasterDTO savedDto = coachMasterService.saveOrUpdate(dto);
        return ResponseEntity.ok(savedDto);
    }

    @GetMapping("/list")
    public List<EmuCoachMasterDTO> getList() {
        List<EmuCoachMasterDTO> recordList = coachMasterService.getEmuList();

        return recordList;
    }

}
