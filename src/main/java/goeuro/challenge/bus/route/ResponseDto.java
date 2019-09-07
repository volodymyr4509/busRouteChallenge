package goeuro.challenge.bus.route;

import java.util.Objects;

public class ResponseDto {
    private Integer dep_sid;
    private Integer arr_sid;
    private boolean direct_bus_route;

    public ResponseDto() {
    }

    public ResponseDto(Integer dep_sid, Integer arr_sid, boolean direct_bus_route) {
        this.dep_sid = dep_sid;
        this.arr_sid = arr_sid;
        this.direct_bus_route = direct_bus_route;
    }

    public Integer getDep_sid() {
        return dep_sid;
    }

    public void setDep_sid(Integer dep_sid) {
        this.dep_sid = dep_sid;
    }

    public Integer getArr_sid() {
        return arr_sid;
    }

    public void setArr_sid(Integer arr_sid) {
        this.arr_sid = arr_sid;
    }

    public boolean isDirect_bus_route() {
        return direct_bus_route;
    }

    public void setDirect_bus_route(boolean direct_bus_route) {
        this.direct_bus_route = direct_bus_route;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseDto that = (ResponseDto) o;
        return direct_bus_route == that.direct_bus_route &&
                Objects.equals(dep_sid, that.dep_sid) &&
                Objects.equals(arr_sid, that.arr_sid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dep_sid, arr_sid, direct_bus_route);
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "dep_sid='" + dep_sid + '\'' +
                ", arr_sid='" + arr_sid + '\'' +
                ", direct_bus_route=" + direct_bus_route +
                '}';
    }
}
