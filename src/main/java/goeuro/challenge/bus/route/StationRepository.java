package goeuro.challenge.bus.route;

import java.util.Set;


public interface StationRepository {

    void readSourceFile();

    Set<Integer> findRoutes(Integer stationId);

}
