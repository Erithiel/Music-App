

public class MusicApp {

    private Artist[] artists;

    public MusicApp() {
        this.artists = new Artist[0];
    }

    public Artist[] getArtists() {
        return artists;
    }

    void addArtists(Artist[] artists) {
        if (this.artists.length == 0) {
            this.artists = artists;
        } else {

            Artist[] temp = this.artists;
            for (Artist first : artists) {
                int is = 0;
                for (Artist second : this.artists) {
                    if (!second.isEqual(first)) {
                        is++;
                    }
                    if (this.artists.length == is) {

                        temp = add(temp, first);
                    }
                }
            }
            this.artists = temp;

        }

    }

    private Artist[] add(Artist arr[], Artist x) {
        int n = arr.length;
        Artist newArr[] = new Artist[n + 1];

        for (int j = 0; j < n; j++)
            newArr[j] = arr[j];

        newArr[n] = x;
        return newArr;
    }

    public String[] getTopTrendingArtist() {

        String str[] = { "", "" };
        Artist max = new Artist(null, null, 0, null, null);
        int maxNum = -1;
        Artist temp;
        for (Artist i : artists) {
            temp = i;
            if (maxNum < temp.totalLikes()) {
                max = temp;
                maxNum = temp.totalLikes();
            }
        }

        str[0] = max.getFirstName();
        str[1] = max.getLastName();

        return str;
    }

    public String getTopTrendingAlbum() {
        Album max = new Album(null, 0);
        Album temp;
        int maxNum = -1;
        for (Artist art : this.artists) {
            for (Album alb : art.getAlbums()) {
                temp = alb;
                if (temp.totalLikes() > maxNum) {
                    maxNum = temp.totalLikes();
                    max = temp;
                }
            }
        }
        return max.getTitle();
    }

    public String getTopTrendingSong() {
        Artist max = new Artist(null, null, 0, null, null);
        Artist temp;
        int maxNum = -1;
        for (Artist art : this.artists) {
            temp = art;
            if (temp.mostLikedSong().getLikes() > maxNum) {
                maxNum = temp.mostLikedSong().getLikes();
                max = temp;
            }
        }
        return max.mostLikedSong().getTitle();

    }

}
