package com.zl.demo.xml;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DomXml {
	
    public void testAdd() throws Exception  
    {  
        //1.创建文档  
        Document doc = DocumentHelper.createDocument();  
           
        //2.增加标签  
        Element rootElement = doc.addElement("ContactList");  
        Element contactElement = rootElement.addElement("Contact");  
        Element nameElement = contactElement.addElement("Name");  
        nameElement.setText("小明");  
           
        //3.增加属性  
        contactElement.addAttribute("id", "c001");  
        contactElement.addAttribute("region", "北京");  
           
        //把修改后的Document对象写出到xml文档中  
        FileOutputStream out = new FileOutputStream("D:/123.xml");  
        OutputFormat format = OutputFormat.createPrettyPrint();  
        format.setEncoding("utf-8");  
        XMLWriter writer = new XMLWriter(out,format);  
        writer.write(doc);  
        writer.close();  
        System.out.println("执行结束！");  
    }  

	public void testModify() throws Exception {
		String filePath = DomXml.class.getResource(".").getPath()
				+ "system-conf.xml";
		File xmlFile = new File(filePath);
		Document doc = new SAXReader().read(xmlFile);
		/**
		 * 方案一： 修改属性值 1.得到标签对象 2.得到属性对象 3.修改属性值
		 */
		// 1.1 得到标签对象
		Element catElement = doc.getRootElement().element("Cat");
		// 1.2 得到属性对象
		Attribute catAttr = catElement.attribute("id");
		// 1.3 修改属性值
		catAttr.setValue("c100");
		/**
		 * 方案二： 修改属性值
		 */
		// 2.1 得到标签对象
		Element dogElement = doc.getRootElement().element("Dog");
		// 2.2 通过增加同名属性的方法，修改属性值
		dogElement.addAttribute("id", "d100");

		/**
		 * 修改文本 1.得到标签对象 2.修改文本
		 */
		Element nameElement = doc.getRootElement().element("Cat")
				.element("Home");
		nameElement.setText("第六宇宙");

		//FileOutputStream out = new FileOutputStream("D:/Animals.xml");
		FileOutputStream out = new FileOutputStream(filePath);
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out, format);
		writer.write(doc);
		writer.close();
		System.out.println("执行结束！");
	}

	/**
	 * 删除：标签，属性
	 */
	public void testDelete() throws Exception {
		Document doc = new SAXReader().read(new File("./src/animals.xml"));
		/**
		 * 1.删除标签 1.1 得到标签对象 1.2 删除标签对象
		 */
		// 1.1 得到标签对象
		Element nameElement = doc.getRootElement().element("Cat")
				.element("Home");
		// 1.2 删除标签对象
		nameElement.detach();
		// nameElement.getParent().remove(nameElement);

		/**
		 * 2.删除属性 2.1得到属性对象 2.2 删除属性
		 */
		Element catElement = doc.getRootElement().element("Cat");
		// 2.1得到属性对象
		Attribute idAttr = catElement.attribute("id");
		// 2.2 删除属性
		idAttr.detach();
		// idAttr.getParent().remove(idAttr);

		FileOutputStream out = new FileOutputStream("D:/rk/animals.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out, format);
		writer.write(doc);
		writer.close();
		System.out.println("执行结束！");
	}
	
	public static void main(String[] args) throws Exception {
		new DomXml().testModify();
	}
}
