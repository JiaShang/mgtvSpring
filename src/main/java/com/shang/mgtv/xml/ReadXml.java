package com.shang.mgtv.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ReadXml {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();//获得解析工厂
    DocumentBuilder db = dbf.newDocumentBuilder(); //获得建造者对象
    File file = new File("test.xml");//获得XML文件
    Document doc = db.parse(file);//获得文档对象

    NodeList nl = doc.getElementsByTagName("file");//根据标签获得节点列表

    Element element = (Element)nl.item(0);//获得特定位置的根节点元素videos  file  filename

    Node node = element.getElementsByTagName("filename").item(0);//获得子节点
//    String s = node.

    String msg = node.getFirstChild().getNodeValue();//获取子节点里面的第一个标签里面的值

    public String getMsg() {
        return msg;
    }
    public String getPath(){
        return file.getPath();
    }

    public ReadXml() throws IOException, SAXException, ParserConfigurationException {
    }
}
