package in.twizmwaz.cardinal.teams;

import in.twizmwaz.cardinal.regions.Region;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.List;
import java.util.Set;

/**
 * Created by kevin on 11/17/14.
 */
public class PgmTeam {

    private Team scoreboardTeam;
    private String name;
    private String id;
    private int max;
    private int maxOverfill;
    private int respawnLimit;
    private ChatColor color;
    private boolean observer;

    PgmTeam(String name, String id, int max, int maxOverfill, int respawnLimit, ChatColor color, boolean obs, Scoreboard scoreboard) {
        this.observer = obs;
        this.name = name;
        this.id = id;
        this.max = max;
        this.maxOverfill = maxOverfill;
        this.respawnLimit = respawnLimit;
        this.color = color;
        this.scoreboardTeam = scoreboard.registerNewTeam(id);
        scoreboardTeam.setDisplayName(color + name);

    }

    public void add(Player player) {
        scoreboardTeam.addPlayer(player.getPlayer());
    }

    public void remove(Player player) {
        scoreboardTeam.remove(player.getName());
        scoreboardTeam.removePlayer(player.getPlayer());
    }

    public boolean hasPlayer(Player player) {
        return scoreboardTeam.hasPlayer(player);
    }

    public Set<OfflinePlayer> getPlayers() {
        return scoreboardTeam.getPlayers();
    }

    public int getMax() {
        return max;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public ChatColor getColor() {
        return color;
    }
}
