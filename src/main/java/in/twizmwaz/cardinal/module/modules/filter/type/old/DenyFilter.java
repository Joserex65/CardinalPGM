package in.twizmwaz.cardinal.module.modules.filter.type.old;

import in.twizmwaz.cardinal.module.ModuleCollection;
import in.twizmwaz.cardinal.module.modules.filter.FilterModule;
import in.twizmwaz.cardinal.module.modules.filter.FilterState;
import in.twizmwaz.cardinal.module.modules.filter.parsers.GenericFilterParser;
import org.bukkit.event.Event;

import static in.twizmwaz.cardinal.module.modules.filter.FilterState.ALLOW;
import static in.twizmwaz.cardinal.module.modules.filter.FilterState.DENY;

public class DenyFilter extends FilterModule {

    private final ModuleCollection<FilterModule> children;

    public DenyFilter(final GenericFilterParser parser) {
        super(parser.getName());
        this.children = parser.getChildren();
    }

    @Override
    public FilterState evaluate(final Event event) {
        for (FilterModule child : children) {
            if (child.evaluate(event).equals(ALLOW)) return DENY;
        }
        return ALLOW;
    }
}
