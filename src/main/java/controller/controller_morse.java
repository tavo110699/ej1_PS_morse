/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
 import view.view_morse;
import model.model_morse;
/**
 *
 * @author gustavo
 */
public class controller_morse {
    view_morse vm =new  view_morse();
    model_morse mm = new model_morse();
        
    public String cadena;
    String [][] matriz = {{"A",".-"},{"B","-..."},{"C","-.-."},{"D","-.."},{"E","."},{"F","..-."},{"G","--."},{"H","...."},{"I",".."},{"J",".---"},{"K","-.-"},{"L",".-.."},{"M","--"},
    		{"N","-."},{"O","---"},{"P",".--."},{"Q","--.-"},{"R",".-."},{"S","..."},{"T","-"},{"U","..-"},{"V","...-"},{"W",".--"},{"X","-..-"},{"Y","-.--"},{"Z","--.."},{"1",".----"},{"2","..---"},{"3","...--"},
    		{"4","....-"},{"5","....."},{"6","-...."},{"7","--..."},{"8","---.."},{"9","----."},{"0","-----"}}; 
    
    
    public controller_morse() {
        addAction();
        vm.setVisible(true);
        
    }

    public void addAction(){
          vm.btnTraducir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //pide la confirmacion de agregar la cita
                if (!vm.txtText.getText().isEmpty()) {
                       mm.setTexto(vm.txtText.getText());
                    TraducirAMorse(mm.getTexto());
                    
                    vm.txtMorse.setText(mm.getMorse());
                
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
       new controller.controller_text();
       vm.dispose();
            }
        });
              
              
              
    }
    
        public String TraducirAMorse(String c) {
    	  cadena = c.toUpperCase();
    	String[] palabras = cadena.split(" ");
    	cadena = "";
    	for(int i = 0; i < palabras.length; i++) {
    		if(i != 0) {
    			cadena += "   ";
    		}
    		cadena += PalabraAMorse(palabras[i]);
    	}
         mm.setMorse(cadena);
                        
    	if(cadena.equals("")) { //En caso de no encontrar un código morse a lo ingresado, regresamos un mensaje
    		cadena = "No se encontró traducción para dicho texto...";    		
    	}
    	
    	return cadena;
    }
        
        
           public String PalabraAMorse(String palabra){
        String[] letras = palabra.split("");
        String p = "";
        for(int i = 0; i < letras.length; i++) {
        	if(i != 0) {
        		p += " ";        		
        	}
        	p += LetraAMorse(letras[i]);
        }
    	return p;
    }
           
               public String LetraAMorse(String letra){
    	String l = "";
    	for(int i = 0; i < matriz.length; i++) {
    		if(letra.equals(matriz[i][0])) {
    			l = matriz[i][1];
    		}
    	}
    	return l;
    }
               
           
}

