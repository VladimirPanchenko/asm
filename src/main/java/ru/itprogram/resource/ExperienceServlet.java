package ru.itprogram.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itprogram.model.dto.ExperienceDto;
import ru.itprogram.service.ExperienceService;
import ru.itprogram.service.impl.ExperienceServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class ExperienceServlet extends HttpServlet {
    private ExperienceService experienceService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        experienceService = new ExperienceServiceImpl();
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ExperienceDto> experienceList = experienceService.getAllExperience();
        String json = new ObjectMapper().writeValueAsString(experienceList);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        ExperienceDto experienceDto = new ObjectMapper().readValue(reader.readLine(), ExperienceDto.class);
        experienceService.saveNewExperience(experienceDto);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        ExperienceDto experienceDto = new ObjectMapper().readValue(reader.readLine(), ExperienceDto.class);
        experienceService.updateExperience(experienceDto);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        experienceService.deleteExperienceById(Long.valueOf(req.getParameter("id")));
    }
}
