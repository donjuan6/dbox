package per.th.dbox.sharding.route;

public interface SQLRouter {

    SQLRouteTable route(SQLRouteContext context);

}
