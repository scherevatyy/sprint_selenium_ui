package org.example.utils;

import org.example.enums.RentalPeriod;
import org.example.enums.ScooterColor;
import org.example.model.OrderDTO;

import java.time.LocalDate;
import java.util.List;

public class TestDataFactory {

    public static OrderDTO validOrderOne() {
        return new OrderDTO(
                "Иван",
                "Иванов",
                "Москва",
                "Сокольники",
                "+79998887766",
                LocalDate.now().plusDays(1),
                RentalPeriod.THREE_DAYS,
                List.of(ScooterColor.BLACK),
                "Позвоните за час"
        );
    }

    public static OrderDTO validOrderTwo() {
        return new OrderDTO(
                "Анна",
                "Петрова",
                "Санкт-Петербург",
                "Черкизовская",
                "+79990001122",
                LocalDate.now().plusDays(2),
                RentalPeriod.ONE_DAY,
                List.of(ScooterColor.GREY),
                "Без комментариев"
        );
    }
}