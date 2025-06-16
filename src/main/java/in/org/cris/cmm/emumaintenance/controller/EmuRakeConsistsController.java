package in.org.cris.cmm.emumaintenance.controller;

import in.org.cris.cmm.emumaintenance.dto.EmuRakeConsistDTO;
import in.org.cris.cmm.emumaintenance.service.EmuRakeConsistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rakeconsists")
public class EmuRakeConsistsController {

    @Autowired
    private EmuRakeConsistsService emuRakeConsistsService;

    /**
     * Save Or Update Rake Consist Record
     * @param emuRakeConsistDTO
     * @return
     */
    @PostMapping("/saveOrUpdate")
    public ResponseEntity<EmuRakeConsistDTO> saveOrUpdate(@RequestBody EmuRakeConsistDTO emuRakeConsistDTO) {

        EmuRakeConsistDTO save = emuRakeConsistsService.saveOrUpdate(emuRakeConsistDTO);
        return ResponseEntity.ok(save);
    }

    /**
     * Retrieve Rake Consist Records
     * @return
     */
    @GetMapping("/getRakeConsistsList")
    public ResponseEntity<List<EmuRakeConsistDTO>> getRakeConsistsList() {

        List<EmuRakeConsistDTO> list = emuRakeConsistsService.getList();
        return ResponseEntity.ok(list);
    }

}
