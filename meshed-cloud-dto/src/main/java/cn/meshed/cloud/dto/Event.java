package cn.meshed.cloud.dto;

import java.io.Serializable;

/**
 * <h1>Event</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public abstract class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
