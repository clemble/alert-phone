package com.clemble.casino.server.phone;

import com.clemble.casino.player.PlayerAware;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

/**
 * Created by mavarazy on 12/8/14.
 */
public class ServerPlayerPhone implements PlayerAware {

    @Id
    final private String player;
    final private String phone;

    @JsonCreator
    public ServerPlayerPhone(@JsonProperty(PLAYER) String player, @JsonProperty("phone") String phone) {
        this.player = player;
        this.phone = phone;
    }

    @Override
    public String getPlayer() {
        return player;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return player + ":" + phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServerPlayerPhone that = (ServerPlayerPhone) o;

        if (!phone.equals(that.phone)) return false;
        if (!player.equals(that.player)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = player.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }
}
