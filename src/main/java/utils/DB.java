package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    //madde bir driver ba�lant�s� private olmal�

    private final  String driver="org.sqlite.JDBC";
    private  String url="jdbc:sqlite:db/";//jdbc b�t�n sql ile kullan�l�r
    private final String dbName="Technical_Service.db";

    //Connection Clas

    private Connection conn=null;


    public DB(){
        this.url=this.url+dbName;



    }
    public DB(String dbName){
        this.url=this.url+dbName;

    }

    public Connection connect(){

        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url);
            System.out.println("Connection Success");
        }
        catch(Exception ex){
            System.out.println("Connection Error"+ex);


        }

        return conn;



    }
    //db close
    public void close(){
        try {
            if (!conn.isClosed()){
                conn.close();
            }
        }catch (Exception ex){
            System.err.println("Close Error: "+ex);

        }
    }}
