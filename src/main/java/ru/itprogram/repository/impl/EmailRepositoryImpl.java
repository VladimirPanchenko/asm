package ru.itprogram.repository.impl;

import ru.itprogram.model.domain.Email;
import ru.itprogram.repository.EmailDao;
import ru.itprogram.utils.CurrentConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailRepositoryImpl implements EmailDao {
    @Override
    public List<Email> getAll() {
        String sql = "SELECT * FROM emails;";
        List<Email> emails = new ArrayList<>();
        CurrentConnection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Email email = new Email();
                email.setId(resultSet.getLong("id"));
                email.setApplicantId(resultSet.getLong("applicant_id"));
                email.setEmail(resultSet.getString("email"));
                emails.add(email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.getConnection().close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emails;
    }

    @Override
    public List<Email> getByApplicantId(long id) {
        String sql = "SELECT * FROM emails WHERE applicant_id=?;";
        List<Email> emails = new ArrayList<>();
        CurrentConnection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Email email = new Email();
                email.setId(resultSet.getLong("id"));
                email.setApplicantId(resultSet.getLong("applicant_id"));
                email.setEmail(resultSet.getString("email"));
                emails.add(email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.getConnection().close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emails;
    }

    @Override
    public void add(Email email) {
        String sql = "INSERT INTO emails (applicant_id, email) VALUES (?, ?);";
        CurrentConnection connection = null;
        PreparedStatement statement = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            statement.setLong(1, email.getApplicantId());
            statement.setString(2, email.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.getConnection().close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void remove(long id) {
        String sql = "DELETE FROM emails WHERE id=?;";
        CurrentConnection connection = null;
        PreparedStatement statement = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.getConnection().close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
