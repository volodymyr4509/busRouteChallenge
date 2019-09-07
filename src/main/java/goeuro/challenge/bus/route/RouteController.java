package goeuro.challenge.bus.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {

    @Autowired
    private RouteService routeService;


    @GetMapping(path = "api/direct")
    public ResponseDto directBusRoute(@RequestParam Integer dep_sid, @RequestParam Integer arr_sid) {
        boolean hasDirectBusRoute = routeService.hasDirectBusRoute(dep_sid, arr_sid);
        return new ResponseDto(dep_sid, arr_sid, hasDirectBusRoute);
    }

}
