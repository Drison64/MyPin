package me.Drison64.doorPin.Inventories.enterInventory;

import me.Drison64.doorPin.Inventories.mkitem;
import me.Drison64.doorPin.data;
import me.Drison64.doorPin.hashmaps;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Door;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.Arrays;

public class enterInventory implements InventoryHolder {

    public static Inventory inventory;

    public static Inventory getNewInventory(String title, Block block) {
        int[] slots = {0,1,2,3,4,5,6,7,8,9,10,11,15,16,17,18,19,20,24,25,26,27,28,29,33,34,35,36,37,38,42,43,44,45,46,47,48,49,50,51,52,53};

        String ftitle;
        if (title.length() < 1) {
            ftitle = "Please enter a pin";
        } else {
            ftitle = title;
        }

        inventory = Bukkit.createInventory(null, 54, ftitle);
        for (int i : slots) {
            inventory.setItem(i, mkitem.mkitem(1, Material.GRAY_STAINED_GLASS_PANE, "", Arrays.asList("")));
        }

        data.reload();
        boolean disabled = false;
        boolean isset = data.get().isSet("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".disabled");
        if (isset) {
            disabled = data.get().getBoolean("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".disabled");
            if (disabled) {
                int[] rglass = {12,13,14,21,22,23,30,31,32,40,41,39};
                for (int i : rglass) {
                    inventory.setItem(i, mkitem.mkitem(1, Material.RED_STAINED_GLASS_PANE, ChatColor.DARK_RED + "DISABLED", Arrays.asList("")));
                }
            }
        } else {
            Bukkit.getPlayer("Drison64").sendMessage("1");
            Material[] doors = {Material.DARK_OAK_DOOR, Material.ACACIA_DOOR, Material.BIRCH_DOOR, Material.IRON_DOOR, Material.JUNGLE_DOOR, Material.OAK_DOOR, Material.SPRUCE_DOOR};
            for (Material material : doors) {
                Bukkit.getPlayer("Drison64").sendMessage("2");
                if (block.getType().equals(material)) {
                    Bukkit.getPlayer("Drison64").sendMessage("3");
                    Door door = (Door) block.getBlockData();
                    if (door.getHalf().toString().equals("TOP")) {
                        Bukkit.getPlayer("Drison64").sendMessage("4.1");
                        Block blockalt = block.getLocation().add(0, -1, 0).getBlock();
                        disabled = data.get().getBoolean("data.blocks." + blockalt.getLocation().getBlockX() + blockalt.getLocation().getBlockY() + blockalt.getLocation().getBlockZ() + ".disabled");
                        if (disabled) {
                            Bukkit.getPlayer("Drison64").sendMessage("4.1.1");
                            int[] rglass = {12,13,14,21,22,23,30,31,32,40,41,39};
                            for (int i : rglass) {
                                inventory.setItem(i, mkitem.mkitem(1, Material.RED_STAINED_GLASS_PANE, ChatColor.DARK_RED + "DISABLED", Arrays.asList("")));
                            }
                        }
                    } else {
                        Bukkit.getPlayer("Drison64").sendMessage("4.2");
                        Block blockalt = block.getLocation().add(0, 1, 0).getBlock();
                        disabled = data.get().getBoolean("data.blocks." + blockalt.getLocation().getBlockX() + blockalt.getLocation().getBlockY() + blockalt.getLocation().getBlockZ() + ".disabled");
                        if (disabled) {
                            Bukkit.getPlayer("Drison64").sendMessage("4.2.1");
                            int[] rglass = {12,13,14,21,22,23,30,31,32,40,41,39};
                            for (int i : rglass) {
                                inventory.setItem(i, mkitem.mkitem(1, Material.RED_STAINED_GLASS_PANE, ChatColor.DARK_RED + "DISABLED", Arrays.asList("")));
                            }
                        }
                    }
                }
            }
        }

        if (!(disabled)) {
            inventory.setItem(12, mkitem.mkskull(1, "http://textures.minecraft.net/texture/caf1b280cab59f4469dab9f1a2af7927ed96a81df1e24d50a8e3984abfe4044", "1", Arrays.asList("")));
            inventory.setItem(13, mkitem.mkskull(1, "http://textures.minecraft.net/texture/e4b1e1d426123ce40cd6a54b0f876ad30c08539cf5a6ea63e847dc507950ff", "2", Arrays.asList("")));
            inventory.setItem(14, mkitem.mkskull(1, "http://textures.minecraft.net/texture/904ccf8b5332c196c9ea02b22b39b99facd1cc82bfe3f7d7aeedc3c3329039", "3", Arrays.asList("")));
            inventory.setItem(21, mkitem.mkskull(1, "http://textures.minecraft.net/texture/6b4fc18e975f4f222d885216e363adc9e6d456aa29080e48eb47144dda436f7", "4", Arrays.asList("")));
            inventory.setItem(22, mkitem.mkskull(1, "http://textures.minecraft.net/texture/1d8b22239712e0ad579a62ae4c115103e7728825e17508acd6cc89174ee838", "5", Arrays.asList("")));
            inventory.setItem(23, mkitem.mkskull(1, "http://textures.minecraft.net/texture/9eefbad16712a05f98e4f0de5b4486af3987b46ea6ab4e3be93d14a832c56e", "6", Arrays.asList("")));
            inventory.setItem(30, mkitem.mkskull(1, "http://textures.minecraft.net/texture/a3e69fa942df3d5ea53a3a97491617510924c6b8d7c4371197378a1cf2def27", "7", Arrays.asList("")));
            inventory.setItem(31, mkitem.mkskull(1, "http://textures.minecraft.net/texture/7d184fd4ab51d4622f49b54ce7a1395c29f02ad35ce5abd5d3c25638f3a82", "8", Arrays.asList("")));
            inventory.setItem(32, mkitem.mkskull(1, "http://textures.minecraft.net/texture/1b2454a5faa25f7c4f5771d52bb4f55deb1939f75efd8e0ac421812ba3dc7", "9", Arrays.asList("")));
            inventory.setItem(40, mkitem.mkskull(1, "http://textures.minecraft.net/texture/ffa45911b16298cfca4b2291eeda666113bc6f2a37dcb2ecd8c2754d24ef6", "0", Arrays.asList("")));
        }

        if (title.length() < 1) {
            inventory.setItem(41, mkitem.mkitem(1, Material.GRAY_STAINED_GLASS_PANE, "", Arrays.asList("")));
            inventory.setItem(39, mkitem.mkitem(1, Material.GRAY_STAINED_GLASS_PANE, "", Arrays.asList("")));
        } else {
            inventory.setItem(41, mkitem.mkskull(1, "http://textures.minecraft.net/texture/a92e31ffb59c90ab08fc9dc1fe26802035a3a47c42fee63423bcdb4262ecb9b6", "Confirm", Arrays.asList("")));
            inventory.setItem(39, mkitem.mkskull(1, "http://textures.minecraft.net/texture/edf5c2f893bd3f89ca40703ded3e42dd0fbdba6f6768c8789afdff1fa78bf6", "Back", Arrays.asList("")));
        }
        return inventory;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }

}
