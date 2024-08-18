package com.topicos.catalog.create;

import com.topicos.catalog.create.exception.DuplicatedRegisterException;
import com.topicos.catalog.create.exception.ObjectNotFoundException;
import com.topicos.catalog.create.interfaces.InterfaceCreateCategory;
import com.topicos.catalog.models.Category;
import com.topicos.catalog.repositories.RepositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreateCategory implements InterfaceCreateCategory {

    @Autowired
    private RepositoryCategory repositoryCategory ;

    @Override
    public Category saveCategory(Category entity) {
        if(repositoryCategory.findByNameIgnoreCase(entity.getName()) == null) {
            return repositoryCategory.save(entity);
        } else {
            throw new DuplicatedRegisterException("A categoria ["+ entity.getName() + "] já se encontra cadastrada no sistema.");
        }
    }

    @Override
    public List<Category> listCategories() {
        return repositoryCategory.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        repositoryCategory.deleteById(id);
    }

    @Override
    public void deleteCategory(Category entity) {
        repositoryCategory.delete(entity);
    }

    @Override
    public Optional<Category> findCategory(Long id) {
        if (id == null) {
            throw new ObjectNotFoundException("O id não pode ser nulo");
            
        }
        
        Optional<Category> optional = repositoryCategory.findById(id);
        if(optional.isPresent()) {
            return optional;
        } else {
            throw new ObjectNotFoundException("Não existe categoria com o id: " + id);
        }
    }

    @Override
    public Category updateCategory(Long id, Category entity) {
        Category category = repositoryCategory.findById(id).orElse(null);
        category.setName(entity.getName());
        category.setDescription(entity.getDescription());
        category.setParent(entity.getParent());
        category.setIcon(entity.getIcon());
        return repositoryCategory.save(category);
    }

}
