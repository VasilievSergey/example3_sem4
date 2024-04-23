package ru.gb.example3_sem4.repository;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sql")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

/*
Свойства запросов
 */
public class QueryProperties {
    String sqlFindAll;    // поиск
    String sqlSave;       // сохранение
    String sqlDeleteById; // удаление
    String sqlUpdateUser; // обновление
    String sqlGetOne;     // id
}