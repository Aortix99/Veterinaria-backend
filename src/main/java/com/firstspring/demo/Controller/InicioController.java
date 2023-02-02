package com.firstspring.demo.Controller;

import com.firstspring.demo.dto.inicioDto;
import com.firstspring.demo.facade.inicioFacadeInterface;

import com.firstspring.demo.exception.ControllerEXcption;
import com.firstspring.demo.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InicioController {
    @Autowired
    private inicioFacadeInterface Cfc;

    @GetMapping("all")
    public ResponseEntity<Message> selectall()throws ControllerEXcption {
        Message message=new Message("0","aqui ta todo", null);
        try {
            List<inicioDto> list= Cfc.selectall();
            message.setData(list);

        }catch (Exception e){
            throw new ControllerEXcption(e);
        }
        return ResponseEntity.ok(message);
    }
}
