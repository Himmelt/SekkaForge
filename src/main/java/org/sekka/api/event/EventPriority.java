package org.sekka.api.event;

public enum EventPriority {
    FIRST, //First to execute
    EARLY,
    DEFAULT,
    LATE,
    LAST //Last to execute
}
