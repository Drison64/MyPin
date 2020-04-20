package me.Drison64.doorPin.Inventories.editInventory.commands.Events;

import me.Drison64.doorPin.Inventories.editInventory.commands.addCommand.addCommandInventory;
import me.Drison64.doorPin.Inventories.editInventory.commands.commandsInventory;
import me.Drison64.doorPin.Inventories.editInventory.commands.removeCommand.removeCommandInventory;
import me.Drison64.doorPin.Inventories.editInventory.info.infoInventory;
import me.Drison64.doorPin.Inventories.editInventory.permissions.permissionsInventory;
import me.Drison64.doorPin.hashmaps;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;

public class onCommandsInventoryClick implements Listener {

    @EventHandler
    public void onAddInventoryClickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getClickedInventory().equals(hashmaps.commandPhaseInventory.get(player)) && e.getClickedInventory() != null) {
            //player.sendMessage("wut");

            if (e.getRawSlot() == 47) {
                Inventory inv = commandsInventory.getNewInventory(hashmaps.editPhaseBlock.get(e.getWhoClicked()), hashmaps.editPhasePage.get(player) + 1);
                e.getWhoClicked().openInventory(inv);
                hashmaps.commandPhaseInventory.remove(player);
                hashmaps.editPhasePage.put(player, hashmaps.editPhasePage.get(player) + 1);
                hashmaps.commandPhaseInventory.put(player, inv);
            } else if (e.getRawSlot() == 51) {
                Inventory inv = commandsInventory.getNewInventory(hashmaps.editPhaseBlock.get(e.getWhoClicked()), hashmaps.editPhasePage.get(player) - 1);
                e.getWhoClicked().openInventory(inv);
                hashmaps.commandPhaseInventory.remove(player);
                hashmaps.editPhasePage.put(player, hashmaps.editPhasePage.get(player) - 1);
                hashmaps.commandPhaseInventory.put(player, inv);
            } else if (e.getRawSlot() == 45) {
                hashmaps.editPhasePage.remove(player);
                Inventory inv = infoInventory.getNewInventory(hashmaps.editPhaseBlock.get(player));
                e.getWhoClicked().openInventory(inv);
                hashmaps.commandPhaseInventory.remove(player);
                hashmaps.infoPhaseInventory.put(player, inv);
            } else if (e.getRawSlot() == 50) {
                Inventory inv = addCommandInventory.getNewInventory(hashmaps.editPhaseBlock.get(player), 1);
                player.openInventory(inv);
                hashmaps.commandPhaseInventory.remove(player);
                hashmaps.editPhasePage.put(player, 1);
                hashmaps.editAddPhase.put(player, true);
                hashmaps.addCommandPhaseInventory.put(player, inv);
            } else if (e.getRawSlot() == 48) {
                Inventory inv = removeCommandInventory.getNewInventory(hashmaps.editPhaseBlock.get(player), 1);
                e.getWhoClicked().openInventory(inv);
                hashmaps.commandPhaseInventory.remove(player);
                hashmaps.editPhasePage.put(player, 1);
                hashmaps.removeCommandPhaseInventory.put(player, inv);
            } else if (e.getRawSlot() == 53) {
                e.getWhoClicked().sendMessage("help me");
                Inventory inv = permissionsInventory.getNewInventory(hashmaps.editPhaseBlock.get(player), 1);
                e.getWhoClicked().openInventory(inv);
                hashmaps.commandPhaseInventory.remove(player);
                hashmaps.editPhasePage.put(player, 1);
                hashmaps.permissionsPhaseInventory.put(player, inv);
            }

        }
    }

}
