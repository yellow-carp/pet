package com.yellow.module.service;

import com.yellow.module.entity.Pet;
import com.yellow.module.mapper.PetMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class PetSercice {
    @Autowired
    private PetMapper petMapper;
    public ArrayList<Pet> getPetList() {
        return petMapper.getList();
    }

    public Pet getPetInfo(Long id) {
        return petMapper.getById(id);
    }

    public Integer add(Pet pet) {
        return petMapper.add(pet);
    }

    public Integer update(Pet pet) {
        return petMapper.update(pet);
    }

    public Integer delete(Long id) {
        return petMapper.delete(id);
    }
}
