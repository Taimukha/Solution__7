import java.util.HashSet;
import java.util.Set;

public class MainBonus {
    public static void main(String[] args) {
        Season s1 = new Season();
        s1.addEpisode(new Episode("S1E1: Intro", 1200));
        s1.addEpisode(new Episode("S1E2: Conflict", 1300));
        s1.addEpisode(new Episode("S1E3: Climax", 1400));

        System.out.println("Skip Intro Example:");
        EpisodeIterator skipIntro = new SkipIntroIterator(s1.getNormalIterator(), 30);
        while (skipIntro.hasNext()) {
            Episode ep = skipIntro.next();
            System.out.println("Playing episode: " + ep.getTitle());
        }

        System.out.println("\nWatch History Filter Example:");
        Set<String> watched = new HashSet<>();
        watched.add("S1E1: Intro");

        EpisodeIterator filtered = new WatchHistoryFilterIterator(s1.getNormalIterator(), watched);
        while (filtered.hasNext()) {
            Episode ep = filtered.next();
            System.out.println("Unwatched episode: " + ep.getTitle());
        }
    }
}