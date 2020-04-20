package me.Drison64.doorPin.Inventories.enterInventory.Events;

import me.Drison64.doorPin.Inventories.enterInventory.enterInventory;
import me.Drison64.doorPin.data;
import me.Drison64.doorPin.hashmaps;
import me.Drison64.doorPin.sha256;
import me.Drison64.doorPin.successEvents;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class onEnterInventoryClick implements Listener {

    @EventHandler
    public void onAddInventoryClickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getClickedInventory().equals(hashmaps.enterPhaseInventory.get(player)) && e.getClickedInventory() != null) {
            Block block = hashmaps.enterPhaseBlock.get(player);
            if (data.get().getBoolean("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".disabled")) {
                e.setCancelled(true);
                return;
            }
            Inventory inv;
            int slot = e.getRawSlot();
            if (slot == 12) {
                if (e.getView().getTitle().equals("Please enter a pin")) {
                    inv = enterInventory.getNewInventory("Pin: " + "1", block);
                } else {
                    inv = enterInventory.getNewInventory(e.getView().getTitle() + "1", block);
                }
                player.openInventory(inv);
                hashmaps.enterPhaseInventory.remove(player);
                hashmaps.enterPhaseInventory.put(player, inv);
            } else if (slot == 13) {
                if (e.getView().getTitle().equals("Please enter a pin")) {
                    inv = enterInventory.getNewInventory("Pin: " + "2", block);
                } else {
                    inv = enterInventory.getNewInventory(e.getView().getTitle() + "2", block);
                }
                player.openInventory(inv);
                hashmaps.enterPhaseInventory.remove(player);
                hashmaps.enterPhaseInventory.put(player, inv);
            } else if (slot == 14) {
                if (e.getView().getTitle().equals("Please enter a pin")) {
                    inv = enterInventory.getNewInventory("Pin: " + "3", block);
                } else {
                    inv = enterInventory.getNewInventory(e.getView().getTitle() + "3", block);
                }
                player.openInventory(inv);
                hashmaps.enterPhaseInventory.remove(player);
                hashmaps.enterPhaseInventory.put(player, inv);
            } else if (slot == 21) {
                if (e.getView().getTitle().equals("Please enter a pin")) {
                    inv = enterInventory.getNewInventory("Pin: " + "4", block);
                } else {
                    inv = enterInventory.getNewInventory(e.getView().getTitle() + "4", block);
                }
                player.openInventory(inv);
                hashmaps.enterPhaseInventory.remove(player);
                hashmaps.enterPhaseInventory.put(player, inv);
            } else if (slot == 22) {
                if (e.getView().getTitle().equals("Please enter a pin")) {
                    inv = enterInventory.getNewInventory("Pin: " + "5", block);
                } else {
                    inv = enterInventory.getNewInventory(e.getView().getTitle() + "5", block);
                }
                player.openInventory(inv);
                hashmaps.enterPhaseInventory.remove(player);
                hashmaps.enterPhaseInventory.put(player, inv);
            } else if (slot == 23) {
                if (e.getView().getTitle().equals("Please enter a pin")) {
                    inv = enterInventory.getNewInventory("Pin: " + "6", block);
                } else {
                    inv = enterInventory.getNewInventory(e.getView().getTitle() + "6", block);
                }
                player.openInventory(inv);
                hashmaps.enterPhaseInventory.remove(player);
                hashmaps.enterPhaseInventory.put(player, inv);
            } else if (slot == 30) {
                if (e.getView().getTitle().equals("Please enter a pin")) {
                    inv = enterInventory.getNewInventory("Pin: " + "7", block);
                } else {
                    inv = enterInventory.getNewInventory(e.getView().getTitle() + "7", block);
                }
                player.openInventory(inv);
                hashmaps.enterPhaseInventory.remove(player);
                hashmaps.enterPhaseInventory.put(player, inv);
            } else if (slot == 31) {
                if (e.getView().getTitle().equals("Please enter a pin")) {
                    inv = enterInventory.getNewInventory("Pin: " + "8", block);
                } else {
                    inv = enterInventory.getNewInventory(e.getView().getTitle() + "8", block);
                }
                player.openInventory(inv);
                hashmaps.enterPhaseInventory.remove(player);
                hashmaps.enterPhaseInventory.put(player, inv);
            } else if (slot == 32) {
                if (e.getView().getTitle().equals("Please enter a pin")) {
                    inv = enterInventory.getNewInventory("Pin: " + "9", block);
                } else {
                    inv = enterInventory.getNewInventory(e.getView().getTitle() + "9", block);
                }
                player.openInventory(inv);
                hashmaps.enterPhaseInventory.remove(player);
                hashmaps.enterPhaseInventory.put(player, inv);
            } else if (slot == 40) {
                if (e.getView().getTitle().equals("Please enter a pin")) {
                    inv = enterInventory.getNewInventory("Pin: " + "0", block);
                } else {
                    inv = enterInventory.getNewInventory(e.getView().getTitle() + "0", block);
                }
                player.openInventory(inv);
                hashmaps.enterPhaseInventory.remove(player);
                hashmaps.enterPhaseInventory.put(player, inv);
            } else if (slot == 41) {
                //player.sendMessage("1");
                if (e.getInventory().getItem(39).getType().equals(Material.PLAYER_HEAD)) {
                    //player.sendMessage("2");
                    String fpin = e.getView().getTitle().substring(5, e.getView().getTitle().length());

                    data.reload();
                    if (data.get().getString("data.blocks." + block.getX() + block.getY() + block.getZ() + ".pin").equals(sha256.getSHA(fpin, block.getLocation()))) {
                        //player.sendMessage("3.1");
                        //player.sendMessage("CORRECT");
                        successEvents.input(block, player, data.get().getStringList("data.blocks." + block.getX() + block.getY() + block.getZ() + ".commands"), 0);
                    } else {
                        //player.sendMessage("3.2");
                        //player.sendMessage("BAD");
                    }
                    player.closeInventory();
                } else {
                    e.setCancelled(true);
                }
            } else if (slot == 39) {
                if (e.getInventory().getItem(39).getType().equals(Material.PLAYER_HEAD)) {
                    if (e.getView().getTitle().length() < 7) {
                        inv = enterInventory.getNewInventory("", block);
                    } else {
                        inv = enterInventory.getNewInventory(e.getView().getTitle().substring(0, e.getView().getTitle().length() - 1), block);
                    }
                    player.openInventory(inv);
                    hashmaps.enterPhaseInventory.remove(player);
                    hashmaps.enterPhaseInventory.put(player, inv);
                } else {
                    e.setCancelled(true);
                }
            } else {
                e.setCancelled(true);
            }
        }
    }
}
