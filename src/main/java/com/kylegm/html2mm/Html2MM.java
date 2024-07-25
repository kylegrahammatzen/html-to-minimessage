package com.kylegm.html2mm;

import com.kylegm.html2mm.command.HtmlCommand;

import org.bukkit.plugin.java.JavaPlugin;

public class Html2MM extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("html").setExecutor(new HtmlCommand());
    }
}
