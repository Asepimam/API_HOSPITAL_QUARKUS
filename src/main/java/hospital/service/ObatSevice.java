package hospital.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import hospital.models.CategoryObat;
import hospital.models.Obat;
import io.quarkus.panache.common.Page;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class ObatSevice {
    @Inject
    EntityManager em;

    @Transactional
    public Response add(JsonObject params){
        Obat obat = new Obat();
        obat.setNamaObat(params.getString("nama_obat"));
        obat.setProduksi(params.getString("produksi"));
        obat.setObatCategroy(CategoryObat.getPosisiByName(params.getString("categori_obat")));
        obat.setDeskripsi(params.getString("deskripsi"));

        obat.persist();

        return Response.ok(obat).build();
    }
    @Transactional
    public Response update(JsonObject params,long id){
        Obat obat = Obat.findById(id);
        if (obat ==null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        obat.setNamaObat(params.getString("nama_obat"));
        obat.setProduksi(params.getString("produksi"));
        obat.setObatCategroy(CategoryObat.getPosisiByName(params.getString("categori_obat")));
        obat.setDeskripsi(params.getString("deskripsi"));

        obat.persist();

        return Response.ok(obat).build();
    }
    @Transactional
    public Response delete(long id){
        Obat obat = Obat.findById(id);
        if (obat ==null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        obat.delete();
        return Response.ok().build();
    }
    public Response get(){
        JsonObject result = new JsonObject();
        List<Obat> obats = Obat.findAll().page(Page.of(0, 10)).list();
        result.put("obat", obats);
        return Response.ok(result).build();
    }
    public Response getfilter(Integer maxResult,Integer page,String kategori,String produksi,String nama){
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT * ");
        sb.append(" FROM hospital.obat o");
        sb.append(" WHERE TRUE ");

        if(kategori != null){
            sb.append(" AND o.obat_category = :obat_category ");
        }
        if(produksi != null){
            sb.append(" AND o.produksi = :produksi ");
        }
        if(nama != null){
            sb.append(" AND o.nama_obat = :nama_obat ");
        }

        sb.append(" ORDER BY o.nama_obat ASC ");
        Query query = em.createNativeQuery(sb.toString(),Obat.class);
        query.setFirstResult(0);
        query.setMaxResults(10);

        if(kategori != null){
            query.setParameter("obat_category", kategori);
        }
        if(produksi != null){
            query.setParameter("produksi",produksi);
        }
        if(nama != null){
            query.setParameter("nama_obat", nama);
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

        List<Obat> obats = query.getResultList();

        JsonObject result = new JsonObject();
        result.put("obats", obats);
        result.put("Jumlah data", obats.size());
        result.put("Max data", query.getMaxResults());
        result.put("Total", total);
        result.put("CurrentPage", page);
        result.put("Totalpage", totalPage);
        return Response.ok(result).build();
    }
}
