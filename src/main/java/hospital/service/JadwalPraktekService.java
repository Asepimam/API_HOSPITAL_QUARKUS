package hospital.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import hospital.models.Dokter;
import hospital.models.JadwalPraktek;
import hospital.utils.DateUtil;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class JadwalPraktekService {
    @Inject
    EntityManager em;

    @Transactional
    public Response add(JsonObject params){
        Dokter dokter = Dokter.findById(params.getLong("dokter_id", -99L));
        if(dokter ==null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        JadwalPraktek jadwalPraktek = new JadwalPraktek();
        jadwalPraktek.setHari(params.getString("hari"));
        jadwalPraktek.setDeskripsi(params.getString("deskripsi"));
        jadwalPraktek.setDokterId(dokter);
        jadwalPraktek.setStarttime(DateUtil.stringToLocalTime(params.getString("start_datetime")));
        jadwalPraktek.setEndTime(DateUtil.stringToLocalTime(params.getString("end_datetime")));

        jadwalPraktek.persist();
        return Response.ok(jadwalPraktek).build();
    }
    @Transactional
    public Response update(JsonObject params, long id){
        Dokter dokter = Dokter.findById(params.getLong("dokter_id", -99L));

        if(dokter ==null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        JadwalPraktek jadwalPraktek = JadwalPraktek.findById(id);
        jadwalPraktek.setHari(params.getString("hari"));
        jadwalPraktek.setDeskripsi(params.getString("deskripsi"));
        jadwalPraktek.setDokterId(dokter);
        jadwalPraktek.setStarttime(DateUtil.stringToLocalTime(params.getString("start_dateTime")));
        jadwalPraktek.setEndTime(DateUtil.stringToLocalTime(params.getString("start_dateTime")));

        jadwalPraktek.persist();
        return Response.ok(jadwalPraktek).build();
    }
}
