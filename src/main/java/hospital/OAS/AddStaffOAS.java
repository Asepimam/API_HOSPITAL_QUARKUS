package hospital.OAS;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class AddStaffOAS {
    @Schema(name = "AddStaffhOAS.Request")
    public class Request{
        @Schema(example = "asep imam", description = "fullname staff")
        public String full_name;

        @Schema(example = "laki")
        public String gender;

        @Schema(example = "Engineer")
        public String posisi;

        @Schema(example = "20200720 08:00")
        public String start_time;

        @Schema(example = "20200720 16:20")
        public String end_time;

        @Schema(example = "asep@mail.com")
        public String email;

        @Schema(example = "081625282")
        public String phone_number;

        @Schema(example = "9000000")
        public Long gajih;

        @Schema(example = "aktif")
        public String status;
    }

    @Schema(name = "AddMatchOAS.Response")
    public class Response{
        public String message;
        public Object payload;
        public Long status;
    }
}
