package online.suiyu.dao;

import online.suiyu.domain.PostDemo;

import java.util.ArrayList;

public interface SearchDao {
    public ArrayList<PostDemo> getPostsBySearch(String searchValue);
}
