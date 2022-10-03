import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MostCommonNucleotide
{
    final static String[] letters = new String[] {"A", "C", "G", "T"};

    public static void main(String[] args)
    {
        String dna = "AAAACTGCGCT";
        String mostCommon = mostCommonNucleotide(dna + "ACTG");
        System.out.println(dna + " => " + mostCommon);
    }

    public static String mostCommonNucleotide(String dna)
    {
        return letters[IntStream.range(0, Stream.of(dna.split(""))
                        .collect(Collectors.groupingBy(String::valueOf, Collectors.counting())).size())
                .reduce( (a, b) -> Stream.of(dna.split(""))
                        .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                        .get(letters[a]) < Stream.of(dna.split(""))
                        .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                        .get(letters[b]) ? b : a ).getAsInt()];
    }
}