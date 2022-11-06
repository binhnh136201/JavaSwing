/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Room;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author binhn
 */
public class RoomDAO {
        public void addRoom(Room room) {
                try {
                        FileWriter fw = new FileWriter("D:\\java_lab/java_lab.txt");
                        fw.write(room.toString());
                        fw.close();
                } catch (IOException ex) {
                        Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                
        }
}
