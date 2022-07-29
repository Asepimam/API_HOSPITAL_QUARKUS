package hospital.OAS;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class AddDokterOAS {
    @Schema(name = "AddDokterOAS.Request")
    public class Request{
        @Schema(example = "Goku",description = "full name dokter ")
        public String full_name;

        @Schema(example = "gokusaiya@mail.com",description = "email diokter")
        public String email;

        @Schema(example = "09762551273",description = "phone number dokter")
        public String phone_number;

        @Schema(example = "specialis saraf",description = "specialis dokter")
        public String specialis_name;

        @Schema(example = "true",description = "specialis")
        public String is_specialis;

        @Schema(example = "5000000",description = "gajih dokter")
        public Long gajih;
    }

    @Schema(name = "AddDokterOAS.Response")
    public class Response{
        public String message;
        public Object playload;
        public Long status;
    }
}
