package top.krasus1966.shop.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Krasus1966
 * @date 2020/7/17 22:50
 **/
@EnableTransactionManagement
@Configuration
@MapperScan("top.krasus1966.shop.mapper")
public class MybatisConfig {


    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setOverflow(false);
        //攻击SQL阻断器配置
//        List<ISqlParser> sqlParserList = new ArrayList<>();
//        // 攻击 SQL 阻断解析器、加入解析链
//        sqlParserList.add(new BlockAttackSqlParser() {
//            @Override
//            public void processDelete(Delete delete) {
//                // 如果你想自定义做点什么，可以重写父类方法像这样子
//                if ("user".equals(delete.getTable().getName())) {
//                    // 自定义跳过某个表，其他关联表可以调用 delete.getTables() 判断
//                    return ;
//                }
//                super.processDelete(delete);
//            }
//        });
//        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }

    //乐观锁插件 需要在实体类上增加字段 version 和 @Version 注解
//    @Bean
//    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
//        return new OptimisticLockerInterceptor();
//    }
}
