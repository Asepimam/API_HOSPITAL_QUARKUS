package hospital.models;

import java.util.EnumSet;
import java.util.Set;

public enum PosisiStaff {
    SECURITY("Security"),
    JANITOR("Janitor"),
    RECEIPT("Receipt"),
    ENGINEER("Enginer");
    
    private String posisi;

    private PosisiStaff(String posisi) {
        this.posisi = posisi;
    }
    public String getPosisi(){
			return posisi;
	}
    public static PosisiStaff getPosisiByName(String payName) {

        for (PosisiStaff oprname : PosisiStaff.values()) {
            if (payName.equalsIgnoreCase(oprname.name())) {
                return oprname;
            }
        }
        return null;
    }
    
    public static Set<PosisiStaff> getall(){
        Set<PosisiStaff> categoryObats = EnumSet.allOf(PosisiStaff.class);
        return categoryObats;
    }

}
