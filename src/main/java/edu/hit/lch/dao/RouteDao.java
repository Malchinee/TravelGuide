package edu.hit.lch.dao;

import edu.hit.lch.domain.Route;

import java.util.List;

public interface RouteDao {
    /**
     * 根据cid、rname获取总记录数
     * @param cid
     * @param rname
     * @return
     */

    public int findTotalCount(int cid, String rname);

    /**
     * 从start开始的记录数获取route
     * @param cid
     * @param start
     * @param pageSize
     * @param rname
     * @return
     */

    public List<Route> findByPage(int cid, int start, int pageSize, String rname);
}
