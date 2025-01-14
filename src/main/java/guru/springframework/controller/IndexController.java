package guru.springframework.controller;

import guru.springframework.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndex(Model model) {
        recipeService.getRecipes().forEach(recipe -> recipe.setPrepTime(2));
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
