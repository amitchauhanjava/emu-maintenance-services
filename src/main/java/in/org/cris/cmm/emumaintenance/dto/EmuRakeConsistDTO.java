package in.org.cris.cmm.emumaintenance.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmuRakeConsistDTO {
    private Long id;
    private Long rakeId;
    private Long coachDynId;
    private Long position;
    private String createdBy;
    private Date createdOn;
    private String updatedBy;
    private Date updatedOn;
    private Boolean isValid;
    private Boolean isDeleted;
    private Long coachId;
    private Long consistId;
    private String depot;
    private String lastSchedule;
    private String currentSchedule;
    private String scheduleType;
    private String currentScheduleStatus;

}
