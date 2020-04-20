package me.Drison64.doorPin;

import me.Drison64.doorPin.Commands.cmdpin;
import me.Drison64.doorPin.Events.BlockInteraction.onBlockClick;
import me.Drison64.doorPin.Events.BlockInteraction.onBlockClickADD;
import me.Drison64.doorPin.Events.BlockInteraction.onBlockClickEDIT;
import me.Drison64.doorPin.Events.BlockInteraction.onBlockClickENTER;
import me.Drison64.doorPin.Events.onChat;
import me.Drison64.doorPin.Events.onJoin;
import me.Drison64.doorPin.Inventories.Events.onInventoryClose;
import me.Drison64.doorPin.Inventories.addInventory.Events.onAddInventoryClick;
import me.Drison64.doorPin.Inventories.editInventory.commands.Events.onCommandsInventoryClick;
import me.Drison64.doorPin.Inventories.editInventory.commands.addCommand.Events.onAddCommandInventoryClick;
import me.Drison64.doorPin.Inventories.editInventory.commands.removeCommand.Events.onRemoveCommandInventoryClick;
import me.Drison64.doorPin.Inventories.editInventory.info.Events.onInfoInventoryClick;
import me.Drison64.doorPin.Inventories.enterInventory.Events.onEnterInventoryClick;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.InputStreamReader;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //InputStreamReader datafile = new InputStreamReader(getResource("me/Drison64/doorPin/data.yml"));
        //YamlConfiguration datadef = YamlConfiguration.loadConfiguration(datafile);
        InputStreamReader messagesfile = new InputStreamReader(getResource("messages.yml"));
        YamlConfiguration messagesdef = YamlConfiguration.loadConfiguration(messagesfile);

        data.setup();
        //data.get().setDefaults(datadef);
        data.get().options().copyDefaults(true);
        data.save();

        messages.setup();
        messages.get().setDefaults(messagesdef);
        messages.get().options().copyDefaults(true);
        messages.save();

        getCommand("pin").setExecutor(new cmdpin());
        Bukkit.getPluginManager().registerEvents(new onBlockClickADD(), this);
        Bukkit.getPluginManager().registerEvents(new onAddInventoryClick(), this);
        Bukkit.getPluginManager().registerEvents(new onBlockClickENTER(), this);
        Bukkit.getPluginManager().registerEvents(new onEnterInventoryClick(), this);
        Bukkit.getPluginManager().registerEvents(new onBlockClick(), this);
        Bukkit.getPluginManager().registerEvents(new onBlockClickEDIT(), this);
        Bukkit.getPluginManager().registerEvents(new onInfoInventoryClick(), this);
        Bukkit.getPluginManager().registerEvents(new onCommandsInventoryClick(), this);
        //Bukkit.getPluginManager().registerEvents(new onInventoryClose(), this);
        Bukkit.getPluginManager().registerEvents(new onRemoveCommandInventoryClick(), this);
        Bukkit.getPluginManager().registerEvents(new onChat(), this);
        Bukkit.getPluginManager().registerEvents(new onJoin(), this);
        Bukkit.getPluginManager().registerEvents(new onAddCommandInventoryClick(), this);
    }

}
