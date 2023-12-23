package me.kelsi.commands;

import me.kelsi.Listeners;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Random;
import me.kelsi.Listeners.*;

import static me.kelsi.Listeners.*;

public class mine extends ListenerAdapter {
    Random random = new Random();
    Double stone1, coal1, iron1, gold1, diamond1, emerald1;
    Double sum_blocks;

    public void mine(String pickaxe) {
        switch (pickaxe) {
            case "WOODEN_PICKAXE":
                stone1 = random.nextInt((50 + 1) - 1) * 1.0;
                coal1 = random.nextInt((40 + 1) - 1) * 1.0;
                iron1 = random.nextInt((30 + 1) - 1) * 1.0;
                gold1 = random.nextInt((20 + 1) - 1) * 1.0;
                diamond1 = random.nextInt((10 + 1) - 1) * 1.0;
                emerald1 = random.nextInt((5 + 1) - 1) * 1.0;
            case "STONE_PICKAXE":
                stone1 = random.nextInt((50 + 1) - 1) * 1.1;
                coal1 = random.nextInt((40 + 1) - 1) * 1.1;
                iron1 = random.nextInt((30 + 1) - 1) * 1.1;
                gold1 = random.nextInt((20 + 1) - 1) * 1.1;
                diamond1 = random.nextInt((10 + 1) - 1) * 1.1;
                emerald1 = random.nextInt((5 + 1) - 1) * 1.1;
            case "IRON_PICKAXE":
                stone1 = random.nextInt((50 + 1) - 1) * 1.2;
                coal1 = random.nextInt((40 + 1) - 1) * 1.2;
                iron1 = random.nextInt((30 + 1) - 1) * 1.2;
                gold1 = random.nextInt((20 + 1) - 1) * 1.2;
                diamond1 = random.nextInt((10 + 1) - 1) * 1.2;
                emerald1 = random.nextInt((5 + 1) - 1) * 1.2;
            case "GOLDEN_PICKAXE":
                stone1 = random.nextInt((50 + 1) - 1) * 1.4;
                coal1 = random.nextInt((40 + 1) - 1) * 1.4;
                iron1 = random.nextInt((30 + 1) - 1) * 1.4;
                gold1 = random.nextInt((20 + 1) - 1) * 1.4;
                diamond1 = random.nextInt((10 + 1) - 1) * 1.4;
                emerald1 = random.nextInt((5 + 1) - 1) * 1.4;
            case "DIAMOND_PICKAXE":
                stone1 = random.nextInt((50 + 1) - 1) * 1.6;
                coal1 = random.nextInt((40 + 1) - 1) * 1.6;
                iron1 = random.nextInt((30 + 1) - 1) * 1.6;
                gold1 = random.nextInt((20 + 1) - 1) * 1.6;
                diamond1 = random.nextInt((10 + 1) - 1) * 1.6;
                emerald1 = random.nextInt((5 + 1) - 1) * 1.6;
        }
        sum_blocks = stone1+coal1+iron1+gold1+diamond1+emerald1;
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (!event.getName().equalsIgnoreCase("mine")) return;

        User user = event.getUser();
        String pickaxe_func = pickaxe.get(user);
        switch (pickaxe_func) {
            case "WOODEN_PICKAXE":
                mine("WOODEN_PICKAXE");
            case "STONE_PICKAXE":
                mine("STONE_PICKAXE");
            case "IRON_PICKAXE":
                mine("IRON_PICKAXE");
            case "GOLDEN_PICKAXE":
                mine("GOLDEN_PICKAXE");
            case "DIAMOND_PICKAXE":
                mine("DIAMOND_PICKAXE");
        }

        EmbedBuilder builder = new EmbedBuilder();


        builder.setTitle("Вы отправились в шахту..");
        builder.setDescription("**Добытые ресурсы:**\n");
        builder.addBlankField(false);
        builder.addField("Камень:",  stone1 + " <:stone_ms:1182703138285826119>", true);
        builder.addBlankField(true);
        builder.addField("Уголь:", coal1 + " <:coal_ore_ms:1182711904045641838>", true);
        builder.addField("Железо:", iron1 + " <:iron_ore_ms:1182703752092844143>", true);
        builder.addBlankField(true);
        builder.addField("Золото:", gold1 + " <:gold_ore_ms:1182710543333740545>", true);
        builder.addField("Алмазы:", diamond1 + " <:diamond_ore_ms:1182711031110307860>", true);
        builder.addBlankField(true);
        builder.addField("Изумруды:", emerald1 + " <:emerald_ore_ms:1182710781930909787>", true);
        event.replyEmbeds(builder.build()).queue();
        blocks.put(user, sum_blocks);
        stone.put(user, stone1);
        coal.put(user, coal1);
        iron.put(user, iron1);
        gold.put(user, gold1);
        diamond.put(user, diamond1);
        emerald.put(user, emerald1);
    }

}
