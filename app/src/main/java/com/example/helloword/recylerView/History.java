package com.example.helloword.recylerView;

public class History {
    String title ;
    int point;

    public History(String title, int point) {
        this.title = title;
        this.point = point;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
