import java.util.Iterator;

public class SeasonIterator implements EpisodeIterator, Iterator<Episode> {
    private Season season;
    private int index = 0;

    public SeasonIterator(Season season) {
        this.season = season;
    }

    @Override
    public boolean hasNext() {
        return index < season.getEpisodes().size();
    }

    @Override
    public Episode next() {
        return season.getEpisodes().get(index++);
    }
}