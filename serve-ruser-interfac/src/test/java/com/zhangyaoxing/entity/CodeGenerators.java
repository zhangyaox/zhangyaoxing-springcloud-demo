package com.zhangyaoxing.entity;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

public class CodeGenerators {
    //程序入口
    public static void main(String[] args) {
        //创建代码生成器对象
        AutoGenerator mpg = new AutoGenerator();
        //全局设置
        GlobalConfig gc = new GlobalConfig();
        //设置输出路径
        gc.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        //设置作者
        gc.setAuthor("chenhj");
        //生成是否打开文件
        gc.setOpen(false);
        //设置生成的结果集
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);
        //全局设置
        mpg.setGlobalConfig(gc);


        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        //设置驱动类
        dsc.setDriverName("com.mysql.jdbc.Driver");
        //设置的url
        dsc.setUrl("jdbc:mysql://localhost:3306/8djava?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        //设置用户名
        dsc.setUsername("root");
        //设置密码
        dsc.setPassword("123");
        //设置代码生成器对象的数据
        mpg.setDataSource(dsc);


        //设置生成到到哪里 包
        PackageConfig pc = new PackageConfig();
        //设置包名称
        pc.setParent(CodeGenerators.class.getPackage().getName());
        //设置包的路径com.bawei.bootplus /entity/service/mapper/controller
        mpg.setPackageInfo(pc);


        //生成的策略
        StrategyConfig strategy = new StrategyConfig();
        //生成那些表  Student DomitCheckIn feeSettle Room
        strategy.setInclude("user","room");
        //  strategy.setInclude("Room");
        // strategy.setInclude("feeSettle");
        //  strategy.setInclude("DomitCheckIn");
        // strategy.setInclude("Student");
        //排除表
        //strategy.setExclude()
        //表的前缀
        //strategy.setTablePrefix("hg_");
        //strategy.setFieldPrefix()
        //采用lombok处理
        strategy.setEntityLombokModel(true);

        //设置生成策略
        mpg.setStrategy(strategy);


        //执行生成
        mpg.execute();
    }
}
