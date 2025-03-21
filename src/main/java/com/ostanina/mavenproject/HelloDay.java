package com.ostanina.mavenproject;

import com.ostanina.mavenproject.model.RussianDaysOfWeek;

import java.time.DayOfWeek;
import java.util.Scanner;

public class HelloDay {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String response;
        String result = "";

        do {
            System.out.println("Add day of the week in English");
            response = scanner.nextLine();
            result = changeResponseToRussian(response);
            if (result.equals("Вы не ввели день недели!") || result.equals("Что-то пошло не так. Попытайся снова!")) {
                System.out.println(result);
            }
        } while (result.equals("Вы не ввели день недели!") || result.equals("Что-то пошло не так. Попытайся снова!"));

        System.out.println(result);

    }

    private static String changeResponseToRussian(String response) {
        if (response == null || response.trim().isEmpty()) {
            return "Вы не ввели день недели!";
        }

        try {
            String formattedResponse = response.trim().toUpperCase();
            DayOfWeek day = DayOfWeek.valueOf(formattedResponse);

            return switch (day) {
                case MONDAY -> String.format("По-русски это %s!", RussianDaysOfWeek.ПОНЕДЕЛЬНИК.name().toLowerCase());
                case TUESDAY -> String.format("По-русски это %s!", RussianDaysOfWeek.ВТОРНИК.name().toLowerCase());
                case WEDNESDAY -> String.format("По-русски это %s!", RussianDaysOfWeek.СРЕДА.name().toLowerCase());
                case THURSDAY -> String.format("По-русски это %s!", RussianDaysOfWeek.ЧЕТВЕРГ.name().toLowerCase());
                case FRIDAY -> String.format("По-русски это %s!", RussianDaysOfWeek.ПЯТНИЦА.name().toLowerCase());
                case SATURDAY -> String.format("По-русски это %s!", RussianDaysOfWeek.СУББОТА.name().toLowerCase());
                case SUNDAY -> String.format("По-русски это %s!", RussianDaysOfWeek.ВОСКРЕСЕНЬЕ.name().toLowerCase());
            };
        } catch (IllegalArgumentException e) {
            return "Что-то пошло не так. Попытайся снова!";
        }
    }
}
