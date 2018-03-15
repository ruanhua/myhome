package cn.com.ulic.op.web;

import cn.com.ulic.op.domain.Menu;
import cn.com.ulic.op.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wangyanyan on 2017/9/11.
 */
@Controller
public class IndexController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/")
    public String getHome(HttpServletRequest request, ModelMap map){
        List<Menu> menus = menuService.getFrontendMenus();
        map.addAttribute("menus", menus);
        return "index";
    }

    @RequestMapping("/success")
    public String success(HttpServletRequest request,ModelMap map){
        List<Menu> menus = menuService.getFrontendMenus();
        map.addAttribute("menus", menus);
        return "success";
    }
    @RequestMapping("/403")
    public String forbidden(ModelMap map){
        return "403";
    }
    @RequestMapping("/404")
    public String notFound(ModelMap map){
        return "404";
    }
    @RequestMapping("/500")
    public String internalServerError(ModelMap map){
        return "500";
    }
}
