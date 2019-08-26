package com.zl.demo.xml;

import java.io.FileOutputStream;
import java.io.IOException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class DomXmlOne {

	public static void main(String[] args) throws DocumentException, IOException {
/*		String filePath = DomXml.class.getResource(".").getPath() +"system-conf.xml";
        File xmlFile = new File(filePath);
        Document doc = new SAXReader().read(xmlFile); 
        List nameElement = doc.getRootElement().elements();  
        Element e1 = (Element) nameElement.get(0);
        e1.addAttribute("value", "123");
        System.out.println(e1.attributeValue("name"));
        e1.addAttribute("name", "123");
        System.out.println(e1.attributeValue("value"));
        System.out.println(e1.attributeValue("name"));
      //  nameElement.detach();  
        //Attribute idAttr = nameElement.attribute("name");  
        //idAttr.setValue("123131");
        FileOutputStream out = new FileOutputStream(filePath);  
        OutputFormat format = OutputFormat.createPrettyPrint();  
        format.setEncoding("utf-8");  
        XMLWriter writer = new XMLWriter(out,format);  
        writer.write(doc);  
        writer.close();  
        System.out.println("执行结束！");  */
		Document doc = DocumentHelper.createDocument();  
	       //2.增加标签  
        Element rootElement = doc.addElement("Meeting");  
        Element product = rootElement.addElement("product");  
        Element machine = rootElement.addElement("machine");  
        Element version = rootElement.addElement("version"); 
        product.setText("Meeting");
        machine.setText("132456465464645654");
        version.setText("Normal");
           
           
        //把修改后的Document对象写出到xml文档中  
        FileOutputStream out = new FileOutputStream("D:/MachineCode.xml");  
        OutputFormat format = OutputFormat.createPrettyPrint();  
        format.setEncoding("utf-8");  
        XMLWriter writer = new XMLWriter(out,format);  
        writer.write(doc);  
        writer.close();  
        System.out.println("执行结束！");  
	}
}
