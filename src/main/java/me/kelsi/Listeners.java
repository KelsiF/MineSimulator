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

public class Listeners extends ListenerAdapter {

    public static HashMap<User, Integer> blocks = new HashMap<>();
    public static HashMap<User, Integer> stone = new HashMap<>();
    public static HashMap<User, Integer> coal = new HashMap<>();
    public static HashMap<User, Integer> iron = new HashMap<>();
    public static HashMap<User, Integer> gold = new HashMap<>();
    public static HashMap<User, Integer> diamond = new HashMap<>();
    public static HashMap<User, Integer> emerald = new HashMap<>();
    public static HashMap<User, Integer> money = new HashMap<>();


    @Override
    public void onReady(@NotNull ReadyEvent event) {
        Guild guild = event.getJDA().getGuildById(918438356642324480L);
        guild.upsertCommand("profile", "Показывает профиль пользователя в боте").addOptions(new OptionData(OptionType.USER, "user", "Если хотите увидеть свой профиль, то ничего не пишите в этом аргументе", false)).queue();
    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {

        User user = event.getUser();
        if (!blocks.containsKey(user) || !money.containsKey(user)) {
            //количество блоков
            blocks.put(user, 0);
            //количество камня
            stone.put(user, 0);
            //количество угля
            coal.put(user, 0);
            //количество железа
            iron.put(user, 0);
            //количество золота
            gold.put(user, 0);
            //количество алмазов
            diamond.put(user, 0);
            //количество изумрудов
            emerald.put(user, 0);
            //количество монет
            money.put(user, 0);
        }
    }

}
