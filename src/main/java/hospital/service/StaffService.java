package hospital.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import hospital.models.PosisiStaff;
import hospital.models.Staff;
import hospital.utils.DateUtil;
import io.quarkus.panache.common.Page;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class StaffService {
    @Inject
    EntityManager em;


    public Response get(){
        JsonObject result = new JsonObject();
        List<Staff> dokters = Staff.findAll().page(Page.of(0, 10)).list();
        result.put("staff", dokters);
        return Response.ok(result).build();
    }
    public Response getfilter(Integer maxResult,Integer page,String fullName,String email,String phonenNumber){
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT * ");
        sb.append(" FROM hospital.staff s");
        sb.append(" WHERE TRUE ");

        if(fullName != null){
            sb.append(" AND s.full_name = :full_name ");
        }
        if(email != null){
            sb.append(" AND s.email = :email ");
        }
        if(phonenNumber != null){
            sb.append(" AND s.phone_number = :phone_number ");
        }

        sb.append(" ORDER BY s.full_name ASC ");
        Query query = em.createNativeQuery(sb.toString(),Staff.class);
        query.setFirstResult(0);
        query.setMaxResults(10);

        if(fullName != null){
            query.setParameter("full_name", fullName);
        }
        if(email != null){
            query.setParameter("email", email);
        }
        if(phonenNumber != null){
            query.setParameter("phone_number", phonenNumber);
        }

        if(maxResult == null|| maxResult == 0){
            query.setMaxResults(10);
        }else{
            query.setMaxResults(maxResult);
        }
        if(page == null || page == 1 ){
            query.setFirstResult(0);
            page = 1;
        }else{
            query.setFirstResult((page - 1)*query.getMaxResults());
        }
        Integer total = query.getResultList().size();

        Integer totalPage = (int) Math.ceil((double) total/(double) query.getMaxResults());

        List<Staff> staffs = query.getResultList();

        JsonObject result = new JsonObject();
        result.put("staffs", staffs);
        result.put("Jumlah data", staffs.size());
        result.put("Max data", query.getMaxResults());
        result.put("Total", total);
        result.put("CurrentPage", page);
        result.put("Totalpage", totalPage);
        return Response.ok(result).build();
    }


    @Transactional
    public Response add(JsonObject params){
        String fullname = params.getString("full_name");
        String gender = params.getString("gender");
        PosisiStaff posisi = PosisiStaff.getPosisiByName(params.getString("posisi"));
        String email = params.getString("email");
        String phoneNumber = params.getString("phone_number");
        String status = params.getString("status");
        Long gajih = params.getLong("gajih");

        if(posisi == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Staff staff = new Staff();
        staff.setName(fullname);
        staff.setGender(gender);
        staff.setPosisi(posisi);
        staff.setGajih(gajih);
        staff.setStarTime(DateUtil.stringToLocalTime(params.getString("start_datetime")));
        staff.setEndTime(DateUtil.stringToLocalTime(params.getString("end_datetime")));
        staff.setEmail(email);
        staff.setPhoneNumber(phoneNumber);
        staff.setStatus(status);

        staff.persist();

        return Response.ok().entity(staff).build();
    }
    @Transactional
    public Response update(JsonObject params,Long id){
        Staff staff = Staff.findById(id);
        if(staff == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        String fullname = params.getString("full_name");
        String gender = params.getString("gender");
        PosisiStaff posisi = PosisiStaff.getPosisiByName(params.getString("posisi"));
        Long gajih = params.getLong("gajih");
        String email = params.getString("email");
        String phoneNumber = params.getString("phone_number");
        String status = params.getString("status");
        if(posisi == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        staff.setName(fullname);
        staff.setGender(gender);
        staff.setPosisi(posisi);
        staff.setStarTime(DateUtil.stringToLocalTime(params.getString("start_datetime")));
        staff.setEndTime(DateUtil.stringToLocalTime(params.getString("end_datetime")));
        staff.setEmail(email);
        staff.setGajih(gajih);
        staff.setPhoneNumber(phoneNumber);
        staff.setStatus(status);

        staff.persist();

        return Response.ok().entity(staff).build();

    }
    @Transactional
    public Response delete(Long id){
        Staff staff = Staff.findById(id);
        if(staff == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        staff.delete();

        return Response.ok().build();
    }


}
