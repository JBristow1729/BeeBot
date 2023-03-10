package com.bristow.beebot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.awt.Color;

public class Ping extends ListenerAdapter {

    // Executed when "/ping" is run
    public static void execute(SlashCommandInteractionEvent event) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setDescription("Pong!");
        embed.setColor(Color.GREEN);
        event.reply("").setEmbeds(embed.build()).setEphemeral(true).queue();
    }

    // Executed when "/configure ping enable" is run
    public static void build(Guild guild) {
        guild.upsertCommand(
                Commands.slash("ping", "Pings the bot!"))
                .queue();
    }
}