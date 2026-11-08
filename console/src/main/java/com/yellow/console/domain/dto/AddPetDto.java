package com.yellow.console.domain.dto;

import lombok.Data;

@Data
public class AddPetDto {

    private String petName;

    private String photos;

    private String variety;

    private Float price;

    private String detail;
}
