package parserXML;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PointService {
    public static List<Point> createPointList(Set<Element> pointElements) {
        List<Point> points = new ArrayList<>();
        for (Element pointElement : pointElements) {
            int uidp = Integer.valueOf(pointElement.getElementsByTagName("UIDP").item(0).getTextContent());
            double x = Double.valueOf(pointElement.getElementsByTagName("X").item(0).getTextContent());
            double y = Double.valueOf(pointElement.getElementsByTagName("Y").item(0).getTextContent());
            Point point = new Point(uidp, x, y);
            points.add(point);
        }
        return points;
    }
}
