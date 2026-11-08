package com.yellow.console.domain.dto;

import com.yellow.module.entity.Pet;
import lombok.Data;
import org.apache.ibatis.annotations.Insert;

@Data
public class UpdatePetDto {
    private Long id;

    private String petName;

    private String photos;

    private String variety;

    private Float price;

    private String detail;
}
