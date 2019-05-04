package org.sekka.core.event;

import com.google.common.collect.ImmutableBiMap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import org.jetbrains.annotations.NotNull;
import org.sekka.api.event.Event;
import org.sekka.api.event.EventManager;

public class SekkaEventManager implements EventManager {

    public static final ImmutableBiMap<EventPriority, org.sekka.api.event.EventPriority> PRIORITY_MAPPINGS =
            new ImmutableBiMap.Builder<EventPriority, org.sekka.api.event.EventPriority>()
                    .put(EventPriority.HIGHEST, org.sekka.api.event.EventPriority.FIRST)
                    .put(EventPriority.HIGH, org.sekka.api.event.EventPriority.EARLY)
                    .put(EventPriority.NORMAL, org.sekka.api.event.EventPriority.DEFAULT)
                    .put(EventPriority.LOW, org.sekka.api.event.EventPriority.LATE)
                    .put(EventPriority.LOWEST, org.sekka.api.event.EventPriority.LAST)
                    .build();

    public void register(@NotNull Object listener) {
        MinecraftForge.EVENT_BUS.register(listener);
    }

    public void unregister(@NotNull Object listener) {
        MinecraftForge.EVENT_BUS.unregister(listener);
    }

    public boolean post(@NotNull Event event) {
        return MinecraftForge.EVENT_BUS.post((net.minecraftforge.fml.common.eventhandler.Event) event);
    }
}
