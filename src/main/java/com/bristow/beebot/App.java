package com.bristow.beebot;

import com.bristow.beebot.config.Config;
import com.bristow.beebot.listeners.EventHandler;
import com.bristow.beebot.listeners.SlashCommands;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class App
{
    public static void main( String[] args )
    throws InterruptedException
    {
        // The bot token
        String TOKEN = new Config().getToken();

        // Instantiate the JDA object and build it
        JDA jda = JDABuilder.createDefault(TOKEN)
            .addEventListeners(new EventHandler(), new SlashCommands())
            .build();
    }
}
