package in.twizmwaz.cardinal.regions;

import in.twizmwaz.cardinal.module.Module;
import in.twizmwaz.cardinal.regions.type.BlockRegion;
import in.twizmwaz.cardinal.util.WorldPoint;

/**
 * Created by kevin on 10/26/14.
 */
public abstract class Region extends Module {

    public Region() {
    }

    public abstract boolean contains(BlockRegion region);

    public abstract boolean contains(WorldPoint point);

    public abstract WorldPoint getRandomPoint();


}
