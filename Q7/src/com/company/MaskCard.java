/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

public class MaskCard {

    public static String mask(String raw){
        int len = raw.length();
        String masked = "";
        // loop through the input string
        for(int i = 0; i<len; i++){
            // check conditions for masking met
            if((i < 4  || i>len-5) || !(raw.charAt(i) >= '0' && raw.charAt(i) <= '9')){
                masked += raw.charAt(i);
            }
            else{
                masked += "#"; 
            }
        }
        return masked;
    }
        
}
