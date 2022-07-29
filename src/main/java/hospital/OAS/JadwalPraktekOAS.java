package hospital.OAS;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class JadwalPraktekOAS {
    @Schema(name = "AddJadwalPraktekOAS.Request")
    public class Request{
        @Schema(example = "senin,selas,kamis",description = "hari praktek ")
        public String hari;

        @Schema(example = "1",description = "dokter id")
        public String dokter_id;

        @Schema(example = "hali ya ahli",description = "dekripsi")
        public String dekripsi;

        @Schema(example = "20220720 09:00",description = "Start_datetime")
        public String start_datetime;

        @Schema(example = "20220720 11:00",description = "end_datetime")
        public Long end_datetime;
    }
    @Schema(name = "AddDokterOAS.Response")
    public class Response{
        public String message;
        public Object playload;
        public Long status;
    }
}

