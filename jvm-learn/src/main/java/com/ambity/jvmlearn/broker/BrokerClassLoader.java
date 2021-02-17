package com.ambity.jvmlearn.broker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BrokerClassLoader extends ClassLoader {
    private String classpath;

    public BrokerClassLoader(String classpath){
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

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (!name.contains("com.ambity.learn")){
                return getSystemClassLoader().loadClass(name);
            }
            if (c == null) {
                // If still not found, then invoke findClass in order
                // to find the class.
                long t1 = System.nanoTime();
                c = findClass(name);

                // this is the defining class loader; record the stats
                sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                sun.misc.PerfCounter.getFindClasses().increment();
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }
}
