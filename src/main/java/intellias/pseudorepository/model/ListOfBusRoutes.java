package intellias.pseudorepository.model;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class ListOfBusRoutes {

  private static Map<Integer, Set<Integer>> listRoutes = null;

  public static void initialize(String fileName) throws RuntimeException {

    if (listRoutes != null) {
      throw new RuntimeException("The data is initialized, to initialize new data, restart the service");
    } else {
      listRoutes = new HashMap<>();
      try {
        readUsingScanner(fileName);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private static void readUsingScanner(String fileName) throws IOException {

    ClassLoader classLoader = ListOfBusRoutes.class.getClassLoader();
    File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());

    Scanner scannerByLine = new Scanner(file);
    while (scannerByLine.hasNextLine()) {
      String line = scannerByLine.nextLine();

      Scanner scannerByNumber = new Scanner(line);
      Integer key = scannerByNumber.nextInt();

      Set<Integer> set = new LinkedHashSet<>();
      while (scannerByNumber.hasNext()) {
        set.add(scannerByNumber.nextInt());
      }
      listRoutes.put(key, set);
    }
  }

  public static boolean isRouteExists(Integer depSid, Integer arrSid) {
    for (Map.Entry<Integer, Set<Integer>> entry : listRoutes.entrySet()) {
      return entry.getValue().contains(depSid) && entry.getValue().contains(arrSid);
    }
    return false;
  }


}
