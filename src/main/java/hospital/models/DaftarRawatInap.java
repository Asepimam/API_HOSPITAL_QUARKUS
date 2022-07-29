package hospital.models;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "daftar_rawat_inap")
public class DaftarRawatInap extends AuditModel implements Serializable {

    @Id
    @SequenceGenerator(name = "daftarRawatInapSeq",sequenceName = "daftar_rawat_inap_sequence",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "daftarRawatInapSeq",strategy = GenerationType.SEQUENCE)

    @Column(name = "id",nullable=false)
    private Long id;

    @ManyToOne(targetEntity = Pasien.class,cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    @JoinColumn(name = "pasien_id",nullable = false)
    private Pasien pasienId;

    @ManyToOne(targetEntity = RuangInap.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "ruang_inap_id",nullable = false)
    private RuangInap ruangInapId;

    @ManyToOne(targetEntity = Perawat.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "perawat_satu_id")
    private Perawat perawatSatuId;

    @ManyToOne(targetEntity = Perawat.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "perawat_duaid")
    private Perawat perawatDuaId;

    @ManyToOne(targetEntity = Dokter.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "dokter_id")
    private Dokter dokterId;

    @Column(name = "start_datetime",nullable = false, columnDefinition = "timestamp")
    private Timestamp startDateTime;

    @Column(name = "end_datetime", columnDefinition = "timestamp")
    private Timestamp endDateTime;

    @Column(name = "is_kosong",nullable = false,columnDefinition = "boolean default 'false'")
    private Boolean isCekout;

    public DaftarRawatInap(Pasien pasienId, RuangInap ruangInapId, Perawat perawatSatuId, Perawat perawatDuaId,
            Timestamp startDateTime, Timestamp endDateTime, Boolean isCekout,Dokter dokterId) {
                super();
        this.pasienId = pasienId;
        this.ruangInapId = ruangInapId;
        this.perawatSatuId = perawatSatuId;
        this.perawatDuaId = perawatDuaId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.isCekout = isCekout;
        this.dokterId = dokterId;
    }

    public DaftarRawatInap() {
        super();
    }

    public Long getId() {
        return id;
    }

    public Pasien getPasienId() {
        return pasienId;
    }

    public void setPasienId(Pasien pasienId) {
        this.pasienId = pasienId;
    }

    public RuangInap getRuangInapId() {
        return ruangInapId;
    }

    public void setRuangInapId(RuangInap ruangInapId) {
        this.ruangInapId = ruangInapId;
    }

    public Perawat getPerawatSatuId() {
        return perawatSatuId;
    }

    public void setPerawatSatuId(Perawat perawatSatuId) {
        this.perawatSatuId = perawatSatuId;
    }

    public Perawat getPerawatDuaId() {
        return perawatDuaId;
    }

    public void setPerawatDuaId(Perawat perawatDuaId) {
        this.perawatDuaId = perawatDuaId;
    }
    public Dokter getDokterId() {
        return dokterId;
    }

    public void setDokterId(Dokter dokterId) {
        this.dokterId = dokterId;
    }
    public Timestamp getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Timestamp startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Timestamp getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Timestamp endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Boolean getIsCekout() {
        return isCekout;
    }

    public void setIsCekout(Boolean isCekout) {
        this.isCekout = isCekout;
    }


}
