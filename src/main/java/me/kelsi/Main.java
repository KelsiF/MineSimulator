package me.kelsi;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("src/main/resources/token.txt"));
        String token = sc.nextLine();
        JDA bot = JDABuilder.createDefault(token).setActivity(Activity.playing("Копается в шахте...")).build();


        }
    }
}