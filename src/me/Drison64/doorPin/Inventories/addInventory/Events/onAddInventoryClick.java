package me.Drison64.doorPin.Inventories.addInventory.Events;

import me.Drison64.doorPin.Inventories.addInventory.addInventory;
import me.Drison64.doorPin.Inventories.mkitem;
import me.Drison64.doorPin.data;
import me.Drison64.doorPin.hashmaps;
import me.Drison64.doorPin.sha256;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class onAddInventoryClick implements Listener {

    @EventHandler
    public void onAddInventoryClickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getClickedInventory().equals(hashmaps.addPhaseInventory.get(player))) {
            Inventory inv;
            int slot = e.getRawSlot();
            if (slot == 12) {
                if (e.getView().getTitle().equals("Please set a pin")) {
                    inv = addInventory.getNewInventory("Pin: " + "1");
                } else {
                    inv = addInventory.getNewInventory(e.getView().getTitle() + "1");
                }
                player.openInventory(inv);
                hashmaps.addPhaseInventory.remove(player);
                hashmaps.addPhaseInventory.put(player, inv);
            } else if (slot == 13) {
                if (e.getView().getTitle().equals("Please set a pin")) {
                    inv = addInventory.getNewInventory("Pin: " + "2");
                } else {
                    inv = addInventory.getNewInventory(e.getView().getTitle() + "2");
                }
                player.openInventory(inv);
                hashmaps.addPhaseInventory.remove(player);
                hashmaps.addPhaseInventory.put(player, inv);
            } else if (slot == 14) {
                if (e.getView().getTitle().equals("Please set a pin")) {
                    inv = addInventory.getNewInventory("Pin: " + "3");
                } else {
                    inv = addInventory.getNewInventory(e.getView().getTitle() + "3");
                }
                player.openInventory(inv);
                hashmaps.addPhaseInventory.remove(player);
                hashmaps.addPhaseInventory.put(player, inv);
            } else if (slot == 21) {
                if (e.getView().getTitle().equals("Please set a pin")) {
                    inv = addInventory.getNewInventory("Pin: " + "4");
                } else {
                    inv = addInventory.getNewInventory(e.getView().getTitle() + "4");
                }
                player.openInventory(inv);
                hashmaps.addPhaseInventory.remove(player);
                hashmaps.addPhaseInventory.put(player, inv);
            } else if (slot == 22) {
                if (e.getView().getTitle().equals("Please set a pin")) {
                    inv = addInventory.getNewInventory("Pin: " + "5");
                } else {
                    inv = addInventory.getNewInventory(e.getView().getTitle() + "5");
                }
                player.openInventory(inv);
                hashmaps.addPhaseInventory.remove(player);
                hashmaps.addPhaseInventory.put(player, inv);
            } else if (slot == 23) {
                if (e.getView().getTitle().equals("Please set a pin")) {
                    inv = addInventory.getNewInventory("Pin: " + "6");
                } else {
                    inv = addInventory.getNewInventory(e.getView().getTitle() + "6");
                }
                player.openInventory(inv);
                hashmaps.addPhaseInventory.remove(player);
                hashmaps.addPhaseInventory.put(player, inv);
            } else if (slot == 30) {
                if (e.getView().getTitle().equals("Please set a pin")) {
                    inv = addInventory.getNewInventory("Pin: " + "7");
                } else {
                    inv = addInventory.getNewInventory(e.getView().getTitle() + "7");
                }
                player.openInventory(inv);
                hashmaps.addPhaseInventory.remove(player);
                hashmaps.addPhaseInventory.put(player, inv);
            } else if (slot == 31) {
                if (e.getView().getTitle().equals("Please set a pin")) {
                    inv = addInventory.getNewInventory("Pin: " + "8");
                } else {
                    inv = addInventory.getNewInventory(e.getView().getTitle() + "8");
                }
                player.openInventory(inv);
                hashmaps.addPhaseInventory.remove(player);
                hashmaps.addPhaseInventory.put(player, inv);
            } else if (slot == 32) {
                if (e.getView().getTitle().equals("Please set a pin")) {
                    inv = addInventory.getNewInventory("Pin: " + "9");
                } else {
                    inv = addInventory.getNewInventory(e.getView().getTitle() + "9");
                }
                player.openInventory(inv);
                hashmaps.addPhaseInventory.remove(player);
                hashmaps.addPhaseInventory.put(player, inv);
            } else if (slot == 40) {
                if (e.getView().getTitle().equals("Please set a pin")) {
                    inv = addInventory.getNewInventory("Pin: " + "0");
                } else {
                    inv = addInventory.getNewInventory(e.getView().getTitle() + "0");
                }
                player.openInventory(inv);
                hashmaps.addPhaseInventory.remove(player);
                hashmaps.addPhaseInventory.put(player, inv);
            } else if (slot == 41) {
                if (e.getInventory().getItem(39).getType().equals(Material.PLAYER_HEAD)) {
                    hashmaps.addPhaseInventory.remove(player);
                    String fpin = e.getView().getTitle().substring(5, e.getView().getTitle().length());
                    Block block = hashmaps.addPhaseBlock.get(player);

                    String hash = sha256.getSHA(fpin, block.getLocation());
                    data.get().set("data.blocks." + block.getX() + block.getY() + block.getZ() + ".pin", hash);
                    data.get().set("data.blocks." + block.getX() + block.getY() + block.getZ() + ".world", block.getLocation().getWorld().getName());
                    data.get().set("data.blocks." + block.getX() + block.getY() + block.getZ() + ".owner", player.getUniqueId().toString());
                    data.get().set("data.blocks." + block.getX() + block.getY() + block.getZ() + ".permissions", Arrays.asList("everyone,10000"));
                    Material[] autoaction = {Material.DARK_OAK_BUTTON, Material.ACACIA_BUTTON, Material.BIRCH_BUTTON, Material.STONE_BUTTON, Material.JUNGLE_BUTTON, Material.OAK_BUTTON, Material.SPRUCE_BUTTON, Material.DARK_OAK_DOOR, Material.ACACIA_DOOR, Material.BIRCH_DOOR, Material.IRON_DOOR, Material.JUNGLE_DOOR, Material.OAK_DOOR, Material.SPRUCE_DOOR};
                    for (Material material : autoaction) {

                        if (block.getType().equals(material)) {
                            data.get().set("data.blocks." + block.getX() + block.getY() + block.getZ() + ".commands", Arrays.asList("action"));
                        }

                    }
                    data.save();
                    player.closeInventory();
                } else {
                    e.setCancelled(true);
                }
            } else if (slot == 39) {
                if (e.getInventory().getItem(39).getType().equals(Material.PLAYER_HEAD)) {
                    if (e.getView().getTitle().length() == 6) {
                        inv = addInventory.getNewInventory("");
                    } else {
                        inv = addInventory.getNewInventory(e.getView().getTitle().substring(0, e.getView().getTitle().length() - 1));
                    }
                    player.openInventory(inv);
                    hashmaps.addPhaseInventory.remove(player);
                    hashmaps.addPhaseInventory.put(player, inv);
                } else {
                    e.setCancelled(true);
                }
            } else {
                e.setCancelled(true);
            }
        }
    }

}
