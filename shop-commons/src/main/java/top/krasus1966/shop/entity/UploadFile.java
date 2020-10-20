package top.krasus1966.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Krasus1966
 * @date 2020/10/7 15:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadFile implements Serializable {
    private static final long serialVersionUID = 1282932753367539810L;

    public static Integer IMG_TYPE = 0;


    private String id;
    private String fileName;
    private LocalDateTime createTime;
    private long size;
    private Integer type;
}
