package com.brogrammer.mymemo.view;

import java.util.List;
import com.brogrammer.mymemo.model.Memo;

public class MemoViewRenderer {
    public static String renderResponse(List<Memo> memos, String err) {

        String part1 =
                       "<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset=\"UTF-8\">" + "<title>My-Memo</title>"
                           + "<link rel=\"stylesheet\" type=\"text/css\" href=\"screen.css\">" + "</head>" + "<body>"
                           + "<div id=\"container\">" + "<div id=\"header\">"
                           + "<p><b>My-Memo</b> - A Simple Web App for Managing Memos</p>" + "</div>" + "<div id=\"content\">"
                           + "<h1>Add Memo:</h1>" + "<form  method=\"POST\" action=\"\">"
                           + "<input type=\"text\" name=\"memo\"  size=\"30\" placeholder=\"Enter your memo here\" />"
                           + "<button type=\"submit\" name=\"button\" value=\"save\">Add</button>";

        StringBuilder output = new StringBuilder(part1);
        if (err != null) {
            System.out.println("err=" + err);
            output.append("<span style=\"color:red\">" + err + "</span>");
        }

        String part2 = "<h1>My Memos:</h1>";
        output.append(part2).append(renderTable(memos));
        String part3 =
                       "</form>" + "</div>" + "<div id=\"footer\">" + "<p>(C) 2015 Schiesser/Schmollinger, MIT Licence</p>" + "</div>"
                           + "</body>" + "</html>";
        output.append(part3);

        return output.toString();
    }

    private static String renderTable(List<Memo> memos) {
        StringBuilder table = new StringBuilder();
        if (memos.size() == 0) {
            table.append("<p>Please add some memos.</p>");
        } else {
            table.append("<table><tr><th>Memo</th><th>Saved</th></tr>");
            for (Memo memo : memos) {
                table.append("<tr><td>").append(memo.getDescription()).append("</td>");
                table.append("<td>").append(memo.getCreated()).append("</td></tr>");
            }
            table.append("</table><br/><button type=\"submit\" name=\"button\" value=\"reset\">Reset list</button>");
        }
        return table.toString();
    }
}
