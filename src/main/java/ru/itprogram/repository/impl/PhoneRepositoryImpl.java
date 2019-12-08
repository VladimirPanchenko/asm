package ru.itprogram.repository.impl;

import ru.itprogram.model.domain.Phone;
import ru.itprogram.repository.PhoneDao;
import ru.itprogram.utils.CurrentConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneRepositoryImpl implements PhoneDao {
    @Override
    public List<Phone> getAll() {
        String sql = "SELECT * FROM phones;";
        List<Phone> phones = new ArrayList<>();
        CurrentConnection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Phone phone = new Phone();
                phone.setId(resultSet.getLong("id"));
                phone.setApplicantId(resultSet.getLong("applicant_id"));
                phone.setNumber(resultSet.getString("number"));
                phones.add(phone);
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
        return phones;
    }

    @Override
    public List<Phone> getByApplicantId(long id) {
        String sql = "SELECT * FROM phones WHERE applicant_id=?;";
        List<Phone> phones = new ArrayList<>();
        CurrentConnection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            statement.setLong(1, id);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Phone phone = new Phone();
                phone.setId(resultSet.getLong("id"));
                phone.setApplicantId(resultSet.getLong("applicant_id"));
                phone.setNumber(resultSet.getString("number"));
                phones.add(phone);
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
        return phones;
    }

    @Override
    public void add(Phone phone) {
        String sql = "INSERT INTO phones (applicant_id, number) VALUES (?, ?);";
        CurrentConnection connection = null;
        PreparedStatement statement = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            statement.setLong(1, phone.getApplicantId());
            statement.setString(2, phone.getNumber());
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
        String sql = "DELETE FROM phones WHERE id=?;";
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
