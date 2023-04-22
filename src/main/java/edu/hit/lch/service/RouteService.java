package edu.hit.lch.service;

import edu.hit.lch.domain.PageBean;
import edu.hit.lch.domain.Route;

import java.util.List;

public interface RouteService {
    PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);
}
