package hospital.OAS;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class AddRuangInapOAS {
    @Schema(name = "AddRuangInapOAS.Request")
    public class Request{
        @Schema(example = "01,melati",description = "prefix ruangan ")
        public String prefix_ruangan;

        @Schema(example = "01",description = "nomor ruangan inap")
        public String nomor_ruangan;

        @Schema(example = "Vip",description = "categori ruangan inap")
        public String categori_ruangan;
    }

    @Schema(name = "AddRuangInapOAS.Response")
    public class Response{
        public String message;
        public Object playload;
        public Long status;
    }
}
