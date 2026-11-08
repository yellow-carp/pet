package com.yellow.console.controller;

import com.yellow.console.domain.dto.AddPetDto;
import com.yellow.console.domain.dto.UpdatePetDto;
import com.yellow.module.entity.Pet;
import com.yellow.module.service.PetSercice;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ConsoleController {
    @Autowired
    private PetSercice petSercice;

    @RequestMapping("/pet/add")
    public String add(@RequestBody AddPetDto addPetDto) {
        log.info("传入的参数为：" + addPetDto.toString());
        Integer i = petSercice.add(new Pet().setPetName(addPetDto.getPetName())
                .setPhotos(addPetDto.getPhotos())
                .setVariety(addPetDto.getVariety())
                .setPrice(addPetDto.getPrice())
                .setDetail(addPetDto.getDetail())
                .setCreateTime((int) (System.currentTimeMillis() / 1000))
                .setUpdateTime((int) (System.currentTimeMillis() / 1000)));
        return i == 0 ? "新增失败" : "新增成功";
    }

    @RequestMapping("/pet/update")
    public String update(@RequestBody UpdatePetDto updatePetDto) {
        log.info("传入的参数为：" + updatePetDto.toString());
        Integer i = petSercice.update(new Pet().setPetName(updatePetDto.getPetName())
                .setPhotos(updatePetDto.getPhotos())
                .setVariety(updatePetDto.getVariety())
                .setPrice(updatePetDto.getPrice())
                .setDetail(updatePetDto.getDetail())
                .setId(updatePetDto.getId()));
        return i == 0 ? "修改失败" : "修改成功";
    }

    @RequestMapping("/pet/delete")
    public String delete(@RequestParam("id") Long id) {
        log.info("传入的参数为：" + id);
        Integer i = petSercice.delete(id);
        return i == 0 ? "删除失败" : "删除成功";
    }
}
