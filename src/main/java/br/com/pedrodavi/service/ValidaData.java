package br.com.pedrodavi.service;

import br.com.pedrodavi.model.Day;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidaData {

    public static Day checkDay(String req, boolean sabadoValido) throws ParseException {

        if (req.length() != 8){
            Day error = new Day();
            error.setMsg("ERRO! Data tem que conter 8 caracteres. Ex: DDMMAAAA");
            return error;
        }

        LocalDate date = convertDate(req);

        String day = date.getDayOfWeek().name();

        String dia = "";

        switch (day) {
            case "SUNDAY":
                dia = "Domingo";
                break;
            case "SATURDAY":
                dia = "Sábado";
                break;
            case "MONDAY":
                dia = "Segunda";
                break;
            case "TUESDAY":
                dia = "Terça";
                break;
            case "WEDNESDAY":
                dia = "Quarta";
                break;
            case "THURSDAY":
                dia = "Quinta";
                break;
            case "FRIDAY":
                dia = "Sexta";
                break;
            default:
                dia = "";
                break;
        }

        if (fimDeSemana(date) && !sabadoValido){
            Day resp = new Day();
            resp.setData(date.toString());
            resp.setDiaDaSemana(dia);
            resp.setUtil("Não");
            resp.setMsg("OK");
            return resp;
        }

        Day resp = new Day();
        resp.setData(date.toString());
        resp.setDiaDaSemana(dia);
        resp.setUtil("Sim");
        resp.setMsg("OK");

        return resp;
    }

    public static LocalDate convertDate(String dateReq) throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat("ddMMyyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormated = format2.format(format1.parse(dateReq));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        return LocalDate.parse(dateFormated, formatter);
    }

    public static boolean fimDeSemana(LocalDate ld) {
        DayOfWeek d = ld.getDayOfWeek();
        return d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY;
    }

}
