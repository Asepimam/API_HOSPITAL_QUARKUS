package hospital.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalTime;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name = "staff")
public class Staff extends AuditModel implements Serializable {
    @Id
    @SequenceGenerator(name = "staffSeq",sequenceName = "staff_sequence",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "staffSeq",strategy = GenerationType.SEQUENCE)

    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "full_name",nullable = false,columnDefinition = "varchar(200)")
    private String name;

    @Column(name = "gender",columnDefinition = "varchar(50)")
    private String gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "posisi",nullable = false,columnDefinition = "varchar(50)")
    private PosisiStaff posisi;

    @Column(name = "start_time",nullable = false,columnDefinition = "timestamp")
    private Timestamp starTime;

    @Column(name = "end_time",nullable = false,columnDefinition = "timestamp")
    private Timestamp endTime;

    @Column(name = "email",nullable = false,columnDefinition = "varchar(250)")
    private String email;

    @Column(name = "phone_number",nullable = false,columnDefinition = "varchar(13)")
    private String phoneNumber;

    @Column(name = "status",nullable = false,columnDefinition = "varchar default ''")
    private String status;

    @Column(name = "gajih",nullable = false,columnDefinition = "bigint")
    private Long gajih;
    // @OneToMany(
    //     mappedBy = "staff",
    //     cascade = CascadeType.ALL,
    //     orphanRemoval = true,
    //     fetch = FetchType.EAGER
    // )
    // Set<DaftarShift>daftarShif = new HashSet<>();

    public Staff(Long id, String name, String gender,PosisiStaff posisi, Timestamp starTime, Timestamp endTime,
            String email, String phoneNumber, String status,Set<DaftarShift> daftarShifts,Long gajih) {
        super();
        this.name = name;
        this.gender = gender;
        this.posisi = posisi;
        this.starTime = starTime;
        this.endTime = endTime;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
        // this.daftarShif = daftarShifts;
        this.gajih = gajih;
    }

    public Staff() {
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

    public PosisiStaff getPosisi() {
        return posisi;
    }

    public void setPosisi(PosisiStaff posisi) {
        this.posisi = posisi;
    }

    public Timestamp getStarTime() {
        return starTime;
    }

    public void setStarTime(Timestamp starTime) {
        this.starTime = starTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // public Set<DaftarShift> getDaftarShif() {
    //     return daftarShif;
    // }

    // public void setDaftarShif(Set<DaftarShift> daftarShif) {
    //     this.daftarShif = daftarShif;
    // }

    public Long getGajih() {
        return gajih;
    }

    public void setGajih(Long gajih) {
        this.gajih = gajih;
    }



}
