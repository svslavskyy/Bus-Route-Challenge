package intellias.domain.service.impl;

import intellias.domain.model.Route;
import intellias.domain.service.RouteService;
import intellias.pseudorepository.model.ListOfBusRoutes;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceDefault implements RouteService {

  @Override
  public Route getRoute(Integer depSid, Integer arrSid) {
    boolean directBusRoute = ListOfBusRoutes.isRouteExists(depSid, arrSid);
    return new Route(depSid, arrSid, directBusRoute);
  }


}
