package itemservice.controllers;

import itemservice.payload.request.SearchVo;
import itemservice.payload.response.ApiDataResponseVo;
import itemservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping()
    public String createForm() {
        return "items";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/fruit/{itemName}")
    @ResponseBody
    public ApiDataResponseVo fruit(SearchVo searchVo) throws Exception {
        return itemService.getFruitPrice(searchVo);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/vegetable/{itemName}")
    @ResponseBody
    public ApiDataResponseVo vegetable(SearchVo searchVo) throws Exception {
        ApiDataResponseVo vo = itemService.getVegetPrice(searchVo);
        return itemService.getVegetPrice(searchVo);
    }

}
