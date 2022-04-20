import java.lang.*;
import java.util.*;
interface ForPodCast {
     List<PodCast> ViewPod(List<PodCast> PodList);
     PodCast playPod(PodCast pod);
     List<PodCast> SortPod(List<PodCast> PodList,String CelebName);
     List<PodCast> SearchPod(List<PodCast>PodList,String CelebName);
}
