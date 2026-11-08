package com.yellow.module.mapper;

import com.yellow.module.entity.Pet;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface PetMapper {
    @Select("select * from pet")
    ArrayList<Pet> getList();

    @Select("select * from pet where id=#{id}")
    Pet getById(Long id);

    @Insert("insert into pet(pet_name,photos,variety,price,detail,create_time,update_time)values (#{petName},#{photos},#{variety},#{price},#{detail},#{createTime},#{updateTime})")
    Integer add(Pet pet);

    @Update("update pet set pet_name=#{petName},photos=#{photos}" +
            ",variety=#{variety},price=#{price},detail=#{detail} where id=#{id}")
    Integer update(Pet pet);

    @Delete("delete from pet where id=#{id}")
    Integer delete(Long id);
}
