package in.org.cris.cmm.emumaintenance.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmuCoachMasterDTO {

    private Long coachId;
    private String coachNo;
    private String owningRly;
    private String coachType;
    private String coachKind;
    private String coachCategory;
    private String powerGenerationType;
    private String pwdTrcType;
    private String pwdTrcMake;
    private String unitNo;
    private String localCoachNo;
    private String manufacturer;
}
