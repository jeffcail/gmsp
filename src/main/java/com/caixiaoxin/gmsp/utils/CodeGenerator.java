package com.caixiaoxin.gmsp.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

/**
 * mp 代码生成器
 * by 太阳上的雨天 blog.caixiaoxin.cn
 * @Since 2023-05-20
 */
public class CodeGenerator {

    public static void main(String[] args) {
        generate();
    }
    
    private static void generate() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3310/gmsp?serverTimezone=GMT%2b8&serverTimezone=Asia/Shanghai", "root", "root")
                .globalConfig(builder -> {
                    builder.author("太阳上的雨天") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("/Users/cc/project/github/java/gmsp/src/main/java/*"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.caixiaoxin.gmsp") // 设置父包名
                            .moduleName("") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "/Users/cc/project/github/java/gmsp/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板

                .execute();

    }

}
