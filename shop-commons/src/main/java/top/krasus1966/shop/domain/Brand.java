package top.krasus1966.shop.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Krasus1966
 * @date 2020/7/17 22:12
 **/
@ApiModel(value = "品牌实体")
@Data
@TableName("tb_brand")
public class Brand extends Model<Brand> implements Serializable {

    private static final long serialVersionUID = 8621985266139394110L;
    @ApiModelProperty(value = "品牌id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "品牌名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "品牌图片")
    @TableField("image")
    private String image;

    @ApiModelProperty(value = "品牌首字母")
    @TableField("first_char")
    private String firstChar;

    @ApiModelProperty(value = "逻辑删除标识")
    @TableLogic
    private Integer del;
}
