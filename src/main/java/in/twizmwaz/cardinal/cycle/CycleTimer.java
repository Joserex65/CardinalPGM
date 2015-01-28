package in.twizmwaz.cardinal.cycle;

import com.sk89q.minecraft.util.commands.ChatColor;
import in.twizmwaz.cardinal.GameHandler;
import in.twizmwaz.cardinal.match.MatchState;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.plugin.java.JavaPlugin;

public class CycleTimer implements Runnable, Cancellable {

    private Cycle cycle;
    private int time;
    private boolean cancelled;
    private JavaPlugin plugin;
    private MatchState originalState;

    public CycleTimer(Cycle cycle, int time) {
        this.cycle = cycle;
        this.time = time;
        this.cancelled = false;
        this.plugin = GameHandler.getGameHandler().getPlugin();
        this.originalState = GameHandler.getGameHandler().getMatch().getState();
    }

    @Override
    public void run() {
        if (!isCancelled()) {
            GameHandler.getGameHandler().getMatch().setState(MatchState.CYCLING);
            if ((this.time % 5 == 0 && time > 0) || (time < 5 && time > 0)) {
                Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "Rotando a " + ChatColor.AQUA + cycle.getMap().getName() + ChatColor.DARK_AQUA + " en " + ChatColor.DARK_RED + time + ChatColor.DARK_AQUA + " segundo(s)");
            }
            if (this.time == 0) {
                GameHandler.getGameHandler().cycleAndMakeMatch();
            } else {
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, this, 20);
            }
            this.time--;
        } else {
            this.setCancelled(false);
        }
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        this.cancelled = isCancelled;
        if (this.cancelled) {
            GameHandler.getGameHandler().getMatch().setState(originalState);
        }
    }
}
