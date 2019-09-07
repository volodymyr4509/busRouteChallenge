package goeuro.challenge.bus.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private StationRepository stationRepository;

    public boolean hasDirectBusRoute(Integer depSid, Integer arrSid) {
        Set<Integer> depRoutes = stationRepository.findRoutes(depSid);
        Set<Integer> arrRoutes = stationRepository.findRoutes(arrSid);
        return !Collections.disjoint(depRoutes, arrRoutes);
    }

}
