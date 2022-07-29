package hospital.OAS;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class DaftarShifOAS {
    @Schema(name = "AddDaftaShifOAS.Request")
    public class Request{
        @Schema(example = "push",description = "catergory shif ")
        public String catogory;

        @Schema(example = "1",description = "staff id")
        public String staff_id;

        @Schema(example = "['seni','selasa']",description = "hari")
        public String phone_number;

        @Schema(example = "20220720 20:00",description = "start_datetime")
        public String start_datetime;

        @Schema(example = "20220720 20:00",description = "end_datetime")
        public Long end_datetime;
    }

    @Schema(name = "AddDaftarShifOAS.Response")
    public class Response{
        public String message;
        public Object playload;
        public Long status;
    }   
}
