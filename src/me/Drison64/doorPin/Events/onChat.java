package me.Drison64.doorPin.Events;

import me.Drison64.doorPin.Inventories.editInventory.commands.addCommand.addCommandInventory;
import me.Drison64.doorPin.Inventories.editInventory.commands.commandsInventory;
import me.Drison64.doorPin.data;
import me.Drison64.doorPin.hashmaps;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class onChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (!(hashmaps.editAddPhase.get(e.getPlayer()) == null)) {
            String action;
            Block block = hashmaps.editPhaseBlock.get(e.getPlayer());
            data.reload();
            List<String> actions = data.get().getStringList("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".commands");
            e.setCancelled(true);
            if (e.getMessage().equals("cancel")) {
                hashmaps.editAddPhase.remove(e.getPlayer());
                hashmaps.editAddPhaseID.remove(e.getPlayer());
            }

            //TODO HELP

            /*if (hashmaps.editAddPhase.get(e.getPlayer()).equals(1)) {
                if (e.getMessage().equals("-1")) {
                    hashmaps.editID.put(e.getPlayer(), actions.size());
                } else {
                    hashmaps.editID.put(e.getPlayer(), Integer.parseInt(e.getMessage()));
                }
                hashmaps.editAddPhase.remove(e.getPlayer());
                hashmaps.editAddPhase.put(e.getPlayer(), 2);
            } else*/
            if (hashmaps.editAddPhase.get(e.getPlayer()) && hashmaps.editAddPhase.get(e.getPlayer()) != null) {
                action = e.getMessage();
                hashmaps.editAddPhase.remove(e.getPlayer());
                move(hashmaps.editAddPhaseID.get(e.getPlayer()), action, actions, block);
                hashmaps.editPhasePage.put(e.getPlayer(), 1);
                hashmaps.editAddPhaseID.remove(e.getPlayer());
                Inventory inv = addCommandInventory.getNewInventory(block, 1);
                hashmaps.addCommandPhaseInventory.put(e.getPlayer(), inv);
                Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("MyPin"), new Runnable() {
                    @Override
                    public void run() {
                        e.getPlayer().openInventory(inv);
                    }
                },1L);
            }
        }
        if (!(hashmaps.editPhaseClick.get(e.getPlayer()) == null)) {
            e.setCancelled(true);
            if (e.getMessage().equals("cancel")) {
                hashmaps.editPhaseClick.remove(e.getPlayer());
            }
        }
    }

    public void move(Integer id, String action, List<String> actions, Block block) {
        int size = actions.size();
        ArrayList list = new ArrayList<String>();
        for (int i = 0; i < id; i++) {
            list.add(i, actions.get(i));
        }
        list.add(id, action);
        for (int i = id; i < size; i++) {
            list.add(i + 1, actions.get(i));
        }
        data.get().set("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".commands", list);
        data.save();
    }


}
