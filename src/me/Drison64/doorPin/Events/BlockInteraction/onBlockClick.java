package me.Drison64.doorPin.Events.BlockInteraction;

import me.Drison64.doorPin.hashmaps;
import org.bukkit.Material;
import org.bukkit.block.data.type.Door;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class onBlockClick implements Listener {

    @EventHandler
    public void onBlockClick(PlayerInteractEvent e) {

        Material[] doors = {Material.DARK_OAK_DOOR, Material.ACACIA_DOOR, Material.BIRCH_DOOR, Material.IRON_DOOR, Material.JUNGLE_DOOR, Material.OAK_DOOR, Material.SPRUCE_DOOR};

        if (e.getAction().equals(Action.LEFT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

            if (!(hashmaps.blockInAction.get(e.getClickedBlock()) == null)) {
                e.setCancelled(true);
            } else {

                for (Material material : doors) {

                    if (e.getClickedBlock().getType().equals(material)) {

                        Door door = (Door) e.getClickedBlock().getBlockData();
                        if (door.getHalf().toString().equals("TOP")) {

                            if (!(hashmaps.blockInAction.get(e.getClickedBlock().getLocation().add(0,-1,0).getBlock()) == null)) {
                                e.setCancelled(true);
                            }

                        } else {

                            if (!(hashmaps.blockInAction.get(e.getClickedBlock().getLocation().add(0,1,0).getBlock()) == null)) {
                                e.setCancelled(true);
                            }

                        }

                    }

                }
            }
        }

    }

}
