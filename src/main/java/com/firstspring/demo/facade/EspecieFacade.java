package com.firstspring.demo.facade;

import com.firstspring.demo.conexion.ManagerConexion;
import com.firstspring.demo.dto.EspecieDto;
import com.firstspring.demo.exception.FacadeEXception;
import com.firstspring.demo.mrg.EspecieMrgInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EspecieFacade implements EspecieFacadeInterface {
    @Autowired
    private EspecieMrgInterface Mgr;

    public void save(EspecieDto C) throws FacadeEXception {
        try{
            ManagerConexion.getInstance().open();
            Mgr.save(C);
            ManagerConexion.getInstance().commit();
        }catch (Exception Ex){
            ManagerConexion.getInstance().rollback();
            throw new FacadeEXception(Ex);
        }finally {
            ManagerConexion.getInstance().close();
        }
    }
    public void delete(long P)throws FacadeEXception{
        try {
            ManagerConexion.getInstance().open();
            Mgr.delete(P);
            ManagerConexion.getInstance().commit();
        }catch (Exception e){
            throw new FacadeEXception();
        }
        finally {
            ManagerConexion.getInstance().close();
        }
    }
    public List<EspecieDto> selectall()throws FacadeEXception{
        ManagerConexion.getInstance().open();
        try {
            return Mgr.selectall();

        }catch (Exception e){
            throw new FacadeEXception(e);
        }finally {
            ManagerConexion.getInstance().close();
        }
    }

}
