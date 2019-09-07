package goeuro.challenge.bus.route;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

@Service
public class StationRepositoryImpl implements StationRepository {
    private static final String SPACE = " ";

    private Map<Integer, Set<Integer>> stationIdToRoutesMap;

    @Override
    @PostConstruct
    public void readSourceFile() {
        File source = new File(Application.filePath);
        System.out.println("Parsing " + source);
        if (source.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(source))) {
                String line = in.readLine();
                this.stationIdToRoutesMap = new HashMap<>(Integer.valueOf(line));
                line = in.readLine();
                while (line != null) {
                    String[] values = line.split(SPACE);
                    try {
                        Integer routeId = Integer.valueOf(values[0]);
                        for (int i = 1; i < values.length; i++) {
                            Integer stationId = Integer.valueOf(values[i]);
                            stationIdToRoutesMap.computeIfAbsent(stationId, it -> new HashSet<>()).add(routeId);
                        }
                    } catch (NumberFormatException e) {//skip one line when bad syntax was found
                        System.err.println(e.getMessage());
                    }
                    line = in.readLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Set<Integer> findRoutes(Integer stationId) {
        return stationIdToRoutesMap.getOrDefault(stationId, Collections.emptySet()); //throw exception if no stationId data exists?!
    }

}
