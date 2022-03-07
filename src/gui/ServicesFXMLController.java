/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.ServiceBusiness;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ServicesFXMLController implements Initializable {
        @FXML
        private Text serviceLabel;

        @FXML
        private Text priceLabel;

        private ServiceBusiness serviceBusiness;
    
        public void setData(ServiceBusiness serviceBusiness) {
        this.serviceBusiness = serviceBusiness;

        serviceLabel.setText(serviceBusiness.getNomService());
        priceLabel.setText(Float.toString(serviceBusiness.getPrix()));
       }


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

}