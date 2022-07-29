package hospital.models;

import java.util.EnumSet;
import java.util.Set;

public enum CategoryObat {
    SYRUP("Syrup"),
    PIL("Pil"),
    TABLET("Tablet"),
    CAIR("Cair");
    private String obat;

    private CategoryObat(String obat) {
        this.obat = obat;
    }
    public String getObat(){
			return obat;
	}
    public static CategoryObat getPosisiByName(String obatName) {

        for (CategoryObat obatn : CategoryObat.values()) {
            if (obatName.equalsIgnoreCase(obatn.name())) {
                return obatn;
            }
        }
        return null;
    }
    public static Set<CategoryObat> getall(){
        Set<CategoryObat> categoryObats = EnumSet.allOf(CategoryObat.class);
        return categoryObats;
    }

}
