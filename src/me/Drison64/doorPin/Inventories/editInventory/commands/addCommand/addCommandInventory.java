package me.Drison64.doorPin.Inventories.editInventory.commands.addCommand;

import me.Drison64.doorPin.Inventories.mkitem;
import me.Drison64.doorPin.data;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.Arrays;
import java.util.List;

public class addCommandInventory implements InventoryHolder {

    public static Inventory inventory;

    public static Inventory getNewInventory(Block block, int page) {

        int[] slots = {46,48,49,50,52,53};

        int actions = data.get().getStringList("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".commands").size();
        int pages = actions / 45;
        if (actions % 45 != 0) pages++;
        if (pages == 0) {
            pages++;
        }

        inventory = Bukkit.createInventory(null, 54, "Pin Edit - Actions (" + page + "/" + pages + ")");

        for (int i : slots) {
            inventory.setItem(i, mkitem.mkitem(1, Material.GRAY_STAINED_GLASS_PANE, " ", Arrays.asList("")));
        }

        inventory.setItem(45, mkitem.mkskull(1, "http://textures.minecraft.net/texture/a89dd7af4c803b5287c433707c7c437cc28d521bb682c47a4d3d5d2a48afa6", "Previous", Arrays.asList("")));

        if (page < pages) {
            inventory.setItem(47, mkitem.mkskull(1, "http://textures.minecraft.net/texture/d1b62db5c0a3fa1ef441bf7044f511be58bedf9b6731853e50ce90cd44fb69", "Down", Arrays.asList("")));
        } else {
            inventory.setItem(47, mkitem.mkitem(1, Material.GRAY_STAINED_GLASS_PANE, " ", Arrays.asList("")));
        }
        if (page > 1) {
            inventory.setItem(51, mkitem.mkskull(1, "http://textures.minecraft.net/texture/14a5667ef7285c9225fc267d45117eab5478c786bd5af0a199c29a2c14c1f", "Up", Arrays.asList("")));
        } else {
            inventory.setItem(51, mkitem.mkitem(1, Material.GRAY_STAINED_GLASS_PANE, " ", Arrays.asList("")));
        }

        List<String> actionslist = data.get().getStringList("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".commands");
        for (int i = 0; i < 45; i++) {
            //Bukkit.getPlayer("Drison64").sendMessage(String.valueOf(actionslist.get(i)));

            if (i + (45 * (page - 1)) >= actionslist.size()) {
                break;
            }

            if (!(actionslist.get(i + (45 * (page - 1))) == null)) {
                int id = i + (45 * (page - 1));
                inventory.setItem(i, mkitem.mkitem(1, Material.COMMAND_BLOCK, actionslist.get(i + (45 * (page - 1))), Arrays.asList("ID: " + id)));
            } else {
                break;
            }
        }

        return inventory;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }

}
