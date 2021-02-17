package com.ambity;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        List<String> war=new ArrayList<>();
        Boolean ovr=true;
        File file=new File("E:\\study\\learn\\mybatis-generate\\src\\main\\java\\com\\ambity\\generatorConfigxml.xml");
        ConfigurationParser cp=new ConfigurationParser(war);
        try {
            Configuration config=cp.parseConfiguration(file);
            DefaultShellCallback back=new DefaultShellCallback(ovr);
            MyBatisGenerator my=new MyBatisGenerator(config, back, war);
            my.generate(null);
            for(String s:war) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
