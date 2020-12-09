package com.ambity.service;

import com.ambity.dto.Tb1;
import com.ambity.mapper.Tb1Mapper;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SqlService {
    @Autowired
    Tb1Mapper tb1Mapper;
    @Transactional
    public void throwerror(){
        Tb1 tb1 = tb1Mapper.selectByPrimaryKey(1);
        System.out.println(RootContext.getXID());
        tb1.setValue("client1");
        tb1Mapper.updateByPrimaryKey(tb1);
        throw new RuntimeException("111");
    }
}
