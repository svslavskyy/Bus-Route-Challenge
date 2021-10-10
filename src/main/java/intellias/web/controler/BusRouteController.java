package intellias.web.controler;


import intellias.domain.service.RouteService;
import intellias.web.mapper.RouteDtoMapper;
import intellias.web.model.RouteDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"/api/direct"}, produces = APPLICATION_JSON_VALUE)
public class BusRouteController {

  private final RouteService routeService;
  private final RouteDtoMapper routeDtoMapper;

  public BusRouteController(RouteService routeService, RouteDtoMapper routeDtoMapper) {
    this.routeService = routeService;
    this.routeDtoMapper = routeDtoMapper;
  }

  @GetMapping(path = "")
  public ResponseEntity<RouteDto> getDirectRoute(
      @RequestParam Integer dep_sid, @RequestParam Integer arr_sid
  ) {
    RouteDto responseRouteDto = routeDtoMapper.toRouteDto(routeService.getRoute(dep_sid,arr_sid));

    return ResponseEntity.ok(responseRouteDto);
  }
}
