import java.util.*;
import java.lang.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.sql.*;

public class Subscriber extends SongImple{
    int SubID;String SubName,SubusrName,Contactno;

    Scanner scan=new Scanner(System.in);

    public Subscriber(){

    }

    public Subscriber(int SubID,String SubName,String SubusrName,String Contactno){
        this.SubID= SubID;
        this.SubName=SubName;
        this.SubusrName=SubusrName;
        this.Contactno=Contactno;

    }
    public String toString(){
        return "Subscriber ID-----"+SubID+"Subscriber Name-----"+SubName+"Subscriber usrName-----"+SubusrName+"Contact No-----"+Contactno;
    }
    public Connection Connect(){
        Connection con=null;
        try{ con= DriverManager.getConnection("jdbc:mysql://Localhost:3306/JukeBox","root","Subash@123");}catch(Exception e){System.out.println(e);}
        return con;
    }
    public void CreateJBacc(){
        try{
            Subscriber s=new Subscriber();
            Connection con=s.Connect();
            System.out.println("Enter your name : ");
            String name=scan.next();
            String Usrname=name+"@jkb";
            String pattern1="^[A-Z|a-z]{3,20}$";
            Pattern pt1=Pattern.compile(pattern1);
            Matcher m1=pt1.matcher(name);
            if(m1.find()){
                System.out.println("Enter mobile number : ");
                String mobile=scan.next();
                String pattern="[789][0-9]{9}";
                Pattern pt=Pattern.compile(pattern);
                Matcher m=pt.matcher(mobile);
                if(m.find()){
                    System.out.println("!!!!Account created!!!!");
                    String myquery = "insert into SubScriber(SubName,SubuserName,MobNo) values (?,?,?);";
                    PreparedStatement ps1 = con.prepareStatement(myquery);
                    ps1.setString(1,name);
                    ps1.setString(2,Usrname);
                    ps1.setString(3,mobile);
                    int rs1 = ps1.executeUpdate();
                    System.out.printf("Ur UserName---"+Usrname+"\tuR PassWord---"+mobile+"\n");
                }
                else{
                    System.out.println("Invalid contact number!!!");return;
                }
            }else{
                System.out.println("Invalid name!!!");return;
            }
        }catch(Exception e){System.out.println(e);}
    }

    public void LogIn(){
        try{
            Subscriber s=new Subscriber();
            Connection con=s.Connect();
            Statement st=con.createStatement();
            System.out.println("Enter usrName ");
            String AccId=scan.next();
            System.out.println("Enter PassWord number : ");
            String mobile=scan.next();
            String myquery="select MobNo from SubScriber where SubuserName='"+AccId+"'";
            ResultSet rs= st.executeQuery(myquery);
            String Mob="";
            while(rs.next()){
                Mob=rs.getString("MobNo");
            }
            if(Mob.equals(mobile)){
                System.out.println("-------Login_SucessFuLL------");
                System.out.println("PRESS (1) TO VIEW SONGS / PRESS (2) TO VIEW PODCAST / PRESS (0) TO LOGOUT");
                int in1=scan.nextInt();
                if (in1==1){
                    System.out.println("---------------You r Viewing Songs List--------------\n");
                    List<Song> e=ViewSong();
                    System.out.printf("%s %10s %12s %10s %6s %10s ","Sid","Name","Artist","Genre","Tym","Date\n");

                    e.forEach(a->System.out.println(a.getSid()+"\t"+a.getSname()+"\t"+a.getSartist()+"\t"+a.getSgenre()+"\t"+a.getSduration()+"\t"+a.getSdate()));
                    System.out.println("Sort Song based on Artist_Name /Genre :-");
                    String  in2=scan.next();
                    List<Song> f=SortSong(e,in2);
                    if(f.size()==0){
                        System.out.println("<<---No-Match-Found--->>");
                        return;
                    }else if(f.size()==1){
                        System.out.println("<<---Playing-Song--->>");
                        return;
                    }
                    else{
                    System.out.println("<<---"+f.size()+"_MatchFound--->>");
                    System.out.printf("%s %10s %12s %10s %6s %10s ","Sid","Name","Artist","Genre","Tym","Date\n");
                    f.forEach(a->System.out.println(a.getSid()+"\t"+a.getSname()+"\t"+a.getSartist()+"\t"+a.getSgenre()+"\t"+a.getSduration()+"\t"+a.getSdate()));
                        System.out.println("Enter Song Name:-");
                        String  in3=scan.next();
                    List<Song> g=SearchSong(e,in3);
                        //System.out.printf("%s %10s %12s %10s %6s %10s ","Sid","Name","Artist","Genre","Tym","Date\n");
                        g.forEach(a->System.out.println("Song:--"+a.getSname()+"\tSungBy:--"+a.getSartist()+"\tUploadedOn:--"+a.getSdate()));
                    }
                }
                else if(in1==2){
                    System.out.println("you are seeing the list of podcast");
                }
                else{
                    System.out.println("you have LOGGED OUT");return;
                }
            }else{
                System.out.println("------Name <--Dont_Match--> MobNo -----");
                System.out.println("if<--Forgot_Password--> press(1) else press (any_Number.Key)");
                int in1=scan.nextInt();
                if(in1==1){
                    ForgetPassWord();
                }else{return;}
            }
        }catch(Exception e){System.out.println(e);}
    }
    public void ForgetPassWord(){
        try{
            Subscriber s=new Subscriber();
            Connection con=s.Connect();
            //Statement st=con.createStatement();
            System.out.println("Enter UserName ");
            String AccId=scan.next();
            System.out.println("Enter  New PaSSword : ");
            String mobile=scan.next();
            String pattern="[789][0-9]{9}";
            Pattern pt=Pattern.compile(pattern);
            Matcher m=pt.matcher(mobile);
            if(m.find()){
                String myquery = "update SubScriber set Mobno=? where SubuserName=?";
                PreparedStatement ps1 = con.prepareStatement(myquery);
                ps1.setString(1,mobile);
                ps1.setString(2,AccId);
                int rs1 = ps1.executeUpdate();
            }else{
                System.out.println("-----SubScriber naMe MisMatch------");return;
            }
        }catch(Exception e){System.out.println(e);}
    }
}