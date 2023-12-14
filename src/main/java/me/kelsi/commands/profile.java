package me.kelsi.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

import static me.kelsi.Listeners.*;


public class profile extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (!event.getName().equalsIgnoreCase("profile")) return;
        OptionMapping user = event.getOption("user");
        User ds_user = null;
        EmbedBuilder builder = new EmbedBuilder();
        User user1 = event.getUser();

        if (!blocks.containsKey(user) || !money.containsKey(user)) {
            //количество блоков
            blocks.put(user1, 0);
            //количество камня
            stone.put(user1, 0);
            //количество угля
            coal.put(user1, 0);
            //количество железа
            iron.put(user1, 0);
            //количество золота
            gold.put(user1, 0);
            //количество алмазов
            diamond.put(user1, 0);
            //количество изумрудов
            emerald.put(user1, 0);
            //количество монет
            money.put(user1, 0);

            if (user != null) {
                ds_user = user.getAsUser();
            } else if (user == null) {
                ds_user = event.getUser();
            }
            String username = ds_user.getName();

            builder.setTitle("Профиль " + username);
            builder.setColor(Color.PINK);
            builder.setThumbnail(ds_user.getAvatarUrl());
            builder.setDescription("**Вскопано всего блоков:**\n" + blocks.get(user1) + " <:blocks_ms:1183029079780368464>");
            builder.addField("Вскопано камня: ", stone.get(user1) + " <:stone_ms:1182703138285826119>", true);
            builder.addField("Вскопано угля: ", coal.get(user1) + " <:coal_ore_ms:1182711904045641838>", true);
            builder.addField("Вскопано железа: ", iron.get(user1) + " <:iron_ore_ms:1182703752092844143>", true);
            builder.addField("Вскопано золота: ", gold.get(user1) + " <:gold_ore_ms:1182710543333740545>", true);
            builder.addField("Вскопано алмазов: ", diamond.get(user1) + " <:diamond_ore_ms:1182711031110307860>", true);
            builder.addField("Вскопано изумрудов: ", emerald.get(user1) + " <:emerald_ore_ms:1182710781930909787>", true);
            //builder.addField(" ", " ", false);
            builder.addField("Монет: ", money.get(user1) + " <:coin_ms:1182950601911447592>", false);

            event.replyEmbeds(builder.build()).queue();
        }

    }
}
