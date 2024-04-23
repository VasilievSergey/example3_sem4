package ru.gb.example3_sem4.repository;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import ru.gb.example3_sem4.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
// аннотация PRIVATE final

/*
 Создание репозитория с конструктором
 */
public class UserRepository {
    @Autowired
    JdbcTemplate jdbc;
    QueryProperties sql;

    public UserRepository(JdbcTemplate jdbc, QueryProperties sql) {
        this.jdbc = jdbc;
        this.sql = sql;
    }

    /*
    Обработка запросов
    String sql = "SELECT * FROM userTable";
     */
    public List<User> findAll() {
        RowMapper<User> userRowMapper = ((rs, rowNum) -> {
            User rowObject = new User();
            rowObject.setId(rs.getInt("id"));
            rowObject.setFirstName(rs.getString("firstName"));
            rowObject.setLastName(rs.getString("lastName"));
            return rowObject;
        });

        return jdbc.query(sql.getSqlFindAll(), userRowMapper);
    }

    /*
    String sql = "INSERT INTO userTable (firstName, lastName) VALUES (?, ?)";
     */
    public void save(@NonNull User user) {
        jdbc.update(sql.getSqlSave(), user.getFirstName(), user.getLastName());
    }

    /*
    String sql = "DELETE FROM userTable WHERE id=?";
     */
    public void deleteById(int id) {
        jdbc.update(sql.getSqlDeleteById(), id);
    }

    /*
    String sql = "UPDATE userTable SET firstName = ?, lastName = ? WHERE id = ?";
     */
    public void updateUser(@NonNull User user) {
        jdbc.update(sql.getSqlUpdateUser(), user.getFirstName(), user.getLastName(), user.getId());
    }
    /*
    String sql = "SELECT * FROM userTable WHERE id = " + id;
     */
    public User getOne(int id) {
        String sql_string = sql.getSqlGetOne() + id;
        RowMapper<User> userRowMapper = ((rs, rowNum) -> {
            User rowObject = new User();
            rowObject.setId(rs.getInt("id"));
            rowObject.setFirstName(rs.getString("firstName"));
            rowObject.setLastName(rs.getString("lastName"));
            return rowObject;
        });
        List<User> users = jdbc.query(sql_string, userRowMapper);
        if (users.isEmpty()) {
            return null;
        } else {
            return jdbc.query(sql_string, userRowMapper).get(0);
        }
    }
}