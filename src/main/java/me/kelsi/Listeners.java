package me.kelsi;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Objects;

public class Listeners extends ListenerAdapter {

    public static HashMap<User, Double> blocks = new HashMap<>();
    public static HashMap<User, Double> stone = new HashMap<>();
    public static HashMap<User, Double> coal = new HashMap<>();
    public static HashMap<User, Double> iron = new HashMap<>();
    public static HashMap<User, Double> gold = new HashMap<>();
    public static HashMap<User, Double> diamond = new HashMap<>();
    public static HashMap<User, Double> emerald = new HashMap<>();
    public static HashMap<User, Double> money = new HashMap<>();
    public static HashMap<User, String> pickaxe = new HashMap<>();


    @Override
    public void onReady(@NotNull ReadyEvent event) {
        Guild guild = event.getJDA().getGuildById(918438356642324480L);
        Objects.requireNonNull(guild).upsertCommand("profile", "Показывает профиль пользователя в боте").addOptions(new OptionData(OptionType.USER, "user", "Если хотите увидеть свой профиль, то ничего не пишите в этом аргументе", false)).queue();
        guild.upsertCommand("mine", "Отправиться в шахту за рудой").queue();
        guild.upsertCommand("start", "Создать профиль в боте").queue();
        guild.upsertCommand("sell", "Продать всю руду, что у вас есть").queue();
    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {

        User user = event.getUser();
        if (!blocks.containsKey(user) || !money.containsKey(user)) {
            //количество блоков
            blocks.put(user, 0.0);
            //количество камня
            stone.put(user, 0.0);
            //количество угля
            coal.put(user, 0.0);
            //количество железа
            iron.put(user, 0.0);
            //количество золота
            gold.put(user, 0.0);
            //количество алмазов
            diamond.put(user, 0.0);
            //количество изумрудов
            emerald.put(user, 0.0);
            //количество монет
            money.put(user, 0.0);
            // экипированная кирка
            pickaxe.put(user, "WOODEN_PICKAXE");
        }
    }

}
