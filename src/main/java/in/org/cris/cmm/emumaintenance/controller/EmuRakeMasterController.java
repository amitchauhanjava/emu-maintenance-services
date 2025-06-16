package in.org.cris.cmm.emumaintenance.controller;

import in.org.cris.cmm.emumaintenance.dto.EmuRakeMasterDTO;
import in.org.cris.cmm.emumaintenance.service.EmuRakeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rakemaster")
public class EmuRakeMasterController {

    @Autowired
    private EmuRakeMasterService emuRakeMasterService;

    /**
     * Save Or Update Emu Rake Master
     * @param emuRakeMasterDTO
     * @return sddsds
     */
    @PostMapping("/saveOrUpdate")
    public ResponseEntity<EmuRakeMasterDTO> saveOrUpdate(@RequestBody EmuRakeMasterDTO emuRakeMasterDTO) {

        EmuRakeMasterDTO saveRecord = emuRakeMasterService.saveOrUpdate(emuRakeMasterDTO);
        return ResponseEntity.ok(saveRecord);
    }

    @GetMapping("/getEmuRakeMasterList")
    public ResponseEntity<List<EmuRakeMasterDTO>> getEmuRakeMasterList() {

        List<EmuRakeMasterDTO> list = emuRakeMasterService.getList();
        return ResponseEntity.ok(list);
    }

}
