package hospital.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.*;;

@Entity
@Table(name = "riwayat_penyakit")
public class RiwayatPeyakit extends AuditModel implements Serializable {
    @Id
    @SequenceGenerator(name = "riwayatPenyakitSeq",sequenceName = "riwayat_penyakit_sequence",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "riwayatPenyakitSeq",strategy = GenerationType.SEQUENCE)
    
    @Column(name = "id",nullable = false)
    private Long id;

    @ManyToOne(targetEntity = Pasien.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "pasien_id",nullable = false)
    private Pasien pasien;

    @Column(name = "nama",nullable = false,columnDefinition = "varchar(250)")
    private String nama;

    @Column(name = "deskripsi",nullable = false,columnDefinition = "text")
    private String deskripsi;

    @Column(name = "awal_date",nullable = false,columnDefinition = "timestamp")
    private Timestamp awalDate;

    @Column(name = "sembuh_date",nullable = false,columnDefinition = "timestamp")
    private Timestamp sembuhDate;

    public RiwayatPeyakit(Pasien pasien, String nama, String deskripsi, Timestamp awalDate, Timestamp sembuhDate) {
        super();
        this.pasien = pasien;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.awalDate = awalDate;
        this.sembuhDate = sembuhDate;
    }

    public RiwayatPeyakit() {
        super();
    }

    public Long getId() {
        return id;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Timestamp getAwalDate() {
        return awalDate;
    }

    public void setAwalDate(Timestamp awalDate) {
        this.awalDate = awalDate;
    }

    public Timestamp getSembuhDate() {
        return sembuhDate;
    }

    public void setSembuhDate(Timestamp sembuhDate) {
        this.sembuhDate = sembuhDate;
    }

}
