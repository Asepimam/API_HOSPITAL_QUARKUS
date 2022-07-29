package hospital.OAS;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class AddPasienOAS {
    @Schema(name = "AddPasienOAS.Request")
    public class Request{
        @Schema(example = "Gohan",description = "full name pasien ")
        public String full_name;

        @Schema(example = "gohasaiya@mail.com",description = "email pasien")
        public String email;

        @Schema(example = "09762551273",description = "phone number pasien")
        public String phone_number;

        @Schema(example = "Laki",description = "gender pasien")
        public String gender;

        @Schema(example = "sakit",description = "status pasien")
        public Long status;

        @Schema(example = "Jl.sai 2 kamehame",description = "alamat pasien")
        public Long address;

        @Schema(example = "true",description = "ditanggung/tidak oleh bpjs")
        public Boolean is_cover_bpjs;
    }

    @Schema(name = "AddPasienOAS.Response")
    public class Response{
        public String message;
        public Object playload;
        public Long status;
    }
}
