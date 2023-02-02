package com.firstspring.demo.mrg;

import com.firstspring.demo.dto.EspecieDto;
import com.firstspring.demo.exception.ManagerEXception;
import java.util.List;

public interface EspecieMrgInterface {
    public void save(EspecieDto C) throws ManagerEXception;
    public void delete(long P)throws ManagerEXception;
    public List<EspecieDto> selectall()throws  ManagerEXception;


}
