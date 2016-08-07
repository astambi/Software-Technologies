package app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class HomeController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpSession httpSession, Model model) {
        List<String> items = (ArrayList<String>) httpSession.getAttribute("list");
        model.addAttribute("items", items);
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String addItem(HttpSession httpSession,
                          @RequestParam("newItem") String item) {
        List<String> items = (ArrayList<String>) httpSession.getAttribute("list");
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
        httpSession.setAttribute("list", items);
        return "redirect:index";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(HttpSession httpSession,
                         @PathVariable(value = "id") int item) {
        List<String> items = (ArrayList<String>) httpSession.getAttribute("list");
        items.remove(item);
        httpSession.setAttribute("list", items);
        return "redirect:/index";
    }
}
