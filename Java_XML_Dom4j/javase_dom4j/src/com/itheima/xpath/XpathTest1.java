package com.itheima.xpath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class XpathTest1 {


    //条件筛选路径表达式
    @Test
    public void test4() throws DocumentException {
        //加载xml文档，创建Document对象
        Document doc = new SAXReader().read("src/Contact.xml");

        //条件筛选路径表达式
        String  path = "//contact[@id=2]";

        //根据路径表达式，去xml文档中检查符合路径的所有元素
        List<Node> nodeList = doc.selectNodes(path);

        for (Node node : nodeList) {
            //获取元素上的id属性值
            Element element =(Element) node;//把Node类型（父类型）强制转换为Element类型（子类型）
            String id = element.attributeValue("id");
            System.out.println("id="+id);

            String nameText = element.elementText("name");
            System.out.println(nameText);
        }
    }



    //全文搜索路径表达式
    @Test
    public void test3() throws DocumentException {
        //加载xml文档，创建Document对象
        Document doc = new SAXReader().read("src/Contact.xml");

        //全文搜索路径表达式
        String  path = "//contact//name";

        //根据路径表达式，去xml文档中检查符合路径的所有元素
        List<Node> nodeList = doc.selectNodes(path);

        for (Node node : nodeList) {
            System.out.println(node.getText());
        }
    }


    //相对路径表达式
    @Test
    public void test2() throws DocumentException {
        //加载xml文档，创建Document对象
        Document doc = new SAXReader().read("src/Contact.xml");
        String  path = "/contactList/contact";//绝对路径表达式

        //根据路径表达式，去xml文档中检查符合路径的所有元素
        List<Node> nodeList = doc.selectNodes(path);

        for (Node node : nodeList) {

            //相对路径表达式
            path = "./name";

            Node nameEl = node.selectSingleNode(path);
            System.out.println(nameEl.getText());
        }
    }



    //绝对路径表达式
    @Test
    public void test1() throws DocumentException {
        //加载xml文档，创建Document对象
        Document doc = new SAXReader().read("src/Contact.xml");

        //路径表达式（绝对路径）
        String  path = "/contactList/contact/name";

        //根据路径表达式，去xml文档中检查符合路径的所有元素
        List<Node> nodeList = doc.selectNodes(path);

        for (Node node : nodeList) {
            String text = node.getText();
            System.out.println(text);
        }
    }
}
