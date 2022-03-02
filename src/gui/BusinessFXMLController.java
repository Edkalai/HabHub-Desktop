/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import HabHub.BusinessListener;
import entities.Business;
import entities.Revue;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import services.RevueServices;
import services.UserBusinessServices;

/**
 * FXML Controller class
 *
 * @author Ed
 */
public class BusinessFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private GridPane grid;

    @FXML
    private ImageView businessImageLabel;

    @FXML
    private Label businessTitleLabel;

    @FXML
    private Label businessLocationLabel;


    @FXML
    private Text businessDecriptionLabel;

  
    @FXML
    private Label experienceLabel;

    
    @FXML
    private Label openingHoursLabel;

   
    @FXML
    private GridPane gridReview;

    private BusinessListener businessListener;

    public ObservableList<Business> businessItems = FXCollections.observableArrayList();
    UserBusinessServices bs = new UserBusinessServices();

    private List<Business> getBusinessItems() {
        List<Business> BI = new ArrayList<>();

        try {
            BI = bs.afficherBusiness();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return BI;

    }
      public ObservableList<Revue> revueItems = FXCollections.observableArrayList();
    RevueServices rs = new RevueServices();

    private List<Revue> getReviewItems(int businessId) {
        List<Revue> RI = new ArrayList<>();

        try {
            RI = rs.afficherRevueId(businessId);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return RI;

    }
    private void setChosenBusiness(Business b) {
        revueItems.clear();
        Image businessImg = new Image(getClass().getResourceAsStream("../assets/img/business/BusinessItem/SalwaKbira.png"));       
        businessImageLabel.setImage(businessImg);
        businessTitleLabel.setText(b.getTitre());
        businessLocationLabel.setText(b.getLocalisation());

        businessDecriptionLabel.setText(b.getDescription());
        experienceLabel.setText(Integer.toString(b.getExperience()));
        openingHoursLabel.setText(b.getHoraire());
        revueItems.addAll(getReviewItems(b.getIdBusiness()));
        System.out.println(revueItems);
        int column2 = 0;
        int row2 = 1;
        /*try {
            for (int i = 0; i < revueItems.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("revueBusiness.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                RevueBusinessController revueBusinessController = fxmlLoader.getController();
                revueBusinessController.setData(revueItems.get(i));

                if (column2 == 1) {
                    column2 = 0;
                    row2++;
                }

                gridReview.add(anchorPane, column2++, row2); //(child,column,row)
                //set grid width
                gridReview.setMinWidth(Region.USE_PREF_SIZE);
                gridReview.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridReview.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridReview.setMinHeight(Region.USE_PREF_SIZE);
                gridReview.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridReview.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        businessItems.addAll(getBusinessItems());
        if (businessItems.size() > 0) {
            setChosenBusiness(businessItems.get(0));
            businessListener = new BusinessListener() {
                @Override
                public void onClickListener(Business business) {
                    setChosenBusiness(business);
                    
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < businessItems.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("BusinessItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                BusinessItemController businessItemController = fxmlLoader.getController();
                businessItemController.setData(businessItems.get(i),businessListener);

                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_PREF_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_PREF_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }

}
