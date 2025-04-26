import java.util.List;

public class BingeIterator implements EpisodeIterator {
    private List<Season> seasons;
    private int currentSeason = 0;
    private EpisodeIterator currentIterator;

    public BingeIterator(List<Season> seasons) {
        this.seasons = seasons;
        if (!seasons.isEmpty()) {
            currentIterator = seasons.get(0).getNormalIterator();
        }
    }

    @Override
    public boolean hasNext() {
        while (currentSeason < seasons.size()) {
            if (currentIterator != null && currentIterator.hasNext()) {
                return true;
            } else {
                currentSeason++;
                if (currentSeason < seasons.size()) {
                    currentIterator = seasons.get(currentSeason).getNormalIterator();
                }
            }
        }
        return false;
    }

    @Override
    public Episode next() {
        return currentIterator.next();
    }
}