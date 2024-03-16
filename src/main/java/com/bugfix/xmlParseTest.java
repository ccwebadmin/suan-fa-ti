package com.bugfix;

import org.w3c.dom.Document;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;

public class xmlParseTest {
//    public static void main(String[] args) {
//
//        //DocumentBuilderFactory library:
//        String xml = "xxe.xml";
//        DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
//        df.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ""); // Compliant
//        df.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ""); // compliant
//        DocumentBuilder builder = df.newDocumentBuilder();
//        Document document = builder.parse(new InputSource(xml));
//        DOMSource domSource = new DOMSource(document);
//
//        //SAXParserFactory library:
//        String xml = "xxe.xml";
//        SaxHandler handler = new SaxHandler();
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        SAXParser parser = factory.newSAXParser();
//        parser.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, ""); // Compliant
//        parser.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ""); // compliant
//        parser.parse(xml, handler);
//
//        //XMLInputFactory library:
//        XMLInputFactory factory = XMLInputFactory.newInstance();
//        factory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, ""); // Compliant
//        factory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ""); // compliant
//        XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("xxe.xml"));
//
//        //TransformerFactory library:
//        String xslt = "xxe.xsl";
//        String xml = "xxe.xml";
//        TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
//        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ""); //Compliant
//        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, ""); // Compliant
//        // ACCESS_EXTERNAL_SCHEMA not supported in several TransformerFactory implementations
//        Transformer transformer = transformerFactory.newTransformer(new StreamSource(xslt));
//        StringWriter writer = new StringWriter();
//        transformer.transform(new StreamSource(xml), new StreamResult(writer));
//        String result = writer.toString();
//
//        //SchemaFactory library:
//        String xsd = "xxe.xsd";
//        StreamSource xsdStreamSource = new StreamSource(xsd);
//        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//        schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ""); //Compliant
//        schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, ""); //Compliant
//        Schema schema = schemaFactory.newSchema(xsdStreamSource);
//
//        //Validator library:
//        String xsd = "xxe.xsd";
//        String xml = "xxe.xml";
//        StreamSource xsdStreamSource = new StreamSource(xsd);
//        StreamSource xmlStreamSource = new StreamSource(xml);
//        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//        Schema schema = schemaFactory.newSchema(xsdStreamSource);
//        schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
//        schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
//        // validators will also inherit of these properties
//        Validator validator = schema.newValidator();
//        validator.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, ""); // Compliant
//        validator.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ""); //Compliant
//        StringWriter writer = new StringWriter();
//        validator.validate(xmlStreamSource, new StreamResult(writer));
//
//        //For dom4j library,
//        ACCESS_EXTERNAL_DTD和 ACCESS_EXTERNAL_SCHEMA不支持，因此一个 非常严格的修复方法是禁用doctype声明：
//        SAXReader xmlReader = new SAXReader();
//        xmlReader.setFeature("http://apache.or g/xml/features/disallow-doctype-decl", true); // Compliant
//        Document xmlResponse = xmlReader.read(xml);
//
//         //Jdom2 library:
//        SAXBuilder builder = new SAXBuilder();
//        // Compliant
//        builder.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, ""); // Compliant
//        builder.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ""); // Compliant
//        Document document = builder.build(new File(xml));
//    }
}
