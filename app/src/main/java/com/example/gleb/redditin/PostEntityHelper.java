package com.example.gleb.redditin;

import com.example.gleb.redditin.entities.PostChildrenEntity;
import com.example.gleb.redditin.entities.PostEntity;

import java.util.ArrayList;
import java.util.List;

public class PostEntityHelper {
    private final String LOG_TAG = this.getClass().getCanonicalName();
    private static PostEntityHelper instance = null;

    private PostEntityHelper() {
    }

//    public List<PostEntity> convertToPostEntity(List<PostChildrenEntity> childrenEntities){
//        List<PostEntity> entities = new ArrayList<>();
//        for (PostChildrenEntity children : childrenEntities) {
//            PostEntity currentEntity = children.getEntity();
//            entities.add(currentEntity);
//        }
//
//        return entities;
//    }
}
