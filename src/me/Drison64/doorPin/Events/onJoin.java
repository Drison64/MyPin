package me.Drison64.doorPin.Events;

import me.Drison64.doorPin.hashmaps;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class onJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        hashmaps.addClickPhase.remove(e.getPlayer());
        hashmaps.addPhaseInventory.remove(e.getPlayer());
        hashmaps.addPhaseBlock.remove(e.getPlayer());
        hashmaps.enterPhaseInventory.remove(e.getPlayer());
        hashmaps.enterPhaseBlock.remove(e.getPlayer());
        hashmaps.editPhaseClick.remove(e.getPlayer());
        //hashmaps.editPhaseInventory.remove(e.getPlayer());
        hashmaps.editPhaseBlock.remove(e.getPlayer());
        hashmaps.editPhasePage.remove(e.getPlayer());
        hashmaps.editAddPhase.remove(e.getPlayer());
        hashmaps.editID.remove(e.getPlayer());
        hashmaps.infoPhaseInventory.remove(e.getPlayer());
        hashmaps.commandPhaseInventory.remove(e.getPlayer());
        hashmaps.removeCommandPhaseInventory.remove(e.getPlayer());
    }

}
