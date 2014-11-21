package in.twizmwaz.cardinal.regions.type;

import in.twizmwaz.cardinal.regions.Region;
import in.twizmwaz.cardinal.regions.parsers.BlockParser;
import in.twizmwaz.cardinal.util.WorldPoint;
import org.bukkit.Bukkit;
import org.bukkit.Location;


/**
 * Created by kevin on 10/26/14.
 */
public class BlockRegion extends Region {

    private double x;
    private double y;
    private double z;

    public BlockRegion(int x, int y, int z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public BlockRegion(BlockParser parser) {
        this.x = parser.getX();
        this.y = parser.getY();
        this.z = parser.getZ();

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean contains(BlockRegion region) {
        return region.getX() == getX() && region.getY() == getY() && region.getZ() == getZ();
    }

    @Override
    public boolean contains(WorldPoint region) {
        return region.getX() == getX() && region.getY() == getY() && region.getZ() == getZ();
    }

    @Override
    public WorldPoint getRandomPoint() {
        return new WorldPoint(x, y, z);
    }
    public Location getLocation() {
        return new Location(Bukkit.getWorlds().get(0), x, y, z);
    }
}
