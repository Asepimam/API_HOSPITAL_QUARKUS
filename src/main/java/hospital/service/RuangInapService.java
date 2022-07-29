package hospital.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import hospital.models.CategoryRuangInap;
import hospital.models.DaftarRawatInap;
import hospital.models.RuangInap;
import io.quarkus.panache.common.Page;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class RuangInapService {

    @Inject
    EntityManager em;

    @Transactional
    public Response add(JsonObject params){
        RuangInap ruangInap = new RuangInap();

        ruangInap.setPrefixRuangan(params.getString("prefix_ruangan"));
        ruangInap.setNomorRuangan(params.getString("nomor_ruangan"));
        ruangInap.setCategoryRuang(CategoryRuangInap.getRuangInapByName(params.getString("categori_ruangan")));

        ruangInap.persist();
        return Response.ok(ruangInap).build();
    }
    public Response get(){
        JsonObject result = new JsonObject();
        List<RuangInap> ruangInaps = RuangInap.findAll().page(Page.of(0, 10)).list();
        result.put("ruanginap", ruangInaps);
        return Response.ok(ruangInaps).build();
    }
    @Transactional
    public Response update(JsonObject params,Long id){
        RuangInap ruangInap = RuangInap.findById(id);
        DaftarRawatInap daftarRawatInap = DaftarRawatInap.findById(id);
        if(ruangInap == null || daftarRawatInap.getIsCekout().equals(false)){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        ruangInap.setPrefixRuangan(params.getString("prefix_ruangan"));
        ruangInap.setNomorRuangan(params.getString("nomor_ruangan"));
        ruangInap.setCategoryRuang(CategoryRuangInap.getRuangInapByName(params.getString("categori_ruangan")));
        ruangInap.setKosong(params.getBoolean("is_kosong"));
        ruangInap.persist();
        return Response.ok(ruangInap).build();

    }
    @Transactional
    public Response delete(Long id){
        RuangInap ruangInap =RuangInap.findById(id);
        DaftarRawatInap daftarRawatInap = DaftarRawatInap.findById(id);
        if(ruangInap == null || daftarRawatInap.getIsCekout().equals(false)){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        ruangInap.delete();
        return Response.ok().build();

    }
}
