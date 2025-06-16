package in.org.cris.cmm.emumaintenance.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmuRakeMasterDTO {
    private Long rakeId;
    private String rakeNo;
    private String rakeName;
    private String rakeType;
    private Long numberCoach;
    private String rakeKind;
    private String rakeMaintenanceLoc;
    private String manufacture;
    private String workingStatus;
    private String remarks;
    private String createdBy;
    private Date createdOn;
    private String updatedBy;
    private Date updatedOn;
}
