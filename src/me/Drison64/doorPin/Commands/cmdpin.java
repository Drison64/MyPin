package me.Drison64.doorPin.Commands;

import me.Drison64.doorPin.Inventories.addInventory.addInventory;
import me.Drison64.doorPin.hashmaps;
import me.Drison64.doorPin.messageParser;
import me.Drison64.doorPin.messages;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class cmdpin implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Tento command je pouze pro hráče!");
            return false;
        }

        Player player = (Player) sender;
        if (args.length < 1) {
            player.sendMessage(messageParser.parse(messages.get().getStringList("pin.help")));
            return false;
        }

        if (args[0].equals("add")) {

            if (hashmaps.editPhaseClick.get(player) == null) {
                hashmaps.addClickPhase.put(player, true);
                player.sendMessage(messageParser.parse(messages.get().getStringList("pin.setup")));
            }

        } else if (args[0].equals("help")) {
            player.sendMessage(messageParser.parse(messages.get().getStringList("pin.help")));
        } else if (args[0].equals("edit")) {

            if (hashmaps.addClickPhase.get(player) == null) {
                hashmaps.editPhaseClick.put(player, true);
            }

        } else {
            player.sendMessage(messageParser.parse(messages.get().getStringList("pin.help")));
        }

        return false;
    }

}
