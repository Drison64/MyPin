package me.Drison64.doorPin;

import org.bukkit.ChatColor;

import java.util.List;

public class messageParser {

    public static String parse(List<String> input) {
        String output = "";

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).isEmpty()) {
                break;
            }
            output = output + "\n" + input.get(i);
        }

        output = ChatColor.translateAlternateColorCodes('&', output);

        return output.substring(2);
    }

}
