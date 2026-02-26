package com.visa.prj.repo;

import com.visa.prj.entity.Mobile;

public interface MobileRepo {
    void addMobile(Mobile m);
    Mobile getMobile(int id);
}
