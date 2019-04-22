package com.mrhu.spring.OldVersion.annotation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

@Deprecated
public class ClassPathXmlApplicationContext implements BeanFactory {
	
	private Map<String, Object> beans = new HashMap<String, Object>();
	
	public ClassPathXmlApplicationContext() throws Exception {
		SAXBuilder sb = new SAXBuilder();
        Document doc = sb.build(this.getClass().getClassLoader().getResource("beans.xml"));
        Element root = doc.getRootElement();
        List list = root.getChildren("bean");
        for(int i = 0;i < list.size();i++) {
            Element element = (Element)list.get(i);
            String id = element.getAttributeValue("id");
            String clazz = element.getAttributeValue("class");
            String directories = element.getChildText("files");
            System.out.println(id+":"+clazz);
            System.out.println("----------------------------------");
            Object o = Class.forName(clazz).newInstance();
            beans.put(id, o);
        }
	}
	
	@Override
	public Object getBean(String name) {
		return beans.get(name);
	}
	
}
