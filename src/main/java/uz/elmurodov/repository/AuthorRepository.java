package uz.elmurodov.repository;

import uz.elmurodov.configs.DbConfig;
import uz.elmurodov.configs.PropertyConfig;
import uz.elmurodov.model.Author;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Elmurodov Javohir, Tue 3:35 PM. 12/14/2021
 */
public class AuthorRepository implements BaseRepository<Author> {
    private static AuthorRepository instance;


    @Override
    public void save(Author entity) {
        try (Connection connection = DbConfig.conn();
             Statement statement = connection.createStatement()) {
            statement.execute(PropertyConfig.get("query.create.author").formatted(entity.getFullName(),
                    entity.getBirthdate()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Author> getAll() {
        List<Author> authors = new ArrayList<>();
        try (Connection connection = DbConfig.conn();
             Statement statement = connection.createStatement()
        ) {
            String sql = "select * from author;";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Author author = Author.childBuilder()
                        .id(resultSet.getLong("id"))
                        .fullName(resultSet.getString("full_name"))
                        .birthdate(resultSet.getString("birthdate"))
                        .build();
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    public static AuthorRepository getInstance() {
        if (instance == null) instance = new AuthorRepository();
        return instance;
    }

    public void delete(int authorId) {
        try (Connection connection = DbConfig.conn();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format("delete from author where id = %d;", authorId);
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Author author, String birth) {
        try (Connection connection = DbConfig.conn();
             Statement statement = connection.createStatement()
        ) {
            String sql = String.format("update author set birthdate = '%s' where full_name = '%s';",
                    birth, author.getFullName());
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Author> search(String str) {
        List<Author> authors = new ArrayList<>();
        try (Connection connection = DbConfig.conn();
             Statement statement = connection.createStatement()
        ) {
            String sql = "select t.* from author t where full_name like '%" + str +
                    "%' or id like '%" + str + "%' or birthdate like '%" + str +
                    "%'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Author author = Author.childBuilder()
                        .id(resultSet.getLong("id"))
                        .fullName(resultSet.getString("full_name"))
                        .birthdate(resultSet.getString("birthdate"))
                        .build();
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }
}
