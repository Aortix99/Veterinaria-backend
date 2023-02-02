package com.firstspring.demo.mrg;

import com.firstspring.demo.dto.DuenoDto;
import com.firstspring.demo.exception.ManagerEXception;
import java.util.List;

public interface DuenoMrgInterface {
    public void save(DuenoDto C) throws ManagerEXception;
    public void delete(long P)throws ManagerEXception;
    public List<DuenoDto> selectall()throws  ManagerEXception;
}
