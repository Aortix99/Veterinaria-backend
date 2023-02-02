package com.firstspring.demo.mrg;


import com.firstspring.demo.dao.DuenoDaoInterface;
import com.firstspring.demo.dto.DuenoDto;
import com.firstspring.demo.exception.ManagerEXception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DuenoMrg implements DuenoMrgInterface{
    @Autowired
    private DuenoDaoInterface Dao;
    public void save(DuenoDto C) throws ManagerEXception {

        try {
            DuenoDto tp=Dao.seledByid(C);

            if(tp==null){

                Dao.Insert(C);
            }else {
                Dao.update(C);
            }

        }catch (Exception EX){
            throw new ManagerEXception(EX);
        }

    }
    public void delete(long P)throws ManagerEXception{
        try {
            Dao.delete(P);
        }catch (Exception ex){
            throw new ManagerEXception(ex);
        }
    }
    public List<DuenoDto> selectall()throws  ManagerEXception{
        try {
            return Dao.selectall();
        }catch (Exception Ex){
            throw new ManagerEXception(Ex);
        }
    }
}
