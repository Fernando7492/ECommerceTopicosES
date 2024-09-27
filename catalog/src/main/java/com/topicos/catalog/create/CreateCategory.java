package com.topicos.catalog.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topicos.catalog.create.exception.DuplicatedRegisterException;
import com.topicos.catalog.create.exception.ObjectNotFoundException;
import com.topicos.catalog.create.interfaces.InterfaceCreateCategory;
import com.topicos.catalog.models.Category;
import com.topicos.catalog.repositories.RepositoryCategory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class CreateCategory implements InterfaceCreateCategory {

    @Autowired
    private RepositoryCategory repositoryCategory;

    @Override
    public Mono<Category> saveCategory(Category entity) {
        return repositoryCategory.findByNameIgnoreCase(entity.getName())
            .flatMap(existingCategory -> Mono.<Category>error(new DuplicatedRegisterException("A categoria [" + entity.getName() + "] já se encontra cadastrada no sistema.")))
            .switchIfEmpty(repositoryCategory.save(entity));
    }

    @Override
    public Flux<Category> listCategories() {
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
    public Mono<Category> findCategory(Long id) {
        if (id == null) {
            throw new ObjectNotFoundException("O id não pode ser nulo");
            
        }
        
        Mono<Category> optional = repositoryCategory.findById(id);
        return optional.switchIfEmpty(Mono.error(new ObjectNotFoundException("Não existe categoria com o id: " + id)));
    }

    @Override
    public Mono<Category> updateCategory(Long id, Category entity) {
        return repositoryCategory.findById(id)
            .flatMap(category -> {
                category.setName(entity.getName());
                category.setDescription(entity.getDescription());
                category.setParentId(entity.getParentId());
                category.setIcon(entity.getIcon());
                return repositoryCategory.save(category);
            })
            .switchIfEmpty(Mono.error(new ObjectNotFoundException("Não existe categoria com o id: " + id)));
    }

}
