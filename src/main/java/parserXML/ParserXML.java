package parserXML;

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
import java.util.HashSet;
import java.util.Set;

public class ParserXML {

    public void findElenent(Set<Element> resultNode, Node node, String name) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            if (element.getTagName().equals(name)) {
                resultNode.add(element);
            }
            NodeList nodes = element.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node1 = nodes.item(i);
                findElenent(resultNode, node1, name);
            }
        }
    }

    public Set<Element> findElementInFile(File xmlFile, String name) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Set<Element> result = new HashSet<>();
        try {
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();

            Document document = builder.parse(xmlFile);
            Element root = document.getDocumentElement();
            NodeList nodes = root.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                findElenent(result, node, name);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }


}

//    public static List<Point> loadFromXMLFile(File file) {
//        PointInfo pointInfo = new PointInfo();
//        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//        try {
//            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//
//            Document document = documentBuilder.parse(file);
//
//            Element root = document.getDocumentElement();
//            System.out.println("Корневой элемент: " + root.getNodeName());
//            System.out.println("--------------------------");
//
//            if (!root.getNodeName().equals("PointInfo")) {
//                Element poinInfo = (Element) ParserXML.nodeSearch(root);
//
//                NodeList points = poinInfo.getChildNodes();
//
//                for (int i = 0; i < points.getLength(); i++) {
//                    Node node = points.item(i);
//
//                    if (node.getNodeType() == Node.ELEMENT_NODE) {
//                        Element element = (Element) node;
//                        Point point = getPointFromNode(element);
//                        if (point != null) {
//                            pointInfo.addPoint(point);
//                        }
//                    }
//                }
//            }
//
//        } catch (ParserConfigurationException | SAXException | IOException e) {
//            e.printStackTrace();
//        }
//        List<Point> pointList = pointInfo.getListPoint();
//        return pointList;
//    }
//
//
//    private static Point getPointFromNode(Element pointElement) {
//        if (!pointElement.getTagName().equals("Point")) {
//            return null;
//        }
//
//        int uidp = Integer.valueOf(pointElement.getElementsByTagName("UIDP").item(0).getTextContent());
//        double x = Double.valueOf(pointElement.getElementsByTagName("X").item(0).getTextContent());
//        double y = Double.valueOf(pointElement.getElementsByTagName("Y").item(0).getTextContent());
//
//        Point point = new Point(uidp, x, y);
//        return point;
//
//    }
//
//    private static PointInfo nodeSearch(Element element) {
//        if (!element.getNodeName().equals("PointInfo")) {
//            NodeList nodeList = element.getChildNodes();
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                Node node = nodeList.item(i);
//                if (node.getNodeName().equals("PointInfo")) {
//                    return (PointInfo) node;
//                } else {
//                    ParserXML.nodeSearch((Element) node);
//                }
//            }
//        }
//        return null;
//    }





