package ru.itprogram.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itprogram.model.dto.EmailDto;
import ru.itprogram.service.EmailService;
import ru.itprogram.service.impl.EmailServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class EmailServlet extends HttpServlet {
    private static final String CONTEXT_TYPE = "text/html;charset=UTF-8";
    private EmailService emailService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        emailService = new EmailServiceImpl();
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(CONTEXT_TYPE);
        List<EmailDto> emails = emailService.getAllEmail();
        String json = new ObjectMapper().writeValueAsString(emails);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        EmailDto emailDto = new ObjectMapper().readValue(reader.readLine(), EmailDto.class);
        emailService.saveNewEmail(emailDto);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        emailService.deleteEmailById(Long.valueOf(req.getParameter("id")));
    }
}
