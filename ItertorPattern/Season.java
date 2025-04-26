import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Season implements Iterable<Episode> {
    private List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public EpisodeIterator getNormalIterator() {
        return new SeasonIterator(this);
    }

    public EpisodeIterator getReverseIterator() {
        return new ReverseSeasonIterator(this);
    }

    public EpisodeIterator getShuffleIterator() {
        return new ShuffleSeasonIterator(this);
    }

    @Override
    public Iterator<Episode> iterator() {
        return new SeasonIterator(this);
    }
}