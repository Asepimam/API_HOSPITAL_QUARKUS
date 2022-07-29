package hospital.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;;

@Entity
@Table(name = "perawat")
public class Perawat extends AuditModel implements Serializable{
    @Id
    @SequenceGenerator(name = "perawatSeq",sequenceName = "perawat_sequence",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "perawatSeq",strategy = GenerationType.SEQUENCE)

    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "full_name",nullable = false,columnDefinition = "varchar(200)")
    private String name;

    @Column(name = "gender",columnDefinition = "varchar(50)")
    private String gender;

    @Column(name = "email",nullable = false,columnDefinition = "varchar(250)")
    private String email;

    @Column(name = "phone_number",nullable = false,columnDefinition = "varchar(13)")
    private String phoneNumber;

    @Column(name = "gajih",nullable = false)
    private Long gajih;

    @Column(name = "status",nullable = false,columnDefinition = "varchar default ''")
    private String status;
    // @OneToMany(
    //     mappedBy = "perawat",
    //     cascade = CascadeType.ALL,
    //     orphanRemoval = true
    // )
    // Set<DaftarShift>daftarShifts = new HashSet<>();

    public Perawat(String name, String gender, String email, String phoneNumber, Long gajih, String status,Set<DaftarShift> daftarShifts) {
        super();
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gajih = gajih;
        this.status = status;
        // this.daftarShifts=daftarShifts;
    }

    public Perawat() {
        super();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getGajih() {
        return gajih;
    }

    public void setGajih(Long gajih) {
        this.gajih = gajih;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // public Set<DaftarShift> getDaftarShifts() {
    //     return daftarShifts;
    // }

    public void setId(Long id) {
        this.id = id;
    }

    // public void setDaftarShifts(Set<DaftarShift> daftarShifts) {
    //     this.daftarShifts = daftarShifts;
    // }
}
