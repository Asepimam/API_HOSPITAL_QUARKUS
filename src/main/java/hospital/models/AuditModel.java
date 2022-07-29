package hospital.models;

import java.time.ZonedDateTime;
// import java.util.Date;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@MappedSuperclass
public class AuditModel extends PanacheEntityBase {
    @JsonbDateFormat("dd-MM-YYYY'T'HH:mm:ss")
    @CreationTimestamp
    @Column(name = "create_date_time")
    private ZonedDateTime creaDateTime;
    
    @JsonbDateFormat("dd-MM-YYYY'T'HH:mm:ss")
    @UpdateTimestamp
    @Column(name = "update_date_time")
    private ZonedDateTime updateDateTime;

    public ZonedDateTime getCreaDateTime() {
        return creaDateTime;
    }

    public ZonedDateTime getUpdateDateTime() {
        return updateDateTime;
    }
    
}
