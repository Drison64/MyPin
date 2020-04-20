package me.Drison64.doorPin.Events.BlockInteraction;

import me.Drison64.doorPin.Inventories.addInventory.addInventory;
import me.Drison64.doorPin.Inventories.enterInventory.enterInventory;
import me.Drison64.doorPin.data;
import me.Drison64.doorPin.hashmaps;
import me.Drison64.doorPin.messageParser;
import me.Drison64.doorPin.messages;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.type.Door;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import sun.security.ssl.HandshakeInStream;

public class onBlockClickENTER implements Listener {

    @EventHandler
    public void onBlockClickENTER(PlayerInteractEvent e) {

        Block clickedBlock = e.getClickedBlock();
        Player whoClicked = e.getPlayer();

        if (!(e.getHand().equals(EquipmentSlot.HAND))) {
            return;
        }

        if (!(hashmaps.blockInAction.get(clickedBlock) == null)) {
            return;
        }

        if (hashmaps.addClickPhase.get(whoClicked) != null) {
            return;
        }

        if (hashmaps.editAddPhase.get(whoClicked) != null) {
            return;
        }

        if (hashmaps.editPhaseClick.get(whoClicked) != null) {
            return;
        }

        Material[] doors = {Material.DARK_OAK_DOOR, Material.ACACIA_DOOR, Material.BIRCH_DOOR, Material.IRON_DOOR, Material.JUNGLE_DOOR, Material.OAK_DOOR, Material.SPRUCE_DOOR};
        /*
        for (Material material : doors) {
            if (clickedBlock.getType().equals(material)) {
                Door door = (Door) clickedBlock.getBlockData();
                if (door.getHalf().toString().equals("TOP")) {
                    if (!(hashmaps.blockInAction.get(clickedBlock.getLocation().add(0,-1,0).getBlock()) == null)) {
                        return;
                    }
                } else {
                    if (!(hashmaps.blockInAction.get(clickedBlock.getLocation().add(0,1,0).getBlock()) == null)) {
                        return;
                    }
                }
            }
        }*/

        if (e.getAction().equals(Action.LEFT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (hashmaps.addClickPhase.get(whoClicked) == null && hashmaps.editPhaseClick.get(whoClicked) == null) {
                data.reload();
                if (data.get().isSet("data.blocks." + clickedBlock.getX() + clickedBlock.getY() + clickedBlock.getZ() + ".pin")) {
                    Inventory inv = enterInventory.getNewInventory("", clickedBlock);
                    whoClicked.openInventory(inv);
                    hashmaps.enterPhaseInventory.put(whoClicked, inv);
                    hashmaps.enterPhaseBlock.put(whoClicked, clickedBlock);
                    e.setCancelled(true);
                } else {
                    for (Material material : doors) {
                        if (clickedBlock.getType().equals(material)) {
                            Door door = (Door) clickedBlock.getBlockData();
                            if (door.getHalf().toString().equals("TOP")) {
                                if (data.get().isSet("data.blocks." + clickedBlock.getX() + (clickedBlock.getY() - 1) + clickedBlock.getZ() + ".pin")) {
                                    Inventory inv = enterInventory.getNewInventory("", clickedBlock);
                                    whoClicked.openInventory(inv);
                                    hashmaps.enterPhaseInventory.put(whoClicked, inv);
                                    hashmaps.enterPhaseBlock.put(whoClicked, clickedBlock.getLocation().add(0,-1,0).getBlock());
                                    e.setCancelled(true);
                                }
                            } else {
                                if (data.get().isSet("data.blocks." + clickedBlock.getX() + (clickedBlock.getY() + 1) + clickedBlock.getZ() + ".pin")) {
                                    Inventory inv = enterInventory.getNewInventory("", clickedBlock);
                                    whoClicked.openInventory(inv);
                                    hashmaps.enterPhaseInventory.put(whoClicked, inv);
                                    hashmaps.enterPhaseBlock.put(whoClicked, clickedBlock.getLocation().add(0,1,0).getBlock());
                                    e.setCancelled(true);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

}
