package com.bristow.beebot.listeners;

import com.bristow.beebot.commands.*;

import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventHandler extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
            System.out.println("Bee bot is online!");
    }

    @Override
    public void onGuildReady(GuildReadyEvent event) {
        System.out.println("Guild: " + event.getGuild().getName() + " is ready!");
        Configure.build(event.getGuild());
    }

    @Override
    public void onGuildJoin(GuildJoinEvent event) {
        Configure.build(event.getGuild());
    }
    
}
