package me.Drison64.doorPin.Events.BlockInteraction;

import me.Drison64.doorPin.Inventories.addInventory.addInventory;
import me.Drison64.doorPin.data;
import me.Drison64.doorPin.hashmaps;
import me.Drison64.doorPin.messageParser;
import me.Drison64.doorPin.messages;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class onBlockClickADD implements Listener {

    @EventHandler
    public void onBlickClickADD(PlayerInteractEvent e) {

        Block clickedBlock = e.getClickedBlock();
        Player whoClicked = e.getPlayer();

        if (e.getAction().equals(Action.LEFT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

            if (hashmaps.addClickPhase.get(e.getPlayer()) == null && !(hashmaps.editPhaseClick.get(e.getPlayer()) == null)) {
                return;
            }

            if (!(hashmaps.addClickPhase.get(e.getPlayer()) == null)) {
                data.reload();
                if (data.get().isSet("data.blocks." + clickedBlock.getX() + clickedBlock.getY() + clickedBlock.getZ() + ".pin")) {
                    e.setCancelled(true);
                    return;
                } else {
                    e.setCancelled(true);
                    Inventory inv = addInventory.getNewInventory("");
                    whoClicked.openInventory(inv);
                    hashmaps.addPhaseInventory.put(whoClicked, inv);
                    hashmaps.addPhaseBlock.put(whoClicked, clickedBlock);
                    hashmaps.addClickPhase.remove(e.getPlayer());
                }


            }

        }

    }

}
