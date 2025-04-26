public class SkipIntroIterator implements EpisodeIterator {
    private EpisodeIterator iterator;
    private final int skipSeconds;

    public SkipIntroIterator(EpisodeIterator iterator, int skipSeconds) {
        this.iterator = iterator;
        this.skipSeconds = skipSeconds;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Episode next() {
        Episode original = iterator.next();
        System.out.println("[Skipping intro]");
        return new EpisodeView(original, skipSeconds).getEpisode();
    }
}