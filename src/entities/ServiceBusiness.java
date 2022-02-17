/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author User
 */
public class ServiceBusiness {
   int idBusinessServices;
   int idBusiness;
   String nomService;
   float prix;

    public ServiceBusiness(int idBusinessServices, int idBusiness, String nomService, float prix) {
        this.idBusinessServices = idBusinessServices;
        this.idBusiness = idBusiness;
        this.nomService = nomService;
        this.prix = prix;
    }

    public int getIdBusinessServices() {
        return idBusinessServices;
    }

    public int getIdBusiness() {
        return idBusiness;
    }

    public String getNomService() {
        return nomService;
    }

    public float getPrix() {
        return prix;
    }

    public void setIdBusinessServices(int idBusinessServices) {
        this.idBusinessServices = idBusinessServices;
    }

    public void setIdBusiness(int idBusiness) {
        this.idBusiness = idBusiness;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "ServiceBusiness{" + "idBusinessServices=" + idBusinessServices + ", idBusiness=" + idBusiness + ", nomService=" + nomService + ", prix=" + prix + '}';
    }
    
   
}
