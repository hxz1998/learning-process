import java.io.IOException;
import java.util.*;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;

public class JdomTest {
    @Test
    public void test() throws JDOMException, IOException {
        SAXBuilder sb = new SAXBuilder();
        Document doc = sb.build("resource/test.xml");
        Element root = doc.getRootElement();
        List list = root.getChildren("disk");
        for(int i = 0;i < list.size();i++) {
            Element element = (Element)list.get(i);
            String name = element.getAttributeValue("name");
            System.out.println("磁盘信息：\n分区磁盘:"+name);
            String capacity = element.getChildText("capacity");
            String directories = element.getChildText("files");
            System.out.println("分区容量："+capacity);
            System.out.println("目录数："+directories);
            System.out.println("----------------------------------");
        }
    }
}
