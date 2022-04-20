import java.util.*;
public class PodCast {
    private int Podid;
    private String PodName,CelebName,PodDuration,Pfilepath;
    private Date UploadDate;
    private int Noofep;
    public PodCast(){

    }
    public PodCast(int Podid,String PodName,String CelebName,int Noofep,String Pfilepath,String PodDuration,Date UploadDate)
    {
        this.Podid=Podid;
        this.PodName= PodName;
        this.CelebName=CelebName;
        this.Pfilepath=Pfilepath;
        this.PodDuration=PodDuration;
        this.UploadDate=UploadDate;
        this.Noofep=Noofep;
    }
    public int getPodid(){
        return Podid;
    }
    public String getPodName(){
        return PodName;
    }
    public String getCelebName(){
        return CelebName;
    }
    public String getPodDuration(){
        return PodDuration;
    }
    public String getPfilepath(){
        return Pfilepath;
    }
    public Date getUploadDate(){
        return UploadDate;
    }
    public int getNoofep(){
        return Noofep;
    }
    public String toString(){
        return "Podid--"+Podid+"PodName--"+PodName+"CelebName--"+CelebName+" Pfilepath--"+Pfilepath+"PodDuration--"+PodDuration+"UploadDate--"+UploadDate+"Noofep--"+Noofep;
    }
}
