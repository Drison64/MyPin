package me.Drison64.doorPin.Inventories.editInventory.permissions;

import me.Drison64.doorPin.data;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class permissionsParser {

    public static String getUUIDAsString(Block block, int input) {
        List<String> actionslist = data.get().getStringList("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".permissions");

        if (actionslist.get(input).isEmpty()) {
            return null;
        }
        String target = actionslist.get(input);

        String[] targetsplit = target.split(",");
        return targetsplit[0];
    }

    public static UUID getUUID(Block block, int input) {
        List<String> actionslist = data.get().getStringList("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".permissions");

        if (actionslist.get(input).isEmpty()) {
            return null;
        }
        String target = actionslist.get(input);

        String[] targetsplit = target.split(",");
        return UUID.fromString(targetsplit[0]);
    }

    public static Integer getPermissions(Block block, int input) {
        List<String> actionslist = data.get().getStringList("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".permissions");

        if (actionslist.get(input).isEmpty()) {
            return null;
        }
        String target = actionslist.get(input);

        String[] targetsplit = target.split(",");
        return Integer.parseInt(targetsplit[1]);
    }

}
