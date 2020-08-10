package top.krasus1966.shop.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static io.swagger.annotations.ApiModelProperty.AccessMode.READ_ONLY;

/**
 * 广告分类DO
 * @author Krasus1966
 * @date 2020/8/6 22:01
 **/
@ApiModel(description = "广告分类实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("tb_content_category")
public class ContentCategory extends Model<ContentCategory> implements Serializable {
    private static final long serialVersionUID = -2122441613448721333L;

    @ApiModelProperty("广告分类id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("广告分类名称")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(accessMode = READ_ONLY)
    @TableLogic
    @TableField(select = false)
    @JsonIgnore
    private Integer del;
}
