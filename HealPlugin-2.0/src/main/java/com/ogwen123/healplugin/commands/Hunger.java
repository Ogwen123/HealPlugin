package com.ogwen123.healplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Hunger implements CommandExecutor {

    int maxHunger = 20;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(args.length == 0) {
                if(p.hasPermission("HealPlugin.heal")) {
                    p.sendMessage(ChatColor.GREEN + "You are now at full hunger and saturation");
                    p.setFoodLevel(maxHunger);
                }else{
                    p.sendMessage(ChatColor.RED + "You do not have the correct permissions to use this command");
                }
            }else if(args.length > 1){
                p.sendMessage( ChatColor.RED + "You gave to many arguments. Please only give 1 argument which should be the players name or 0 if you want to heal yourself");
                p.sendMessage(ChatColor.RED + "Usage: /heal <player>");

            }else{
                Player target = Bukkit.getPlayerExact(args[0]);
                if(target != null) {
                    if(p.hasPermission("HealPlugin.heal")) {
                        target.setFoodLevel(maxHunger);
                        p.sendMessage(ChatColor.GREEN + "You have given full hunger to " + ChatColor.GOLD +target.getDisplayName());
                    }
                }else{
                    p.sendMessage(ChatColor.RED + "You cannot heal the console or players that do not exist");
                }
            }

        }else{
            System.out.println("Console cannot use this command");
        }

        return true;
    }
}
