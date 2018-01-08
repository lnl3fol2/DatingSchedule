package girlstock;

import java.util.ArrayList;
import java.util.Comparator;

public class SelectGirl {
    static int count = 0;
    ArrayList<Girl> stock;
    ArrayList<Girl> girlList = new ArrayList<Girl>();

    public SelectGirl(ArrayList<Girl> stock) {
        this.stock = stock;
    }
    
    public ArrayList<Girl> getSchedule(){
        return null;
    }
    
    public void sortGirl(int i){
        switch(i){
            case 0  :   stock.sort(Comparator.comparing(Girl::getStart));break;
            case 1  :   stock.sort(Comparator.comparing(Girl::getEnd));break;
            default :   stock.sort(Comparator.comparing(Girl::getTime));break;
        }
    }
    
    public ArrayList<Girl> scheduling(int method){
        /*switch(method){
            case 0:
                if(stock!=null){
                    selGirl.add(stock.get(0));
                    count++;
                    for(int i=1; i<stock.size(); i++){
                        if(stock.get(i).start.getTime()>=selGirl.get(selGirl.size()-1).end.getTime()){
                            selGirl.add(stock.get(i));
                            count++;
                        }
                    }
                } break;
            default:*/
                if(stock!=null){
                    girlList.add(stock.get(0));
                    count++;
                    for(int i=1;i<stock.size();i++){
                        boolean notoverlap = true;
                        for(int j=0;j<girlList.size();j++){
                            if(stock.get(i).start.getTime()>=girlList.get(j).start.getTime()&&stock.get(i).start.getTime()<girlList.get(j).end.getTime()||
                               stock.get(i).end.getTime()>girlList.get(j).start.getTime()&&stock.get(i).end.getTime()<=girlList.get(j).end.getTime()||
                               stock.get(i).start.getTime()<girlList.get(j).start.getTime()&&stock.get(i).end.getTime()>girlList.get(j).end.getTime()){
                                notoverlap = false;
                                break;
                            }
                        }
                        if(notoverlap){
                            girlList.add(stock.get(i));
                            count++;    
                        }
                    }                    
                }
        //}
        return girlList;
    }
    
    public String toString(){
        String ans = "{\n";
        for(int i=0; i<stock.size(); i++)
            ans += stock.get(i)+"\n";
        return ans+"}";
    }
}
