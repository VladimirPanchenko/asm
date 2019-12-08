package ru.itprogram.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itprogram.model.dto.PhoneDto;
import ru.itprogram.service.PhoneService;
import ru.itprogram.service.impl.PhoneServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class PhoneServlet extends HttpServlet {
    private PhoneService phoneService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        phoneService = new PhoneServiceImpl();
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PhoneDto> allPhone = phoneService.getAllPhone();
        String json = new ObjectMapper().writeValueAsString(allPhone);
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        PhoneDto phoneDto = new ObjectMapper().readValue(reader.readLine(), PhoneDto.class);
        phoneService.saveNewPhone(phoneDto);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        phoneService.deletePhoneById(Long.valueOf(req.getParameter("id")));
    }
}
