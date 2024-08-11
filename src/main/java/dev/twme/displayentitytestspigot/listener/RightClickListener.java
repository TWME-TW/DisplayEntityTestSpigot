package dev.twme.displayentitytestspigot.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockType;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class RightClickListener implements Listener {
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getHand() != EquipmentSlot.HAND) {
            return;
        }
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK && event.getAction() != Action.RIGHT_CLICK_AIR) {
            return;
        }

        event.setCancelled(true);
        Block block =  event.getClickedBlock();
        if (block == null) {
            return;
        }

        Entity displayBlock = block.getWorld().spawnEntity(block.getLocation(), EntityType.BLOCK_DISPLAY);
        BlockDisplay blockDisplay = (BlockDisplay) displayBlock;

        blockDisplay.setBlock(block.getBlockData());
        player.sendMessage("Block Display spawned!");

        block.setType(Material.AIR, true);
        block.getState().update();

    }
}
