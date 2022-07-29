package hospital.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import hospital.models.Pasien;
import io.quarkus.panache.common.Page;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class PasienService {
    @Inject
    EntityManager em;



    public Response get(){
        JsonObject result = new JsonObject();
        List<Pasien> pasiens = Pasien.findAll().page(Page.of(0, 10)).list();
        result.put("pasien", pasiens);
        return Response.ok(result).build();
    }
    public Response getfilter(Integer maxResult,Integer page,String fullName,String email,String phonenNumber){
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT * ");
        sb.append(" FROM hospital.pasien p");
        sb.append(" WHERE TRUE ");

        if(fullName != null){
            sb.append(" AND p.full_name = :full_name ");
        }
        if(email != null){
            sb.append(" AND p.email = :email ");
        }
        if(phonenNumber != null){
            sb.append(" AND p.phone_number = :phone_number ");
        }

        sb.append(" ORDER BY p.full_name ASC ");
        Query query = em.createNativeQuery(sb.toString(),Pasien.class);
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

        List<Pasien> staffs = query.getResultList();

        JsonObject result = new JsonObject();
        result.put("Pasien", staffs);
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
        String address = params.getString("address");
        String email = params.getString("email");
        String phoneNumber = params.getString("phone_number");
        String status = params.getString("status");
        Boolean isCoverBpjs = params.getBoolean("is_cover_bpjs");

        Pasien pasien =new Pasien();
        pasien.setFullName(fullname);
        pasien.setGender(gender);
        pasien.setEmail(email);
        pasien.setPhoneNumber(phoneNumber);
        pasien.setStatus(status);
        pasien.setAddress(address);
        pasien.setIsCoverBpjs(isCoverBpjs);

        pasien.persist();

        return Response.ok().entity(pasien).build();
    }
    @Transactional
    public Response update(JsonObject params,Long id){
        Pasien pasien = Pasien.findById(id);
        if(pasien == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        String fullname = params.getString("full_name");
        String gender = params.getString("gender");
        String address = params.getString("address");
        String email = params.getString("email");
        String phoneNumber = params.getString("phone_number");
        String status = params.getString("status");
        Boolean isCoverBpjs = params.getBoolean("is_cover_bpjs");

        pasien.setFullName(fullname);
        pasien.setGender(gender);
        pasien.setEmail(email);
        pasien.setPhoneNumber(phoneNumber);
        pasien.setStatus(status);
        pasien.setAddress(address);
        pasien.setIsCoverBpjs(isCoverBpjs);

        pasien.persist();

        return Response.ok().entity(pasien).build();

    }
    @Transactional
    public Response delete(Long id){
        Pasien pasien = Pasien.findById(id);
        if(pasien == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        pasien.delete();

        return Response.ok().build();
    }
}
