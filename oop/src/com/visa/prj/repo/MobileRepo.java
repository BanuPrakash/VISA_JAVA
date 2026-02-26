package com.visa.prj.repo;

import com.visa.prj.entity.Mobile;

public interface MobileRepo {

    // all methods by default are public and abstract
    public abstract void addMobile(Mobile m);
    Mobile getMobile(int id);
}

