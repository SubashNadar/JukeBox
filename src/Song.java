import java.util.*;
public class Song{
private int Sid;
private String Sname,Sduration,Sgenre,Sartist,Sfilepath;
private Date Sdate;
    public Song(){

    }

    public Song(int Sid,String Sname,String Sartist,String Sgenre,String Sduration,String Sfilepath,Date Sdate){
            //int Sid,String Sname,String Sduration,Date Sdate,String Sgenre,String Sartist){
        this.Sid=Sid;
        this.Sname=Sname;
        this.Sduration=Sduration;
        this.Sdate=Sdate;
        this.Sgenre=Sgenre;
        this.Sfilepath=Sfilepath;
        this.Sartist=Sartist;

    }
    public int getSid(){
        return Sid;
        }
    public String getSname(){
        return Sname;
    }
    public String getSartist(){
        return Sartist;
    }
    public String getSgenre(){
        return Sgenre;
    }
    public String getSduration(){
        return Sduration;
    }
    public String getSfilepath(){
        return Sfilepath;
    }
    public Date getSdate(){
        return Sdate;
    }
    
    

//public String toString(){
//    return "Sid-- "+Sid+" Sname-- "+Sname+" Sartist-- "+Sartist+" Sgenre-- "+Sgenre+" Sduration-- "+Sduration+" Sfilepath--"+Sfilepath+" Sdate-- "+Sdate;
//}
    
}