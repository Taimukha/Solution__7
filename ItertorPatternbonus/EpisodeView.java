public class EpisodeView {
    private Episode episode;
    private int startOffsetSec;

    public EpisodeView(Episode episode, int startOffsetSec) {
        this.episode = episode;
        this.startOffsetSec = startOffsetSec;
    }

    public void play() {
        System.out.println("Playing " + episode.getTitle() + " from " + startOffsetSec + " seconds...");
    }

    public Episode getEpisode() {
        return episode;
    }
}
