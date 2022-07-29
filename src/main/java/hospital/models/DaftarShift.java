package hospital.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import javax.persistence.GenerationType;
import javax.persistence.ForeignKey;
/**
 * Daftar_shift
 */
@Entity
@Table(name = "daftar_shift")
public class DaftarShift extends AuditModel implements Serializable{
    @Id
    @SequenceGenerator(name = "daftarSeq",sequenceName = "daftar_shift",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "daftaSeq",strategy = GenerationType.SEQUENCE)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "category",nullable = false,columnDefinition = "varchar(250)")
    private String category;

    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perawat_id", foreignKey = @ForeignKey(name = "perawat_id_fk"))
    private Perawat perawat;

    @JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", foreignKey = @ForeignKey(name = "staff_id_fk"))
    private Staff staff;

    @Column(name="start_time",columnDefinition = "timestamp")
    private Timestamp startTime;

    @Column(name = "end_time",columnDefinition = "timestamp")
    private Timestamp endTime;

    @ElementCollection
    @CollectionTable(name = "daftar_shift_hari",joinColumns = @JoinColumn(name = "daftar_shift_id"))
    @Column(name = "hari")
    Set<String>daftarshift = new HashSet<>();

    public DaftarShift(Long id, String category, Timestamp startTime, Timestamp endTime) {
        super();
        this.id = id;
        this.category = category;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public DaftarShift() {
        super();
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Set<String> getDaftarshift() {
        return daftarshift;
    }

    public void setDaftarshift(Set<String> daftarshift) {
        this.daftarshift = daftarshift;
    }

    public Perawat getPerawat() {
        return perawat;
    }

    public void setPerawat(Perawat perawat) {
        this.perawat = perawat;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }



}
