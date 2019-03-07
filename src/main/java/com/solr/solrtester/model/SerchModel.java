package com.solr.solrtester.model;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import java.util.ArrayList;
import java.util.List;

public class SerchModel  extends  Result{


    private  String id;
    private  String username;
    private  String password;

    public SerchModel(String id, String username, String password) {
        this.id = id ;
        this.username = username;
        this.password = password;
    }

    public static String queryString(String[] fileds, String keyword) {
        if(fileds == null){
            return  "*:*";
        }
        String qs = " ";
        for(String filed :fileds){
           qs = qs + filed +":*"+ keyword+"* or ";
        }
        return qs;
    }


    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public static List<SerchModel> build(SolrDocumentList list, long count) {

        List<SerchModel> smlist = new ArrayList<SerchModel>();
        for (SolrDocument document : list) {
            String id = (String) document.get("id");
            String username = (String)document.get("username");
            String password = (String) document.get("password");

            SerchModel serchModel = new SerchModel(id,username,password);
            smlist.add(serchModel);
        }
        return smlist;
    }
}
