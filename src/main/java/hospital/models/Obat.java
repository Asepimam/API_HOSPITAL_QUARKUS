package hospital.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "obat")
public class Obat extends AuditModel implements Serializable {
    
    @Id
    @SequenceGenerator(name = "obatSeq",sequenceName = "obat_sequence",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "obatSeq",strategy = GenerationType.SEQUENCE)
    
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "nama_obat",nullable = false,columnDefinition = "varchar(250)")
    private String namaObat;

    @Column(name = "produksi",columnDefinition = "varchar(250)")
    private String produksi;

    @Enumerated(EnumType.STRING)
    @Column(name = "obat_category",nullable = false,columnDefinition = "varchar(250)")
    private CategoryObat obatCategroy;

    @Column(name = "deskripsi",nullable = false,columnDefinition = "varchar(250)")
    private String deskripsi;

    public Obat(String namaObat, String produksi, CategoryObat obatCategroy, String deskripsi) {
        super();
        this.namaObat = namaObat;
        this.produksi = produksi;
        this.obatCategroy = obatCategroy;
        this.deskripsi = deskripsi;
    }

    public Obat() {
        super();
    }

    public Long getId() {
        return id;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public String getProduksi() {
        return produksi;
    }

    public void setProduksi(String produksi) {
        this.produksi = produksi;
    }

    public CategoryObat getObatCategroy() {
        return obatCategroy;
    }

    public void setObatCategroy(CategoryObat obatCategroy) {
        this.obatCategroy = obatCategroy;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
}
