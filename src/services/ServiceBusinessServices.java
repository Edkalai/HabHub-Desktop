/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.ServiceBusiness;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author User
 */
public class ServiceBusinessServices implements Interface_ServiceBusiness {
      Connection connect;
      Statement stm;

    public ServiceBusinessServices() {
      connect=MyDB.getInstance().getConnexion();
        
}
    public void ajouter(ServiceBusiness S)throws SQLException {
        PreparedStatement pre = connect.prepareStatement("INSERT INTO business_services (idBusinessServices,idBusiness,nomService,prix)VALUES (?,?,?,?);");
        pre.setInt(1, S.getIdBusinessServices());
        pre.setInt(2, S.getIdBusiness());
        pre.setString(3, S.getNomService());
        pre.setFloat(4,S.getPrix());

        pre.executeUpdate();
   }
 

 public boolean Update(int idBusiness,String nomService,float prix,int idBusinessServices) {
            try {

            PreparedStatement pre = connect.prepareStatement("UPDATE business_services SET idBusiness = ? , nomService= ? , prix= ?  where idBusinessServices= ? ;");
            pre.setInt(1, idBusiness);
            pre.setString(2, nomService);
            pre.setFloat(3, prix);   
            pre.setInt(5,idBusinessServices);

            if (pre.executeUpdate() != 0) {
                System.out.println(" Business Service Updated");
                 } else {
                System.out.println("not Updated");
            }
                return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

 public boolean delete(Integer idBusinessServices) throws SQLException {

        PreparedStatement pre = connect.prepareStatement("Delete from business_services where idBusinessServices=? ;");
        pre.setInt(1, idBusinessServices);
        if (pre.executeUpdate() != 0) {
            System.out.println("Service Deleted");
            return true;
        }
        System.out.println("id of Service not found");
        return false;

    }
 public List<ServiceBusiness> afficherBusinessServices() throws SQLException{
        List<ServiceBusiness> BServices = new ArrayList<>();
        String req = "select * from reservation;";
        stm = connect.createStatement();
        ResultSet rst = stm.executeQuery(req);
            while (rst.next()) {
            ServiceBusiness BS = new ServiceBusiness (rst.getInt("idBusinessServices"),
            rst.getInt("idBusiness"),
            rst.getString("nomService"),
            rst.getFloat("prix"));

            BServices.add(BS);
        }
        return BServices;
        }
        }