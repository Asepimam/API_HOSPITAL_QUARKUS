package hospital.service;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;

import hospital.models.CategoryObat;

@ApplicationScoped
public class CategoryObatService {
    public Set<CategoryObat> getall(){
        Set<CategoryObat> categoryObat2 = CategoryObat.getall();
        return categoryObat2;
    }
}
