import java.lang.*;
import java.util.*;

interface ForSong{
    List<Song> ViewSong();
    List<Song> SearchSong(List<Song> SongList,String Sartist);
    List<Song> SortSong(List<Song> SongList,String Sartist);
    Song PlaySong(List<Song> Song);
    

}