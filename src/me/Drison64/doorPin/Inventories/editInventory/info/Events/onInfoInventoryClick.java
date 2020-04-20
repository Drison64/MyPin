package me.Drison64.doorPin.Inventories.editInventory.info.Events;

import me.Drison64.doorPin.Inventories.editInventory.commands.commandsInventory;
import me.Drison64.doorPin.Inventories.editInventory.info.infoInventory;
import me.Drison64.doorPin.Inventories.mkitem;
import me.Drison64.doorPin.data;
import me.Drison64.doorPin.hashmaps;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

public class onInfoInventoryClick implements Listener {

    @EventHandler
    public void onAddInventoryClickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getClickedInventory().equals(hashmaps.infoPhaseInventory.get(player)) && e.getClickedInventory() != null) {

            if (e.getRawSlot() == 53) {
                Inventory inv = commandsInventory.getNewInventory(hashmaps.editPhaseBlock.get(e.getWhoClicked()), 1);
                e.getWhoClicked().openInventory(inv);
                hashmaps.infoPhaseInventory.remove(player);
                hashmaps.editPhasePage.put(player, 1);
                hashmaps.commandPhaseInventory.put(player, inv);
            } else if (e.getRawSlot() == 49) {
                hashmaps.infoPhaseInventory.remove(player);
                hashmaps.editPhasePage.remove(player);
                Location loc = hashmaps.editPhaseBlock.get(e.getWhoClicked()).getLocation();
                data.get().set("data.blocks." + loc.getBlockX() + loc.getBlockY() + loc.getBlockZ(), null);
                data.save();
                player.closeInventory();
            } else if (e.getRawSlot() == 45) {
                data.reload();
                Block block = hashmaps.editPhaseBlock.get(player);
                boolean isset = data.get().isSet("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".disabled");
                if (isset) {
                    boolean disabled = data.get().getBoolean("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".disabled");
                    if (disabled) {
                        data.get().set("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".disabled", false);
                    } else {
                        data.get().set("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".disabled", true);
                    }
                } else {
                    data.get().set("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".disabled", true);
                }
                data.save();
                Inventory inv = infoInventory.getNewInventory(hashmaps.editPhaseBlock.get(e.getWhoClicked()));
                e.getWhoClicked().openInventory(inv);
                hashmaps.infoPhaseInventory.remove(player);
                hashmaps.infoPhaseInventory.put(player, inv);
            }

        }
    }
}
