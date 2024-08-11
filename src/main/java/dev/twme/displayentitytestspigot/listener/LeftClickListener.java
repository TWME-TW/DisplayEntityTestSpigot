package dev.twme.displayentitytestspigot.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class LeftClickListener implements Listener {
    @EventHandler
    public void onLeftClickEvent(PlayerInteractEvent event) {

        if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK) {
            return;
        }

        Player player = event.getPlayer();
        event.setCancelled(true);

        List<Entity> entities = player.getNearbyEntities(5, 5, 5);
        for (Entity entity : entities) {
            if (entity.getType() == EntityType.BLOCK_DISPLAY) {
                entity.remove();
                player.sendMessage("Block Display removed!");
            }
        }
    }
}
