package online.suiyu.service;

import online.suiyu.domain.PostDemo;

import java.util.ArrayList;

public interface SearchService {
    public ArrayList<PostDemo> getPostsBySearch(String searchValue);
}
