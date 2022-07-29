package hospital.models;
import java.io.Serializable;

import javax.persistence.*;
/**
 * RuangInap
 */
@Entity
@Table(name = "ruang_inap")
public class RuangInap extends AuditModel implements Serializable{
    @Id
    @SequenceGenerator(name = "ruangInapSeq",sequenceName = "ruang_inap_sequence",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "ruangInamSeq",strategy = GenerationType.SEQUENCE)

    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "prefix_ruangan",nullable = false,columnDefinition = "varchar(250)")
    private String prefixRuangan;

    @Column(name = "nomor_ruangan",nullable = false,columnDefinition = "varchar(250)")
    private String nomorRuangan;

    @Column(name = "categori_ruangan",nullable = false,columnDefinition = "varchar(250)")
    private CategoryRuangInap categoryRuang;

    @Column(name = "is_kosong",nullable = false,columnDefinition = "boolean default 'false'")
    private boolean isKosong;

    public RuangInap(String prefixRuangan, String nomorRuangan, CategoryRuangInap categoryRuang, boolean isKosong) {
        super();
        this.prefixRuangan = prefixRuangan;
        this.nomorRuangan = nomorRuangan;
        this.categoryRuang = categoryRuang;
        this.isKosong = isKosong;
    }

    public RuangInap() {
        super();
    }

    public Long getId() {
        return id;
    }

    public String getPrefixRuangan() {
        return prefixRuangan;
    }

    public void setPrefixRuangan(String prefixRuangan) {
        this.prefixRuangan = prefixRuangan;
    }

    public String getNomorRuangan() {
        return nomorRuangan;
    }

    public void setNomorRuangan(String nomorRuangan) {
        this.nomorRuangan = nomorRuangan;
    }

    public CategoryRuangInap getCategoryRuang() {
        return categoryRuang;
    }

    public void setCategoryRuang(CategoryRuangInap categoryRuang) {
        this.categoryRuang = categoryRuang;
    }

    public boolean isKosong() {
        return isKosong;
    }

    public void setKosong(boolean isKosong) {
        this.isKosong = isKosong;
    }
    
}