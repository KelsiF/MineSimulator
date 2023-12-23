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
        User ds_user = event.getUser();
        EmbedBuilder builder = new EmbedBuilder();
        User user1 = event.getUser();
        String username = ds_user.getName();

        String pickaxe_name = pickaxe.get(user1);
        if (user != null) {
            ds_user = user.getAsUser();
        } else {
            ds_user = event.getUser();
        }

        if (stone.containsKey(ds_user)) {
            switch (pickaxe_name) {
                case ("WOODEN_PICKAXE"):
                    pickaxe_name = "Деревянная кирка <:wooden_pickaxe_ms:1182718389500776509>";
                    break;
                case ("STONE_PICKAXE"):
                    pickaxe_name = "Каменная кирка <:stone_pickaxe_ms:1182718543926677636>";
                    break;
                case ("IRON_PICKAXE"):
                    pickaxe_name = "Железная кирка <:iron_pickaxe_ms:1182718027440074873>";
                    break;
                case ("GOLDEN_PICKAXE"):
                    pickaxe_name = "Золотая кирка <:gold_pickaxe_ms:1182718931375509504>";
                    break;
                case ("DIAMOND_PICKAXE"):
                    pickaxe_name = "Алмазная кирка <:diamond_pickaxe_ms:1182718739909718156>";
                    break;
                default:
                    pickaxe_name = "Деревянная кирка <:wooden_pickaxe_ms:1182718389500776509>";
                    break;
            }
            builder.setTitle("Профиль " + username);
            builder.setColor(Color.PINK);
            builder.setThumbnail(ds_user.getAvatarUrl());
            builder.setDescription("**Вскопано всего блоков:**\n" + String.format("%.1f", blocks.get(user1)) + " <:blocks_ms:1183029079780368464> \n");
            builder.addField("Вскопано камня: ", String.format("%.1f", stone.get(user1)) + " <:stone_ms:1182703138285826119>", true);
            builder.addField("Вскопано угля: ", String.format("%.1f", coal.get(user1)) + " <:coal_ore_ms:1182711904045641838>", true);
            builder.addField("Вскопано железа: ", String.format("%.1f", iron.get(user1)) + " <:iron_ore_ms:1182703752092844143>", true);
            builder.addField("Вскопано золота: ", String.format("%.1f", gold.get(user1)) + " <:gold_ore_ms:1182710543333740545>", true);
            builder.addField("Вскопано алмазов: ", String.format("%.1f", diamond.get(user1)) + " <:diamond_ore_ms:1182711031110307860>", true);
            builder.addField("Вскопано изумрудов: ", String.format("%.1f", emerald.get(user1)) + " <:emerald_ore_ms:1182710781930909787>", true);
            builder.addBlankField(false);
            builder.addField("Монет: ", String.format("%.1f", money.get(user1)) + " <:coin_ms:1182950601911447592>", false);
            builder.addBlankField(false);
            builder.addField("Ваша кирка: ", pickaxe_name + " <:wooden_pickaxe_ms:1182718389500776509>", false);

            event.replyEmbeds(builder.build()).queue();
        } else {
            event.reply("У вас не создан аккаунт!\nЧтобы его создать используйте команду /start").queue();
        }

    }
}
