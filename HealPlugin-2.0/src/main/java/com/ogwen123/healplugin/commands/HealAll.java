package com.ogwen123.healplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealAll implements CommandExecutor {

    double maxHealth = 20;
    int maxHunger = 20;
    float maxSaturation = 14;
    int playerCount = 0;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("HealPlugin.healall")) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    playerCount++;
                    player.setHealth(maxHealth);
                    player.setFoodLevel(maxHunger);
                    player.setSaturation(maxSaturation);
                }
                p.sendMessage(ChatColor.GREEN + "You have healed " + ChatColor.GOLD + ChatColor.BOLD + playerCount + ChatColor.RESET + ChatColor.GREEN + " players");
                playerCount = 0;
            }else{
                p.sendMessage(ChatColor.RED + "You do not have the correct permissions to run this command");
            }
        }else{
            System.out.println("Console cannot use this command");
        }
        return true;
    }
}
