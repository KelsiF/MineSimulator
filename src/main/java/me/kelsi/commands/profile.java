package me.kelsi.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class profile extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (!event.getName().equalsIgnoreCase("profile")) return;
        OptionMapping user = event.getOption("user");
        User ds_user = null;
        EmbedBuilder builder = new EmbedBuilder();
        if (user != null) {
            ds_user = user.getAsUser();
        } else if (user == null) {
            ds_user = event.getUser();
        }
        String username = ds_user.getName();


        builder.setTitle("Профиль " + username);
        builder.setColor(Color.PINK);
        builder.setDescription("**Вскопано всего блоков:**\n%value% <:blocks_ms:1183029079780368464>");
        builder.addField("Вскопано камня: ", "%value% <:stone_ms:1182703138285826119>", true);
        builder.addField("Вскопано угля: ", "%value% <:coal_ore_ms:1182711904045641838>", true);
        builder.addField("Вскопано железа: ", "%value% <:iron_ore_ms:1182703752092844143>", true);
        builder.addField("Вскопано золота: ", "%value% <:gold_ore_ms:1182710543333740545>", true);
        builder.addField("Вскопано алмазов: ", "%value% <:diamond_ore_ms:1182711031110307860>", true);
        builder.addField("Вскопано изумрудов: ", "%value% <:emerald_ore_ms:1182710781930909787>", true);
        builder.addField(" ", " ", false);
        event.replyEmbeds(builder.build()).queue();
    }

}
