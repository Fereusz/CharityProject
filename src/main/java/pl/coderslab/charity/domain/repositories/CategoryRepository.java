package pl.coderslab.charity.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.domain.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
