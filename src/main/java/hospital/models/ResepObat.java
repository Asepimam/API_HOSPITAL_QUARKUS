package hospital.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name="resep_obat")
class ResepObat extends AuditModel implements Serializable {
  @Id
  @SequenceGenerator(name="resepSeq",sequenceName="resep_obat_sequence",initialValue=1,allocationSize=1)
  @GeneratedValue(generator="resepSeq",strategy=GenerationType.SEQUENCE)

  @Column(name="id",nullable=false)
  private Long id;

  @ManyToOne(targetEntity=DaftarPertemuan.class,cascade = CascadeType.ALL,fetch=FetchType.EAGER)
  @JoinColumn(name = "pertemuan_id",nullable=false)
  private DaftarPertemuan pertemuanId;

  @ManyToOne(targetEntity = Obat.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  @JoinColumn(name = "obat_id",nullable = false)
  private Obat obatid;

  @Column(name = "dosis",nullable = false,columnDefinition = "varchar(250)")
  private String dosis;

  @Column(name = "deskripsi",nullable =false,columnDefinition = "text")
  private String deskripsi;

  public ResepObat(Long id, DaftarPertemuan pertemuanId, String dosis, String deskripsi,Obat obatId) {
    super();
    this.pertemuanId = pertemuanId;
    this.dosis = dosis;
    this.deskripsi = deskripsi;
    this.obatid = obatId;
  }

  public ResepObat() {
    super();
  }

  public Long getId() {
    return id;
  }

  public String getDosis() {
    return dosis;
  }

  public void setDosis(String dosis) {
    this.dosis = dosis;
  }

  public String getDeskripsi() {
    return deskripsi;
  }

  public void setDeskripsi(String deskripsi) {
    this.deskripsi = deskripsi;
  }

  public DaftarPertemuan getPertemuanId() {
    return pertemuanId;
  }

  public void setPertemuanId(DaftarPertemuan pertemuanId) {
    this.pertemuanId = pertemuanId;
  }

  public Obat getObatid() {
    return obatid;
  }

  public void setObatid(Obat obatid) {
    this.obatid = obatid;
  }

}

