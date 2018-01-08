package girlstock;

import java.sql.Time;

public class Girl {
        int no;
        Time start,end;

        public Girl(int no, Time start, Time end) {
            this.no = no;
            this.start = start;
            this.end = end;
        }

    public int getNo() {
        return no;
    }

    public Time getStart() {
        return start;
    }

    public Time getEnd() {
        return end;
    }
    
    public Time getTime() {
        return new Time(end.getTime()-start.getTime());
    }
    
    public String toString(){
        return no+" "+start+" "+end;
    }
        
        
}
