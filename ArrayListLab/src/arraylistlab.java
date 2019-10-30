import java.util.*;

public class arraylistlab {

    //returns true if all the items in the supplied List are unique
    public static <E> Boolean in(List<E> list) {
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size(); j++){
                if( i == j) {
                }
                else if(list.get(i).equals(list.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    //returns a new List of integers that contains all of the
    //integers in the List argument that are multiples of the given int
    public static <E> List<Integer> allMultiples(List<Integer> list, int num) {
        ArrayList<Integer> multiple = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) % num == 0){
                multiple.add(list.get(i));
            }
        }
        return multiple;
    }

    //returns a new List<String> which
    //contains all the Strings from the List argument that are length characters long
    public static <E> List<String> allStringsOfSize(List<String> list, int length) {
        List<String> goodList = new ArrayList<String>();
        for(int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            if(word.length() == length) {
                goodList.add(word);
            }
        }
        return goodList;
    }

    //return true if the two List arguments are
    //permutations of each other, otherwise it returns false
    public static <E> Boolean isPermutation(List<E> list, List<E> otherList) {
        int counter = 0;
        if(list.size() != otherList.size()) {
            return false;
        }
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < otherList.size(); j++){
                if(list.get(i).equals(otherList.get(j))) {


                    counter++;
                    System.out.println(list.get(i) + " " + otherList.get(j) + " " + counter);
                }
            }
        }
        if(counter == list.size()) {
            return true;
        }
        return false;
    }

    //returns a List of words from the input string. We assume that
    //each word in the input string is separated by whitespace
    public static <E> List<String> tokenization(String words) {
        ArrayList<String> list = new ArrayList(Arrays.asList(words.split(" ")));
        for (int i = 0; i < list.size(); i++) {
            String word = (String)list.get(i);
            list.set(i, word.replaceAll("\\p{Punct}", ""));
        }
        return list;
    }

    //removes all of the specified items from the List and
    //returns the new List
    public static <E> List<E> removeAll(List<E> list, E object) {
        List<E>newList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if(!list.get(i).equals(object)) {
                newList.add(list.get(i));
            }
        }

        return newList;
    }




    //MAIN METHOD
    public static void main(String[] args) {
        //Testing in method
        List<String> listFalse = new ArrayList<>();
        listFalse.addAll(Arrays.asList("Cat", "Owl", "Hi", "Hello", "Hey"));
        System.out.println(in(listFalse));
        List<Integer> listTrue = new ArrayList<>();
        listTrue.addAll(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(in(listTrue));

        //Testing findMultiples method
        List<Integer> findMultiples = new ArrayList<>();
        findMultiples.addAll(Arrays.asList(2, 4, 5, 10, 0, 20, 15, 105));
        System.out.println(allMultiples(findMultiples, 5));

        //Testing allStringOfSize method
        List<String> sizeList = new ArrayList<>();
        sizeList.addAll(Arrays.asList("Cat", "Dog", "Mouse", "Panda", "Raccoon", "Cat", "Hat"));
        System.out.println(allStringsOfSize(sizeList, 5));

        //Testing isPermutation method
        //Testing true
        List<String> permString = new ArrayList<>();
        List<String> permStringTwo = new ArrayList<>();
        permString.addAll(Arrays.asList("Cat", "Dog", "Mouse", "Panda"));
        permStringTwo.addAll(Arrays.asList("Cat", "Panda", "Dog", "Seal"));
        System.out.println("Ispermutation:" + isPermutation(permString, permStringTwo));

        //Testing isPermutation method false
        List<String> permStringThree = new ArrayList<>();
        permStringThree.addAll(Arrays.asList("Cat", "Seal", "Panda"));
        System.out.println(isPermutation(permStringThree, permString));

        //Testing isPermutation with integers
        //Testing true
        List<Integer> permInt = new ArrayList<>();
        List<Integer> permIntTwo = new ArrayList<>();
        permInt.addAll(Arrays.asList(1, 2, 3, 4));
        permIntTwo.addAll(Arrays.asList(1, 4, 3, 2));
        System.out.println(isPermutation(permInt, permIntTwo));

        //Testing Tokenization method
        String myWords = "Hello! My name is Rose's.";
        System.out.println(tokenization(myWords));

        //Testing removeAll method Integers
        List<Integer> removeList = new ArrayList<>();
        removeList.addAll(Arrays.asList(1, 2, 3, 3, 4, 5, 3, 4));
        System.out.println(removeAll(removeList, 3));

//        //Testing removeAll method with Strings
//        System.out.println(removeAll(listFalse));








    }

}
