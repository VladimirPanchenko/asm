package ru.itprogram.repository.impl;

import ru.itprogram.model.domain.Experience;
import ru.itprogram.repository.ExperienceDao;
import ru.itprogram.utils.CurrentConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExperienceRepositoryImpl implements ExperienceDao {
    @Override
    public List<Experience> getAll() {
        String sql = "SELECT * FROM experience";
        List<Experience> experiences = new ArrayList<>();
        CurrentConnection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Experience experience = new Experience();
                experience.setId(resultSet.getLong("id"));
                experience.setProfessionTime(resultSet.getShort("profession_time"));
                experiences.add(experience);
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
        return experiences;
    }

    @Override
    public Experience getById(long id) {
        String sql = "SELECT * FROM experience WHERE id=?;";
        Experience experience = new Experience();
        CurrentConnection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                experience.setId(resultSet.getLong("id"));
                experience.setProfessionTime(resultSet.getShort("profession_time"));
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
        return experience;
    }

    @Override
    public Experience getByProfessionTime(short professionTime) {
        String sql = "SELECT * FROM experience WHERE profession_time=?;";
        Experience experience = new Experience();
        CurrentConnection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            statement.setShort(1, professionTime);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                experience.setId(resultSet.getLong("id"));
                experience.setProfessionTime(resultSet.getShort("profession_time"));
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
        return experience;
    }

    @Override
    public void add(Experience experience) {
        String sql = "INSERT INTO experience (profession_time) VALUES (?);";
        CurrentConnection connection = null;
        PreparedStatement statement = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            statement.setShort(1, experience.getProfessionTime());
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
    public void update(Experience experience) {
        String sql = "UPDATE experience SET profession_time=? WHERE id=?;";
        CurrentConnection connection = null;
        PreparedStatement statement = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            statement.setShort(1, experience.getProfessionTime());
            statement.setLong(2, experience.getId());
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
        String sql = "DELETE FROM experience WHERE id=?;";
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
