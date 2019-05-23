package online.suiyu.service.impl;

import online.suiyu.dao.impl.PostDaoImpl;
import online.suiyu.dao.impl.SearchDaoImpl;
import online.suiyu.domain.PostDemo;
import online.suiyu.service.SearchService;

import java.util.ArrayList;

public class SearchServiceImpl implements SearchService {

    @Override
    public ArrayList<PostDemo> getPostsBySearch(String searchValue) {
//        ArrayList<PostDemo> publicList = new PostDaoImpl().getPostsForPublish();
        ArrayList<PostDemo> list = new SearchDaoImpl().getPostsBySearch(searchValue);
        for (PostDemo postDemo : list) {
            System.out.println(postDemo.getTitle());
        }
        return new SearchDaoImpl().getPostsBySearch(searchValue);
    }
}
