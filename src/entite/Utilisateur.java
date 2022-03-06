/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author User
 */
public class Utilisateur {
    int idUtilisateur ;
    String email ; 
    String password;
    int numTel;
    String type ; 

    @Override
    public String toString() {
        return "Utilisateur{" + "idUtilisateur=" + idUtilisateur + ", email=" + email + ", password=" + password + ", numTel=" + numTel + ", type=" + type + '}';
    }
    

    public Utilisateur() {
    }

    public Utilisateur(String email, String password, int numTel, String type) {
        
        this.email = email;
        this.password = password;
        this.numTel = numTel;
        this.type = type;
       
    }

    public Utilisateur(int idUtilisateur, String email, String password, int numTel, String type) {
        this.idUtilisateur = idUtilisateur;
        this.email = email;
        this.password = password;
        this.numTel = numTel;
        this.type = type;
    }
      public Utilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}