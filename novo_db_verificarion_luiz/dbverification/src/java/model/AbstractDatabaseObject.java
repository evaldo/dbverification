/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.PrefixoDAO;
import dao.VocabularioDAO;

/**
 *
 * @author luiz.rodrigues
 */
public class AbstractDatabaseObject implements DatabaseObject{
    protected String objectName;
    protected String wrongWord;
    protected String databaseObjectInstanceType;
    
    public String getObjectInstanceType(){
        return  databaseObjectInstanceType;
    }

    public AbstractDatabaseObject(String objectName) {
        this.objectName = objectName;
    }
    
     @Override
    public Boolean isValid() {
        String[] words = getObjectName().split(getSeparator());
        
        //The valid name have two parts or more splitted by separator
        if (words.length < 2){
            return false;
        }
        
        int i =0;
        for (String word : words){
            if (i==0){
               if (validatePrefix(word)==false){
                    return false;
                }
            }else{
                if (validateWord(word)==false){
                    return false;
                }
            }
            i++;
        }
        
        return true;
    }
    
    protected boolean validatePrefix(String prefix){
        PrefixoDAO prefixoDAO = new PrefixoDAO();
        Boolean isAllowed = prefixoDAO.IsAllowedPrefixForObject(prefix, databaseObjectInstanceType);
        if (!isAllowed){
            wrongWord = prefix;
        }
        return isAllowed;
    }
    
    protected Boolean validateWord(String word) {
        VocabularioDAO vocabularioDAO = new VocabularioDAO();
        Boolean isAllowed = vocabularioDAO.IsAllowedWord(word);
        if (!isAllowed){
            wrongWord = word;
        }
        return isAllowed; 
    }
    
    private String getSeparator(){
        return "_";
    }

    /**
     * @return the objectName
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * @return the wrongWord
     */
    public String getWrongWord() {
        return wrongWord;
    }
}
