package top.krasus1966.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Krasus1966
 * @date 2020/8/13 20:49
 **/
// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static int scannerTemplate(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("模板列表：\n");
        help.append("(1)：服务端管理系统模板 \n");
        help.append("(2)：服务端用户系统模板 \n");
        help.append("(3)：消费端管理系统模板 \n");
        help.append("(4)：消费端用户系统模板 \n");
        help.append("其他：Mybatis-Plus通用模板 \n");
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNextInt()) {
            int ipt = scanner.nextInt();
            return ipt;
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/common-generator/src/main/java");
        gc.setAuthor("krasus1966");
        gc.setOpen(false);
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setActiveRecord(true);
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/spring_shop?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("196610121");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("top.krasus1966");
        mpg.setPackageInfo(pc);

        // 自定义配置


        int templateChoise = scannerTemplate("要使用的模板");
        if (templateChoise == 3 || templateChoise == 4) {
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                    // to do nothing
                }
            };
            // 自定义输出配置
            String templatePath = "";
            List<FileOutConfig> focList = new ArrayList<>();
            if (templateChoise == 3){
                templatePath = "templates/consumer/admin/service.java.ftl";
            }
            if (templateChoise == 4){
                // 自定义输出配置
                templatePath = "templates/consumer/service.java.ftl";
            }
            focList.add(new FileOutConfig(templatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return  gc.getOutputDir() + "/"
                            + pc.getParent().replaceAll("\\.", "/") + "/"
                            +"/service/" + tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
                }
            });
//            cfg.setFileCreate(new IFileCreate() {
//                @Override
//                public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
//                    // 判断自定义文件夹是否需要创建
//                    checkDir("调用默认方法创建的目录，自定义目录用");
//                    if (fileType == FileType.SERVICE) {
//                        // 已经生成 mapper 文件判断存在，不想重新生成返回 false
//                        return !new File(filePath).exists();
//                    }
//                    // 允许生成模板文件
//                    return true;
//                }
//            });
            cfg.setFileOutConfigList(focList);
            mpg.setCfg(cfg);
        }

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        switch (templateChoise) {
            case 1:
                templateConfig.setService("templates/provider/admin/service.java");
                templateConfig.setServiceImpl("templates/provider/admin/serviceImpl.java");
                templateConfig.setController("templates/provider/admin/controller.java");
                templateConfig.setMapper("templates/provider/admin/mapper.java");
                templateConfig.disable(TemplateType.XML);
                break;
            case 2:
                templateConfig.setService("templates/provider/service.java");
                templateConfig.setServiceImpl("templates/provider/serviceImpl.java");
                templateConfig.setController("templates/provider/controller.java");
                templateConfig.setMapper("templates/provider/mapper.java");
                templateConfig.disable(TemplateType.XML);
                break;
            case 3:
                templateConfig.setController("templates/consumer/admin/controller.java");
                templateConfig.disable(TemplateType.XML).disable(TemplateType.MAPPER).disable(TemplateType.SERVICE);
                break;
            case 4:
                templateConfig.setController("templates/consumer/controller.java");
                templateConfig.disable(TemplateType.XML).disable(TemplateType.MAPPER).disable(TemplateType.SERVICE);
                break;
            default:
                break;
        }
        templateConfig.setEntity("templates/entity.java");
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setEntitySerialVersionUID(true);
        strategy.setRestControllerStyle(true);
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("tb_");
        strategy.setLogicDeleteFieldName("del");
        //strategy.setTablePrefix(scanner("需要去掉的表前缀"+"_"));
        //strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
