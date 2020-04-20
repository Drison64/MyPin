package me.Drison64.doorPin;

import com.sun.istack.internal.NotNull;
import org.bukkit.Location;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class sha256 {

    @NotNull
    public static String getSHA(String input, Location loc) {

        String hash;

        //HASH
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            hash = hashtext;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown" + " for incorrect algorithm: " + e);
            return null;
        }

        String slocx = String.valueOf(loc.getBlockX());
        String slocy = String.valueOf(loc.getBlockY());
        String slocz = String.valueOf(loc.getBlockZ());
        String sloc = slocx + slocy + slocz;

        return hash + sloc;
    }

}
