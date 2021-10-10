package intellias.web.mapper;

import intellias.domain.model.Route;
import intellias.web.model.RouteDto;

public interface RouteDtoMapper {

  Route routeDtoToRoute(RouteDto routeDto);

  RouteDto toRouteDto(Route route);


}
