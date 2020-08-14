package top.krasus1966.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.krasus1966.shop.entity.AdminLoginLog;

/**
 * @author Krasus1966
 * @date 2020/7/27 22:08
 **/
@Mapper
public interface AdminLogDao extends BaseMapper<AdminLoginLog> {
}
