package com.lu.workManageSystem;

import com.lu.workManageSystem.exceptions.StorageException;
import com.lu.workManageSystem.service.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import com.lu.workManageSystem.service.storage.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MybatisplusApplication {


    //被移除了
//    @Bean
//    @Profile({"dev","test"})//设置dev开发、test测试 环境开启  保证我们的效率
//    public PerformanceInterceptor performanceInterceptor(){
//        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
//        performanceInterceptor.setMaxTime(100);//设置sql最大执行时间*ms，如果超过了则不执行
//        performanceInterceptor.setFormat(true);//开启sql格式化
//        return performanceInterceptor;
//    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
//            storageService.deleteAll();
            try{
                storageService.init();

            }catch (StorageException e){
                e.printStackTrace();
            }

        };
    }
}
