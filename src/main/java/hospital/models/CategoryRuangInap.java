package hospital.models;

public enum CategoryRuangInap {
    STANDAR("Standar"),
    VIP("Vip"),
    VVIP("Vvip");

    private String kelasInap;

    private CategoryRuangInap(String KelasInap) {
        this.kelasInap = KelasInap;
    }
    public String getObat(){
			return kelasInap;
	}
    public static CategoryRuangInap getRuangInapByName(String kelasinap) {

        for (CategoryRuangInap cRuangInap : CategoryRuangInap.values()) {
            if (kelasinap.equalsIgnoreCase(cRuangInap.name())) {
                return cRuangInap;
            }
        }
        return null;
    }
}
