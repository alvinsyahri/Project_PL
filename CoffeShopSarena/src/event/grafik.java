/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import com.raven.main.Main;
public class grafik {
    
    public void grafikOn(){
        Main m = new Main();
        m.setVisible(true);
    }
    
    public void cancel(){
        Main m = new Main();
        m.dispose();
    }
}
