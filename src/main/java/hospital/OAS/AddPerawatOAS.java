package hospital.OAS;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class AddPerawatOAS {
    @Schema(name = "AddPerawatOAS.Request")
    public class Request{
        @Schema(example = "Goku",description = "full name perawat ")
        public String full_name;

        @Schema(example = "gokusaiya@mail.com",description = "email perawat")
        public String email;

        @Schema(example = "09762551273",description = "phone number perawat")
        public String phone_number;

        @Schema(example = "laki",description = "gender perawat")
        public String gender;

        @Schema(example = "5000000",description = "gajih perawar")
        public Long gajih;

        @Schema(example = "aktif",description = "status perawat")
        public String status;
    }

    @Schema(name = "AddPerawatOAS.Response")
    public class Response{
        public String message;
        public Object playload;
        public Long status;
    }
}
