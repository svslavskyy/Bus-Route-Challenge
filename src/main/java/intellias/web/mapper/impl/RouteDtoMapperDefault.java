package intellias.web.mapper.impl;

import intellias.domain.model.Route;
import intellias.web.mapper.RouteDtoMapper;
import intellias.web.model.RouteDto;
import org.springframework.stereotype.Component;

@Component
public class RouteDtoMapperDefault implements RouteDtoMapper {

  @Override
  public Route routeDtoToRoute(RouteDto routeDto) {
    if(routeDto == null){
      return null;
    }

    return new Route(routeDto.getDepSid(), routeDto.getDepSid(), routeDto.getDirectBusRoute());
  }

  @Override
  public RouteDto toRouteDto(Route route) {
    if(route == null){
      return null;
    }

    return new RouteDto(route.getDepSid(), route.getArrSid(), route.getDirectBusRoute());
  }


}
