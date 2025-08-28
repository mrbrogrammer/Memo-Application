package com.brogrammer.mymemo.controller;

import java.io.IOException;

import com.brogrammer.mymemo.model.Memo;
import com.brogrammer.mymemo.view.MemoViewRenderer;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/MemoServlet", "/memos"})
public class MemoServlet extends HttpServlet {

    private static final long serialVersionUID = -7843898075264520941L;
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sendResponse(request, response);
    }

    private void sendResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        response.getOutputStream().print(MemoViewRenderer.renderResponse(java.util.Collections.<Memo>emptyList(), null));
    }

}
