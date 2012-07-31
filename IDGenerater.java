/* This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * createid(Ststement,Table Colum Name,Table Name,ID Name);
 * createid(st,"StaffID",Staff,"SF");
 */

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class IDGenerater {
	static Statement st;
	static ResultSet rs;
	
	public static String createid(Statement sts,String ID,String table,String nwID){
        String returnvalue="";
        try{
            rs = sts.executeQuery("SELECT MAX("+ID+") AS LastID FROM "+table+"");
            String lastid = "", newid=nwID,tempid="";
            int tempnum=0;

            if(rs.next()){
                lastid = rs.getString("LastID");

                for(int i=2;i<lastid.length();i++){
                    tempid = tempid + lastid.charAt(i);
                }

                tempnum = Integer.parseInt(tempid);
                tempnum += 1;
                newid =  newid + tempnum + "";
              
                returnvalue = newid;
            }
        }
        catch(Exception ex){
        	JOptionPane.showMessageDialog(null, "The Microsoft Access database engine cannot find the input table or query"+table+"."+'\n'+
        			" Make sure it exists and that its name is spelled correctly.");
        }
        return returnvalue;
    }
}
