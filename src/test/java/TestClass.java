import org.testng.annotations.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class TestClass {
    private static final String xmlFilePath = "C:\\Users\\user\\Desktop\\Test.xml";
    @Test
    public void test1(){

    }

    @Test
    public void test2() throws ParserConfigurationException, TransformerException {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element suite = document.createElement("suite");
            document.appendChild(suite);
            Attr verbose = document.createAttribute("verbose");
            verbose.setValue("10");
            Attr name = document.createAttribute("name");
            name.setValue(this.getClass().getName());
            suite.setAttributeNode(verbose);
            suite.setAttributeNode(name);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
            transformer.transform(domSource, streamResult);
        }
}
