package hospital.OAS;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class AddDaftarRawatInapOAS {
    
    @Schema(name = "AddRuangInapOAS.Request")
    public class Request{
        @Schema(example = "1",description = "pasien id ")
        public Long pasien_id;
    
        @Schema(example = "1",description = "ruangan inap id ")
        public Long ruang_inap_id;
    
        @Schema(example = "2",description = "perawat satu id")
        public Long perawat_satu_id;

        @Schema(example = "3",description = "perawat dua id")
        public Long perawat_dua_id;

        @Schema(example = "20220720 20:12",description = "start datetime")
        public String start_datetime;

        @Schema(example = "20220720 20:12",description = "end datetime")
        public String end_datetime;

        @Schema(example = "false")
        public Boolean is_Checkout;
    }
    
    @Schema(name = "AddRuangInapOAS.Response")
    public class Response{
        public String message;
        public Object playload;
        public Long status;
    }

}
