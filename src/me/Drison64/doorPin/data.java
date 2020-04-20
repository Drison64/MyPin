package me.Drison64.doorPin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class data {

    public static File file;
    public static FileConfiguration config;

    public static void setup() {
        file = new File(Bukkit.getPluginManager().getPlugin("MyPin").getDataFolder(), "data.yml");
        if (!(file.exists())) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                //oof
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {
        return config;
    }

    public static void reload() {
        config = YamlConfiguration.loadConfiguration(file);
    }

    public static void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            //oof
        }
    }

}
