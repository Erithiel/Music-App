


import java.util.Random;

public class Album {
    private String title;
    private int releaseYear;
    public Song[] songs;

    public String getTitle() {
        return title;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public Song[] getSongs() {
        return songs;
    }


    public Album(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    private Song[] add(Song arr[], Song x){
       int n = arr.length;
       Song newArr[] = new Song[n + 1];

       for (int j = 0; j < n; j++)
           newArr[j] = arr[j];
   
       newArr[n] = x;
       return newArr;
   }

    public int addSongs(Song[] songs){
        int count = 0;
        if(this.songs == null){
            this.songs = songs;
            count = songs.length;
            return count;
        }
        
        Song[] temp=this.songs;
        for (Song first : songs){
            int is = 0;
            for (Song second : this.songs){
                if(!second.isEqual(first)){
                    is++;
                }
                if(this.songs.length==is){
                    count++;
                    temp =add(temp, first);
                }
            }
        }
        this.songs = temp;
        return count;
    }

    public Song[] shuffle(){
        Song[] result = new Song[this.songs.length];
        Random rand = new Random();
        int length = this.songs.length;

        for (int i = 0; i < length; i++) {
            int n = rand.nextInt(this.songs.length);
            while(result[n]!=null){
                n = rand.nextInt(this.songs.length);
            }
            result[i]=this.songs[n];
        }
        
        return result;
    }

    public static Song[] reverse(Song[] songs){
        Song[] result = songs;
        int len = songs.length;
        int left = 0, right = len - 1 - left;
        while (left < right) {
            swap(result, left, right);
            left++;
            right--;
        }
        return result;
    }
        
    private static void swap(Song[] arr, int left, int right) {
        Song tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public Song[] sortByTitle(boolean isAscending){
        Song[] arr = this.songs;
        int n = this.songs.length;
        for(int i = 0; i < n-1; ++i) {  
            for (int j = i + 1; j < n; ++j) {  
               if (arr[i].getTitle().compareTo(arr[j].getTitle()) > 0) {  
                  Song temp = arr[i];  
                  arr[i] = arr[j];  
                  arr[j] = temp;  
               }  
            }  
         }
        if(isAscending) 
        return arr;
        return reverse(arr);
    }

    public Song[] sortByDuration(boolean isAscending){

        Song[] arr = this.songs;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Song temp;
                if (arr[j].getDuration() < arr[i].getDuration()) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        if(isAscending)
        return arr;
        return reverse(arr);

    }

    Song[] sortByReleaseYear(boolean isAscending){
        Song[] arr = this.songs;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Song temp;
                if (arr[j].getReleaseYear() < arr[i].getReleaseYear()) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        if(isAscending)
        return arr;
        return reverse(arr);

    }

    Song[] sortByPopularity(boolean isAscending){
        Song[] arr = this.songs;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Song temp;
                if (arr[j].getLikes() < arr[i].getLikes()) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        if(isAscending)
        return arr;
        return reverse(arr);

    }

    @Override
    public String toString() {
        String first = "Title:" + title + ",Release year:" + releaseYear + ",Songs:{";
        for (int i = 0; i < this.songs.length; i++) {
            if(i!=this.songs.length-1){
                first += this.songs[i].toString()+"|";
            }else{
                first += this.songs[i].toString()+"}";
            }
        }
        return first;
    }

    public int totalLikes(){
        int sum = 0;
        for(Song i : songs ){
            sum += i.getLikes();
        }
        return sum;
    }

}
    









    



    

    











