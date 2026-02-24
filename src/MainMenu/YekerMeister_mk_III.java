package MainMenu;

import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class YekerMeister_mk_III {
    Boolean firstDraw = false;
    Boolean lastDraw = false;
    Boolean afterKan  = false;
    ArrayList<Integer> kans = new ArrayList<>();
    int[] hand = {
            11,12,13,
            14,15,16,
            17,21,29,
            31,39,41,
            48,22
    };
    int[] YHand;
//    <editor-fold desc="General">
    void normaliseHand(){
        int[] temp = new int[hand.length];
        for ( int i = 0; i < hand.length; i++){
            if (hand[i] >100){
                temp[i] = hand[i]/10;
            }else {
                temp[i] = hand[i];
            }
        }
        if (!kans.isEmpty()){
            switch (kans.size()){
                case 1:
                    temp[11] = kans.get(0);
                    temp[12] = kans.get(0);
                    temp[13] = kans.get(0);
                    break;
                case 2:
                    temp[8] = kans.get(0);
                    temp[9] = kans.get(0);
                    temp[10] = kans.get(0);
                    temp[11] = kans.get(1);
                    temp[12] = kans.get(1);
                    temp[13] = kans.get(1);
                    break;
                case 3:
                    temp[5] = kans.get(0);
                    temp[6] = kans.get(0);
                    temp[7] = kans.get(0);
                    temp[8] = kans.get(1);
                    temp[9] = kans.get(1);
                    temp[10] = kans.get(1);
                    temp[11] = kans.get(2);
                    temp[12] = kans.get(2);
                    temp[13] = kans.get(2);
                    break;
                case 4:
                    temp[2] = kans.get(3);
                    temp[3] = kans.get(3);
                    temp[4] = kans.get(3);
                    temp[5] = kans.get(0);
                    temp[6] = kans.get(0);
                    temp[7] = kans.get(0);
                    temp[8] = kans.get(1);
                    temp[9] = kans.get(1);
                    temp[10] = kans.get(1);
                    temp[11] = kans.get(2);
                    temp[12] = kans.get(2);
                    temp[13] = kans.get(2);
                    break;
            }
            Main.mainWindow.game.Sorthand(temp);
        }
        hand = temp;
    }
//    </editor-fold>
//    <editor-fold desc="Tenpais">

    List<Integer> T7pairsWaits(int[] hand) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int t : hand)
            count.put(t, count.getOrDefault(t, 0) + 1);
        int pairs = 0;
        List<Integer> singles = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            int c = e.getValue();
            if (c == 2) pairs++;
            if (c  == 1) singles.add(e.getKey());
        }
        if (pairs == 7) return Arrays.asList(1);
        if (pairs == 6 && singles.size() == 1)
            return singles;
        return Arrays.asList(0);
    }

    List<Integer> T13OrphansWaits(int[] hand) {
        List<Integer> orphans = Arrays.asList(
                11,12,13,14,15,16,17,
                21,29,31,39,41,49
        );

        Map<Integer, Integer> count = new HashMap<>();
        Set<Integer> found = new HashSet<>();
        Set<Integer> junk = new HashSet<>();

        for (int t : hand) {
            if (orphans.contains(t)) {
                System.out.println(" testin n rollin "+t);
                count.put(t, count.getOrDefault(t, 0) + 1);
                found.add(t);
            }else{
                junk.add(t);
            }
        }
        System.out.println(" co do "+found.size());
        if (!junk.isEmpty()){
            return Arrays.asList(0);
        }

        boolean hasAll = found.containsAll(orphans);
        boolean hasDuplicate = count.values().stream().anyMatch(c -> c == 2);

        if (hasAll && hasDuplicate) {
            return new ArrayList<>(orphans);
        }

        if (found.size() == 12 && junk.size()!=1) {
            List<Integer> waits = new ArrayList<>();
            for (int o : orphans) {
                if (!found.contains(o)) waits.add(o);
            }
            System.out.println("john n rollin");
            return waits;
        }

        if (found.size() == 13 && hasDuplicate) {
            System.out.println("jabra n rollin");
            return new ArrayList<>(orphans);
        }

        if (found.size() == 13 && !hasDuplicate) {
            System.out.println("ahmed n rollin");
            return new ArrayList<>(orphans);
        }

        return Arrays.asList(0);
    }



    List<Integer> findRegularWaitsFast(int[] hand) {
        List<Integer> waits = new ArrayList<>();

        for (int tile = 11; tile <= 49; tile++) {
            int suit = tile / 10, num = tile % 10;
            if (num == 0 || num > 9) continue;
            if (suit == 1 && tile > 17) continue;

            int[] test = Arrays.copyOf(hand, hand.length + 1);
            test[hand.length] = tile;

            if (isWinningHandFast(test))
                waits.add(tile);
        }

        if (waits.isEmpty()) waits.add(0);
        return waits;
    }

    boolean isWinningHandFast(int[] hand) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int t : hand) count.put(t, count.getOrDefault(t, 0) + 1);

        for (int pair : count.keySet()) {
            if (count.get(pair) >= 2) {
                count.put(pair, count.get(pair) - 2);
                if (canFormMeldsFast(count)) return true;
                count.put(pair, count.get(pair) + 2);
            }
        }
        return false;
    }

    boolean canFormMeldsFast(Map<Integer, Integer> count) {
        int remaining = 0;
        for (int c : count.values()) remaining += c;
        if (remaining == 0) return true;

        int first = -1;
        for (int k : count.keySet()) {
            if (count.get(k) > 0) { first = k; break; }
        }
        if (first == -1) return true;

        int suit = first / 10;
        int num = first % 10;

        if (count.get(first) >= 3) {
            count.put(first, count.get(first) - 3);
            if (canFormMeldsFast(count)) return true;
            count.put(first, count.get(first) + 3);
        }

        if (suit != 1 && num <= 7) {
            int t1 = first + 1, t2 = first + 2;
            if (count.getOrDefault(t1, 0) > 0 && count.getOrDefault(t2, 0) > 0) {
                count.put(first, count.get(first) - 1);
                count.put(t1, count.get(t1) - 1);
                count.put(t2, count.get(t2) - 1);
                if (canFormMeldsFast(count)) return true;
                count.put(first, count.get(first) + 1);
                count.put(t1, count.get(t1) + 1);
                count.put(t2, count.get(t2) + 1);
            }
        }

        return false;
    }

    List<List<Integer>> TenpaiAllCombined(int[] currentHand) {
        List<List<Integer>> results = new ArrayList<>();
        normaliseHand();
        currentHand = hand;
        List<Integer> kokushiWaits = T13OrphansWaits(currentHand);
        boolean kokushi13Way = kokushiWaits.size() == 13;

        List<Integer> orphans = Arrays.asList(
                11,12,13,14,15,16,17,21,29,31,39,41,49
        );
        Map<Integer, Integer> count = new HashMap<>();
        for (int t : currentHand)
            count.put(t, count.getOrDefault(t, 0) + 1);

        Integer kokushiDuplicate = null;
        for (int o : orphans) {
            if (count.getOrDefault(o, 0) == 2) {
                kokushiDuplicate = o;
                break;
            }
        }

        for (int i = 0; i < currentHand.length; i++) {
            int[] sub = new int[currentHand.length - 1];
            for (int j = 0, k = 0; j < currentHand.length; j++) {
                if (j == i) continue;
                sub[k++] = currentHand[j];
            }

            Set<Integer> waitsSet = new LinkedHashSet<>();

            if (kokushi13Way) {
                int discarded = currentHand[i];
                if (discarded == kokushiDuplicate) {
                    waitsSet.addAll(kokushiWaits);
                } else {
                    waitsSet.addAll(kokushiWaits);
                }
            } else {
                List<Integer> w13 = T13OrphansWaits(sub);
                if (!(w13.size() == 1 && w13.get(0) == 0))
                    waitsSet.addAll(w13);
            }
            List<Integer> w7 = T7pairsWaits(sub);
            if (!(w7.size() == 1 && w7.get(0) == 0)) {
                if (w7.size() == 1 && w7.get(0) == 1)
                    waitsSet.add(1);
                else
                    waitsSet.addAll(w7);
            }

            List<Integer> wReg = findRegularWaitsFast(sub);
            if (!(wReg.size() == 1 && wReg.get(0) == 0))
                waitsSet.addAll(wReg);

            List<Integer> waits = waitsSet.isEmpty()
                    ? Collections.singletonList(0)
                    : new ArrayList<>(waitsSet);

            results.add(waits);
        }

        return results;
    }





//    </editor-fold>
//    <editor-fold desc="Yakus">

    Boolean YTanyao(){
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] /10 ==1 || hand[i]%10 == 1 || hand[i]%10 == 9) {
                return false;
            }
        }
        for (int kan : kans){
            if (kan/10==1){
                return false;
            }
        }
        return true;
    }
    Boolean YYakuhai(){
        for (int i = 0; i < hand.length-2; i++) {
            if (hand[i]/10==1) {
                if (hand[i] == hand[i + 1] && hand[i] == hand[i + 2]) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean YPinfu() {
        ArrayList<Integer> handList = new ArrayList<>();
        for (int tile : hand) handList.add(tile);
        if (kans.size()>0){
            return false;
        }

        for (int i = 0; i < handList.size() - 1; i++) {
            if (!Objects.equals(handList.get(i), handList.get(i + 1))) continue;
            if (handList.get(i) / 10 == 1) return false;

            ArrayList<Integer> temp = new ArrayList<>(handList);
            temp.remove(i + 1);
            temp.remove(i);

            if (canFormSequences(temp)) return true;
        }

        return false;
    }
    boolean canFormSequences(ArrayList<Integer> tiles) {
        while (!tiles.isEmpty()) {
            int base = tiles.get(0);

            Integer next1 = base + 1;
            Integer next2 = base + 2;

            if (tiles.contains(next1) && tiles.contains(next2)) {
                tiles.remove((Integer) next1);
                tiles.remove((Integer) next2);
                tiles.remove((Integer) base);
            } else {
                return false;
            }
        }
        return true;
    }
    Boolean YIpeikou(){
        for (int i = 0; i < hand.length-5; i++) {
            if (hand[i] == hand[i+1]){
                if(hand[i]+1 == hand[i+3] && hand[i]+2 == hand[i+5]){
                    return true;
                }
            }
        }
        return false;
    }
    Boolean YRinshanKaihou(){
        return afterKan;
    }
    Boolean YHaiteiRaoyue(){
        return lastDraw;
    }
    Boolean YToitoihou (){
        ArrayList<Integer> handList = new ArrayList<>();
        for (int i = 0; i < hand.length; i++) {
            handList.add(hand[i]);
        }
        for (int i = 0; i < handList.size() - 1; i++) {
            int base = handList.get(i);

            Integer next1 = base + 1;
            Integer next2 = base + 2;

            if (handList.contains(next1) && handList.contains(next2)) {
                return false;
            }
        }
        return true;
    }
    Boolean YSenshokuDoukou (){
        int triplets =0;
        ArrayList<Integer> tripletNums = new ArrayList<>();
        for (int i = 0; i < hand.length-2; i++) {
            if (hand[i]/10 == 1){
                continue;
            }
            if (hand[i] == hand[i+1] && hand[i] == hand[i+2]) {
                tripletNums.add(hand[i]);
                i+=2;
            }
        }
        Map<Integer, Integer> counts = new HashMap<>();
        for (int t : tripletNums) {
            int digit = t % 10;
            counts.put(digit, counts.getOrDefault(digit, 0) + 1);
            if (counts.get(digit) >= 3) return true;
        }
        return false;
    }
    Boolean YSankatsu (){
        return kans.size()==3;
    }
    Boolean YShousangen (){
        int DelDraho =0;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == 15 || hand[i] == 16 || hand[i] == 17) {
                DelDraho++;
            }
        }
        if (DelDraho == 8) return true;
        return false;
    }
    Boolean YHonrouto (){
        for (int i = 0; i < hand.length; i++) {
            if(hand[i]/10 == 1 || hand[i]%10 == 1 || hand[i]%10 == 9) {
            }else {
                return false;
            }
        }
        return true;
    }
    Boolean YChitoitsu (){
        Map<Integer, Integer> count = new HashMap<>();
        for (int t : hand)
            count.put(t, count.getOrDefault(t, 0) + 1);
        int pairs = 0;
        List<Integer> singles = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            int c = e.getValue();
            if (c == 2) pairs++;
            if (c  == 1) singles.add(e.getKey());
        }
        if (pairs == 7) return true;
        return false;
    }

    Boolean YHonchantaiYaochu() {
        int pairCount = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int t : hand) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }

        for (int t : hand) {
            int suit = t / 10;
            int num = t % 10;
            if (suit == 1) continue;
            if (num >= 4 && num <= 6) return false;
            int c = count.get(t);
            if (c == 2) pairCount++;
            if (pairCount > 1) return false;
            if (num == 2) {if (!count.containsKey(t - 1) && !count.containsKey(t + 1)) return false;}
            if (num == 3) {if (!count.containsKey(t - 1) && !count.containsKey(t - 2)) return false;}
            if (num == 7) {if (!count.containsKey(t + 1) && !count.containsKey(t + 2)) return false;}
            if (num == 8) {if (!count.containsKey(t - 1) && !count.containsKey(t + 1)) return false;}
            if (num == 1) {if (!count.containsKey(t + 1) && !count.containsKey(t + 2)) return false;}
            if (num == 9) {if (!count.containsKey(t - 1) && !count.containsKey(t - 2)) return false;}
            if (c == 1) return false;
        }

        return true;
    }

    Boolean YIkkitsuukan() {
        Map<Integer, Set<Integer>> suitToNums = new HashMap<>();
        for (int t : hand) {
            int suit = t / 10;
            int num = t % 10;
            if (suit == 1) continue;
            suitToNums.putIfAbsent(suit, new HashSet<>());
            suitToNums.get(suit).add(num);
        }
        for (Map.Entry<Integer, Set<Integer>> e : suitToNums.entrySet()) {
            Set<Integer> nums = e.getValue();
            if (nums.contains(1) && nums.contains(2) && nums.contains(3) &&
                    nums.contains(4) && nums.contains(5) && nums.contains(6) &&
                    nums.contains(7) && nums.contains(8) && nums.contains(9)) {
                return true;
            }
        }
        return false;
    }
    Boolean YSanshokuDoujun() {
        Map<Integer, Set<Integer>> suitToNums = new HashMap<>();
        for (int t : hand) {
            int suit = t / 10;
            int num = t % 10;
            if (suit == 1) continue;
            suitToNums.putIfAbsent(suit, new HashSet<>());
            suitToNums.get(suit).add(num);
        }
        if (!suitToNums.containsKey(2) || !suitToNums.containsKey(3) || !suitToNums.containsKey(4))
            return false;
        Set<Integer> man = suitToNums.get(2);
        Set<Integer> pin = suitToNums.get(3);
        Set<Integer> sou = suitToNums.get(4);
        for (int start = 1; start <= 7; start++) {
            boolean manHas = man.contains(start) && man.contains(start + 1) && man.contains(start + 2);
            boolean pinHas = pin.contains(start) && pin.contains(start + 1) && pin.contains(start + 2);
            boolean souHas = sou.contains(start) && sou.contains(start + 1) && sou.contains(start + 2);
            if (manHas && pinHas && souHas) {
                return true;
            }
        }
        return false;
    }
    Boolean YRyanpeikou() {
        Map<String, Integer> sequenceCount = new HashMap<>();
        for (int t : hand) {
            int suit = t / 10;
            int num = t % 10;
            if (suit == 1 || num > 7) continue;
            if (containsTile(suit * 10 + num + 1) && containsTile(suit * 10 + num + 2)) {
                String key = suit + "-" + num;
                sequenceCount.put(key, sequenceCount.getOrDefault(key, 0) + 1);
            }
        }
        int iipeikouCount = 0;
        for (int v : sequenceCount.values()) {
            if (v >= 2) iipeikouCount++;
        }
        return iipeikouCount >= 2;
    }
    private boolean containsTile(int tile) {
        for (int t : hand) {
            if (t == tile) return true;
        }
        return false;
    }
    Boolean YJunchantaiYaochu() {
        int pairCount = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int t : hand) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }
        for (int t : hand) {
            int suit = t / 10;
            int num = t % 10;
            if (suit == 1) return false;
            if (num >= 4 && num <= 6) return false;
            int c = count.get(t);
            if (c == 1) return false;
            if (c == 2) pairCount++;
            if (pairCount > 1) return false;
            if (num == 1) {
                if (!count.containsKey(t + 1) && !count.containsKey(t + 2)) return false;
            }
            if (num == 9) {
                if (!count.containsKey(t - 1) && !count.containsKey(t - 2)) return false;
            }
            if (num == 2) {
                if (!count.containsKey(t - 1) && !count.containsKey(t + 1)) return false;
            }
            if (num == 3) {
                if (!count.containsKey(t - 1) && !count.containsKey(t - 2)) return false;
            }
            if (num == 7) {
                if (!count.containsKey(t + 1) && !count.containsKey(t + 2)) return false;
            }
            if (num == 8) {
                if (!count.containsKey(t - 1) && !count.containsKey(t + 1)) return false;
            }
        }

        return true;
    }
    Boolean YHonIsou() {
        boolean hasHonor = false;
        int suitType = 0;
        for (int t : hand) {
            int suit = t / 10;
            if (suit == 1) {
                hasHonor = true;
                continue;
            }
            if (suitType == 0) {
                suitType = suit;
            }
            else if (suit != suitType) {
                return false;
            }
        }
        return hasHonor && suitType != 0;
    }
    Boolean YChinIsou() {
        int suitType = 0;
        for (int t : hand) {
            int suit = t / 10;
            if (suit == 1) return false;
            if (suitType == 0) {
                suitType = suit;
            }
            else if (suit != suitType) {
                return false;
            }
        }
        return suitType != 0;
    }
    Boolean YTenhou (){
        return firstDraw;
    }
    Boolean YDaisangen() {
        Map<Integer, Integer> count = new HashMap<>();
        for (int t : hand) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }
        int haku = 15;
        int hatsu = 16;
        int chun = 17;
        boolean hasHaku = count.getOrDefault(haku, 0) >= 3;
        boolean hasHatsu = count.getOrDefault(hatsu, 0) >= 3;
        boolean hasChun = count.getOrDefault(chun, 0) >= 3;
        return hasHaku && hasHatsu && hasChun;
    }
    Boolean YSuankou() {
        Map<Integer, Integer> count = new HashMap<>();
        for (int t : hand) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }
        int tripletCount = 0;
        int pairCount = 0;
        for (int c : count.values()) {
            if (c >= 3) tripletCount++;
            else if (c == 2) pairCount++;
            else if (c == 1) return false;
        }
        return tripletCount == 4 && pairCount == 1;
    }
    Boolean YTsuisou() {
        for (int t : hand) {
            int suit = t / 10;
            if (suit != 1) return false;
        }
        return true;
    }
    Boolean YRyuuiisou() {
        for (int t : hand) {
            if (t == 17) continue;
            int suit = t / 10;
            int num = t % 10;
            if (suit != 4) return false;
            if (!(num == 2 || num == 3 || num == 4 || num == 6 || num == 8)) return false;
        }
        return true;
    }
    Boolean YChinroutou() {
        for (int t : hand) {
            int suit = t / 10;
            int num = t % 10;
            if (suit == 1) return false;
            if (num != 1 && num != 9) return false;
        }
        return true;
    }
    Boolean Y13Orphans() {
        Set<Integer> orphans = new HashSet<>(Arrays.asList(
                11,12,13,14,15,16,17,
                21,29,31,39,41,49
        ));

        Map<Integer, Integer> count = new HashMap<>();
        for (int t : hand)
            if (orphans.contains(t)) {
                count.put(t, count.getOrDefault(t, 0) + 1);
            }
        if (count.size() != 13) {
            return false;
        }
        return true;
    }
    Boolean YSousuushi() {
        Map<Integer, Integer> count = new HashMap<>();
        for (int t : hand)
            count.put(t, count.getOrDefault(t, 0) + 1);
        int[] winds = {11, 12, 13, 14};
        int triplet = 0;
        int pair = 0;
        for (int w : winds) {
            int c = count.getOrDefault(w, 0);
            if (c >= 3) triplet++;
            else if (c == 2) pair++;
            else if (c == 1) return false;
        }
        return triplet == 3 && pair == 1;
    }
    Boolean YSuukantsu (){
        return kans.size()==4;
    }
    Boolean YChuurenPoutou() {
        Map<Integer, Integer> count = new HashMap<>();
        for (int t : hand)
            count.put(t, count.getOrDefault(t, 0) + 1);
        int suit = -1;
        for (int t : hand) {
            int s = t / 10;
            if (s == 1) return false;
            if (suit == -1) suit = s;
            else if (suit != s) return false;
        }
        for (int num = 2; num <= 8; num++) {
            if (!count.containsKey(suit * 10 + num))
                return false;
        }
        int one = count.getOrDefault(suit * 10 + 1, 0);
        int nine = count.getOrDefault(suit * 10 + 9, 0);
        return one >= 3 && nine >= 3;
    }
//    Boolean YKokushiMusoujuusanmenMachi (){}
//    Boolean Suuankoutankimachi{}
//    int YJunseiChuurenPoutou (){}
    Boolean YDaisuushii() {
        Map<Integer, Integer> count = new HashMap<>();
        for (int t : hand)
            count.put(t, count.getOrDefault(t, 0) + 1);

        int[] winds = {11, 12, 13, 14};
        int triplet = 0;

        for (int w : winds) {
            if (count.getOrDefault(w, 0) >= 3)
                triplet++;
            else
                return false;
        }

        return triplet == 4;
    }

//    </editor-fold>

    Map<String,Object> analyzeYakuFull(int[] currentHand) {

        System.out.println(" ręka przed sprawdzaniem 1 "+Arrays.toString(hand));
        int[] savedHand = this.hand;
        this.hand = Arrays.copyOf(currentHand, currentHand.length);
        normaliseHand();
        System.out.println(" ręka przed sprawdzaniem 2 "+ Arrays.toString(hand));

        List<String> detected = new ArrayList<>();
        int totalHan = 0;
        boolean anyYakuman = false;

        Map<String, Integer> yakuHan = new LinkedHashMap<>();
        yakuHan.put("Tanyao", 1);
        yakuHan.put("Yakuhai", 1);
        yakuHan.put("Pinfu", 1);
        yakuHan.put("Iipeikou", 1);
        yakuHan.put("Ryanpeikou", 3);
        yakuHan.put("RinshanKaihou", 1);
        yakuHan.put("HaiteiRaoyue", 1);
        yakuHan.put("Toitoihou", 2);
        yakuHan.put("SanshokuDoujun", 2);
        yakuHan.put("SanshokuDoukou", 2);
        yakuHan.put("SanKantsu", 2);
        yakuHan.put("Shousangen", 2);
        yakuHan.put("Honroutou", 2);
        yakuHan.put("Chitoitsu", 2);
        yakuHan.put("HonchantaiYaochu", 2);
        yakuHan.put("Ikkitsuukan", 2);
        yakuHan.put("JunchantaiYaochu", 3);
        yakuHan.put("Honitsu", 2);
        yakuHan.put("Chinitsu", 6);
        Map<String, Integer> yakumanMap = new LinkedHashMap<>();
        yakumanMap.put("Daisangen", 13);
        yakumanMap.put("Suuankou", 13);
        yakumanMap.put("Tsuisou", 13);
        yakumanMap.put("Ryuuiisou", 13);
        yakumanMap.put("Chinroutou", 13);
        yakumanMap.put("KokushiMusou", 13);
        yakumanMap.put("Daisuushii", 13);
        yakumanMap.put("ChuurenPoutou", 13);
        yakumanMap.put("Suukantsu", 13);
        yakumanMap.put("DaisuuShii", 13);
        yakumanMap.put("Tenhou",13);

        if (YTanyao()) { detected.add("Tanyao (1)"); totalHan += yakuHan.get("Tanyao"); }
        if (YYakuhai()) { detected.add("Yakuhai (1)"); totalHan += yakuHan.get("Yakuhai"); }
        if (YPinfu())  { detected.add("Pinfu (1)"); totalHan += yakuHan.get("Pinfu"); }
        if (YIpeikou()) { detected.add("Iipeikou (1)"); totalHan += yakuHan.get("Iipeikou"); }
        if (YRyanpeikou()) { detected.add("Ryanpeikou (3)"); totalHan += yakuHan.get("Ryanpeikou"); }
        if (YRinshanKaihou()) { detected.add("RinshanKaihou (1)"); totalHan += yakuHan.get("RinshanKaihou"); }
        if (YHaiteiRaoyue()) { detected.add("HaiteiRaoyue (1)"); totalHan += yakuHan.get("HaiteiRaoyue"); }
        if (YToitoihou()) { detected.add("Toitoihou (2)"); totalHan += yakuHan.get("Toitoihou"); }
        if (YSanshokuDoujun()) { detected.add("SanshokuDoujun (2)"); totalHan += yakuHan.get("SanshokuDoujun"); }
        if (YSenshokuDoukou()) { detected.add("SanshokuDoukou (2)"); totalHan += yakuHan.get("SanshokuDoukou"); }
        if (YSankatsu()) { detected.add("SanKantsu (2)"); totalHan += yakuHan.get("SanKantsu"); }
        if (YShousangen()) { detected.add("Shousangen (2)"); totalHan += yakuHan.get("Shousangen"); }
        if (YHonrouto()) { detected.add("Honroutou (2)"); totalHan += yakuHan.get("Honroutou"); }
        if (YChitoitsu()) { detected.add("Chitoitsu (2)"); totalHan += yakuHan.get("Chitoitsu"); }
        if (YHonchantaiYaochu()) { detected.add("HonchantaiYaochu (2)"); totalHan += yakuHan.get("HonchantaiYaochu"); }
        if (YIkkitsuukan()) { detected.add("Ikkitsuukan (2)"); totalHan += yakuHan.get("Ikkitsuukan"); }
        if (YJunchantaiYaochu()) { detected.add("JunchantaiYaochu (3)"); totalHan += yakuHan.get("JunchantaiYaochu"); }
        if (YHonIsou()) { detected.add("Honitsu (2)"); totalHan += yakuHan.get("Honitsu"); }
        if (YChinIsou()) { detected.add("Chinitsu (6)"); totalHan += yakuHan.get("Chinitsu"); }

        if (Y13Orphans()) {
            List<Integer> tmp = T13OrphansWaits(Arrays.copyOf(this.hand, this.hand.length));
            if (tmp.size() == 13) {
                detected.add("Kokushi Musou Juusanmenmachi (Double Yakuman)");
                totalHan += 26;
                anyYakuman = true;
            } else {
                detected.add("Kokushi Musou (Yakuman)");
                totalHan += 13;
                anyYakuman = true;
            }
        }
        if (YDaisangen()) { detected.add("Daisangen (Yakuman)"); totalHan += yakumanMap.get("Daisangen"); anyYakuman = true; }
        if (YSuankou()) { detected.add("Suuankou (Yakuman)"); totalHan += yakumanMap.get("Suuankou"); anyYakuman = true; }
        if (YTsuisou()) { detected.add("Tsuisou (Yakuman)"); totalHan += yakumanMap.get("Tsuisou"); anyYakuman = true; }
        if (YRyuuiisou()) { detected.add("Ryuuiisou (Yakuman)"); totalHan += yakumanMap.get("Ryuuiisou"); anyYakuman = true; }
        if (YChinroutou()) { detected.add("Chinroutou (Yakuman)"); totalHan += yakumanMap.get("Chinroutou"); anyYakuman = true; }
        if (YDaisuushii()) { detected.add("Daisuushii (Yakuman)"); totalHan += yakumanMap.get("Daisuushii"); anyYakuman = true; }
        if (YChuurenPoutou()) { detected.add("Chuuren Poutou (Yakuman)"); totalHan += yakumanMap.get("ChuurenPoutou"); anyYakuman = true; }
        if (YSuukantsu()) { detected.add("Suukantsu (Yakuman)"); totalHan += yakumanMap.get("Suukantsu"); anyYakuman = true; }
        if (YTenhou()) { detected.add("Tenhou (Yakuman)"); totalHan += yakumanMap.get("Tenhou"); anyYakuman = true; }

        int fu = estimateFuSimplified(currentHand);

        int points = fu * totalHan;

        this.hand = savedHand;

        System.out.println(" pies ci matke " + kans);

        Map<String,Object> out = new HashMap<>();
        out.put("yakuList", detected);
        out.put("totalHan", totalHan);
        out.put("fu", fu);
        out.put("points", points);
        out.put("isYakuman", anyYakuman);
        return out;
    }
    public int estimateFuSimplified(int[] currentHand) {
        int fu = 0;
        for (int i = 0; i < currentHand.length;i++){
            for (int j =0;j<Deck.uniqueTiles.length;j++){
                if (currentHand[i] == Deck.uniqueTiles[j]){
                    fu+=Main.mainWindow.game.fuval[j];
                }
            }
        }
        return fu;
    }
    public boolean isComplete(int[] hand) {
        Boolean one = isWinningHandFast(hand);
        Boolean two = YChitoitsu();
        Boolean three = Y13Orphans();
        if (one){
            System.out.println(" regular");
        }
        if (two){
            System.out.println(" 7 gruch");
        }
        if (three){
            System.out.println(" 13 sierot");
        }
        return isWinningHandFast(hand) || YChitoitsu() || Y13Orphans();
    }
    public static void main(String[] args) {
        YekerMeister_mk_III engine = new YekerMeister_mk_III();
        engine.normaliseHand();

        int[] hand = {
                11,12,13,
                14,15,16,
                17,21,29,
                31,39,41,
                49,17
        };

        engine.hand = hand;

        List<List<Integer>> tenpai = engine.TenpaiAllCombined(engine.hand);
        System.out.println(tenpai);

        Map<String,Object> analysis = engine.analyzeYakuFull(engine.hand);
        System.out.println("Detected yaku: " + analysis.get("yakuList"));
        System.out.println("Total han: " + analysis.get("totalHan"));
        System.out.println("Fu: " + analysis.get("fu"));
        System.out.println("Points (fu x han): " + analysis.get("points"));

        System.out.println(engine.T13OrphansWaits(new int[]{
                11,12,13,14,15,16,17,
                21,29,31,39,41,49,17
        }));
    }
}
