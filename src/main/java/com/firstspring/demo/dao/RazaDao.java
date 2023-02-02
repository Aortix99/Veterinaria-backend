package com.firstspring.demo.dao;

import com.firstspring.demo.conexion.ManagerConexion;
import com.firstspring.demo.dto.RazaDto;
import com.firstspring.demo.exception.DaoEXception;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class RazaDao implements RazaDaoInterface{

    public RazaDto seledByid(RazaDto R) throws DaoEXception {
        RazaDto Alamacena=null;
        String SELECT = " SELECT idRaza, raza FROM raza " +
                "WHERE idRaza=?";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        Connection connection = ManagerConexion.getInstance().getConnection();

        try{
            statement=connection.prepareStatement(SELECT);
            statement.setInt(1, R.getIdRaza());
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Alamacena=new RazaDto();
                Alamacena.setRaza(resultSet.getString("raza"));
                Alamacena.setIdRaza(resultSet.getInt("idRaza"));
            }
            return Alamacena;

        }catch (Exception e){
            throw new DaoEXception(e);
        }finally {
            try {
                resultSet.close();
                statement.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }


    public void Insert(RazaDto R) throws DaoEXception {
        String Insert = "INSERT INTO raza(idRaza, raza) VALUES (?,?)";

        PreparedStatement statement = null;

        Connection connection = ManagerConexion.getInstance().getConnection();
        try {
            statement=connection.prepareStatement(Insert);
            statement.setInt(1, R.getIdRaza());
            statement.setString(2, R.getRaza());

            statement.executeUpdate();
        }catch (Exception e){
            throw new DaoEXception();
        }finally {
            try {
                statement.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public List<RazaDto> selectall()throws DaoEXception{
        List<RazaDto> list=new ArrayList<>();
        String Select="SELECT * FROM raza ";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        RazaDto almacenar=null;

        Connection connection=ManagerConexion.getInstance().getConnection();

        try {
            statement=connection.prepareStatement(Select);
            resultSet=statement.executeQuery();

            while (resultSet.next()){
                almacenar=new RazaDto();
                almacenar.setIdRaza(resultSet.getInt("idRaza"));
                almacenar.setRaza(resultSet.getString("raza"));

                list.add(almacenar);
            }

            return list;
        }catch (Exception e){
            throw new DaoEXception(e);
        }


    }
    public void update(RazaDto C) throws DaoEXception {

        String UPDATE="UPDATE  raza SET raza=?WHERE idRaza=?";
        PreparedStatement statement=null;
        Connection connection= ManagerConexion.getInstance().getConnection();

        try {

            statement=connection.prepareStatement(UPDATE);

            statement.setString(1, C.getRaza());
            statement.setInt(2, C.getIdRaza());

            statement.executeUpdate();
            System.out.println(statement);

        }catch (Exception ex){
            throw new DaoEXception(ex);

        }finally {
            try {
                statement.close();
            }catch (Exception e){
                throw new DaoEXception(e);
            }
        }



    }
    public void delete(long P) throws DaoEXception {
        String DELETE="DELETE FROM raza WHERE idRaza=?";
        PreparedStatement statement=null;
        Connection connection=ManagerConexion.getInstance().getConnection();
        try {
            statement=connection.prepareStatement(DELETE);
            statement.setLong(1, P);
            statement.executeUpdate();

        }catch (Exception ex){
            throw new DaoEXception(ex);
        }finally {
            try {
                statement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
