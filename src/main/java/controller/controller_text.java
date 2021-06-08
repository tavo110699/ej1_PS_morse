/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.model_morse;
 import view.view_text;
/**
 *
 * @author gustavo
 * Controlador de morse a texto
 */
public class controller_text {
        view_text vm =new  view_text();
    model_morse mm = new model_morse();
    
        public String cadena;
    String [][] matriz = {{"A",".-"},{"B","-..."},{"C","-.-."},{"D","-.."},{"E","."},{"F","..-."},{"G","--."},{"H","...."},{"I",".."},{"J",".---"},{"K","-.-"},{"L",".-.."},{"M","--"},
    		{"N","-."},{"O","---"},{"P",".--."},{"Q","--.-"},{"R",".-."},{"S","..."},{"T","-"},{"U","..-"},{"V","...-"},{"W",".--"},{"X","-..-"},{"Y","-.--"},{"Z","--.."},{"1",".----"},{"2","..---"},{"3","...--"},
    		{"4","....-"},{"5","....."},{"6","-...."},{"7","--..."},{"8","---.."},{"9","----."},{"0","-----"}}; 
    
        public controller_text() {
        addAction();
        vm.setVisible(true);  
    }
        
        
            public void addAction(){
          vm.btnTraducir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //pide la confirmacion de agregar la cita
                if (!vm.txtMorse.getText().isEmpty()) {
                       mm.setMorse(vm.txtMorse.getText());
                    TraducirATexto(mm.getMorse());
                    
                    vm.txtText.setText(mm.getTexto());
                
                }else{
                    JOptionPane.showMessageDialog(null, "Escriba el texto a traducir");
                }
            }
        });
          
          
              vm.btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
   vm.dispose();
   System.exit(0);
            }
        });
           
              
                            vm.btnRevert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
       new controller.controller_morse();
       vm.dispose();
            }
        });
              
                   
    }
            
            
                public String TraducirATexto(String c) {
    	String[] palabras = c.split("   ");
    	String cadena = "";
    	for(int i = 0; i < palabras.length; i++) {
    		if(i != 0) {
    			cadena += " ";
    		}
    		cadena += PalabraATexto(palabras[i]);
    	}
    	   mm.setTexto(cadena);
    	if(cadena.equals("")) { //En caso de no encontrar una traducción, regresamos un mensaje
    		cadena = "No se encontró traducción para dicho código...";
    	}
    	return cadena;
    }
                
                    public String PalabraATexto(String palabra){
        String[] letras = palabra.split(" ");
        String p = "";
        for(int i = 0; i < letras.length; i++) {
        	p += LetraATexto(letras[i]);
        }
    	return p;
    }
      
                        public String LetraATexto(String letra){
    	String l = "";
    	for(int i = 0; i < matriz.length; i++) {
    		if(letra.equals(matriz[i][1])) {
    			l = matriz[i][0];
    		}
    	}
    	return l;
    }
                
}
