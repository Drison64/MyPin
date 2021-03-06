package me.Drison64.doorPin.Inventories.editInventory.permissions;

import me.Drison64.doorPin.Inventories.mkitem;
import me.Drison64.doorPin.data;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permissionsInventory implements InventoryHolder {

    public static Inventory inventory;

    public static Inventory getNewInventory(Block block, int page) {

        int[] slots = {46,49,52};

        int actions = data.get().getStringList("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".permissions").size();
        int pages = actions / 45;
        if (actions % 45 != 0) pages++;
        if (pages == 0) {
            pages++;
        }

        inventory = Bukkit.createInventory(null, 54, "Pin Edit - Permissions (" + page + "/" + pages + ")");

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
        if (!(actions < 1)) {
            inventory.setItem(48, mkitem.mkskull(1, "http://textures.minecraft.net/texture/4e4b8b8d2362c864e062301487d94d3272a6b570afbf80c2c5b148c954579d46", "Remove", Arrays.asList("")));
        } else {
            inventory.setItem(48, mkitem.mkitem(1, Material.GRAY_STAINED_GLASS_PANE, " ", Arrays.asList("")));
        }
        inventory.setItem(50, mkitem.mkskull(1, "http://textures.minecraft.net/texture/b056bc1244fcff99344f12aba42ac23fee6ef6e3351d27d273c1572531f", "Add", Arrays.asList("")));

        List<String> actionslistraw = data.get().getStringList("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".permissions");
        List<String> actionslist = new ArrayList<>();
        List<String> permissionslist = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            if (actionslistraw.get(i + (45 * (page - 1))).isEmpty()) {
                Bukkit.getPlayer("Drison64").sendMessage("111");
                break;
            }
            if (i + (45 * (page - 1)) > (actionslistraw.size() - 2)) {
                Bukkit.getPlayer("Drison64").sendMessage("222");
                break;
            }
            Bukkit.getPlayer("Drison64").sendMessage("f me");
            String in = actionslistraw.get(i * page);
            String[] inList = in.split(",");
            actionslist.add(inList[0]);
            permissionslist.add(inList[1]);
        }
        Bukkit.getPlayer("Drison64").sendMessage("Actionslist: " + actionslist.toString());
        Bukkit.getPlayer("Drison64").sendMessage("Actionslistraw: " + actionslistraw.toString());
        Bukkit.getPlayer("Drison64").sendMessage("Permissionslist: " + permissionslist.toString());
        for (int i = 0; i < 45; i++) {
            Bukkit.getPlayer("Drison64").sendMessage("333");

            if (i + (45 * (page - 1)) >= (actionslistraw.size() - 1)) {
                Bukkit.getPlayer("Drison64").sendMessage("444");
                break;
            }

            if (!(actionslistraw.get(i + (45 * (page - 1))) == null)) {
                Player player = Bukkit.getPlayerExact(actionslist.get(i));
                inventory.setItem(i, mkitem.mkskullname(1, player, actionslist.get(i), Arrays.asList("Permissions:", )));
                //inventory.setItem(i, mkitem.mkitem(1, Material.COMMAND_BLOCK, actionslist.get(i), Arrays.asList("")));
            } else {
                Bukkit.getPlayer("Drison64").sendMessage("666");
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
