package parserXML;

import org.w3c.dom.Element;

import java.io.File;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Natali\\Desktop\\xml_converter\\3522855000020001762.xml");

        ParserXML parser = new ParserXML();

        Set<Element> resultPoint = parser.findElementInFile(file, "Point");

        List<Point> points = PointService.createPointList(resultPoint);
        for (Point point : points) {
            System.out.println(point);
        }
    }
}
