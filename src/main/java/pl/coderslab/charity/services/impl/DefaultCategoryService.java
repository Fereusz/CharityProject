package pl.coderslab.charity.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import pl.coderslab.charity.domain.repositories.CategoryRepository;
import pl.coderslab.charity.dtos.CategoryDTO;
import pl.coderslab.charity.services.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DefaultCategoryService implements CategoryService {

    private final CategoryRepository categoryRepository;

    public DefaultCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> findAllCategories() {
        ModelMapper findAllMapper = new ModelMapper();
        return categoryRepository.findAll().stream()
                .map(c->findAllMapper.map(c,CategoryDTO.class))
                .collect(Collectors.toList());
    }

}
