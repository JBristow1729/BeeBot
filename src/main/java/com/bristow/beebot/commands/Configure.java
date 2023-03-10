package com.bristow.beebot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.awt.Color;

public class Configure extends ListenerAdapter {

    // Executed when "/configure" is run
    public static void execute(SlashCommandInteractionEvent event) {

        // Executed if "/configure * enable" is run
        if (event.getOption("configure").getAsString().equals("enable")) {

            EmbedBuilder embed = new EmbedBuilder();

            // Executes the building of the feature that has been requested to be enabled
            switch (event.getOption("feature").getAsString()) {

                case "ping":
                    Ping.build(event.getGuild());
                    embed.setDescription("Ping feature enabled! Use `/ping` to get started.");
                    embed.setColor(Color.GREEN);
                    event.replyEmbeds(embed.build()).queue();
                    break;

                default:
                    embed.setDescription("Feature not recognised! Contact the developer.");
                    embed.setColor(Color.RED);
                    event.replyEmbeds(embed.build()).queue();
                    break;
            }
        }
    }

    public static void build(Guild guild) {
        guild.upsertCommand(
                Commands.slash("configure", "Configures features for this server.")
                        .addOptions(
                                new OptionData(OptionType.STRING, "feature", "The feature you want to configure.")
                                        .addChoice("Ping", "ping")
                                        .setRequired(true),
                                new OptionData(OptionType.STRING, "configure",
                                        "Whether to enable or disable this feature.")
                                        .addChoice("Enable", "enable")
                                        .setRequired(true)))
                .queue();

    }
}