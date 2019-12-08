package ru.itprogram.repository.impl;

import ru.itprogram.model.domain.Applicant;
import ru.itprogram.model.domain.Experience;
import ru.itprogram.model.domain.Gender;
import ru.itprogram.model.domain.Profession;
import ru.itprogram.repository.ApplicantDao;
import ru.itprogram.repository.ExperienceDao;
import ru.itprogram.repository.ProfessionDao;
import ru.itprogram.utils.CurrentConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicantRepositoryImpl implements ApplicantDao {
    @Override
    public List<Applicant> getAll() {

        String sql = "SELECT applicant.id, applicant.name, surname, middle_name, age, gender, professions.profession_name, experience.profession_time " +
                "FROM applicant " +
                "LEFT JOIN experience ON experience.id = applicant.experience_id " +
                "LEFT JOIN professions ON professions.id = applicant.profession_id;";
        List<Applicant> applicants = new ArrayList<>();
        CurrentConnection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Applicant applicant = new Applicant();
                applicant.setId(resultSet.getLong("id"));
                applicant.setName(resultSet.getString("name"));
                applicant.setSurname(resultSet.getString("surname"));
                applicant.setMiddleName(resultSet.getString("middle_name"));
                applicant.setAge(resultSet.getShort("age"));
                applicant.setGender(Gender.values()[resultSet.getShort("gender")]);
                applicant.setProfession(new Profession(0l, resultSet.getString("profession_name")));
                applicant.setExperience(new Experience(0l, resultSet.getShort("profession_time")));
                applicants.add(applicant);
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
        return applicants;
    }

    @Override
    public Applicant getById(long id) {
        String sql = "SELECT * FROM applicant WHERE id=?;";
        Applicant applicant = new Applicant();
        CurrentConnection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                applicant.setId(resultSet.getLong("id"));
                applicant.setName(resultSet.getString("name"));
                applicant.setSurname(resultSet.getString("surname"));
                applicant.setMiddleName(resultSet.getString("middle_name"));
                applicant.setAge(resultSet.getShort("age"));
                applicant.setGender(Gender.values()[resultSet.getShort("gender")]);
                applicant.setProfession(new Profession(0l, resultSet.getString("profession_name")));
                applicant.setExperience(new Experience(0l, resultSet.getShort("profession_time")));
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
        return applicant;
    }

    @Override
    public void add(Applicant applicant) {
        String sql = "INSERT INTO applicant " +
                "(name, surname, middle_name, age, gender, profession_id, experience_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        CurrentConnection connection = null;
        PreparedStatement statement = null;
        Applicant applicantFullFields = getProfessionIdAndExperienceId(applicant);
        if (applicantFullFields.getProfession().getId() == 0 || applicantFullFields.getExperience().getId() == 0) {
            return;
        }

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, applicantFullFields.getName());
            statement.setString(2, applicantFullFields.getSurname());
            statement.setString(3, applicantFullFields.getMiddleName());
            statement.setShort(4, applicantFullFields.getAge());
            statement.setShort(5, (short) applicantFullFields.getGender().ordinal());
            statement.setLong(6, applicantFullFields.getProfession().getId());
            statement.setLong(7, applicantFullFields.getExperience().getId());
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
    public void update(Applicant applicant) {
        String sql = "UPDATE applicant SET " +
                "name=?, surname=?, middle_name=?, age=?, gender=?, profession_id=?, experience_id=?" +
                "WHERE id=?;";
        CurrentConnection connection = null;
        PreparedStatement statement = null;
        Applicant applicantFullFields = getProfessionIdAndExperienceId(applicant);
        if (applicantFullFields.getProfession() == null || applicantFullFields.getExperience() == null) {
            return;
        }

        try {
            connection = new CurrentConnection();
            statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, applicantFullFields.getName());
            statement.setString(2, applicantFullFields.getSurname());
            statement.setString(3, applicantFullFields.getMiddleName());
            statement.setShort(4, applicantFullFields.getAge());
            statement.setShort(5, (short) applicantFullFields.getGender().ordinal());
            statement.setLong(6, applicantFullFields.getProfession().getId());
            statement.setLong(7, applicantFullFields.getExperience().getId());
            statement.setLong(8, applicantFullFields.getId());
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
        String sql = "DELETE FROM applicant WHERE id=?;";
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

    private Applicant getProfessionIdAndExperienceId(Applicant applicant) {
        ProfessionDao professionDao = new ProfessionRepositoryImpl();
        Profession profession = professionDao.getByProfessionName(applicant.getProfession().getProfessionName());
        ExperienceDao experienceDao = new ExperienceRepositoryImpl();
        Experience experience = experienceDao.getByProfessionTime(applicant.getExperience().getProfessionTime());
        applicant.setProfession(profession);
        applicant.setExperience(experience);
        return applicant;
    }
}
