package me.Drison64.doorPin;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

public class hashmaps {

    public static HashMap<Player, Boolean> addClickPhase = new HashMap<>();
    public static HashMap<Player, Inventory> addPhaseInventory = new HashMap<>();
    public static HashMap<Player, Block> addPhaseBlock = new HashMap<>();

    public static HashMap<Player, Inventory> enterPhaseInventory = new HashMap<>();
    public static HashMap<Player, Block> enterPhaseBlock = new HashMap<>();

    public static HashMap<Player, Boolean> editPhaseClick = new HashMap<>();
    //public static HashMap<Player, Inventory> editPhaseInventory = new HashMap<>();
    public static HashMap<Player, Block> editPhaseBlock = new HashMap<>();
    public static HashMap<Player, Integer> editPhasePage = new HashMap<>();
    public static HashMap<Player, Boolean> editAddPhase = new HashMap<>();
    public static HashMap<Player, Integer> editAddPhaseID = new HashMap<>();
    public static HashMap<Player, Integer> editID = new HashMap<>();
    public static HashMap<Player, Inventory> removeCommandPhaseInventory = new HashMap<>();
    public static HashMap<Player, Inventory> commandPhaseInventory = new HashMap<>();
    public static HashMap<Player, Inventory> infoPhaseInventory = new HashMap<>();
    public static HashMap<Player, Inventory> addCommandPhaseInventory = new HashMap<>();
    public static HashMap<Player, Inventory> permissionsPhaseInventory = new HashMap<>();

    public static HashMap<Block, Boolean> blockInAction = new HashMap<>();

}
