import java.util.*;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private List<Episode> shuffled;
    private int index = 0;

    public ShuffleSeasonIterator(Season season) {
        shuffled = new ArrayList<>(season.getEpisodes());
        Collections.shuffle(shuffled, new Random(42));
    }

    @Override
    public boolean hasNext() {
        return index < shuffled.size();
    }

    @Override
    public Episode next() {
        return shuffled.get(index++);
    }
}