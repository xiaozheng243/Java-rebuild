package online.suiyu.service;

import online.suiyu.domain.Classify;
import online.suiyu.domain.Post;
import online.suiyu.domain.PostDemo;

import java.util.ArrayList;
import java.util.List;

public interface PostService {
    public ArrayList<PostDemo> getPostsForPublish();

    public ArrayList<PostDemo> getPostsForDraft();

    public ArrayList<PostDemo> getPostsForRecycle();

    public boolean addPost(Post post);

    public boolean removePost(Post post);

    public boolean changePost(Post post, int state);

    public PostDemo getPostForOne(int cid);

    public boolean updatePost(Post post);

    public List<PostDemo> getPostForClassify(Classify classify);

    public boolean deletePost(Post post);
}
