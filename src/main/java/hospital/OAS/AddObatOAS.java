package hospital.OAS;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class AddObatOAS {
    @Schema(name = "AddObatOAS.Request")
    public class Request{
        @Schema(example ="intors",description = "nama obat ")
        public String nama_obat;

        @Schema(example = "kimia parma",description = "produksi")
        public String produksi;

        @Schema(example = "Pil",description = "categori")
        public String categori_obat;

        @Schema(example = "meredahkan yeri lutut",description = "deskripsi")
        public String deskripsi;
    }
    @Schema(name = "AddObatOAS.Response")
    public class Response{
        public String message;
        public Object playload;
        public Long status;
    }
}
