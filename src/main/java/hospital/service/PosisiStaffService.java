package hospital.service;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;

import hospital.models.PosisiStaff;

@ApplicationScoped
public class PosisiStaffService {
    public Set<PosisiStaff> getall(){
        Set<PosisiStaff> categoryObat2 = PosisiStaff.getall();
        return categoryObat2;
    }
}
