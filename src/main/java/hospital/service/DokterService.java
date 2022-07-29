package hospital.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import hospital.models.Dokter;
import io.quarkus.panache.common.Page;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class DokterService {
    @Inject
    EntityManager em;

    @Transactional
    public Response add(JsonObject params){
        Dokter dokter = new Dokter();

        dokter.setFullName(params.getString("full_name"));
        dokter.setEmail(params.getString("email"));
        dokter.setPhoneNumber(params.getString("phone_number"));
        dokter.setSpecialisName(params.getString("specialis_name"));
        dokter.setIsSpecialis(params.getBoolean("is_specialis"));
        dokter.setStatus(params.getString("status"));
        dokter.setGajih(params.getLong("gajih"));

        dokter.persist();

        return Response.ok(dokter).build();
    }

    public Response get(){
        JsonObject result = new JsonObject();
        List<Dokter> dokters = Dokter.findAll().page(Page.of(0, 10)).list();
        result.put("dokter", dokters);
        return Response.ok(result).build();
    }
    public Response getfilter(Integer maxResult,Integer page,String specialis,String fullName,String email,String phonenNumber){
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT * ");
        sb.append(" FROM hospital.dokter d");
        sb.append(" WHERE TRUE ");

        if(fullName != null){
            sb.append(" AND d.full_name = :full_name ");
        }
        if(email != null){
            sb.append(" AND d.email = :email ");
        }
        if(phonenNumber != null){
            sb.append(" AND d.phone_number = :phone_number ");
        }

        if(specialis != null){
            sb.append(" AND d.specialis_nama = :specialis ");
        }

        sb.append(" ORDER BY d.full_name ASC ");
        Query query = em.createNativeQuery(sb.toString(),Dokter.class);
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
        if(specialis != null){
            query.setParameter("specialis", specialis);
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

        List<Dokter> dokters = query.getResultList();

        JsonObject result = new JsonObject();
        result.put("Dokters", dokters);
        result.put("Jumlah data", dokters.size());
        result.put("Max data", query.getMaxResults());
        result.put("Total", total);
        result.put("CurrentPage", page);
        result.put("Totalpage", totalPage);
        return Response.ok(result).build();
    }
    @Transactional
    public Response update(JsonObject params ,long id){
        Dokter dokter  = Dokter.findById(id);
        if(dokter == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        dokter.setFullName(params.getString("full_name"));
        dokter.setEmail(params.getString("email"));
        dokter.setPhoneNumber(params.getString("phone_number"));
        dokter.setSpecialisName(params.getString("specialis_name"));
        dokter.setIsSpecialis(params.getBoolean("is_specialis"));
        dokter.setStatus(params.getString("status"));
        dokter.setGajih(params.getLong("gajih"));

        dokter.persist();

        return Response.ok(dokter).build();

    }
    @Transactional
    public Response delete(Long id){
        Dokter dokter = Dokter.findById(id);
        if(dokter == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        dokter.delete();
        return Response.ok().build();
    }

}
