package hospital.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import hospital.models.DaftarRawatInap;
import hospital.models.Dokter;
import hospital.models.Pasien;
import hospital.models.Perawat;
import hospital.models.RuangInap;
import hospital.utils.DateUtil;
import io.quarkus.panache.common.Page;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class DaftarRaawatInapService {
    @Inject
    EntityManager em;

    @Transactional
    public Response add(JsonObject params){
        DaftarRawatInap daftarRawatInap = new DaftarRawatInap();
        Pasien pasien = Pasien.findById(params.getLong("pasien_id", -99L));
        RuangInap ruangInap = RuangInap.findById(params.getLong("ruang_inap_id", -99L));
        Perawat perawat = Perawat.findById(params.getLong("perawat_satu_id", -99L));
        Perawat perawat2 = Perawat.findById(params.getLong("perawat_dua_id", -99L));
        Dokter dokters = Dokter.findById(params.getLong("dokter_id",-99L));
        if(pasien == null|| ruangInap == null||perawat ==null||perawat2 ==null||dokters ==null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        daftarRawatInap.setPasienId(pasien);
        daftarRawatInap.setRuangInapId(ruangInap);
        daftarRawatInap.setPerawatSatuId(perawat);
        daftarRawatInap.setPerawatDuaId(perawat2);
        daftarRawatInap.setDokterId(dokters);
        daftarRawatInap.setStartDateTime(DateUtil.stringToLocalTime(params.getString("start_datetime")));
        daftarRawatInap.setEndDateTime(DateUtil.stringToLocalTime(params.getString("end_datetime")));
        daftarRawatInap.setIsCekout(params.getBoolean("is_checkout"));
        daftarRawatInap.persist();

        return Response.ok(daftarRawatInap).build();


    }
    public Response get(){
        JsonObject result = new JsonObject();
        List<DaftarRawatInap> dokters = DaftarRawatInap.findAll().page(Page.of(0, 10)).list();
        result.put("Daftar rawatinap", dokters);
        return Response.ok(result).build();
    }
    @Transactional
    public Response update(JsonObject params,Long id){
        DaftarRawatInap daftarRawatInapId = DaftarRawatInap.findById(id);
        Pasien pasien = Pasien.findById(params.getString("pasien_id"));
        RuangInap ruangInap = RuangInap.findById(params.getString(("pasien_id")));
        Perawat perawat = Perawat.findById(params.getString("perawat_satu_id"));
        Perawat perawat2 = Perawat.findById(params.getString("perawat_dua_id"));
        Dokter dokters = Dokter.findById(params.getLong("dokter_id",-99L));
        Boolean check = daftarRawatInapId.getIsCekout();
        if(daftarRawatInapId == null||pasien == null|| ruangInap == null||perawat ==null||perawat2 ==null||dokters == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if (check.equals(false)) {
            daftarRawatInapId.setIsCekout(params.getBoolean("is_checkout"));
            return Response.ok(daftarRawatInapId).build();
        }
        
        daftarRawatInapId.setPasienId(pasien);
        daftarRawatInapId.setRuangInapId(ruangInap);
        daftarRawatInapId.setPerawatSatuId(perawat);
        daftarRawatInapId.setPerawatDuaId(perawat2);
        daftarRawatInapId.setDokterId(dokters);
        daftarRawatInapId.setStartDateTime(DateUtil.stringToLocalTime(params.getString("start_datetime")));
        daftarRawatInapId.setEndDateTime(DateUtil.stringToLocalTime(params.getString("start_datetime")));
        daftarRawatInapId.setIsCekout(params.getBoolean("is_checkout"));

        daftarRawatInapId.persist();

        return Response.ok(daftarRawatInapId).build();
    }
    @Transactional
    public Response delete(long id){
        DaftarRawatInap daftarRaawatInapId = DaftarRawatInap.findById(id);
        Boolean check =daftarRaawatInapId.getIsCekout();
        if (daftarRaawatInapId ==null||check.equals(false)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        daftarRaawatInapId.delete();
        return Response.ok().build();
    }

}
