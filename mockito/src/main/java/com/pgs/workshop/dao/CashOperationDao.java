package com.pgs.workshop.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pgs.workshop.domain.CashOperation;

@Repository
public class CashOperationDao {

    public boolean commitOperation(CashOperation operation) {
        //commit operation
        return true;
    }
    
    public List<CashOperation> fetchListOfUserOperations(Long userId, Date periodStart, Date periodEnd) {
        return new ArrayList<CashOperation>();
    }
    
}
