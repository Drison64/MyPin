package me.Drison64.doorPin.Inventories.editInventory.commands.removeCommand.Events;

import me.Drison64.doorPin.Inventories.editInventory.commands.commandsInventory;
import me.Drison64.doorPin.Inventories.editInventory.commands.removeCommand.removeCommandInventory;
import me.Drison64.doorPin.Inventories.editInventory.info.infoInventory;
import me.Drison64.doorPin.data;
import me.Drison64.doorPin.hashmaps;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class onRemoveCommandInventoryClick implements Listener {

    @EventHandler
    public void onRemoveInventoryClickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        //player.sendMessage("kunda");
        //player.sendMessage(e.getClickedInventory().toString());
        //player.sendMessage(hashmaps.editPhaseInventory.get(player).toString());
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getClickedInventory().equals(hashmaps.removeCommandPhaseInventory.get(player)) && e.getClickedInventory() != null) {
            //player.sendMessage("pusi");
            int[] no = {46,48,49,50,52,53};
            for (int i : no) {
                if (e.getRawSlot() == i) {
                    e.setCancelled(true);
                    return;
                }
            }
            if (e.getRawSlot() == 47) {
                Inventory inv = removeCommandInventory.getNewInventory(hashmaps.editPhaseBlock.get(e.getWhoClicked()), hashmaps.editPhasePage.get(player) + 1);
                e.getWhoClicked().openInventory(inv);
                hashmaps.removeCommandPhaseInventory.remove(player);
                hashmaps.editPhasePage.put(player, hashmaps.editPhasePage.get(player) + 1);
                hashmaps.removeCommandPhaseInventory.put(player, inv);
            } else if (e.getRawSlot() == 51) {
                Inventory inv = removeCommandInventory.getNewInventory(hashmaps.editPhaseBlock.get(e.getWhoClicked()), hashmaps.editPhasePage.get(player) - 1);
                e.getWhoClicked().openInventory(inv);
                hashmaps.removeCommandPhaseInventory.remove(player);
                hashmaps.editPhasePage.put(player, hashmaps.editPhasePage.get(player) - 1);
                hashmaps.removeCommandPhaseInventory.put(player, inv);
            } else if (e.getRawSlot() == 45) {
                Inventory inv = commandsInventory.getNewInventory(hashmaps.editPhaseBlock.get(e.getWhoClicked()), 1);
                e.getWhoClicked().openInventory(inv);
                hashmaps.removeCommandPhaseInventory.remove(player);
                hashmaps.editPhasePage.put(player, 1);
                hashmaps.commandPhaseInventory.put(player, inv);
            } else {
                e.setCancelled(true);
                Block block = hashmaps.editPhaseBlock.get(player);
                move((e.getRawSlot() * hashmaps.editPhasePage.get(player)), data.get().getStringList("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".commands"), block);
                //Inventory inv = commandsInventory.getNewInventory(hashmaps.editPhaseBlock.get(player), 1);
                Inventory inv = removeCommandInventory.getNewInventory(hashmaps.editPhaseBlock.get(player), 1);
                e.getWhoClicked().openInventory(inv);
                hashmaps.removeCommandPhaseInventory.remove(player);
                hashmaps.editPhasePage.put(player, 1);
                hashmaps.removeCommandPhaseInventory.put(player, inv);
            }

        }
    }

    public void move(Integer id, List<String> actions, Block block) {
        int size = actions.size() - 1; //1
        ArrayList list = new ArrayList<String>();
        for (int i = 0; i < id; i++) {
            list.add(i, actions.get(i));
        }
        for (int i = id + 1; i < size + 1; i++) {
            list.add(i - 1, actions.get(i));
        }
        data.get().set("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".commands", list);
        data.save();
    }

}
