package src.lib;

import java.util.ArrayList;

public class Helpers {
    public <L,T> int isContained(ArrayList<L> genArray,Object targetElem) {
        int size = genArray.size();
        for(int i = 0 ; i < size ;i++){
            if(genArray.get(i).equals(targetElem)) return i;
        }
        return -1;
    }
    
    public <L> Boolean hasDuplicate(ArrayList<L> genericArray) {
        int size = genericArray.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (genericArray.get(i).equals(genericArray.get(j)) ) {
                    return true;
                }
            }
        }
        return false;
    }
}