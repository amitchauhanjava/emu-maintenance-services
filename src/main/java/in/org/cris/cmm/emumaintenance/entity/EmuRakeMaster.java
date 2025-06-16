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
@Table(name = "emu_rake_master")
public class EmuRakeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rake_id")
    private Long rakeId;

    @Column(name = "rake_no")
    private String rakeNo;

    @Column(name = "rake_name")
    private String rakeName;

    @Column(name = "rake_type")
    private String rakeType;

    @Column(name = "number_coach")
    private Long numberCoach;

    @Column(name = "rake_kind")
    private String rakeKind;

    @Column(name = "rake_maintenance_loc")
    private String rakeMaintenanceLoc;

    @Column(name = "manufacture")
    private String manufacture;

    @Column(name = "working_status")
    private String workingStatus;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_on")
    private Date updatedOn;

}
