package top.krasus1966.shop.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Krasus1966
 * @date 2020/7/22 21:53
 **/
@ApiModel("管理员实体")
@Data
@TableName("tb_admin")
public class Admin extends Model<Admin> {

    @ApiModelProperty("id")
    @TableId
    private Long id;

    @ApiModelProperty("用户名")
    @TableField
    private String username;

    @ApiModelProperty(value = "密码",notes = "默认不会被查询")
    @TableField(select = false)
    private String password;

    @ApiModelProperty("用户状态")
    @TableField
    private Integer status;

    @ApiModelProperty("用户照片")
    @TableField
    private String photo;

    @ApiModelProperty("用户名")
    @TableLogic
    private Integer del;
}
