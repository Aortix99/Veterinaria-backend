package com.firstspring.demo.dao;

import com.firstspring.demo.conexion.ManagerConexion;
import com.firstspring.demo.dto.EspecieDto;
import com.firstspring.demo.exception.DaoEXception;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class EspecieDao implements EspecieDaoInterface {

    public EspecieDto seledByid(EspecieDto E) throws DaoEXception {
        EspecieDto Alamacena=null;
        String SELECT = " SELECT idEspecie, especie FROM especie " +
                "WHERE idEspecie=?";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        Connection connection = ManagerConexion.getInstance().getConnection();

        try{
            statement=connection.prepareStatement(SELECT);
            statement.setInt(1, E.getIdEspecie());
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                Alamacena=new EspecieDto();
                Alamacena.setEspecie(resultSet.getString("raza"));
                Alamacena.setIdEspecie(resultSet.getInt("idEspecie"));
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


    public void Insert(EspecieDto E) throws DaoEXception {
        String Insert = "INSERT INTO especie(idEspecie, especie) VALUES (?,?)";

        PreparedStatement statement = null;

        Connection connection = ManagerConexion.getInstance().getConnection();
        try {
            statement=connection.prepareStatement(Insert);
            statement.setInt(1, E.getIdEspecie());
            statement.setString(2, E.getEspecie());

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

    public List<EspecieDto> selectall()throws DaoEXception{
        List<EspecieDto> list=new ArrayList<>();
        String Select="SELECT idEspecie, especie FROM especie ";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        EspecieDto almacenar=null;

        Connection connection=ManagerConexion.getInstance().getConnection();


        try {
            statement=connection.prepareStatement(Select);
            resultSet=statement.executeQuery();

            while (resultSet.next()){
                almacenar=new EspecieDto();
                almacenar.setIdEspecie(resultSet.getInt("idEspecie"));
                almacenar.setEspecie(resultSet.getString("especie"));

                list.add(almacenar);
            }

            return list;
        }catch (Exception e){
            throw new DaoEXception(e);
        }


    }
    public void update(EspecieDto E) throws DaoEXception {

        String UPDATE="UPDATE  especie SET especie=?WHERE idEspecie=?";
        PreparedStatement statement=null;
        Connection connection= ManagerConexion.getInstance().getConnection();

        try {

            statement=connection.prepareStatement(UPDATE);

            statement.setString(1, E.getEspecie());
            statement.setInt(2, E.getIdEspecie());

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
        String DELETE="DELETE FROM `especie` WHERE idEspecie=?";
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