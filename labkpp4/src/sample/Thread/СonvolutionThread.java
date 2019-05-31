package sample.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.text.DecimalFormat;

public class СonvolutionThread extends Thread {
    private Integer k;
    private Exchanger<String> exchanger;

    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();

    public СonvolutionThread(List<Integer> list, List<Integer> list3, Integer k, Exchanger<String> exchanger) {
        this.list1 = list;
        this.list2 = list3;
        this.k = k;
        this.exchanger = exchanger;
    }

    public void run() {
        int sum=0;
        int s;
        if(list1.size()>list2.size()) {
            while(list1.size()!=list2.size()){
                list2.add(0);
            }
        }
        if(list2.size()>list1.size()) {
            while(list1.size()!=list2.size()){
                list1.add(0);
            }
        }

        for(int i=0;i<list1.size();i++){
            if(k-i>=0)
                s=list1.get(i)*list2.get(k-i);
            else
                s=list1.get(i)*list2.get(k-i+list1.size());
            sum+=s;
        }

        DecimalFormat formatter = new DecimalFormat("#0");
        String result = formatter.format(sum);
        try {
            exchanger.exchange(result);
        } catch (Exception ex) {
        }
    }
}