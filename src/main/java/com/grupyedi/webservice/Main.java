package com.grupyedi.webservice;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.grupyedi.webservice.dao.DaoManager;
import com.grupyedi.webservice.entity.*;
import com.grupyedi.webservice.server.ServerLauncher;
import com.grupyedi.webservice.util.HibernateUtil;
import com.grupyedi.webservice.util.SeedUtil;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();

//        SeedUtil.seedDb();

        try {
            ServerLauncher serverLauncher = new ServerLauncher();
            System.out.println("Server launched");
        } catch (IOException e) {
            System.out.println("Server failed to launch!");
            e.printStackTrace();
        }
    }
}
