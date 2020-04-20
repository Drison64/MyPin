package me.Drison64.doorPin.Inventories.Events;

import me.Drison64.doorPin.Inventories.editInventory.commands.commandsInventory;
import me.Drison64.doorPin.hashmaps;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class onInventoryClose implements Listener {

    @EventHandler
    public void onCommandInventoryClose(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();
        if (e.getInventory().equals(hashmaps.infoPhaseInventory.get(player))) {
            closed(player);
        } else if (e.getInventory().equals(hashmaps.enterPhaseInventory.get(player))) {
            closed(player);
        } else if (e.getInventory().equals(hashmaps.addPhaseInventory.get(player))) {
            closed(player);
        }
    }

    public void closed(Player player) {
        //hashmaps.editPhasePage.remove(player);
        //hashmaps.editPhaseInventory.remove(player);
        //hashmaps.addPhaseBlock.remove(player);
        //hashmaps.addPhaseInventory.remove(player);
        //hashmaps.enterPhaseBlock.remove(player);
        //hashmaps.enterPhaseInventory.remove(player);
    }

}
