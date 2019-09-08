package cn.itcast.file.demo1;


import org.junit.Test;

import java.io.*;
import java.util.*;

public class Demo01 {
    //获取系统换行符
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    //获取文件编码
    private static final String CHARSET = System.getProperty("file.encoding");

    /**
     * 测试文件清单
     *
     * @param dir 源文件夹
     * @param src 文件清单
     */
    @Test
    public void FileList() throws Exception {
        String dir = "D:\\毕业照片";
        String src = "D:\\毕业照片\\file_list.txt";
        File file_dir = new File(dir);
        File file_src = new File(src);
        OutFileList(file_dir, file_src);
    }

    /**
     * 测试文件复制
     */
    @Test
    public void testFileCopy() throws Exception {
        String dir = "D:\\毕业照片\\视频\\世界上最不能等待的事.mp4";
        String src = "d:\\毕业照片\\";
        File file_dir = new File(dir);
        File file_src = new File(src);
        this.FileCopy(file_dir, file_src);
    }

    /**
     * 测试字符串保存到文件
     */
    @Test
    public void testFileOut() throws Exception {
        String path = "D:\\毕业照片\\file_list.sql";
        File file = new File(path);
        String name = "邹芳";
        String url = "http://www.zoufang.com";
        for (int i = 1; i <= 1000; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("INSERT INTO `tb_file_list` (`id`,`name`, `url`)\n" +
                    "VALUES\n" +
                    "\t(\n" +
                    "\t\t" + i + ",\n" +
                    "\t\t'" + name + "',\n" +
                    "\t\t'" + url + i + "'\n" +
                    "\t);");
            this.FileOut(stringBuffer.toString(), file, true);
        }
    }

    @Test
    public void FileOutSystemPropertions() throws Exception {
        Properties properties = System.getProperties();
        Set<String> strings = properties.stringPropertyNames();
        for (String key : strings) {
            String value = System.getProperty(key);
            this.FileOut(new StringBuffer(key + ":" + value).toString(), new File("d:\\毕业照片\\system_propertes.propertioes"), true);
        }
    }

    /**
     * 字符串保存到文件中
     *
     * @param string 等待保存的字符串;
     * @param file   指定保存的文件
     * @param append 是否续写标记，false 不续写，true 文件续写
     */
    public void FileOut(String string, File file, Boolean append) throws Exception {
        this.FileOut(string, file, append, CHARSET);
    }

    /**
     * @param CHARSET 指定的文件编码
     */
    public void FileOut(String string, File file, Boolean append, String CHARSET) throws Exception {
        String charset = "utf-8";
        if (file.isDirectory()) {
            throw new Exception("not file exception");
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, append));
        outputStreamWriter.write(string + LINE_SEPARATOR);
        outputStreamWriter.flush();
        outputStreamWriter.close();

    }

    /**
     * 遍历文件夹下的文件夹和文件，保存到文件中，文件清单，递归调用
     * @param file 源文件(文件夹或文件)
     * @param file_out 文件输出流，文件清单目标
     */
    public void getFileList(File file, File file_out) throws Exception {
        File[] files = file.listFiles();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                this.FileOut("files【" + files[i].getAbsolutePath() + "】", file_out, true);
                getFileList(files[i], file_out);
            } else if (files[i].isFile()) {
                this.FileOut("file【" + files[i].getAbsolutePath() + "】", file_out, true);
            }
        }
    }

    @Test
    public void testGetFileList() {
        String path = "D:\\技术文档";
        File file = new File(path);
        Map<String, List> map = getFileList(file);
        int size = map.size();
        System.out.println(map);
        if (size > 0) {
            List list = map.get("files");
            List list1 = map.get("file");
            for (int i = 0; i < list.size(); i++) {
                System.out.println("files:" + list.get(i));
            }
            System.out.println("----------------------------------");
            for (int i = 0; i < list1.size(); i++) {
                System.out.println("file:" + list1.get(i));
            }
        }
    }

    /**
     * 获取文件夹下的文件和文件夹
     * @param file 文件或文件夹资源
     * @return map<String,List> = {"files"=["文件夹1,文件夹2,文件夹3,..."],"file"=["文件1","文件2","文件3",...]}
     * */
    public Map<String, List> getFileList(File file) {
        Map<String, List> map = new LinkedHashMap<>();
        List<String> FileList = new LinkedList<>();
        List<String> FilesList = new LinkedList<>();
        //判断文件夹或文件夹存在
        if (!file.exists()) {
            return map;
        }
        //判断文件是否文件夹
        if (!file.isDirectory()) {
            ((LinkedList<String>) FileList).addLast(file.getAbsolutePath());
        } else {
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    ((LinkedList<String>) FilesList).addLast(file1.getAbsolutePath());
                } else {
                    ((LinkedList<String>) FileList).addLast(file1.getAbsolutePath());
                }
            }
        }
        map.put("files", FilesList);
        map.put("file", FileList);
        return map;
    }


    /**
     * 利用队列遍历文件夹下的文件夹和文件，保存到文件中，文件清单，队列调用
     */
    public void OutFileList(File file_dir, File file_out) throws Exception {
        Queue<File> queue = new Queue<File>();
        File[] files = file_dir.listFiles();
        for (File file : files) {
            isFile(file, file_out, queue);
        }
        while (!queue.isNull()) {
            File file = queue.myGet();
            for (File subFile : file.listFiles()) {
                isFile(subFile, file_out, queue);
            }
        }
    }

    /**
     * 判断是否为文件或文件夹
     */
    private void isFile(File file, File file_out, Queue<File> queue) throws Exception {
        if (file.isDirectory()) {
            FileOut("files=" + file.getAbsolutePath(), file_out, true);
            queue.myAdd(file);
        } else {
            FileOut("file=" + file.getAbsolutePath(), file_out, true);
        }
    }

    /**
     * 文件复制
     * @param file_dir 源文件，待复制的文件
     * @param file_src 目的文件;
     */
    public void FileCopy(File file_dir, File file_src) throws Exception {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        /**
         * 判断源是否为文件
         * */
        if (file_dir.isDirectory()) {
            throw new Exception("not is file");
        }
        /**
         * 获取源文件名
         * */
        if (file_src.isDirectory()) {

            file_src = new File(file_src.getAbsolutePath() + "\\copy_" + file_dir.getName());
        }
        try {
            fileInputStream = new FileInputStream(file_dir);
            fileOutputStream = new FileOutputStream(file_src);
            int len = 0;
            byte[] bytes = new byte[1024];

            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
                fileOutputStream.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
