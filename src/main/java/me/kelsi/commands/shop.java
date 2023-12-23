package me.kelsi.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.awt.*;
import static me.kelsi.Listeners.*;

public class shop extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equalsIgnoreCase("shop")) return;
        EmbedBuilder builder = new EmbedBuilder();
        OptionMapping arg = event.getOption("pickaxe");
        User user = event.getUser();

        if (arg == null) {
            //эмбед
            builder.setColor(Color.PINK);
            builder.setTitle("Магазин");
            builder.setDescription("Здесь вы можете купить себе новую экипировку");
            builder.addField("Каменная кирка <:stone_pickaxe_ms:1182718543926677636>", "Цена: 500 <:coin_ms:1182950601911447592>", true);
            builder.addField("Железная кирка <:iron_pickaxe_ms:1182718027440074873>", "Цена: 1500 <:coin_ms:1182950601911447592>", true);
            builder.addBlankField(false);
            builder.addField("Золотая кирка <:gold_pickaxe_ms:1182718931375509504>", "Цена: 3000 <:coin_ms:1182950601911447592>", true);
            builder.addField("Алмазная кирка <:diamond_pickaxe_ms:1182718739909718156>", "Цена: 5000 <:coin_ms:1182950601911447592>", true);
            builder.addField(" ", "Для покупки напишите команду в формате: /shop название_кирки", false);
            builder.addField("Название кирок для покупки", "*Каменная кирка - stone pickaxe\nЖелезная кирка - iron pickaxe\nЗолотая кирка - gold pickaxe\nАлмазная кирка - diamond pickaxe*", false);

            event.replyEmbeds(builder.build()).queue();
        } else {
            String pickaxename = arg.getAsString();
            //покупка кирки
            if (pickaxename.equalsIgnoreCase("stone pickaxe")) {
                if (money.get(user) >= 500) {
                    money.put(user, money.get(user) - 500);
                    pickaxe.put(user, "STONE_PICKAXE");
                    event.reply("Каменная кирка куплена").queue();
                } else {
                    event.reply("У вас недостаточно монет").queue();
                }
                if (!money.containsKey(user)) {
                    event.reply("У вас не создан аккаунт!\nЧтобы его создать используйте команду /start").queue();
                }
            }
            if (pickaxename.equalsIgnoreCase("iron pickaxe")) {
                if (money.get(user) >= 1500) {
                    money.put(user, money.get(user) - 1500);
                    pickaxe.put(user, "IRON_PICKAXE");
                    event.reply("Железная кирка куплена").queue();
                } else {
                    event.reply("У вас недостаточно монет").queue();
                }
                if (!money.containsKey(user)) {
                    event.reply("У вас не создан аккаунт!\nЧтобы его создать используйте команду /start").queue();
                }
            }
            if (pickaxename.equalsIgnoreCase("gold pickaxe")) {
                if (money.get(user) >= 3000) {
                    money.put(user, money.get(user) - 3000);
                    pickaxe.put(user, "GOLDEN_PICKAXE");
                    event.reply("Золотая кирка куплена").queue();
                } else {
                    event.reply("У вас недостаточно монет").queue();
                }
                if (!money.containsKey(user)) {
                    event.reply("У вас не создан аккаунт!\nЧтобы его создать используйте команду /start").queue();
                }
            }
            if (pickaxename.equalsIgnoreCase("diamond pickaxe")) {
                if (money.get(user) >= 5000) {
                    money.put(user, money.get(user) - 5000);
                    pickaxe.put(user, "DIAMOND_PICKAXE");
                    event.reply("Алмазная кирка куплена").queue();
                } else {
                    event.reply("У вас недостаточно монет").queue();
                }
                if (!money.containsKey(user)) {
                    event.reply("У вас не создан аккаунт!\nЧтобы его создать используйте команду /start").queue();
                }
            } else {
                event.reply("Кирка введена неправильно\nВведенная кирка: " + pickaxename).queue();
            }
        }
    }

}
