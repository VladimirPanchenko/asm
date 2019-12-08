package ru.itprogram.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itprogram.model.domain.Profession;
import ru.itprogram.model.dto.ProfessionDto;
import ru.itprogram.service.ProfessionService;
import ru.itprogram.service.impl.ProfessionServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class ProfessionServlet extends HttpServlet {
    private static final String CONTEXT_TYPE = "text/html;charset=UTF-8";
    private ProfessionService professionService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        professionService = new ProfessionServiceImpl();
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(CONTEXT_TYPE);
        List<ProfessionDto> professionDtoList = professionService.getAllProfession();
        String json = new ObjectMapper().writeValueAsString(professionDtoList);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        ProfessionDto professionDto = new ObjectMapper().readValue(reader.readLine(), ProfessionDto.class);
        professionService.saveNewProfession(professionDto);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        ProfessionDto professionDto = new ObjectMapper().readValue(reader.readLine(), ProfessionDto.class);
        professionService.updateProfession(professionDto);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        professionService.deleteProfessionById(Long.valueOf(req.getParameter("id")));
    }
}
