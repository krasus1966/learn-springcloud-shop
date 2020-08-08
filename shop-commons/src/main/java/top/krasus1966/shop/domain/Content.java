package top.krasus1966.shop.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 广告DO
 *
 * @author Krasus1966
 * @date 2020/8/8 22:47
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("tb_content")
public class Content extends Model<Content> implements Serializable {

    private static final long serialVersionUID = -4570311924606008148L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("category_id")
    private Long categoryId;

    @TableField("title")
    private String title;

    @TableField("url")
    private String url;

    @TableField("pic")
    private String pic;

    @TableField("status")
    private String status;

    @TableField("sort_order")
    private Integer sortOrder;

    @TableLogic
    @TableField(select = false)
    private Integer del;
}
