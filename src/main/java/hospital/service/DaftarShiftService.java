package hospital.service;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import hospital.models.DaftarShift;
import hospital.models.Perawat;
import hospital.models.Staff;
import hospital.utils.DateUtil;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class DaftarShiftService {
    @Inject
    EntityManager em;

    @Transactional
    public Response addShifPerawat(JsonObject params){
        Set<String> hari = new HashSet<>(params.getJsonArray("hari").getList());
        DaftarShift daftarShift = new DaftarShift();
        Perawat perawat = Perawat.findById(params.getLong("perawat_id", -99L));
        if(perawat == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        daftarShift.setCategory(params.getString("category"));
        daftarShift.setPerawat(perawat);
        daftarShift.setStartTime(DateUtil.stringToLocalTime(params.getString("start_datetime")));
        daftarShift.setEndTime(DateUtil.stringToLocalTime(params.getString("end_datetime")));
        daftarShift.setDaftarshift(hari);

        daftarShift.persist();
        return Response.ok(daftarShift).build();

    }
    @Transactional
    public Response addShifStaff(JsonObject params){
        Set<String> hari = new HashSet<>(params.getJsonArray("hari").getList());
        DaftarShift daftarShift = new DaftarShift();
        Staff staff = Staff.findById(params.getLong("staff_id", -99L));
        if(staff == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        daftarShift.setCategory(params.getString("category"));
        daftarShift.setStaff(staff);
        daftarShift.setStartTime(DateUtil.stringToLocalTime(params.getString("start_datetime")));
        daftarShift.setEndTime(DateUtil.stringToLocalTime(params.getString("end_datetime")));
        daftarShift.setDaftarshift(hari);

        daftarShift.persist();
        return Response.ok(daftarShift).build();

    }
    @Transactional
    public Response updateShifStaff(JsonObject params,Long id){
        Set<String> hari = new HashSet<>(params.getJsonArray("hari").getList());
        DaftarShift daftarShift1 = DaftarShift.findById(id);
        if(daftarShift1 == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Staff staff = Staff.findById(params.getLong("staff_id", -99L));
        if(staff == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        daftarShift1.setStaff(staff);
        daftarShift1.setCategory(params.getString("category"));
        daftarShift1.setStartTime(DateUtil.stringToLocalTime(params.getString("start_datetime")));
        daftarShift1.setEndTime(DateUtil.stringToLocalTime(params.getString("start_datetime")));
        daftarShift1.setDaftarshift(hari);

        daftarShift1.persist();
        return Response.ok(daftarShift1).build();

    }
    @Transactional
    public Response updateShifPerawat(JsonObject params,Long id){
        Set<String> hari = new HashSet<>(params.getJsonArray("hari").getList());
        DaftarShift daftarShift1 = DaftarShift.findById(id);
        if(daftarShift1 == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Perawat perawat = Perawat.findById(params.getLong("staff_id", -99L));
        if(perawat == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        daftarShift1.setPerawat(perawat);;
        daftarShift1.setCategory(params.getString("category"));
        daftarShift1.setStartTime(DateUtil.stringToLocalTime(params.getString("start_datetime")));
        daftarShift1.setEndTime(DateUtil.stringToLocalTime(params.getString("start_datetime")));
        daftarShift1.setDaftarshift(hari);

        daftarShift1.persist();
        return Response.ok(daftarShift1).build();

    }
    @Transactional
    public Response delete(long id){
      DaftarShift daftarShift =DaftarShift.findById(id);
      if (daftarShift == null) {
          return Response.status(Response.Status.BAD_REQUEST).build();
      }
      daftarShift.delete();
      return Response.ok().build();
    }
}
