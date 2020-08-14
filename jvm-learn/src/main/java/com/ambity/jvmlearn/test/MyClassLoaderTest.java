package com.ambity.jvmlearn.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyClassLoaderTest {
    public static class MyClassLoader extends ClassLoader {
        private String classpath;

        public MyClassLoader(String classpath){
            this.classpath = classpath;
        }

        public byte[] loadByte(String name){
            name = name.replace(".","/");
            FileInputStream fis = null;
            try {
                 fis = new FileInputStream(classpath + "/"+name+".class");
                int len = fis.available();
                byte[] bytes = new byte[len];
                fis.read(bytes);
                return bytes;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            Class clazz = null;
            byte[] bytes = loadByte(name);
            if (bytes==null){
                return null;
            }
            clazz = defineClass(name,bytes,0,bytes.length);
            return clazz;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
//        MyClassLoader myClassLoader = new MyClassLoader("D:/study/test");
//        Class clazz = myClassLoader.loadClass("com.Test");
//        MyClassLoader myClassLoader = new MyClassLoader("D:\\study\\learn\\src\\main\\java");
//        Class clazz = myClassLoader.loadClass("com.ambity.learn.broker.User");
//        System.out.println(clazz.getClassLoader());
        System.out.println(System.getProperties());
        Thread.sleep(100000000);
    }

}
