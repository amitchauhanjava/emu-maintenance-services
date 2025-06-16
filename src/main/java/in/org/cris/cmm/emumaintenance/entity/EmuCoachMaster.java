package in.org.cris.cmm.emumaintenance.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emu_coach_master")
public class EmuCoachMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coach_id")
    private Long coachId;

    @Column(name = "coach_no")
    private String coachNo;

    @Column(name = "owning_rly")
    private String owningRly;

    @Column(name = "coach_type")
    private String coachType;

    @Column(name = "coach_kind")
    private String coachKind;

    @Column(name = "coach_category")
    private String coachCategory;

    @Column(name = "power_generation_type")
    private String powerGenerationType;

    @Column(name = "pwd_trc_type")
    private String pwdTrcType;

    @Column(name = "pwd_trc_make")
    private String pwdTrcMake;

    @Column(name = "unit_no")
    private String unitNo;

    @Column(name = "local_coach_no")
    private String localCoachNo;

    @Column(name = "manu_facturer")
    private String manufacturer;
}
