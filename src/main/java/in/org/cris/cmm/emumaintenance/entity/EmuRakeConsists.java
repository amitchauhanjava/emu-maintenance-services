package in.org.cris.cmm.emumaintenance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emu_rake_consists")
public class EmuRakeConsists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rake_id")
    private Long rakeId;

    @Column(name = "coach_dyn_id")
    private Long coachDynId;

    @Column(name = "position")
    private Long position;

    @Column(name = "is_valid")
    private Boolean isValid;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "coach_id")
    private Long coachId;

    @Column(name = "consist_id")
    private Long consistId;

    @Column(name = "last_schedule")
    private String lastSchedule;

    @Column(name = "current_schedule")
    private String currentSchedule;

    @Column(name = "schedule_type")
    private String scheduleType;

    @Column(name = "current_schedule_status")
    private String currentScheduleStatus;

    @Column(name = "depot")
    private String depot;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_on")
    private Date updatedOn;
}
