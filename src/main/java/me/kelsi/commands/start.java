package me.kelsi.commands;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import static me.kelsi.Listeners.*;

public class start extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equalsIgnoreCase("start")) return;
        User user1 = event.getUser();

        if (!stone.containsKey(user1)) {
            //количество блоков
            blocks.put(user1, 0.0);
            //количество камня
            stone.put(user1, 0.0);
            //количество угля
            coal.put(user1, 0.0);
            //количество железа
            iron.put(user1, 0.0);
            //количество золота
            gold.put(user1, 0.0);
            //количество алмазов
            diamond.put(user1, 0.0);
            //количество изумрудов
            emerald.put(user1, 0.0);
            //количество монет
            money.put(user1, 0.0);
            // экипированная кирка
            pickaxe.put(user1, "WOODEN_PICKAXE");

            event.reply("Профиль успешно создан").queue();
        } else {
            event.reply("У вас уже есть профиль, для сброса своей статистика используйте /reset").queue();
        }
    }
}
