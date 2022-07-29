package hospital.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import hospital.models.Perawat;
import io.quarkus.panache.common.Page;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class PerawatService {
    @Inject
    EntityManager em;

    @Transactional
    public Response add(JsonObject params){
        Perawat perawat = new Perawat();

        perawat.setName(params.getString("full_name"));
        perawat.setEmail(params.getString("email"));
        perawat.setPhoneNumber(params.getString("phone_number"));
        perawat.setGender(params.getString("gender"));
        perawat.setGajih(params.getLong("gajih"));
        perawat.setStatus(params.getString("status"));

        perawat.persist();

        return Response.ok(perawat).build();
    }

    public Response get(){
        JsonObject result = new JsonObject();
        List<Perawat> perawats = Perawat.findAll().page(Page.of(0, 10)).list();
        result.put("perawat", perawats);
        return Response.ok(result).build();
    }
    public Response getfilter(Integer maxResult,Integer page,String fullName,String email,String phonenNumber){
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT * ");
        sb.append(" FROM hospital.perawat p");
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
        Query query = em.createNativeQuery(sb.toString(),Perawat.class);
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

        List<Perawat> perawats = query.getResultList();

        JsonObject result = new JsonObject();
        result.put("perawats", perawats);
        result.put("Jumlah data", perawats.size());
        result.put("Max data", query.getMaxResults());
        result.put("Total", total);
        result.put("CurrentPage", page);
        result.put("Totalpage", totalPage);
        return Response.ok(result).build();
    }
    @Transactional
    public Response update(JsonObject params ,long id){
        Perawat dokter  = Perawat.findById(id);
        if(dokter == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        dokter.setName(params.getString("full_name"));
        dokter.setEmail(params.getString("email"));
        dokter.setPhoneNumber(params.getString("phone_number"));
        dokter.setGender(params.getString("gender"));
        dokter.setGajih(params.getLong("gajih"));
        dokter.setStatus(params.getString("status"));

        dokter.persist();

        return Response.ok(dokter).build();

    }
    @Transactional
    public Response delete(Long id){
        Perawat perawat = Perawat.findById(id);
        if(perawat == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        perawat.delete();
        return Response.ok().build();
    }

}
