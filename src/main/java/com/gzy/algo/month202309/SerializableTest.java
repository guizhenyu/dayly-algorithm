package com.gzy.algo.month202309;

import java.io.*;

/**
 * @Author dw
 * @ClassName SerializableTest
 * @Description
 * @Date 2023/1/2 15:08
 * @Version 1.0
 */
public class SerializableTest {

    public static void main(String[] args) {
        // 初始化
        User user = new User();
        user.setName("王二");
        user.setAge(18);
        System.out.println(user);

//        // 把对象写到文件中
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.txt"))){
//            oos.writeObject(user);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 从文件中读出对象
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("user.txt")))){
//            User userRead = (User) ois.readObject();
//            System.out.println(userRead);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        Thread thread = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(10000);
                    System.out.println("i'm sleeping ");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end");
    }

    public static class User implements Serializable{

        private static final long serialVersionUID = -9085952353374185654L;

        private String name;

        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}