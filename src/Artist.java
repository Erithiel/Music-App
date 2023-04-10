



public class Artist {
    private String firstName;
    private String lastName;
    private int birthYear;
    private Album[] albums;
    private Song[] singles;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Album[] getAlbums() {
        return albums;
    }

    public Song[] getSingles() {
        return singles;
    }

    public Artist(String firstName, String lastName, int birthYear, Album[] albums, Song[] singles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.albums = albums;
        this.singles = singles;
    }

    private Song[] add(Song arr[], Song x) {
        int n = arr.length;
        Song newArr[] = new Song[n + 1];

        for (int j = 0; j < n; j++)
            newArr[j] = arr[j];

        newArr[n] = x;
        return newArr;
    }
    
    public Song mostLikedSong() {
        Song[] arr = singles;
        for (Album alb : albums) {
            for (Song son : alb.getSongs()) {
                add(arr, son);
            }
        }
        Song maxSong = new Song("", 1);
        Song tempSong;
        for (int i = 0; i < arr.length; i++) {
            tempSong = arr[i];
            if (tempSong.getLikes() >= maxSong.getLikes()) {
                maxSong = tempSong;
            }
        }
        return maxSong;
    }

    public Song leastLikedSong() {
        Song[] arr = singles;
        for (Album alb : albums) {
            for (Song son : alb.getSongs()) {
                add(arr, son);
            }
        }
        Song minSong = new Song("", 1, 30, Integer.MAX_VALUE);
        Song tempSong;
        for (int i = 0; i < arr.length; i++) {
            tempSong = arr[i];
            if (tempSong.getLikes() > minSong.getLikes()) {
                minSong = tempSong;
            }
        }
        return minSong;
    }

    public int totalLikes() {
        Song[] arr = singles;
        for (Album alb : albums) {
            for (Song son : alb.getSongs()) {
                add(arr, son);
            }
        }
        int sum = 0;
        for (Song i : arr) {
            sum += i.getLikes();
        }
        return sum;
    }

    public boolean isEqual(Artist other) {
        if (firstName == other.getFirstName() && lastName == other.getLastName() && birthYear == other.getBirthYear())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Name:" + firstName + " " + lastName + ", birth year:" + birthYear + "Total likes:"+ this.totalLikes();
    }
}
