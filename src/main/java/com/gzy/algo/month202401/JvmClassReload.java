package com.gzy.algo.month202401;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JvmClassReload extends ClassLoader{

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        if(shouldBeakDelegation(name)){
            return findClass(name);
        }

        return super.loadClass(name);
    }

    private boolean shouldBeakDelegation(String name) {
        return name.equals("java.lang.String");
    }

    public Class<?> findClass(String name) throws ClassNotFoundException {
        // 实现自定义类加载逻辑

        File file = new File("/Users/apple_gui/idea_project/algo/dayly-algorithm/src/main/java/java/lang/String.class");
        // 例如，从指定位置加载字节码

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            int b = 0;
            while ((b = fileInputStream.read()) != 0){
                output.write(b);
            }
            byte[] bytes = output.toByteArray();
            output.close();
            fileInputStream.close();

            return defineClass(name, bytes, 0, bytes.length);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

//    private byte[] loadClassBytes(String name) {
//        // 实现加载类字节码的逻辑
//        // 例如，从文件、数据库等获取字节码
//        String
//    }

    public static void main(String[] args) throws Exception {
        JvmClassReload l = new JvmClassReload();
        Class<?> aClass = l.loadClass("java.lang.String");
        String o = (String)aClass.newInstance();
        System.out.println(o.toString());
    }

}
