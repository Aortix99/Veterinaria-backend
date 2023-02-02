package com.firstspring.demo.dto;

import java.io.Serializable;

public class RazaDto implements Serializable {
   private int idRaza;
   private String raza;

   public int getIdRaza() {
      return idRaza;
   }

   public void setIdRaza(int idRaza) {
      this.idRaza = idRaza;
   }

   public String getRaza() {
      return raza;
   }

   public void setRaza(String raza) {
      this.raza = raza;
   }
}
