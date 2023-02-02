package com.firstspring.demo.mrg;

import com.firstspring.demo.dao.RazaDaoInterface;
import com.firstspring.demo.dto.RazaDto;
import com.firstspring.demo.exception.ManagerEXception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RazaMrg implements RazaMrgInterface{
@Autowired
    private RazaDaoInterface Dao;

    public void save(RazaDto C) throws ManagerEXception {

        try {
            RazaDto tp=Dao.seledByid(C);

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
    public List<RazaDto> selectall()throws  ManagerEXception{
        try {
            return Dao.selectall();
        }catch (Exception Ex){
            throw new ManagerEXception(Ex);
        }
    }
}
