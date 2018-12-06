package com.nike.reptile.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: reptile
 * @description: 读写文件工具类
 * @author: Geekye
 * @create: 2018-12-06 17:59
 **/
public class ReadAndWriteUtil {

    private File file = new File("./ShoesHash.txt");

    /**
     * 将List写入到文件中
     */
    public void writeListIntoFile(List<String> list) {

        System.out.println(file.getAbsolutePath());
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            for (String str:list
                 ) {
                fileWriter.append(str+"\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 将文件数据读到List中
     *
     */
    public List<String> readFileIntoList(){

        List<String> list = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line ;
            while ((line = bufferedReader.readLine() )!= null) {
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        File file = new File("./123.txt");
        System.out.println(file.exists());
    }
}
