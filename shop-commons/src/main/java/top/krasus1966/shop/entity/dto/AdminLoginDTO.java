package top.krasus1966.shop.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Krasus1966
 * @date 2020/8/10 21:45
 **/
@Data
public class AdminLoginDTO implements Serializable {
    private static final long serialVersionUID = 1845660238304941708L;
    private String username;
    private String password;
}
