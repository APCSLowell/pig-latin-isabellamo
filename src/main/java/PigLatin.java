public void setup() {
  String[] lines = loadStrings("words.txt");
  System.out.println("there are " + lines.length + " lines");
  for (int i = 0 ; i < lines.length; i++) {
    System.out.println(pigLatin(lines[i]));
  }
}

public void draw() {
   
}

public int findFirstVowel (String sWord) {
//precondition: sWord is a valid String of length greater than 0.
//postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
  for(int i = 0; i < sWord.length(); i++)
    if(sWord.charAt(i) == 'a' || sWord.charAt(i) == 'e' || sWord.charAt(i) == 'i' || sWord.charAt(i) == 'o' || sWord.charAt(i) == 'u') {
      return i;
    } return -1;
}

public String pigLatin (String sWord) {
//precondition: sWord is a valid String of length greater than 0
//postcondition: returns the pig latin equivalent of sWord
  
  int index = findFirstVowel(sWord);
  boolean hasQU = false;
  String look = "qu";
  
  for (int i = 0; i < sWord.length() - 2; i++){
    if (look.equals(sWord.substring(i, i + 2))){
      hasQU = true;
    }
  }
  
  if (index == -1) { // only y
    return sWord + "ay";
  } else if (index == 0) { // starts with a vowel
    return sWord + "way";  
  } else if (hasQU == true){ // has "qu"
    return sWord.substring(index + 1, sWord.length()) + sWord.substring(0, index + 1) + "ay";
  } else { // starts with consonants
    return sWord.substring(index, sWord.length()) + sWord.substring(0, index) + "ay";
  }
}
