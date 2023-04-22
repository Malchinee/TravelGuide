package edu.hit.lch.service.impl;

import edu.hit.lch.dao.RouteDao;
import edu.hit.lch.dao.impl.RouteDaoImpl;
import edu.hit.lch.domain.PageBean;
import edu.hit.lch.domain.Route;
import edu.hit.lch.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {

    private RouteDao routeDao = new RouteDaoImpl();

    /**
     *  根据分类id、当前页号、每页大小、路线名字查询
     * @param cid
     * @param currentPage
     * @param pageSize
     * @param rname
     * @return
     */
    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
        /*
        *   private int totalCount;//总记录数
            private int totalPage;//总页数
            private int currentPage;//当前页码
            private int pageSize;//每页显示的条数
            private List<T> list;//每页显示的数据集合
        * */
        PageBean<Route> pb = new PageBean<>();

        // 设置当前页、页总数
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);

        // 获得总记录数
        int totalCount = routeDao.findTotalCount(cid, rname);
        pb.setTotalCount(totalCount);

        int start = (currentPage - 1) * pageSize;
        pb.setList(routeDao.findByPage(cid, start, pageSize, rname));
        // 判断是否整除
        if(totalCount % pageSize == 0) {
            pb.setTotalPage(totalCount / pageSize);
        }else {
            pb.setTotalPage(totalCount / pageSize + 1);
        }

        return pb;
    }
}
