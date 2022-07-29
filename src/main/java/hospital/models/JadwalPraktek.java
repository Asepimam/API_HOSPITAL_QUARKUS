package hospital.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.*;


@Entity
@Table(name = "jadwal_praktek")
public class JadwalPraktek extends AuditModel implements Serializable{
    @Id
    @SequenceGenerator(name = "jadwalPraktekSeq",sequenceName = "jadwal_prakte_sequence",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "jadwalPraktekSeq",strategy = GenerationType.SEQUENCE)

    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "hari",nullable = false,columnDefinition = "varchar(200)")
    private String hari;

    @Column(name = "start_time",nullable = false,columnDefinition = "timestamp")
    private Timestamp starttime;

    @Column(name = "end_time",nullable = false,columnDefinition = "timestamp")
    private Timestamp endTime;

    @Column(name = "deskripsi",nullable = false,columnDefinition = "varchar(250)")
    private String deskripsi;

    @ManyToOne(targetEntity = Dokter.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "dokter_id",nullable = false)
    private Dokter dokterId;

    public JadwalPraktek(String hari, Timestamp starttime, Timestamp endTime, String deskripsi,
            Dokter dokterId) {
                super();
        this.hari = hari;
        this.starttime = starttime;
        this.endTime = endTime;
        this.deskripsi = deskripsi;
        this.dokterId = dokterId;
    }

    public JadwalPraktek() {
        super();
    }

    public Long getId() {
        return id;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Dokter getDokterId() {
        return dokterId;
    }

    public void setDokterId(Dokter dokterId) {
        this.dokterId = dokterId;
    }


}
