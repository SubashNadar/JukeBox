import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
 class PodImple extends PodCast implements ForPodCast {
     public List<PodCast> ViewPod(List<PodCast> PodList){
         List<PodCast> SongList=new ArrayList<>();
         System.out.println("Song lists");
         try{
             Subscriber s=new Subscriber();
             Connection con=s.Connect();
             Statement st=con.createStatement();
             String myquery="select * from PodCast ";
             ResultSet rs= st.executeQuery(myquery);
            System.out.printf("%s %6s %30s %10s %10s %10s %10s","Podid","PodName","CelebName","Noofep","PodDuration","UploadDate\n");
             while(rs.next()){
                 PodCast sobj=new PodCast(rs.getInt("PodCastid"),rs.getString("PodCastName"),rs.getString("CelebName"),rs.getInt("EpNo"),rs.getString("Pfilepath"),rs.getString("PodCastDuration"),rs.getDate("UpLoadDate"));
                 SongList.add(sobj);
                 System.out.printf("%d %10s %25s %10s %15s %15s\n",rs.getInt("PodCastid"),rs.getString("PodCastName"),rs.getString("CelebName"),rs.getInt("EpNo"),rs.getString("PodCastDuration"),rs.getDate("UpLoadDate"));
             }
             //SongList.forEach(a->System.out.println(a));
         }catch(Exception e){System.out.println(e);}
         return PodList;
     }
     public PodCast playPod(PodCast pod){
         pod=new PodCast();
         return pod;

     }
     public List<PodCast> SortPod(List<PodCast> PodList,String CelebName){
         List<PodCast>SortedPodList =null;
         return SortedPodList;
     }
     public List<PodCast> SearchPod(List<PodCast>PodList,String EpNo){
         List<PodCast>SearchPodList =null;
         return SearchPodList;
     }
}
