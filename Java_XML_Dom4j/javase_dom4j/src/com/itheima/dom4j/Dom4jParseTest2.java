package com.itheima.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Dom4jParseTest2 {

    @Test
    public void testDom4j() throws DocumentException {
        //使用SaxReader类，加载xml文件，并创建Document对象
        Document doc = new SAXReader().read("src/books.xml");

        //使用document对象，获取到dom树的根节点
        Element rootElement = doc.getRootElement();

        //基于根元素，获取所有的子元素
        List<Element> bookList = rootElement.elements("book");

        //集合：存储Book对象
        List<Book> books = new ArrayList<>();
        //遍历：所有的子元素
        for (Element bookElement : bookList) {
            //获取id属性值
            String id = bookElement.attributeValue("id");
            //获取name元素的文本值
            String name = bookElement.element("name").getText();
            //获取author元素的文本值
            String author = bookElement.elementText("author");
            //获取sale元素的文本值
            String sale = bookElement.elementText("sale");

            //把解析出来的数据，封装到Book对象
            Book book = new Book(id,name,author,sale);

            books.add(book);//把book对象存储到集合中
        }

        //遍历集合
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
