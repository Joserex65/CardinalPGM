package in.twizmwaz.cardinal.module.modules.regions.parsers;

import in.twizmwaz.cardinal.module.modules.regions.RegionParser;
import in.twizmwaz.cardinal.util.NumUtils;
import org.jdom2.Element;

public class RectangleParser extends RegionParser {

    private final double xMin, zMin, xMax, zMax;

    public RectangleParser(Element element) {
        super(element.getName());
        String min = element.getAttributeValue("min");
        String max = element.getAttributeValue("max");
        String[] mins = min.trim().replaceAll(" ", ",").split(",");
        String[] maxs = max.trim().replaceAll(" ", ",").split(",");
        xMin = NumUtils.parseDouble(mins[0]);
        zMin = NumUtils.parseDouble(mins[1]);
        xMax = NumUtils.parseDouble(maxs[0]);
        zMax = NumUtils.parseDouble(maxs[1]);
    }

    public double getXMin() {
        return xMin;
    }

    public double getZMin() {
        return zMin;
    }

    public double getXMax() {
        return xMax;
    }

    public double getZMax() {
        return zMax;
    }

}
