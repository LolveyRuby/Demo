import com.Car;
import com.XbCalFunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Long value = 0l;
        System.out.println(value < 0);

//        testList();
//        testFunction();
//        testCal();
//        readFile();
//        String str = "1000";
//        String[] split = str.split("\\.");
//        System.out.println(split.length);

//        int a = 10;
//        int b = a--;
//        System.out.println(a);
//        System.out.println(b);


//        String str = "testByte";


//        byte[] bytes = str.getBytes();
//        ByteTest byteTest = new ByteTest();
//        byteTest.setB(bytes);
//        System.out.println("bytes:" + bytes);
//        System.out.println("byteTest:" + byteTest);
//        System.out.println("string:" + new String(bytes));

//        String s1 = new String("程序员");
//        String s2 = s1.intern();
//        String s3 = "程序员";
//        System.out.println(s1 == s2);
//        System.out.println(s3 == s2);
//        String str1 = "str";
//        String str2 = "ing";
//        String str3 = "str" + "ing";
//        String str4 = str1 + str2;
//        String str5 = "string";
//        System.out.println(str3 == str4);
//        System.out.println(str3 == str5);
//        System.out.println(str4 == str5);

//                Integer a = 10;
//        Integer b = 10;
//                Integer c= 129;Integer d = 129;
//        System.out.println(a == b);System.out.println(c == d);

//        String s1 = "Hello";
//        String s2 = "Hello";
//        String s3 = "Hel" + "lo";
//        String s4 = "Hel" + new String("lo");
//        String s5 = new String("Hello");
//        String s6 = s5.intern();
//        String s7 = "H";
//        String s8 = "ello";
//        String s9 = s7 + s8;
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s1 == s4);
//        System.out.println(s1 == s9);
//        System.out.println(s4 == s5);
//        System.out.println(s1 == s6);

//        BigDecimal z = new BigDecimal(0.00000);
//        System.out.println(z.stripTrailingZeros());


//        Car car = new Car();
//        if (null != car.getSeat() && 0 == car.getSeat()) {
//            System.out.println("-----------");
//        } else {
//            System.out.println("+++++++++++");
//        }
    }

    /**
     * 集合泛型类型为不同数据类型时进行排序
     */
    private static void testList() {
        List<Object> list = new ArrayList<>();
        list.add(new Integer(1));
        list.add(new Double(1.2));
        list.add("123");

        List<String> strList = new ArrayList<>();

        for (Object obj : list) {
            strList.add(String.valueOf(obj));
        }

        System.out.println(strList.toString());

        List<Object> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
    }

    /**
     * java1.8函数式接口
     */
    private static void testFunction() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("输出所有偶数：");
        eval(list, integer -> integer % 2 == 0);

        System.out.println("输出大于5的数：");
        eval(list, integer -> integer > 5);
    }

    private static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer i : list) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }

    /**
     * 函数式接口做计算
     */
    private static void testCal() {
        Integer a = 100;
        Integer b = 50;

        cal(a, b, (o, p) -> o + p);

        cal(a, b, (o, p) -> o - p);

        cal(a, b, (o, p) -> o * p);

        cal(a, b, (o, p) -> o / p);
    }

    private static void cal(Integer a, Integer b, CalFunction<Integer, Integer> calFunction) {
        System.out.println(calFunction.cal(a, b));
    }


    private static void cal1(String a, String b, XbCalFunction<String, String> calFunction) {
        System.out.println(calFunction.sum(a, b));
    }


    private static void testXbCal() {
        String a = "张";
        String b = "三";
//        Integer a = 100;
//        Integer b = 50;

        cal1(a,b,(o,p) -> a.equals(b));

//        cal(a, b, (o, p) -> o + p);
//
//        cal(a, b, (o, p) -> o - p);
//
//        cal(a, b, (o, p) -> o * p);
//
//        cal(a, b, (o, p) -> o / p);
    }


    private static void readFile() {
        // D:\IDEAWorkSpace\fintech\client-web\src\views\demo
        Map<String, String> map = getFilesDatas("D:\\IDEAWorkSpace\\fintech\\client-web\\src\\views\\userCenter");
        for (String key : map.keySet()) {
            String value = map.get(key);
//            System.out.println("文件名："+key+"   内容："+value);
            // label=".*"
            // <span .*>.*</span>
            String pattern = "label=\"(.*)\"";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(value);
            while (m.find()) {
                System.out.println("Found value: " + m.group(1));
            }
        }
    }

    /**
     * 获取某文件夹下的文件名和文件内容,存入map集合中
     *
     * @param filePath 需要获取的文件的 路径
     * @return 返回存储文件名和文件内容的map集合
     */
    public static Map<String, String> getFilesDatas(String filePath) {
        Map<String, String> files = new HashMap<>();
        File file = new File(filePath); //需要获取的文件的路径
        String[] fileNameLists = file.list(); //存储文件名的String数组
        File[] filePathLists = file.listFiles(); //存储文件路径的String数组
        for (int i = 0; i < filePathLists.length; i++) {
            if (filePathLists[i].isFile()) {
                try {//读取指定文件路径下的文件内容
                    String fileDatas = readFile(filePathLists[i]);
                    //把文件名作为key,文件内容为value 存储在map中
                    files.put(fileNameLists[i], fileDatas);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (filePathLists[i].isDirectory()) {
                files.putAll(getFilesDatas(filePathLists[i].getPath()));
            }
        }
        return files;
    }

    /**
     * 读取指定目录下的文件
     *
     * @param path 文件的路径
     * @return 文件内容
     * @throws IOException
     */
    public static String readFile(File path) throws IOException {
        //创建一个输入流对象
        InputStream is = new FileInputStream(path);
        //定义一个缓冲区
        byte[] bytes = new byte[1024];// 1kb
        //通过输入流使用read方法读取数据
        int len = is.read(bytes);
        //System.out.println("字节数:"+len);
        String all = "";
        String str = null;
        while (len != -1) {
            //把数据转换为字符串
            str = new String(bytes, 0, len);
            all = all + str;
            //继续进行读取
            len = is.read(bytes);
        }
        //释放资源
        is.close();
        return all;
    }
}
