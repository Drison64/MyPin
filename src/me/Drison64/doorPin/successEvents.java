package me.Drison64.doorPin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Powerable;
import org.bukkit.block.data.type.Door;
import org.bukkit.block.data.type.Switch;
import org.bukkit.entity.Player;
import org.bukkit.material.Button;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;

import java.util.List;

public class successEvents {

    public static void input(Block block, Player player, List<String> input, int index) {

        try {
            input.get(index);
        } catch (IndexOutOfBoundsException e) {
            return;
        }

        String[] sinput = input.get(index).split(" ");
        if (sinput[0].equals("command")) {
            String rcommand = "";

            for (int i = 1; i < sinput.length; i++) {
                if (sinput[i].isEmpty()) {
                    break;
                } else {
                    rcommand = rcommand + " " + sinput[i];
                }
            }
            boolean isop = player.isOp();
            String command = rcommand.substring(1, rcommand.length());
            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            player.setOp(true);
            Bukkit.dispatchCommand(player, command);
            if (!(isop)) {
                player.setOp(false);
            }
            if (!(index == (input.size() - 1))) {
                input(block, player, input, index + 1);
            }
        }


        else if (sinput[0].equals("servercommand")) {
            String rcommand = "";

            for (int i = 1; i < sinput.length; i++) {
                if (sinput[i].isEmpty()) {
                    break;
                } else {
                    rcommand = rcommand + " " + sinput[i];
                }
            }
            String command = rcommand.substring(1, rcommand.length());
            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            if (!(index == (input.size() - 1))) {
                input(block, player, input, index + 1);
            }
        }


        else if (sinput[0].equals("delay")) {
            if (sinput[1].isEmpty()) {
                return;
            }
            int rdelay = Integer.parseInt(sinput[1]);
            long delay = rdelay * 20;
            if (!(index == (input.size() - 1))) {
                Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("MyPin"), new Runnable() {
                    @Override
                    public void run() {
                        input(block, player, input, index + 1);
                    }
                }, delay);
            }
        }


        else if (sinput[0].equals("action")) {
            Material[] doors = {Material.DARK_OAK_DOOR, Material.ACACIA_DOOR, Material.BIRCH_DOOR, Material.IRON_DOOR, Material.JUNGLE_DOOR, Material.OAK_DOOR, Material.SPRUCE_DOOR};
            Material[] buttons = {Material.DARK_OAK_BUTTON, Material.ACACIA_BUTTON, Material.BIRCH_BUTTON, Material.STONE_BUTTON, Material.JUNGLE_BUTTON, Material.OAK_BUTTON, Material.SPRUCE_BUTTON};

            int delay;

            if (sinput.length == 2) {
                int rdelay = Integer.parseInt(sinput[1]);
                delay = rdelay * 20;
            } else {
                delay = 20;
            }

            for (Material material : doors) {
                if (block.getType().equals(material)) {
                    Door door = (Door) block.getBlockData();

                    if (door.getHalf().toString().equals("TOP")) {
                        door.setOpen(true);
                        Door lowdoor = (Door) block.getLocation().add(0,-1,0).getBlock().getBlockData();
                        lowdoor.setOpen(true);
                        block.setBlockData(door);
                        block.getLocation().add(0,-1,0).getBlock().setBlockData(lowdoor);
                        hashmaps.blockInAction.put(block, true);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.playSound(block.getLocation().add(0,-1,0), Sound.BLOCK_WOODEN_DOOR_OPEN, 1, 1);
                        }

                        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("MyPin"), new Runnable() {
                            @Override
                            public void run() {
                                door.setOpen(false);
                                lowdoor.setOpen(false);
                                block.setBlockData(door);
                                block.getLocation().add(0,-1,0).getBlock().setBlockData(lowdoor);
                                hashmaps.blockInAction.remove(block);
                                for (Player players : Bukkit.getOnlinePlayers()) {
                                    players.playSound(block.getLocation().add(0,-1,0), Sound.BLOCK_WOODEN_DOOR_CLOSE, 1, 1);
                                }
                            }
                        }, delay);

                    } else {
                        door.setOpen(true);
                        Door topdoor = (Door) block.getLocation().add(0,1,0).getBlock().getBlockData();
                        topdoor.setOpen(true);
                        block.setBlockData(door);
                        block.getLocation().add(0,1,0).getBlock().setBlockData(topdoor);
                        hashmaps.blockInAction.put(block, true);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.playSound(block.getLocation(), Sound.BLOCK_WOODEN_DOOR_OPEN, 1, 1);
                        }

                        Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("MyPin"), new Runnable() {
                            @Override
                            public void run() {
                                door.setOpen(false);
                                topdoor.setOpen(false);
                                block.setBlockData(door);
                                block.getLocation().add(0,1,0).getBlock().setBlockData(topdoor);
                                hashmaps.blockInAction.remove(block);
                                for (Player players : Bukkit.getOnlinePlayers()) {
                                    players.playSound(block.getLocation(), Sound.BLOCK_WOODEN_DOOR_CLOSE, 1, 1);
                                }
                            }
                        }, delay);

                    }

                }

            }

            for (Material material : buttons) {

                if (block.getType().equals(material)) {

                    Switch data = (Switch) block.getBlockData();
                    data.setPowered(true);
                    block.setBlockData(data);
                    block.getState().update();
                    Block b = block.getRelative(data.getFacing().getOppositeFace());
                    boolean stone = false;
                    Material original = b.getType();
                    if (b.getType().equals(Material.STONE)) {
                        stone = true;
                    }
                    if (stone) {
                        b.setType(Material.GRASS_BLOCK);
                        b.setType(original);
                    } else {
                        b.setType(Material.STONE);
                        b.setType(original);
                    }

                    boolean finalStone = stone;
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("MyPin"), new Runnable() {
                        @Override
                        public void run() {
                            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "setblock " + block.getLocation().getBlockX() + " " + block.getLocation().getBlockY() + " " + block.getLocation().getBlockZ() + " " + block.getType().toString().toLowerCase() + "[powered=false,face=" + button.getFace().toString().toLowerCase() + ",facing=" + button.getFacing().toString().toLowerCase() + "]");
                            hashmaps.blockInAction.remove(block);
                            data.setPowered(false);
                            block.setBlockData(data);
                            if (finalStone) {
                                b.setType(Material.GRASS_BLOCK);
                                b.setType(original);
                            } else {
                                b.setType(Material.STONE);
                                b.setType(original);
                            }
                        }
                    }, delay);

                }

            }
            input(block, player, input, index + 1);
        } else {
            input(block, player, input, index + 1);
        }
    }

}
