package com.example.courseschedule.dto;

import com.example.courseschedule.domain.PreSchedule;

import java.util.ArrayList;
import java.util.List;

public class CollisionResult {
    private List<List<PreSchedule>> collisionList = new ArrayList<>();

    public boolean isCollision() {
        return isCollision;
    }

    public void setCollision(boolean collision) {
        isCollision = collision;
    }

    private boolean isCollision = false;

    public CollisionResult() {
    }

    public CollisionResult(List<List<PreSchedule>> collisionList) {
        this.collisionList = collisionList;
    }

    public List<List<PreSchedule>> getCollisionList() {
        return collisionList;
    }

    public void setCollisionList(List<List<PreSchedule>> collisionList) {
        this.collisionList = collisionList;
    }

    public void addCollision(List<PreSchedule> collision) {
        this.collisionList.add(collision);
    }

}
