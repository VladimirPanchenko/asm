package ru.itprogram.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itprogram.model.dto.ApplicantDto;
import ru.itprogram.service.ApplicantService;
import ru.itprogram.service.impl.ApplicantServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class ApplicantServlet extends HttpServlet {
    private static final String CONTEXT_TYPE = "text/html;charset=UTF-8";
    private ApplicantService applicantService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        applicantService = new ApplicantServiceImpl();
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(CONTEXT_TYPE);
        List<ApplicantDto> applicantDtoList = applicantService.getAllApplicant();
        String json = new ObjectMapper().writeValueAsString(applicantDtoList);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        ApplicantDto applicantDto = new ObjectMapper().readValue(reader.readLine(), ApplicantDto.class);
        applicantService.saveNewApplicant(applicantDto);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        ApplicantDto applicantDto = new ObjectMapper().readValue(reader.readLine(), ApplicantDto.class);
        applicantService.updateApplicant(applicantDto);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        applicantService.deleteProfessionById(Long.valueOf(req.getParameter("id")));
    }
}
