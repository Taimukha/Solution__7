import java.util.Set;

public class WatchHistoryFilterIterator implements EpisodeIterator {
    private EpisodeIterator iterator;
    private Set<String> watchedTitles;

    public WatchHistoryFilterIterator(EpisodeIterator iterator, Set<String> watchedTitles) {
        this.iterator = iterator;
        this.watchedTitles = watchedTitles;
    }

    @Override
    public boolean hasNext() {
        while (iterator.hasNext()) {
            Episode next = iterator.next();
            if (!watchedTitles.contains(next.getTitle())) {
                current = next;
                hasPreloaded = true;
                return true;
            }
        }
        return false;
    }

    private Episode current;
    private boolean hasPreloaded = false;

    @Override
    public Episode next() {
        if (hasPreloaded) {
            hasPreloaded = false;
            return current;
        }
        return iterator.next();
    }
}