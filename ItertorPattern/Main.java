public class Main {
    public static void main(String[] args) {
        Season s1 = new Season();
        s1.addEpisode(new Episode("S1E1: Intro", 1200));
        s1.addEpisode(new Episode("S1E2: Conflict", 1300));
        s1.addEpisode(new Episode("S1E3: Climax", 1400));

        Season s2 = new Season();
        s2.addEpisode(new Episode("S2E1: Return", 1500));
        s2.addEpisode(new Episode("S2E2: Twist", 1600));

        Series series = new Series();
        series.addSeason(s1);
        series.addSeason(s2);

        System.out.println("Normal Season 1:");
        for (Episode e : s1) {
            System.out.println(e);
        }

        System.out.println("\nReverse Season 2:");
        EpisodeIterator rev = s2.getReverseIterator();
        while (rev.hasNext()) {
            System.out.println(rev.next());
        }

        System.out.println("\nShuffle Season 1:");
        EpisodeIterator shuf = s1.getShuffleIterator();
        while (shuf.hasNext()) {
            System.out.println(shuf.next());
        }

        System.out.println("\nFull Series Binge Mode:");
        EpisodeIterator binge = series.getBingeIterator();
        while (binge.hasNext()) {
            System.out.println(binge.next());
        }
    }
}