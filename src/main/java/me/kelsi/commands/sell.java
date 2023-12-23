package me.kelsi.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static me.kelsi.Listeners.*;

public class sell extends ListenerAdapter {

    double moneystone, moneycoal, moneyiron, moneygold, moneydiamond, moneyemerald;


    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equalsIgnoreCase("sell")) return;
        EmbedBuilder builder = new EmbedBuilder();
        User user1 = event.getUser();

        moneystone = stone.get(user1) * 1.1; moneycoal = coal.get(user1) * 1.2; moneyiron = iron.get(user1) * 1.3; moneygold = gold.get(user1) * 1.4; moneydiamond = diamond.get(user1) * 1.5; moneyemerald = emerald.get(user1) * 1.7;
        double summoney = moneystone+moneycoal+moneyiron+moneygold+moneydiamond+moneyemerald;
        money.put(user1, money.get(user1) + summoney);

        builder.setTitle("Добытые ресурсы проданы");
        builder.setDescription("Ресурсы, которые были проданы");
        builder.addField("Камень", String.format("%.1f", stone.get(user1)) + " <:stone_ms:1182703138285826119> -> +" + String.format("%.2f", moneystone) + " <:coin_ms:1182950601911447592>", true);
        builder.addField("Уголь", String.format("%.1f", coal.get(user1)) + " <:coal_ore_ms:1182711904045641838> -> +" + String.format("%.2f", moneycoal) + " <:coin_ms:1182950601911447592>", true);
        builder.addBlankField(false);
        builder.addField("Железо", String.format("%.1f", iron.get(user1)) + " <:iron_ore_ms:1182703752092844143> -> +" + String.format("%.2f", moneyiron) + " <:coin_ms:1182950601911447592>", true);
        builder.addField("Золото", String.format("%.1f", gold.get(user1)) + " <:gold_ore_ms:1182710543333740545> -> +" + String.format("%.2f", moneygold) + " <:coin_ms:1182950601911447592>", true);
        builder.addBlankField(false);
        builder.addField("Алмазы", String.format("%.1f", diamond.get(user1)) + " <:diamond_ore_ms:1182711031110307860> -> +" + String.format("%.2f", moneydiamond) + " <:coin_ms:1182950601911447592>", true);
        builder.addField("Изумруды", String.format("%.1f", emerald.get(user1)) + " <:emerald_ore_ms:1182710781930909787> -> +" + String.format("%.2f", moneyemerald) + " <:coin_ms:1182950601911447592>", true);
        builder.addBlankField(false);
        builder.addField("Получено всего монет", "+" + String.format("%.2f", summoney) + "<:coin_ms:1182950601911447592>", false);

        event.replyEmbeds(builder.build()).queue();
    }

}
