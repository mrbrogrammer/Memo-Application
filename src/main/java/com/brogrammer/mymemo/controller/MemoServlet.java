package com.brogrammer.mymemo.controller;

import java.io.IOException;
import java.util.*;
import java.time.*;

import com.brogrammer.mymemo.model.Memo;
import com.brogrammer.mymemo.view.MemoViewRenderer;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // get post parameter
        final String button = request.getParameter("button");
        switch (button) {
            case "save":
                actionAddMemo(request);
                sendResponse(request, response);
                break;
            default:
                // no action
                sendResponse(request, response);
        }
    }

    private synchronized void actionAddMemo(HttpServletRequest request) {
        String memoDescr = request.getParameter("memo");
        if (memoDescr != null && !memoDescr.isEmpty()) {
            List<Memo> memos = getMemos(request);
            // create memo
            Memo memo = new Memo();
            memo.setDescription(memoDescr);
            memo.setCreated(new Date());
            // add todo list
            memos.add(memo);
        } else {
            //set error message in request
            request.setAttribute("err", "Please, enter a memo!");
        }
    }

    private void sendResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        List<Memo> memos = getMemos(request);
        response.getOutputStream().print(MemoViewRenderer.renderResponse(java.util.Collections.<Memo>emptyList(), null));
    }

    private List<Memo> getMemos(HttpServletRequest request) {
        // Consider session
        HttpSession session = request.getSession();
        List<Memo> memos = (List<Memo>)session.getAttribute("memos");
        return memos;
    }

}
