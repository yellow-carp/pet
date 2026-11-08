package com.yellow.app.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Accessors(chain = true)
public class PetListVo {

    private Long id;

    private String petName;

    private String photos;

    private String variety;

    private Float price;

}
