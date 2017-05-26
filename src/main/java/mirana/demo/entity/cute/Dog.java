package mirana.demo.entity.cute;

import mirana.demo.entity.cute.kind.Rabbit;

public class Dog {

    /**
     * 编号
     */
    long id;

    /**
     * 名称
     */
    String name;

    /**
     * 善良的朋友
     */
    Rabbit friend;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rabbit getFriend() {
        return friend;
    }

    public void setFriend(Rabbit friend) {
        this.friend = friend;
    }
}
