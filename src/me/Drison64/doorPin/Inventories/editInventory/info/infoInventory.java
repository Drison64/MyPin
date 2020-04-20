package me.Drison64.doorPin.Inventories.editInventory.info;

import me.Drison64.doorPin.Inventories.mkitem;
import me.Drison64.doorPin.data;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.Arrays;
import java.util.UUID;

public class infoInventory implements InventoryHolder {

    public static Inventory inventory;

    public static Inventory getNewInventory(Block block) {

        int[] slots = {46,47,51,52};
        inventory = Bukkit.createInventory(null, 54, "Pin Edit - Info");

        for (int i : slots) {
            inventory.setItem(i, mkitem.mkitem(1, Material.GRAY_STAINED_GLASS_PANE, " ", Arrays.asList("")));
        }

        data.reload();
        String suuid = data.get().getString("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".owner");
        UUID uuid = UUID.fromString(suuid);
        Player player = Bukkit.getServer().getPlayer(uuid);

        boolean isset = data.get().isSet("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".disabled");
        if (isset) {
            boolean disabled = data.get().getBoolean("data.blocks." + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ() + ".disabled");
            if (disabled) {
                inventory.setItem(45, mkitem.mkskull(1, "http://textures.minecraft.net/texture/3cc470ae2631efdfaf967b369413bc2451cd7a39465da7836a6c7a14e877", ChatColor.DARK_RED + "DISABLED", Arrays.asList("")));
            } else {
                inventory.setItem(45, mkitem.mkskull(1, "http://textures.minecraft.net/texture/3296d3e1493fa32d827a3635a683e5bded64914d75e73aacdccba46d8fd90", ChatColor.GREEN + "ENABLED", Arrays.asList("")));
            }
        } else {
            inventory.setItem(45, mkitem.mkskull(1, "http://textures.minecraft.net/texture/3296d3e1493fa32d827a3635a683e5bded64914d75e73aacdccba46d8fd90", ChatColor.GREEN + "ENABLED", Arrays.asList("")));
        }

        inventory.setItem(48, mkitem.mkitem(1, Material.RED_STAINED_GLASS_PANE, " ", Arrays.asList("")));
        inventory.setItem(49, mkitem.mkitem(1, Material.BARRIER, ChatColor.DARK_RED + "DELETE THIS PIN", Arrays.asList("")));
        inventory.setItem(50, mkitem.mkitem(1, Material.RED_STAINED_GLASS_PANE, " ", Arrays.asList("")));
        inventory.setItem(53, mkitem.mkskull(1, "http://textures.minecraft.net/texture/ea26e5ff186778eee6dbf98a15074384c3211d16be0f29460bbd964aeff", "Next", Arrays.asList("")));
        inventory.setItem(19, mkitem.mkskull(1, "http://textures.minecraft.net/texture/caf1b280cab59f4469dab9f1a2af7927ed96a81df1e24d50a8e3984abfe4044", "ID: " + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ(), Arrays.asList("")));
        inventory.setItem(22, mkitem.mkskullname(1,
                player,
                "Owner: " + player.getDisplayName(),
                Arrays.asList("")));
        inventory.setItem(25, mkitem.mkskull(1, "http://textures.minecraft.net/texture/b1dd4fe4a429abd665dfdb3e21321d6efa6a6b5e7b956db9c5d59c9efab25", "Location:", Arrays.asList("", "X: " + block.getLocation().getBlockX(), "Y: " + block.getLocation().getBlockY(), "Z: " + block.getLocation().getBlockZ(), "World: " + block.getLocation().getWorld().toString())));

        //use,edit

        return inventory;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }

}
