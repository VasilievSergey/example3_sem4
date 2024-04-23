package ru.gb.example3_sem4.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
/*
Доменная сущность ПОЛЬЗОВАТЕЛЬ
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)//аннотация добавления PRIVATE к полям
public class User {
    int id;
    String firstName;
    String lastName;
}
