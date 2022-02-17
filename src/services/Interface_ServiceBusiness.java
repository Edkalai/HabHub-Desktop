/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.ServiceBusiness;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public interface Interface_ServiceBusiness {
    public void ajouter(ServiceBusiness S)throws SQLException ;
     public boolean Update(int idBusiness,String nomService,float prix,int idBusinessServices) ;
    public boolean delete(Integer idBusinessServices) throws SQLException ;
    public List<ServiceBusiness> afficherBusinessServices() throws SQLException;


}
