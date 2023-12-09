package me.kelsi;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

public class Listeners extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        Guild guild = event.getJDA().getGuildById(918438356642324480L);
        guild.upsertCommand("profile", "Показывает профиль пользователя в боте").addOptions(new OptionData(OptionType.USER, "user", "Если хотите увидеть свой профиль, то ничего не пишите в этом аргументе", false)).queue();
    }

}
