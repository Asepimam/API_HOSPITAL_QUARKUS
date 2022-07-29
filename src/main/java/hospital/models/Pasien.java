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
@Table(name = "pasien")
public class Pasien extends AuditModel implements Serializable {
    @Id
    @SequenceGenerator(name = "pasienSeq",sequenceName = "pasien_sequence",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "pasienSeq",strategy = GenerationType.SEQUENCE)
    @Column(name = "id",nullable = false)
    private Long Id;

    @Column(name = "full_name",nullable = false,columnDefinition = "varchar(100)")
    private String fullName;

    @Column(name = "gender",nullable = false,columnDefinition = "varchar default ''")
    private String gender;

    @Column(name = "status",nullable = false,columnDefinition = "varchar(250)")
    private String status;

    @Column(name = "address",nullable = false,columnDefinition = "varchar(250)")
    private String address;

    @Column(name = "phone_number",nullable = false,columnDefinition = "varchar(13)")
    private String phoneNumber;
    
    @Column(name = "email",columnDefinition = "varchar(250)")
    private String email;

    @Column(name = "is_cover_bpjs",nullable = false,columnDefinition = "boolean")
    private Boolean isCoverBpjs;

    public Pasien(String fullName, String gender, String status, String address, String phoneNumber, String email,
            Boolean isCoverBpjs) {
                super();
        this.fullName = fullName;
        this.gender = gender;
        this.status = status;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isCoverBpjs = isCoverBpjs;
    }

    public Pasien() {
        super();
    }

    public Long getId() {
        return Id;
    }
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsCoverBpjs() {
        return isCoverBpjs;
    }

    public void setIsCoverBpjs(Boolean isCoverBpjs) {
        this.isCoverBpjs = isCoverBpjs;
    }
    

    
    
}
