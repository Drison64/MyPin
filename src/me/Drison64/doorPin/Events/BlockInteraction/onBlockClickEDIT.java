package me.Drison64.doorPin.Events.BlockInteraction;

import me.Drison64.doorPin.Inventories.editInventory.info.infoInventory;
import me.Drison64.doorPin.Inventories.enterInventory.enterInventory;
import me.Drison64.doorPin.data;
import me.Drison64.doorPin.hashmaps;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Door;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;

public class onBlockClickEDIT implements Listener {

    @EventHandler
    public void onBlockClickEDIT(PlayerInteractEvent e) {

        Block clickedBlock = e.getClickedBlock();
        Player whoClicked = e.getPlayer();

        //whoClicked.sendMessage("DEBUG: 1");
        if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_BLOCK) {

            //whoClicked.sendMessage("DEBUG: 2");
            if (e.getHand().equals(EquipmentSlot.HAND)) {
                //whoClicked.sendMessage("DEBUG: 3");
                //whoClicked.sendMessage(String.valueOf(hashmaps.editPhaseClick.get(whoClicked)));
                //whoClicked.sendMessage(String.valueOf(hashmaps.addClickPhase.get(whoClicked)));
                if (hashmaps.editPhaseClick.get(whoClicked) != null && hashmaps.addClickPhase.get(whoClicked) == null) {
                    //whoClicked.sendMessage("DEBUG: 4");
                    data.reload();
                    e.setCancelled(true);
                    if (data.get().isSet("data.blocks." + clickedBlock.getX() + clickedBlock.getY() + clickedBlock.getZ() + ".pin")) {
                        //whoClicked.sendMessage("DEBUG: 5.1");
                        if (hashmaps.editPhaseClick.get(whoClicked)) {
                            //whoClicked.sendMessage("DEBUG: 5.1.1");
                            Inventory inv = infoInventory.getNewInventory(clickedBlock);
                            whoClicked.openInventory(inv);
                            hashmaps.editPhaseClick.remove(whoClicked);
                            hashmaps.infoPhaseInventory.put(whoClicked, inv);
                            hashmaps.editPhaseBlock.put(whoClicked, clickedBlock);
                            e.setCancelled(true);
                        }
                    } else {
                        //whoClicked.sendMessage("DEBUG: 5.2");
                        Material[] doors = {Material.DARK_OAK_DOOR, Material.ACACIA_DOOR, Material.BIRCH_DOOR, Material.IRON_DOOR, Material.JUNGLE_DOOR, Material.OAK_DOOR, Material.SPRUCE_DOOR};
                        for (Material material : doors) {
                            if (clickedBlock.getType().equals(material)) {
                                //whoClicked.sendMessage("DEBUG: 6");
                                Door door = (Door) clickedBlock.getBlockData();
                                if (door.getHalf().toString().equals("TOP")) {
                                    //whoClicked.sendMessage("DEBUG: 7.1");
                                    if (data.get().isSet("data.blocks." + clickedBlock.getX() + (clickedBlock.getY() - 1) + clickedBlock.getZ() + ".pin")) {
                                        //whoClicked.sendMessage("DEBUG: 7.1.1");
                                        Inventory inv = infoInventory.getNewInventory(clickedBlock.getLocation().add(0,-1,0).getBlock());
                                        whoClicked.openInventory(inv);
                                        hashmaps.editPhaseClick.remove(whoClicked);
                                        hashmaps.infoPhaseInventory.put(whoClicked, inv);
                                        hashmaps.editPhaseBlock.put(whoClicked, clickedBlock.getLocation().add(0, -1, 0).getBlock());
                                        e.setCancelled(true);
                                    }
                                } else {
                                    //whoClicked.sendMessage("DEBUG: 7.2");
                                    if (data.get().isSet("data.blocks." + clickedBlock.getX() + (clickedBlock.getY() + 1) + clickedBlock.getZ() + ".pin")) {
                                        //whoClicked.sendMessage("DEBUG: 7.1.2");
                                        Inventory inv = infoInventory.getNewInventory(clickedBlock.getLocation().add(0,1,0).getBlock());
                                        whoClicked.openInventory(inv);
                                        hashmaps.editPhaseClick.remove(whoClicked);
                                        hashmaps.infoPhaseInventory.put(whoClicked, inv);
                                        hashmaps.editPhaseBlock.put(whoClicked, clickedBlock.getLocation().add(0, 1, 0).getBlock());
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

}
