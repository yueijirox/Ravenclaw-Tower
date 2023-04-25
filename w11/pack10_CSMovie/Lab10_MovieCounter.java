package pack10_CSMovie;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lab10_MovieCounter {
    ArrayList<CSMovie> mList = new ArrayList<>();
    Set<String> uniqueTitle = new HashSet<>();
    public Lab10_MovieCounter() {
        String row;
        int rowCount = 1;
        int incompleteCount = 0;
        String title;
        String rating;
        String genre;
        Integer year;
        String skipped_released;
        Double score;
        Integer votes;
        String director;
        String skipped_writer;
        String star;
        String country;
        Integer budget;
        Long gross;
        String company;
        Integer runtime;

        try(Scanner input = new Scanner(Paths.get("pack10_CSMovie/movies.csv"))) {
            input.nextLine(); //skip header row
            while (input.hasNext()) {
                row = input.nextLine();
                rowCount++;
                String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (tokens.length < 15) {
                    incompleteCount++;
                    System.out.println(rowCount + " " + incompleteCount + " is incompleted");
                    continue; //skip this row
                } 
                title = tokens[0];   
                rating = tokens[1];
                genre = tokens[2];
                year = Integer.parseInt(tokens[3]);
                score = Double.parseDouble(parseDouble(tokens[5]));
                votes = (int) (Double.parseDouble(parseDouble(tokens[6])));
                director = tokens[7];
                star = tokens[9];
                country = tokens[10];
                budget =  (int) (Double.parseDouble(parseDouble(tokens[11])));
                gross = (long) (Double.parseDouble(parseDouble(tokens[12])));
                company = tokens[13];
                runtime = (int) (Double.parseDouble(parseDouble(tokens[14])));
                if (!uniqueTitle.contains(title)) {
                    mList.add(new CSMovie(title, rating, genre, 
                    year, score, votes, 
                    director, star, country, 
                    budget, gross, company, 
                    runtime));
                }   
                uniqueTitle.add(title);
            }
            System.out.print("There are " + incompleteCount + " rows of incompleted data ");
            System.out.println("from " + rowCount + " rows. (" + uniqueTitle.size()+ ") unique titles.");
            System.out.println("list size is " + mList.size());
        } catch (IOException e) {
            System.out.println("from IO error");
            e.printStackTrace();
        }
    }
    private static String parseDouble(String str) {
        if (str.isEmpty())
            return ".0";
        return str;
    }

    public Double q1() {
        
        double average = mList.stream().mapToDouble(m->m.getScore()).average().getAsDouble();
        return average;

    }
    public List<CSMovie> q2() {
        List<CSMovie> morethan19 = mList.stream().filter(m-> m.getVotes()>1_900_000).collect(Collectors.toList());
        return morethan19;
    }
    public CSMovie q3() {
        CSMovie maxgross;
        maxgross = mList.stream().max(Comparator.comparing(CSMovie::getGross)).orElse(null);
        return maxgross;
    }   
    public List<String> q4() {
        List<String> genre = mList.stream().map(m->m.getGenre()).distinct().collect(Collectors.toList());
        return genre;
    }
    public List<String> q5() { 

        List<String> runtime = mList.stream().sorted(Comparator.comparing(CSMovie::getRuntime)).map(m -> String.format("%-55s --> %s",m.getTitle(), m.getRuntime())).limit(5).toList();
    
        return runtime;
    }

    public CSMovie[] q6() {
        CSMovie[] budget = new CSMovie[2];
        budget[0] = mList.stream().max(Comparator.comparing(CSMovie::getBudget)).orElse(null);
        budget[1] = mList.stream().min(Comparator.comparing(CSMovie::getBudget)).orElse(null);
        return budget;
    }

    public List<CSMovie> q7(String genre) {
        List<CSMovie> topActionCsMovies = mList.stream()
                .filter(m -> m.getGenre().contains(genre))
                .sorted(Comparator.comparing(CSMovie::getScore).reversed())
                .limit(3)
                .collect(Collectors.toList());
        return topActionCsMovies;
    }
    public List<CSMovie> q8() {
        List<CSMovie> top3ActionMovies = mList.stream()
                .filter(m -> m.getGenre().contains("Action"))
                .sorted(Comparator.comparing(CSMovie::getScore).reversed() 
                        .thenComparing(Comparator.comparing(CSMovie::getTitle)))
                .limit(3)
                .collect(Collectors.toList());
        return top3ActionMovies;
    }
    
    public Map<String,Long> q9() {
        Map<String,Long> sumMap = new HashMap<>();
        sumMap = mList.stream().collect(Collectors.groupingBy(CSMovie::getGenre , Collectors.summingLong(CSMovie::getGross)));

        return sumMap;
    }
    public Map<String, Long> q10() {

        Map<String, Long> movieCountByCompany = new HashMap<>();
    
      
        for (CSMovie movie : mList) {
            String company = movie.getCompany();
            movieCountByCompany.put(company, movieCountByCompany.getOrDefault(company, 0L) + 1);
        }
    
        
        LinkedHashMap<String, Long> sortedMap = new LinkedHashMap<>();
        movieCountByCompany.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
    
     
        Map<String, Long> top10Companies = new LinkedHashMap<>();
        int count = 0;
        for (Map.Entry<String, Long> entry : sortedMap.entrySet()) {
            if (count >= 10) {
                break;
            }
            top10Companies.put(entry.getKey(), entry.getValue());
            count++;
        }
    
        return top10Companies;
    }
    
    public CSMovie q11() {
        // Function most 'a' 
        Function<CSMovie, Integer> countVowel = m -> {
            int cnt = 0;
            String titlename = m.getTitle();
            for(int i = 0 ; i< titlename.length() ; i++){
                if(titlename.charAt(i)=='a' || titlename.charAt(i)== 'A'){
                    cnt++;
                }
            }
            return cnt;
        };

        Optional<CSMovie> m;
        m=mList.stream().max(Comparator.comparing(countVowel));
        return m.get();
    }
}
// https://www.baeldung.com/java-split-string-commas