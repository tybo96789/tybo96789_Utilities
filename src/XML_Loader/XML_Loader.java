package XML_Loader;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Tyler Atiburcio
 */
public abstract class XML_Loader implements XML_Interface {
    
    private String fileName;
    private org.w3c.dom.Document doc;
    
    public XML_Loader(String file)
    {
        File xml = new File(file);
        if(!xml.exists())
        {
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }
    
    public org.w3c.dom.Document loadXML()
    {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            doc = docBuilder.parse(new File(fileName));
            
            doc.getDocumentElement().normalize();
          

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XML_Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doc;
    }

}
/***
HOW TO GET ELEMENTS FROM THE XML FILE
* 
* 
* 
*             doc.getDocumentElement().normalize();
            NodeList listOfDrinks = doc.getElementsByTagName("drink");
            int totalDrinks = listOfDrinks.getLength();
for(int s=0; s<listOfDrinks.getLength() ; s++){

                Node drinkNode = listOfDrinks.item(s);
                if(drinkNode.getNodeType() == Node.ELEMENT_NODE){


                    Element drinkElement = (Element)drinkNode;

                    NodeList nameList = drinkElement.getElementsByTagName("name");
                    Element nameElement = (Element)nameList.item(0);

                    NodeList textNameList = nameElement.getChildNodes();
                    String drinkName = ((Node)textNameList.item(0)).getNodeValue().trim();

                    NodeList costList = drinkElement.getElementsByTagName("cost");
                    Element costElement = (Element)costList.item(0);

                    NodeList textCostList = costElement.getChildNodes();
                    Scanner scan = new Scanner(((Node)textCostList.item(0)).getNodeValue().trim());
                    double cost = scan.nextDouble();
                }
*/