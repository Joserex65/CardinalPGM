package in.twizmwaz.cardinal.regions.type.combinations;


import in.twizmwaz.cardinal.regions.Region;
import in.twizmwaz.cardinal.regions.parsers.modifiers.CombinationParser;
import in.twizmwaz.cardinal.regions.type.BlockRegion;
import in.twizmwaz.cardinal.util.WorldPoint;

import java.util.List;

/**
 * Created by kevin on 10/26/14.
 */
public class ComplementRegion extends Region {

    private List<Region> regions;

    public ComplementRegion(String name, List<Region> regions) {
        this.regions.addAll(regions);
    }

    public ComplementRegion(CombinationParser parser) {
        this.regions.addAll(parser.getRegions());
    }

    public List<Region> getRegions() {
        return regions;
    }

    @Override
    public boolean contains(BlockRegion region) {
        List<Region> working = getRegions();
        for (Region work : working) {
            if (work.contains(region)) {
                working.remove(work);
            }
        }
        if (working.size() == 1) return true;
        else return false;
    }

    @Override
    public boolean contains(WorldPoint region) {
        List<Region> working = getRegions();
        for (Region work : working) {
            if (work.contains(region)) {
                working.remove(work);
            }
        }
        if (working.size() == 1) return true;
        else return false;
    }

    //kinda need to finish this
    @Override
    public WorldPoint getRandomPoint() {
        return null;
        /*while (true) {
            WorldPoint point = regions.get(0).getRandomPoint();
            for (Region region : regions) {

            }
        }*/
    }
}
