package pl.npe.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.npe.model.NpeView;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ViewsController {
    @GetMapping("/views")
    public List<NpeView> getAllViews() {
        try (Reader reader = new FileReader("views.json")) {
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(reader, List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}
