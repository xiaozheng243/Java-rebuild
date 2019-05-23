package online.suiyu.service.impl;

import online.suiyu.dao.PostDao;
import online.suiyu.dao.impl.PostDaoImpl;
import online.suiyu.domain.Classify;
import online.suiyu.domain.Post;
import online.suiyu.domain.PostDemo;
import online.suiyu.service.PostService;

import java.util.ArrayList;
import java.util.List;

public class PostServiceImpl implements PostService {
    private PostDao postDao = new PostDaoImpl();

    @Override
    public ArrayList<PostDemo> getPostsForPublish() {
        return postDao.getPostsForPublish();
    }

    @Override
    public ArrayList<PostDemo> getPostsForDraft() {
        return postDao.getPostsForDraft();
    }

    @Override
    public ArrayList<PostDemo> getPostsForRecycle() {
        return postDao.getPostsForRecycle();
    }

    @Override
    public boolean addPost(Post post) {
        return postDao.addPost(post);
    }

    @Override
    public boolean removePost(Post post) {
        return new PostDaoImpl().removePost(post);
    }

    @Override
    public boolean changePost(Post post, int state) {
        return new PostDaoImpl().changePost(post, state);
    }

    @Override
    public PostDemo getPostForOne(int cid) {
        return postDao.getPostForOne(cid);
    }

    @Override
    public boolean updatePost(Post post) {
        return postDao.updatePost(post);
    }

    @Override
    public List<PostDemo> getPostForClassify(Classify classify) {
        return postDao.getPostForClassify(classify);
    }

    @Override
    public boolean deletePost(Post post) {
        return postDao.deletePost(post);
    }

}
