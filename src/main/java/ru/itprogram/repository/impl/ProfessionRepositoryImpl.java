package ru.itprogram.repository.impl;

import ru.itprogram.model.domain.Profession;
import ru.itprogram.repository.ProfessionDao;
import ru.itprogram.utils.CurrentConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessionRepositoryImpl implements ProfessionDao {
    @Override
    public List<Profession> getAll() {
        String sql = "SELECT * FROM professions";
        List<Profession> professions = new ArrayList<>();
        CurrentConnection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Profession profession = new Profession();
                profession.setId(resultSet.getLong("id"));
                profession.setProfessionName(resultSet.getString("profession_name"));
                professions.add(profession);
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
        return professions;
    }

    @Override
    public Profession getById(long id) {
        String sql = "SELECT * FROM professions WHERE id=?;";
        Profession profession = new Profession();
        CurrentConnection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                profession.setId(resultSet.getLong("id"));
                profession.setProfessionName(resultSet.getString("profession_name"));
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
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return profession;
    }

    @Override
    public Profession getByProfessionName(String professionName) {
        String sql = "SELECT * FROM professions WHERE profession_name=?;";
        Profession profession = new Profession();
        CurrentConnection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, professionName);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                profession.setId(resultSet.getLong("id"));
                profession.setProfessionName(resultSet.getString("profession_name"));
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
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return profession;
    }

    @Override
    public void add(Profession profession) {
        String sql = "INSERT INTO professions (profession_name) VALUES (?);";
        CurrentConnection connection = null;
        PreparedStatement statement = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, profession.getProfessionName());
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
    public void update(Profession profession) {
        String sql = "UPDATE professions SET profession_name=? WHERE id=?;";
        CurrentConnection connection = null;
        PreparedStatement statement = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, profession.getProfessionName());
            statement.setLong(2, profession.getId());
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
        String sql = "DELETE FROM professions WHERE id=?;";
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
