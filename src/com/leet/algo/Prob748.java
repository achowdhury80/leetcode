package com.leet.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/27/17.
 */
public class Prob748 {
  public String shortestCompletingWord(String licensePlate, String[] words) {
    if(licensePlate == null || licensePlate.length() == 0 || words == null || words.length == 0) return null;
    Map<Character, Integer> map = new HashMap<>();
    IntStream.range(0, licensePlate.length()).forEach(idx -> {
      char c = Character.toLowerCase(licensePlate.charAt(idx));
      if(c >= 'a' && c <= 'z'){
        if(map.containsKey(c)){
          map.put(c, map.get(c) + 1);
        } else {
          map.put(c, 1);
        }
      }
    });
    Arrays.sort(words, (s1, s2) -> s1.length() < s2.length() ? -1 : 1);
    Arrays.sort(words, (s1, s2) -> s1.length() < s2.length() ? -1 : 1);
    Arrays.stream(words).forEach(x -> System.out.print(x + ", "));
    Set<Character> set = map.keySet();
    for (String word : words){
      if(isValid(word, map)) return word;
    }
    return null;
  }

  private boolean isValid(String word, Map<Character, Integer> map){
    Map<Character, Integer> tempMap = new HashMap<>(map);
    IntStream.range(0, word.length()).forEach(idx -> {
      char c = word.charAt(idx);
      if(tempMap.containsKey(c)){
        tempMap.put(c, tempMap.get(c) - 1);
      }
    });
    for(char c : tempMap.keySet()){
      if(tempMap.get(c) > 0) return false;
    }
    return true;
  }

  public static void main(String[] args){
    Prob748 prob748 = new Prob748();
//    System.out.println(prob748.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
//    System.out.println(prob748.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));


    String[] arr = new String[]{"remember","cold","tree","north","mean","board","hour","system","expect","build","song","you","stop","cancer","experiencing","worrying","coach","red","method","foreign","manager","compare","investment","knowledge","box","result","she","provide","ground","exactly","education","billion","happen","success","specific","fly","oil","man","realize","finger","receive","example","production","summer","rich","cover","property","cup","media","product","administration","while","front","actually","four","major","matter","support","his","heart","character","leave","consumer","pull","can","wide","eight","finally","throw","final","order","other","picture","house","return","rock","action","but","according","station","maybe","scene","concern","table","science","victim","offer","plant","sex","trip","area","best","produce","everybody","stand","start","cut","hold","their","single","decide","even","use","tonight","heavy","miss","evening","us","development","street","middle","big","want","student","direction","ten","language","message","allow","important","well","radio","than","pick","positive","wondering","religious","morning","legal","floor","attorney","outside","death","painting","military","occur","type","him","perhaps","society","these","nothing","also","necessary","goal","degree","die","pressure","whatever","per","economy","place","grow","history","heat","similar","either","democratic","sexual","sport","attack","business","inside","doctor","item","amount","stock","series","friend","scientist","stage","score","third","all","ability","three","include","discover","peace","there","exist","natural","security","dream","case","sit","account","institution","lead","list","hang","along","range","fast","nearly","letter","project","south","period","building","soon","impact","yeah","candidate","open","food","for","reveal","top","source","sound","much","down","which","soldier","good","toward","analysis","disease","meeting","page","million","during","value","what","meet","city","hair","arm","officer","serve","life","later","reduce","control","baby","small","may","fall","fail","rise","power","size","several","structure","view","many","before","here","old","find","position","land","hot","difference","full","care","everyone","director","color","kitchen","key","particular","spring","trial","age","traditional","threat","sister","audience","very","on","break","go","response","population","plan","bank","thus","official","ago","would","they","create","nature","none","born","fund","its","election","experienced","study","note","right","himself","thing","some","whom","focus","road","section","wish","pattern","quickly","eye","difficult","room","economic","subject","close","crime","short","human","should","ok","eat","itself","develop","come","risk","strategy","onto","woman","federal","hard","thank","moment","worker","chair","treat","assume","recently","like","as","win","war","them","strong","first","despite","college","few","your","play","try","poor","with","brother","family","stay","continue","point","a","travel","able","such","teach","hundred","class","fire","then","fish","know","feel","seek","successful","world","perform","little","main","behind","rather","whole","week","day","test","raise","trouble","make","authority","air","might","require","training","past","truth","debate","until","away","appear","sometimes","modern","machine","tough","against","will","beautiful","piece","why","or","establish","although","particularly","certainly","film","data","star","field","bag","already","determine","need","across","enjoy","significant","option","think","share","image","young","factor","computer","agent","reason","long","lose","within","opportunity","sea","member","how","rule","suddenly","sort","nor","in","write","market","unit","carry","report","end","real","nation","enter","keep","improve","believe","mention","hospital","that","mother","though","central","seat","person","policy","from","learn","edge","quite","tax","paper","fine","spend","recent","claim","politics","model","agency","century","since","together","church","represent","fact","light","usually","last","artist","line","talk","current","environmental","prepare","up","discuss","former","sell","professor","weight","theory","program","too","price","simple","throughout","office","blood","buy","customer","yard","number","agreement","upon","dead","of","show","marriage","service","loss","base","trade","now","space","themselves","among","oh","yourself","animal","manage","effort","if","violence","about","others","name","expert","news","technology","answer","pay","contain","this","statement","drive","special","girl","leg","draw","another","fill","likely","deep","mouth","bad","ask","present","culture","hotel","chance","wishing","budget","true","after","purpose","skin","skill","responsibility","side","rate","move","music","style","interest","book","force","each","green","get","because","teacher","any","water","kid","west","could","suffer","father","daughter","beat","movement","anyone","see","shake","bar","president","blue","campaign","newspaper","say","free","smile","attention","surface","part","apply","both","participant","begin","cause","relate","foot","reality","prevent","who","act","not","six","author","protect","kill","be","center","country","probably","catch","owner","save","notice","interesting","certain","instead","clear","indeed","through","address","choose","role","employee","willing","energy","performance","sing","myself","affect","set","ever","state","black","far","never","recognize","have","year","car","local","story","generation","reach","conference","second","thought","laugh","stuff","avoid","various","five","personal","look","especially","it","great","couple","east","almost","organization","firm","join","white","operation","body","common","court","question","once","low","increase","run","accept","take","better","social","quality","same","decision","whether","research","push","store","hope","least","idea","information","management","political","near","herself","private","follow","clearly","worry","maintain","around","career","change","wait","lay","dog","article","school","own","month","speech","half","industry","admit","remove","head","imagine","respond","gun","tend","player","yet","problem","growth","interview","fear","practice","behavior","live","identify","do","simply","dark","pain","memory","someone","process","law","garden","prove","watch","national","card","voice","television","door","child","job","level","writer","just","different","company","figure","southern","weapon","magazine","site","cost","early","challenge","explain","individual","group","welcomed","medical","agree","safe","seem","leader","design","when","government","remain","two","check","into","often","situation","again","yes","involve","welcoming","listen","large","entire","her","including","put","standard","he","else","nice","sign","fight","send","high","community","vote","wear","those","over","left","night","home","region","hand","camera","people","son","deal","capital","today","pass","word","wind","phone","party","rest","guess","financial","material","professional","bill","shot","measure","next","everything","ready","my","pretty","relationship","approach","mind","town","only","resource","activity","call","suggest","task","forget","effect","time","choice","something","partner","gas","under","citizen","whose","dinner","lawyer","beyond","popular","and","evidence","thousand","more","indicate","parent","easy","term","our","detail","guy","art","sense","work","welcome","cell","majority","possible","happy","most","collection","wonder","huge","off","benefit","network","race","record","future","glass","form","physical","reflect","cultural","hear","let","understand","love","alone","add","condition","sure","police","by","international","bit","new","anything","become","me","issue","where","so","total","must","shoulder","however","defense","give","late","the","out","wrong","tell","experience","discussion","season","one","window","somebody","shoot","help","mission","minute","describe","bed","lie","wall","forward","way","bring","boy","always","general","walk","available","face","ahead","visit","event","working","wife","public","read","husband","ball","no","speak","still","step","hit","between","decade","money","serious","at","above","seven","staff","every","we","lot","western","without","commercial","finish","drop","argue","back","executive","civil","team","health","arrive","kind","adult","treatment","to","senior","movie","turn","game","course","really","environment","less","patient","drug","enough","charge","consider","feeling"};
    Arrays.sort(arr, (s1, s2) -> Integer.valueOf(s1.length()).compareTo(s2.length()));
    Arrays.stream(arr).forEach(x -> System.out.print(x + ", "));
  }
}
