package com.yellow.app.controller;

import com.yellow.app.domain.vo.PetInfoVo;
import com.yellow.app.domain.vo.PetListVo;
import com.yellow.module.entity.Pet;
import com.yellow.module.service.PetSercice;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@Slf4j
public class AppController {

    @Autowired
    private PetSercice petSercice;

    @RequestMapping("/pet/petList")
    public ArrayList<PetListVo> petList() {
        java.util.ArrayList<Pet> petList = petSercice.getPetList();
        log.info("当前取出的数据有" + petList.size() + "条");
        ArrayList<PetListVo> petListVos = new ArrayList<>();
        for (Pet pet : petList) {
            PetListVo petListVo = new PetListVo();
            petListVo.setPhotos(pet.getPhotos().split("\\$")[0])
                    .setId(pet.getId())
                    .setPetName(pet.getPetName())
                    .setVariety(pet.getVariety())
                    .setPrice(pet.getPrice());
            petListVos.add(petListVo);
        }
        return petListVos;
    }

    @RequestMapping("/pet/info")
    public PetInfoVo info(@RequestParam("id") Long id) {
        log.info("传入的参数为："+id);
        Pet pet = petSercice.getPetInfo(id);
        log.info("获取的数据为："+pet.toString());
        return new PetInfoVo().setId(pet.getId())
                .setPetName(pet.getPetName())
                .setPhotos(pet.getPhotos().split("\\$"))
                .setVariety(pet.getVariety())
                .setPrice(pet.getPrice())
                .setDetail(pet.getDetail());
    }
}
