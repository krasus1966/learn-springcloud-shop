package top.krasus1966.shop.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static io.swagger.annotations.ApiModelProperty.AccessMode.READ_ONLY;

/**
 * 品牌信息DO
 * @author Krasus1966
 * @date 2020/7/17 22:12
 **/
@ApiModel(description = "品牌实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("tb_brand")
public class Brand extends Model<Brand> implements Serializable {

    private static final long serialVersionUID = 8621985266139394110L;
    @ApiModelProperty("品牌id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("品牌名")
    @TableField("name")
    private String name;

    @ApiModelProperty("品牌图片")
    @TableField("image")
    private String image;

    @ApiModelProperty("品牌首字母")
    @TableField("first_char")
    private String firstChar;

    @ApiModelProperty(accessMode = READ_ONLY)
    @TableLogic
    @TableField(select = false)
    private Integer del;
}
