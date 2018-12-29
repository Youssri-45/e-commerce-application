/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjee;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.jms.Session;
import javax.persistence.Query;

/**
 *
 * @author Amani
 */
@Named(value = "articleControler")
@SessionScoped
public class ArticleControler implements Serializable {
    //Attributes 
    Article article = new Article();
    List<Article> list = new ArrayList();
    @EJB
    ArticleFacade articleFacade;
    String username;
    String password;
    String data = "1";
    
    
    
    
    
    
    //Methods
    public String create (){
        articleFacade.create(article);
        return "list";
    }
    public void remove(Article article){
        articleFacade.remove(article);
        list.remove(article);
        
    }
    public List<Article> findAll(){
        return articleFacade.findAll();
    }
    public String editView (Article article){
        this.article= article;
        return "edit";
    }
    public String edit(){
        articleFacade.edit(article);
         return "list";
        
    }
    public String browse (){
        return "list";
    }
    
    public String log (String username, String password){
        if(username.equals("admin")&&password.equals("123456")){
           return "adminSpace"; 
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Incorrect Username AND/OR Passowrd","Please enter correct username and Password"));
            return "Login";
        }
        
        
    }

    
    
    
    
    
    //Getters and Setters
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public ArticleFacade getArticlefacade() {
        return articleFacade;
    }

    public void setArticleFacade(ArticleFacade articlefacade) {
        this.articleFacade = articlefacade;
    }
    
    public List<Article> getList() {
        return list;
    }

    public void setList(List<Article> list) {
        this.list = list;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
       public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }

    /**
     * Creates a new instance of ArticleControler
     */
    public ArticleControler() {
       
    }
    
}
