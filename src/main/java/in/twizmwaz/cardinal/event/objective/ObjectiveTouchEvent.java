package in.twizmwaz.cardinal.event.objective;

import in.twizmwaz.cardinal.module.GameObjective;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class ObjectiveTouchEvent extends ObjectiveEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private boolean updateScoreboard;

    public ObjectiveTouchEvent(GameObjective objective, Player player, boolean updateScoreboard) {
        super(objective, player);
        this.updateScoreboard = updateScoreboard;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

    public GameObjective getObjective() {
        return objective;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean updateScoreboard() {
        return updateScoreboard;
    }
}
