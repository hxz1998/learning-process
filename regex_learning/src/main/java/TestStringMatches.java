import org.junit.Test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestStringMatches {

    /**
     * 辅助打印函数
     * @param o 要打印的对象
     */
    private static void print(Object o){
        System.out.println(o);
    }

    /**
     * 初步认识正则表达式及Java接口
     */
    @Test
    public void testStringMatches() {
        print("abc".matches("..."));

        Pattern pattern = Pattern.compile("[a-z]{3}");
        Matcher matcher = pattern.matcher("abc");
        print(matcher.matches());

        print(pattern.pattern());
    }

    /**
     *
     * . + ? * {} 代表的意思
     *
     * .        任意一个字符
     * +        一个或者多个
     * ?        一次或者一次都没有
     * *        零次或者多次
     * {n}      出现 n 次
     * {n,}     至少出现 n 次
     * {n, m}   至少出现 n 次，最多 m 次
     */
    @Test
    public void testRegex1() {
        print("aaa".matches("a.."));//.表示任意字符       true
        print("aaa".matches("a+"));//一次或者多次         true
        print("aaa".matches("a?"));//一次或者没有         false
        print("aaa".matches("a*"));//0次或者多次          true
        print("".matches("a*"));//空串当然是匹配的         true
        print("".matches("a?"));//同上                    true
        print("aaaaaa".matches("a{1,3}"));//一次到三次    false
        print("aaa".matches("a{1,}"));//                true
    }

    /**
     *  范围
     *
     *  [abc]           a,b,c中任意一个字符
     *  [^abc]          除了a,b,c其他任意字符
     *  [a-zA-Z]        范围a-z或者A-Z
     *  [a-z[A-Z]]      同上
     *  [a-z]|[A-Z]     同上
     *  [A-Z&&[RFG]]    &&取并集
     */
    @Test
    public void testRegex2() {
        print("a".matches("[abc]"));        //true
        print("a".matches("[^abc]"));       //false
        print("a".matches("[a-zA-Z]"));     //true
        print("a".matches("[a-z]|[A-Z]"));  //true
        print("a".matches("[a-z[A-Z]]"));   //true
        print("R".matches("[A-Z&&[RFG]]")); //true
    }

    /**
     * 特殊符号
     * .
     * \d   数字0-9
     * \D   除了0-9
     * \s   空格
     * \S   除了空格
     * \w   一个单词 a-z A-Z 空格 _
     * \W   不是一个单词
     */
    @Test
    public void testRegex3() {
        print(" \n\r\t".matches("\\s{4}"));
        print(" ".matches("\\S"));
        print("a_8".matches("\\w{3}"));
        print("abc888&^%".matches("[a-z]{1,3}\\d+[&^%]+"));
        print("\\".matches("\\\\"));
    }

    /**
     * 边界情况
     * ^    一行的开始
     * $    一行的结尾
     * \b   一个单词的边界
     */
    @Test
    public void testRegex4() {
        print("hello sir".matches("^h.*"));
        print("hello sir".matches(".*ir$"));
        print("hello sir".matches("^h[a-z]{1,3}o\\b.*"));
        print(" \n".matches("^[\\s&&[^\\n]]*\\n$")); //匹配空白行
    }

    /**
     * 练习
     * 匹配email地址
     */
    @Test
    public void testRegex5() {
        String reg = "[\\d|[a-z]]+@[[a-z]|\\d]*\\.[a-z]+";
        print("1366@162.com".matches(reg));
        print("hello@outlook.com".matches(reg));
        print("hello".matches(reg));
        print("123@23.co1".matches(reg));
        print("222".matches(reg));
        print("@23.com".matches(reg));
    }

    /**
     * matches find lookingAt
     * matches      匹配整个字符串
     * find         匹配字串是否有符合要求的，找到字符串符合了之后会去掉第一个字串，指向剩下的字串
     * lookingAt    每次都从头开始看看——差劲的命名
     */
    @Test
    public void testRegex6() {
        Pattern pattern = Pattern.compile("\\d{3,5}");
        String s = "123-4563-232-00";
        Matcher matcher = pattern.matcher(s);
        print(matcher.matches());       //matches匹配整个字符串，吃掉了前四个字符串
        matcher.reset();                //将吃掉的字符吐出来
        print(matcher.find());
        print(matcher.start() + "------" + matcher.end());
        print(matcher.find());
        print(matcher.start() + "------" + matcher.end());
        print(matcher.find());
        print(matcher.start() + "------" + matcher.end());
        print(matcher.find());
        //必须找到后才可以使用 start 和 end
//        print(matcher.start() + "------" + matcher.end());
        print(matcher.lookingAt());
        print(matcher.lookingAt());
        print(matcher.lookingAt());
        print(matcher.lookingAt());
    }

    /**
     * 字符串的替换
     * replaceAll();
     * appendReplacement();
     * appendTail();
     */
    @Test
    public void testRegex7() {
        Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher("java Java JAVa JaVa ILoveJAVA you hateJava 34123412341");
//        print(m.replaceAll("Java"));
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (m.find()) {
            i++;
            if (i % 2 == 0) {
                m.appendReplacement(stringBuffer, "java");
            } else {
                m.appendReplacement(stringBuffer, "JAVA");
            }
        }
        //将尾巴添加进来
        m.appendTail(stringBuffer);
        print(stringBuffer.toString());
    }

    /**
     * 正则表达式的分组
     * 数组数的方式：数左边的小括号，数到第几个就是第几组
     * find(index);
     */
    @Test
    public void testRegex8() {
        Pattern pattern = Pattern.compile("(\\d{3,5})([a-z]{2})");
        String s = "123aa-2342bb-48329cc-00";
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            print(matcher.group(2));
        }
    }

    /**
     * email spider
     * 练习：查找网页上的所有邮箱地址
     */
    @Test
    public void testRegex9() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/data.html"));
        String line = "";
        while ((line = br.readLine()) != null) {
            parse(line);
        }
    }
    private void parse(String line) {
        Pattern pattern = Pattern.compile("[\\d|[a-z]]+@[[a-z]|\\d]*\\.[a-z]+");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    /**
     * 练习， 统计代码量
     */
    private static long normalLines = 0;
    private static long commentLines = 0;
    private static long whiteLines = 0;
    @Test
    public void testRegex10() {
        File f = new File("S:\\source\\Java\\RegexLearning\\src\\main\\java\\");
        File[] codeFiles = f.listFiles();
        for (File child : codeFiles) {
            if (child.getName().matches(".*\\.java$")) {
                codeCounter(child);
            }
        }

        print("代码行：" + normalLines);
        print("注释行：" + commentLines);
        print("空白行：" + whiteLines);
    }
    public void codeCounter(File file) {
        BufferedReader br = null;
        boolean comment = false;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.matches("^[\\s&&[^\\n]]*")) {
                    whiteLines++;
                } else if (line.startsWith("/*") && !line.endsWith("*/")){
                    commentLines++;
                    comment = true;
                } else if (comment){
                    commentLines++;
                    if (line.endsWith("*/")) {
                        comment = false;
                    }
                }  else {
                    normalLines++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修饰符
     * Greedy       默认的修饰符 贪婪的 一下子读进去所有字符，然后一个一个吐出来
     * Reluctant    勉强的 一下子吞最小的集合，然后一个一个读进来，满足要求后就不动了
     * Possessive   不吐
     */
    @Test
    public void testRegex11() {
        Pattern pattern = Pattern.compile("(.{3,10}+)[0-9]");
        String s = "aaaa5bbb693";
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            print(matcher.start() + "-" + matcher.end());
        } else {
            print("not matches");
        }
    }
}