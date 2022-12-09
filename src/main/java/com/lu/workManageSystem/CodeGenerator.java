package com.lu.workManageSystem;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @author 杨富宇
 * @create 2021-04-13 下午 5:56
 */
public class CodeGenerator {
    @Test
    public void go(){
        //全局配置
        GlobalConfig config = new GlobalConfig(); config.setActiveRecord(true)    //是否支持AR模式
                .setAuthor("lu") //作者
                .setOutputDir("src/main/java") //生成路径(绝对路径)
                .setFileOverride(false)//文件覆盖
                .setServiceName("%sService")    //设置生成的service接口名 首字母是否为I
                .setIdType(IdType.ASSIGN_ID) //主键策略
                .setBaseColumnList(true)
                .setBaseResultMap(true)
        ;
        //数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig(); dsConfig.setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://rm-bp1n76xwt0nc2w0mipo.mysql.rds.aliyuncs.com:3306/web")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("cweb")
                .setPassword("cwebmima");
        //策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true)    // 全局大写命名
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setInclude("work")    //生成的表
//                .setTablePrefix("tbl_") // 表前缀
                .setEntityLombokModel(true);
        ;
        //包名策略
        PackageConfig pkConfig = new PackageConfig(); pkConfig.setParent("com.lu.workManageSystem")
                .setController("controller")
                .setEntity("pojo")
                .setService("service")
                .setMapper("mapper")
                .setXml("mapper")
                .setServiceImpl("service")
        ;
        AutoGenerator ag    = new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);
        //执行
        ag.execute();
    }
}
