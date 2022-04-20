import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.lang.*;

abstract class SongImple extends Song implements ForSong{
    Scanner scan=new Scanner(System.in);
    public List<Song> ViewSong(){
        List<Song> SongList=new ArrayList<>();
        System.out.println("Song lists");
        try{
            Subscriber s=new Subscriber();
            Connection con=s.Connect();
            Statement st=con.createStatement();
            String myquery="select * from Song ";
            ResultSet rs= st.executeQuery(myquery);
           // System.out.printf("%s %6s %30s %10s %10s %10s %10s","Sid","Sname","Sartist","Sgenre","Sduration","Sdate\n");
            while(rs.next()){
               Song sobj=new Song(rs.getInt("Songid"),rs.getString("SongName"),rs.getString("AtristName"),rs.getString("Genre"),rs.getString("SongDuration"),rs.getString("Sfilepath"),rs.getDate("UpLoadDate"));
               SongList.add(sobj);
               //System.out.printf("%d %10s %25s %10s %15s %15s\n",rs.getInt("Songid"),rs.getString("SongName"),rs.getString("AtristName"),rs.getString("Genre"),rs.getString("SongDuration"),rs.getDate("UpLoadDate"));
            }
            //SongList.forEach(a->System.out.println(a));
        }catch(Exception e){System.out.println(e);}
        return SongList;
    }
    public List<Song> SortSong(List<Song> SongList,String XXXX){
        List<Song> SortedSongList=new ArrayList<>();
        for(Song a:SongList){
            if(a.getSartist().trim().equals(XXXX)){
                SortedSongList.add(a);
            }
            else if(a.getSgenre().trim().equals(XXXX)){
                SortedSongList.add(a);
            }
        }
        return SortedSongList;
    }
    public List<Song> SearchSong(List<Song> SongList,String SongName){
        List<Song> SearchedSongList=new ArrayList<>();
        for(Song a:SongList){
            if(a.getSname().trim().equals(SongName)){
                SearchedSongList.add(a);
            }
        }
        return SearchedSongList;
    }
    public Song PlaySong(List<Song> Song){
        System.out.println("<<<Playing>>>");
        Song S=new Song();
        return S;
    }
}