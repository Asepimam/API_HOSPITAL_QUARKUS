package hospital.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "users")
public class User extends AuditModel implements Serializable {
    @Id
    @SequenceGenerator(name = "userSeq",sequenceName = "user_sequences",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "userSeq",strategy = GenerationType.SEQUENCE)

    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "name",nullable = false,columnDefinition = "varchar(200)")
    private String name;

    @Column(name = "user_name",nullable = false,columnDefinition = "varchar(250)")
    private String userName;

    @Column(name = "password",nullable = false,columnDefinition = "varchar(250)")
    private String password;

    @Column(name = "email",nullable = false,columnDefinition = "varchar default ''")
    private String email;

    @Column(name = "phone_number",nullable = false,columnDefinition = "varchar(13)")
    private String phoneNumber;

    @Column(name = "user_type",nullable = false,columnDefinition = "varchar(250)")
    private String userType;

    @ElementCollection
    @CollectionTable(name = "user_permission",joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "name",nullable = false)
    Set<String>roles = new HashSet<>();
    // @ManyToMany(fetch = FetchType.LAZY)
    // @JoinTable(name = "user_roles",
    //         joinColumns = @JoinColumn(name = "user_id"),
    //         inverseJoinColumns = @JoinColumn(name = "role_id"))
    // private Set<Role> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phone_number;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String user_type) {
        this.userType = user_type;
    }
    public User() {
        super();
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public User(String name, String userName, String password, String email, String phoneNumber, String userType,
            Set<String> roles) {
                super();
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.roles = roles;
    }


}
