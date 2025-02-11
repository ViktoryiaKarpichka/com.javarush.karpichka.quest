package com.javarush.quest.controller;

import com.javarush.quest.entity.Question;
import com.javarush.quest.service.QuestService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/quest")
public class QuestServlet extends HttpServlet {
    private QuestService questService = new QuestService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("gamesPlayed") == null) {
            session.setAttribute("gamesPlayed", 0);
            session.setAttribute("gamesWon", 0);
        }

        Integer currentQuestionId = (Integer) session.getAttribute("currentQuestion");
        if (currentQuestionId == null) {
            currentQuestionId = 1;
            session.setAttribute("currentQuestion", currentQuestionId);
        }

        Question question = questService.getQuestion(currentQuestionId);
        request.setAttribute("question", question);
        request.getRequestDispatcher("/quest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nextIdParam = request.getParameter("nextId");

        if (nextIdParam == null || nextIdParam.isEmpty()) {
            response.sendRedirect("quest");
            return;
        }

        int nextId = Integer.parseInt(nextIdParam);
        System.out.println("Next question ID: " + nextIdParam);

        if (nextId == -1 || nextId == 100) {
            int gamesPlayed = (int) session.getAttribute("gamesPlayed") + 1;
            session.setAttribute("gamesPlayed", gamesPlayed);

            if (nextId == 100) {
                int gamesWon = (int) session.getAttribute("gamesWon") + 1;
                session.setAttribute("gamesWon", gamesWon);
            }

            session.removeAttribute("currentQuestion");
            response.sendRedirect("index.jsp");
        } else {
            session.setAttribute("currentQuestion", nextId);
            response.sendRedirect("quest");
        }
    }
}

