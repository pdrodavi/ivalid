package br.com.pedrodavi.model;

public class Day {

    private String data;
    private String diaDaSemana;
    private String util;
    private String msg;

    public Day() {
    }

    public Day(String data, String diaDaSemana, String util, String msg) {
        this.data = data;
        this.diaDaSemana = diaDaSemana;
        this.util = util;
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public String getUtil() {
        return util;
    }

    public void setUtil(String util) {
        this.util = util;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Day{" +
                "data='" + data + '\'' +
                ", diaDaSemana='" + diaDaSemana + '\'' +
                ", util='" + util + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

}
