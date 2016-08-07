package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@Controller
public class FilesController {

    @RequestMapping("/files")
    public String listFiles(Model model,
                @RequestParam(value = "dir", defaultValue = "C:\\") String path) {
        File[] files = new File(path).listFiles();
        model.addAttribute("files", files);
        model.addAttribute("path", path);
        return "files";
    }

    @RequestMapping("/filesplus")
    public String files(Model model,
                @RequestParam(value = "dir", defaultValue = "C:/") String path) {
        File[] allFiles = new File(path).listFiles();
        model.addAttribute("allFiles", allFiles);
        model.addAttribute("path", path);
        return "filesplus";
    }
}