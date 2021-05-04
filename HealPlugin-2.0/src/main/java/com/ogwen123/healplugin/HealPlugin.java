package com.ogwen123.healplugin;

import com.ogwen123.healplugin.commands.Heal;
import com.ogwen123.healplugin.commands.HealAll;
import com.ogwen123.healplugin.commands.Health;
import com.ogwen123.healplugin.commands.Hunger;
import org.bukkit.plugin.java.JavaPlugin;

public final class HealPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("heal").setExecutor(new Heal());
        getCommand("health").setExecutor(new Health());
        getCommand("healall").setExecutor(new HealAll());
        getCommand("hunger").setExecutor(new Hunger());

    }

    @Override
    public void onDisable() {
        System.out.println("HealPlugin-2.0 is shutting down");
    }
}
