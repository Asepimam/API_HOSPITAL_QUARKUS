package hospital.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name = "dokter")
public class Dokter extends AuditModel implements Serializable {
    @Id
    @SequenceGenerator(name = "dokterSeq",sequenceName = "dokter_sequnce",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "dokterSeq",strategy = GenerationType.SEQUENCE)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "full_name",nullable = false,columnDefinition = "varchar(100)")
    private String fullName;

    @Column(name = "is_spesialis",columnDefinition = "boolean")
    private Boolean isSpecialis;

    @Column(name = "spesialis_nama",nullable = false,columnDefinition = "varchar(250)")
    private String specialisName;

    @Column(name = "email",nullable = false,columnDefinition = "varchar(200)")
    private String email;

    @Column(name = "phone_number",nullable = false,columnDefinition = "varchar(13)")
    private String phoneNumber;
    
    @Column(name = "status",columnDefinition = "varchar default ''")
    private String status;

    @Column(name = "gajih",nullable = false,columnDefinition = "bigint")
    private Long gajih;

    public Dokter(String fullName, Boolean isSpecialis, String specialisName, String email, String phoneNumber,
            String status, Long gajih) {
                super();
        this.fullName = fullName;
        this.isSpecialis = isSpecialis;
        this.specialisName = specialisName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.gajih = gajih;
    }

    public Dokter() {
        super();
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getIsSpecialis() {
        return isSpecialis;
    }

    public void setIsSpecialis(Boolean isSpecialis) {
        this.isSpecialis = isSpecialis;
    }

    public String getSpecialisName() {
        return specialisName;
    }

    public void setSpecialisName(String specialisName) {
        this.specialisName = specialisName;
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

    public Long getGajih() {
        return gajih;
    }

    public void setGajih(Long gajih) {
        this.gajih = gajih;
    }

    
}
