package hospital.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.*;
@Entity
@Table(name="daftar_pertemuan")
class DaftarPertemuan extends AuditModel implements Serializable {
  @Id
  @SequenceGenerator(name = "daftarPertemuanSeq",sequenceName="daftar_pertemuan_sequence",initialValue=1,allocationSize=1)
  @GeneratedValue(generator="daftarPertemuanSeq",strategy=GenerationType.SEQUENCE)

  @Column(name="id",nullable=false)
  private Long id;

  @ManyToOne(targetEntity = Dokter.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  @JoinColumn(name = "dokter_id",nullable = false)
  private Dokter dokterId;

  @ManyToOne(targetEntity = Pasien.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  @JoinColumn(name = "pasien_id",nullable = false)
  private Pasien pasienId;

  @Column(name = "categori",nullable = false,columnDefinition = "varchar(250)")
  private String category;

  @Column(name = "deskripsi",nullable = false,columnDefinition = "text")
  private String deskripsi;

  @Column(name = "tanggal",nullable = false,columnDefinition = "timestamp")
  private Timestamp tanggal;

  public DaftarPertemuan(Dokter dokterId, Pasien pasienId, String category, String deskripsi, Timestamp tanggal) {
    super();
    this.dokterId = dokterId;
    this.pasienId = pasienId;
    this.category = category;
    this.deskripsi = deskripsi;
    this.tanggal = tanggal;
  }

  public DaftarPertemuan() {
    super();
  }

  public Long getId() {
    return id;
  }

  public Dokter getDokterId() {
    return dokterId;
  }

  public void setDokterId(Dokter dokterId) {
    this.dokterId = dokterId;
  }

  public Pasien getPasienId() {
    return pasienId;
  }

  public void setPasienId(Pasien pasienId) {
    this.pasienId = pasienId;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getDeskripsi() {
    return deskripsi;
  }

  public void setDeskripsi(String deskripsi) {
    this.deskripsi = deskripsi;
  }

  public Timestamp getTanggal() {
    return tanggal;
  }

  public void setTanggal(Timestamp tanggal) {
    this.tanggal = tanggal;
  }


}
