package com.itheima.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Dom4jParseTest1 {

    @Test
    public void testDom4j() throws DocumentException {
        //使用SaxReader类，加载xml文件，并创建Document对象
        Document doc = new SAXReader().read("src/books.xml");

        //使用document对象，获取到dom树的根节点
        Element rootElement = doc.getRootElement();

        //基于根元素，获取所有的子元素
        List<Element> bookList = rootElement.elements("book");

        //遍历：所有的子元素
        for (Element bookElement : bookList) {
            //获取name元素
            Element nameEl = bookElement.element("name");
            //获取name元素中的文本内容
            String nameText = nameEl.getText();
            System.out.println(nameText);

            //获取book元素上的id属性值
            String idValue = bookElement.attributeValue("id");
            System.out.println("id="+idValue);

            //获取作者元素下的文本内容
            String authorText = bookElement.elementText("author");
            System.out.println(authorText);
            System.out.println("------------------------------");
        }


    }
}
