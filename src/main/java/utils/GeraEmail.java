package utils;

import java.util.Random;

public class GeraEmail {
   public String geraEmail(){
       Random aleatorio = new Random();
       int valor = aleatorio.nextInt();
       String email = String.valueOf(valor)+"@teste.com";
       return email;
   }


}
