package com.firstspring.demo.mrg;

import com.firstspring.demo.dto.RazaDto;
import com.firstspring.demo.exception.ManagerEXception;

import java.util.List;

public interface RazaMrgInterface {
    public void save(RazaDto C) throws ManagerEXception;
    public void delete(long P)throws ManagerEXception;
    public List<RazaDto> selectall()throws  ManagerEXception;
}
