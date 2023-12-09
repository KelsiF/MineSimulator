package me.kelsi;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
    public static void main(String[] args) {

        String token = "OTg0Nzk4OTk4OTExMTU2Mjg1.GSqmP2.uzGl3K0Ze70qvbt6KpXO_H1xGVZUH2uO4q5ktw";
        JDA bot = JDABuilder.createDefault(token).setActivity(Activity.playing("Копается в шахте...")).build();

    }
}