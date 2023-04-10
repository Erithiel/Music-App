

public class Song {
    private String title;
    private int releaseYear;
    private int duration;
    private int likes;

    public String getTitle() {
        return title;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public double getDuration() {
        return duration;
    }
    public int getLikes() {
        return likes;
    }

    public void setDuration(int duration){
        changeDuration(duration);
    }
    public Song(String title,int releaseYear,int duration){
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = 0;
        
    }

    public Song(String title,int releaseYear){
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = 60;
        this.likes = 0;
        
    }

    public Song(String title, int releaseYear, int duration, int likes) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = likes;
    }

    public boolean changeDuration(int duration){
        if(duration<0 || duration>720 || duration==this.duration)
            return false;
        return true;
    }

    public void like(){
        this.likes++;
    }
    public void unlike(){
        if(likes>0)
        this.likes--;
    }

    private double round(double value) {
        long rame = (long) Math.pow(10, 2);
        value = value * rame;
        long tmp = Math.round(value);
        return (double) tmp / rame;
    }

    @Override
    public String toString() {
        double dur = (double) duration/60;
        return "Title:" + title + ",Duration:" + round(dur) + ",Release year:" + releaseYear + ",Likes:" + likes;       
    }

    
    public boolean isEqual(Song other){
        if(this.title == other.title && this.duration == other.duration && this.releaseYear == other.releaseYear){
            return true;
        }
        return false;
    }
}
