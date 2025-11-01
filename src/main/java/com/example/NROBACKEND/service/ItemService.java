package com.example.NROBACKEND.service;


import com.example.NROBACKEND.entity.Item;
import com.example.NROBACKEND.repository.ItemRepository;
import com.example.NROBACKEND.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> getAll() {
        return repository.findAll();
    }

    public Item getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Item> getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public Item create(Item item) {
        return repository.save(item);
    }

    public Item update(Long id, Item item) {
        if (repository.existsById(id)) {
            item.setId(id);
            return repository.save(item);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
