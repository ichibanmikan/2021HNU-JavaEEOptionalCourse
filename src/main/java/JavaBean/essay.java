package JavaBean;

import java.util.Vector;

public class essay {
    private int index;
    private String title;
    private String type;
    private String editor;
    private Vector<String> label;
    private String date;
    public essay(){
        this.label=new Vector<String>();
        this.title="error";
    }
    public essay(int id, String tit, String typ, String edt, String[] lab, String date){
        this.index=id;
        this.title=tit;
        this.type=typ;
        this.editor=edt;
        this.date=date;
        for(int i=0; i<lab.length; i++){
            label.add(lab[i]);
        }
    }
    public essay(String tit, String typ, String edt, String[] lab, String date){
        this.title=tit;
        this.type=typ;
        this.editor=edt;
        this.date=date;
        for(int i=0; i<lab.length; i++){
            label.add(lab[i]);
        }
        this.index=-1;
    }
    public void addLabel(String Str){
        label.add(Str);
    }
    public int getIndex(){
        return index;
    }
    public String getTitle(){
        return title;
    }
    public String getType(){
        return type;
    }
    public String getEditor(){
        return editor;
    }
    public String getDate(){
        return date;
    }
    public Vector<String> getLabel() {
        return label;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setLabel(Vector<String> label) {
        this.label = label;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }
}