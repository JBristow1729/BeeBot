package com.bristow.beebot.listeners;

import com.bristow.beebot.commands.*;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.Color;

public class SlashCommands extends ListenerAdapter{

    // When a slashcommand event happens
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        // Get the first arg of the slash command and decide what to do from there
        switch (event.getName().toString()) {

            // For "/ping"
            case "ping":
                Ping.execute(event);
                break;
            
            // For "/configure"
            case "configure":
                Configure.execute(event);
                break;

            // If something goes wrong
            default:
                EmbedBuilder embed = new EmbedBuilder();
                embed.setDescription("Command not recognised! Contact the developer.");
                embed.setColor(Color.RED);
                event.replyEmbeds(embed.build()).queue();
                break;
        }
    }
}